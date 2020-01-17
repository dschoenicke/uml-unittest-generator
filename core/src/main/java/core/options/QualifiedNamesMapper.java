package core.options;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.MissingArgumentException;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.Core;

/**
 * Manages mappings from shortcuts of external classes to fully qualified names
 * 
 * @author dschoenicke
 *
 */
public class QualifiedNamesMapper {
	
	private QualifiedNamesMapper() {
		throw new IllegalStateException("utility class");
	}
	
	/**
	 * The {@link org.slf4j.Logger} to be used in the methods
	 */
	private static final Logger LOG = LoggerFactory.getLogger("");
	
	/**
	 * Creates the {@link org.apache.commons.cli.Option}s for the qualified name mapping administration
	 * 
	 * @param options the {@link org.apache.commons.cli.Options} instance to add the {@link org.apache.commons.cli.Option}s to
	 */
	public static void addQualifiedNamesMapperOptions(Options options) {
		options.addOption(Option.builder("aqn")
				.longOpt("addqualifiedname")
				.desc("add a fully qualified name for a given shortcut used in the class diagram")
				.numberOfArgs(2)
				.argName("shortcut qualified-name")
				.build());
		
		options.addOption(Option.builder("rqn")
				.longOpt("replacequalifiedname")
				.desc("replace a fully qualified name for a given shortcut used in the class diagram")
				.numberOfArgs(2)
				.argName("shortcut qualified-name")
				.build());
		
		options.addOption(Option.builder("dqn")
				.longOpt("deletequalifiedname")
				.desc("delete the mapping with the given shortcut")
				.numberOfArgs(1)
				.argName("shortcut")
				.build());
		
		options.addOption(Option.builder("cqn")
				.longOpt("clearqualifiednames")
				.desc("delete all mappings of diagram shortcuts to fully qualified names")
				.build());
		
		options.addOption(Option.builder("sqn")
				.longOpt("showqualifiednames")
				.desc("show all mappings of diagram shortcuts to fully qualified names")
				.build());
	}
	
	/**
	 * Evaluates the input arguments whether they match the {@link org.apache.commons.cli.Options}.
	 * 
	 * @param cmd the parsed {@link org.apache.commons.cli.CommandLine} containing the arguments
	 * @param args the command line input arguments to be parsed
	 * @return true, if the given arguments belong to the qualified names mapping administration {@link org.apache.commons.cli.Options}.
	 */
	public static boolean parseOptions(CommandLine cmd, String[] args) {	
		if (cmd.hasOption("aqn")) {
			addQualifiedName(args[1], args[2]);
			return true;
		}
		else if (cmd.hasOption("rqn")) {
			replaceQualifiedName(args[1], args[2]);
			return true;
		}
		else if (cmd.hasOption("dqn")) {
			deleteQualifiedName(args[1]);
			return true;
		}
		else if (cmd.hasOption("cqn")) {
			clearQualifiedNames();
			return true;
		}
		else if (cmd.hasOption("sqn")) {
			showQualifiedNames();
			return true;
		}
		
		return false;
	} 
	
	/**
	 * Checks a thrown {@link org.apache.commons.cli.ParseException} whether it is associated with association type commands
	 * 
	 * @param e the {@link org.apache.commons.cli.ParseException} to be parsed.
	 */
	public static void checkQualifiedNamesParseException(ParseException e) {
		if (e instanceof MissingArgumentException) {
			if (((MissingArgumentException) e).getOption().getOpt().equals("aqn")) {
				LOG.error("-addqualifiedname requires arguments <shortcut> <qualified-name>");
				LOG.error("Example: -addqualifiedname java.Money org.javamoney.moneta.Money");
			}
			else if (((MissingArgumentException) e).getOption().getOpt().equals("dqn")) {
				LOG.error("-deletequalifiedname requires argument <shortcut>");
			}
			else if (((MissingArgumentException) e).getOption().getOpt().equals("rqn")) {
				LOG.error("-replacequalifiedname requires arguments <shortcut> <new-qualified-name>");
			}
		}
	}
	
