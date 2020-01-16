package core.options;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.MissingArgumentException;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.Serializer;

import core.Core;

/**
 * Manages mappings from shortcuts of external classes to fully qualified names
 * 
 * @author dschoenicke
 *
 */
public class QualifiedNamesMapper {
	
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
	 * @param options the {@link org.apache.commons.cli.Options} to be checked
	 * @param args the input arguments to be checked
	 * @return true, if the given arguments belong to the qualified names mapping administration {@link org.apache.commons.cli.Options}.
	 */
	public static boolean parseOptions(Options options, String args[]) {
		try {
			CommandLine cmd = new DefaultParser().parse(options, args);
			
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
		} catch (ParseException e) {
			if (e instanceof MissingArgumentException) {
				if (((MissingArgumentException) e).getOption().getOpt().equals("aqn")) {
					System.out.println("\tError: -addqualifiedname requires arguments <shortcut> <qualified-name>");
					System.out.println("\tExample: -addqualifiedname java.Money org.javamoney.moneta.Money");
					return true;
				}
				else if (((MissingArgumentException) e).getOption().getOpt().equals("rqn")) {
					System.out.println("\tError: -replacequalifiedname requires arguments <shortcut> <new-qualified-name>");
					return true;
				}
				else if (((MissingArgumentException) e).getOption().getOpt().equals("dqn")) {
					System.out.println("\tError: -deletequalifiedname requires argument <shortcut>");
					return true;
				}
			}
			
			return false;
		}
	}
	
	/**
	 * Creates a new entry for a given shortcut and its qualified name
	 * 
	 * @param shortcut the shortcut as the key
	 * @param qualifiedName the qualified name as the object
	 */
	static void addQualifiedName(String shortcut, String qualifiedName) {
		DB database = DBMaker.fileDB(Core.dbPath).make();
		
		BTreeMap<String, String> qualifiedNames = database.treeMap("qualifiedNames")
				.keySerializer(Serializer.STRING)
				.valueSerializer(Serializer.STRING)
				.createOrOpen();
		
		if (qualifiedNames.containsKey(shortcut)) {
			System.out.println("\tError: There is already a mapping for the shortcut " + shortcut + "!");
			System.out.println("\tThe mapping for " + shortcut + " is " + qualifiedNames.get(shortcut) + ".");
			return;
		}
		
		qualifiedNames.put(shortcut, qualifiedName);
		database.close();
		System.out.println("\tThe mapping " + shortcut + " -> " + qualifiedName + " was added.");
	}
	
	/**
	 * Replaces the value of an entry for the given key with the new value
	 * 
	 * @param shortcut the key of the entry to be replaced
	 * @param qualifiedName the new value to be set for the entry
	 */
	static void replaceQualifiedName(String shortcut, String qualifiedName) {
		DB database = DBMaker.fileDB(Core.dbPath).make();
		
		BTreeMap<String, String> qualifiedNames = database.treeMap("qualifiedNames")
				.keySerializer(Serializer.STRING)
				.valueSerializer(Serializer.STRING)
				.createOrOpen();
		
		if (!qualifiedNames.containsKey(shortcut)) {
			System.out.println("\tError: There is no mapping for the shortcut " + shortcut + " to be replaced!");
			return;
		}
		
		String oldValue = qualifiedNames.get(shortcut);
		qualifiedNames.replace(shortcut, qualifiedName);
		database.close();
		System.out.println("\tThe mapping " + shortcut + " -> " + oldValue + " was replaced by " + shortcut + " -> " + qualifiedName + ".");
	}
	
	/**
	 * Deletes an entry with the given key shortcut
	 * 
	 * @param shortcut the key to be deleted
	 */
	static void deleteQualifiedName(String shortcut) {
		DB database = DBMaker.fileDB(Core.dbPath).make();
		
		BTreeMap<String, String> qualifiedNames = database.treeMap("qualifiedNames")
				.keySerializer(Serializer.STRING)
				.valueSerializer(Serializer.STRING)
				.createOrOpen();
		
		if (!qualifiedNames.containsKey(shortcut)) {
			System.out.println("\tError: There is no mapping for the shortcut " + shortcut + " to be deleted!");
			return;
		}
		
		String oldValue = qualifiedNames.get(shortcut);
		qualifiedNames.remove(shortcut);
		database.close();
		System.out.println("\tThe mapping " + shortcut + " -> " + oldValue + " was deleted.");
	}
	
	/**
	 * Deletes all entries
	 */
	static void clearQualifiedNames() {
		DB database = DBMaker.fileDB(Core.dbPath).make();
		
		BTreeMap<String, String> qualifiedNames = database.treeMap("qualifiedNames")
				.keySerializer(Serializer.STRING)
				.valueSerializer(Serializer.STRING)
				.createOrOpen();
		
		qualifiedNames.clear();
		database.close();
		System.out.println("\tAll qualified name mappings were deleted.");
	}
	
	/**
	 * Prints a list of all mappings to the console
	 */
	static void showQualifiedNames() {
		DB database = DBMaker.fileDB(Core.dbPath).make();
		
		BTreeMap<String, String> qualifiedNames = database.treeMap("qualifiedNames")
				.keySerializer(Serializer.STRING)
				.valueSerializer(Serializer.STRING)
				.createOrOpen();
		
		if (qualifiedNames.isEmpty()) {
			System.out.println("\tThere have no mappings been stored yet!");
			database.close();
			return;
		}
		
		qualifiedNames.forEach((shortcut, qualifiedName) -> {
			System.out.println("\t" + shortcut + " -> " + qualifiedName);
		});
		
		database.close();
	}
}