	/**
	 * Creates a new entry for a given shortcut and its qualified name
	 * 
	 * @param shortcut the shortcut as the key
	 * @param qualifiedName the qualified name as the object
	 */
	static void addQualifiedName(String shortcut, String qualifiedName) {
		DB database = DBMaker.fileDB(Core.DB_PATH).make();
		BTreeMap<String, String> qualifiedNames = null;
				
		try {
			qualifiedNames = loadQualifiedNamesDB(database);
			
			if (qualifiedNames.containsKey(shortcut)) {
				LOG.error("There is already a mapping for the shortcut {}!", shortcut);
				LOG.error("The mapping for {} is {}.", shortcut, qualifiedNames.get(shortcut));
				return;
			}
			
			qualifiedNames.put(shortcut, qualifiedName);
			LOG.info("The mapping {} -> {} was added.", shortcut, qualifiedName);
		} finally {
			if (qualifiedNames != null) {
				qualifiedNames.close();
			}
			
			database.close();
		}
	}
	
	/**
	 * Replaces the value of an entry for the given key with the new value
	 * 
	 * @param shortcut the key of the entry to be replaced
	 * @param qualifiedName the new value to be set for the entry
	 */
	static void replaceQualifiedName(String shortcut, String qualifiedName) {
		DB database = DBMaker.fileDB(Core.DB_PATH).make();
		BTreeMap<String, String> qualifiedNames = null;
		
		try {
			qualifiedNames = loadQualifiedNamesDB(database);
			
			if (!qualifiedNames.containsKey(shortcut)) {
				LOG.error("There is no mapping for the shortcut {} to be replaced!", shortcut);
				return;
			}
			
			String oldValue = qualifiedNames.get(shortcut);
			qualifiedNames.replace(shortcut, qualifiedName);
			LOG.info("The mapping {} -> {} was replaced by {} -> {}.", shortcut, oldValue, shortcut, qualifiedName);
		} finally {
			if (qualifiedNames != null) {
				qualifiedNames.close();
			}
			
			database.close();
		}
	}
	
	/**
	 * Deletes an entry with the given key shortcut
	 * 
	 * @param shortcut the key to be deleted
	 */
	static void deleteQualifiedName(String shortcut) {
		DB database = DBMaker.fileDB(Core.DB_PATH).make();
		BTreeMap<String, String> qualifiedNames = null;
		
		try {
			qualifiedNames = loadQualifiedNamesDB(database);
			
			if (!qualifiedNames.containsKey(shortcut)) {
				LOG.error("There is no mapping for the shortcut {} to be deleted!", shortcut);
				return;
			}
			
			String oldValue = qualifiedNames.get(shortcut);
			qualifiedNames.remove(shortcut);
			LOG.info("The mapping {} -> {} was deleted.", shortcut, oldValue);
		} finally {
			if (qualifiedNames != null) {
				qualifiedNames.close();
			}
			
			database.close();
		}
	}
	
	/**
	 * Deletes all entries
	 */
	static void clearQualifiedNames() {
		DB database = DBMaker.fileDB(Core.DB_PATH).make();
		BTreeMap<String, String> qualifiedNames = null;
		
		try {
			qualifiedNames = loadQualifiedNamesDB(database);
			qualifiedNames.clear();
			LOG.info("All qualified name mappings were deleted.");
		} finally {
			if (qualifiedNames != null) {
				qualifiedNames.close();
			}
			
			database.close();
		}
	}
	
	/**
	 * Prints a list of all mappings to the console
	 */
	static void showQualifiedNames() {
		DB database = DBMaker.fileDB(Core.DB_PATH).make();
		BTreeMap<String, String> qualifiedNames = null;
		
		try {
			qualifiedNames = loadQualifiedNamesDB(database);
		
			if (qualifiedNames.isEmpty()) {
				LOG.info("There have no mappings been stored yet!");
				database.close();
				return;
			}
			
			qualifiedNames.forEach((shortcut, qualifiedName) -> 
				LOG.info("{} -> {}", shortcut, qualifiedName)
			);
		} finally {
			if (qualifiedNames != null) {
				qualifiedNames.close();
			}
			
			database.close();
		}
	}
	
	/**
	 * Loads the qualified names database map
	 * 
	 * @param database the mapDB database
	 * @return the loaded qualified names database map
	 */
	static BTreeMap<String, String> loadQualifiedNamesDB(DB database) {
		return database.treeMap("qualifiedNames")
				.keySerializer(Serializer.STRING)
				.valueSerializer(Serializer.STRING)
				.createOrOpen();
	}
}
