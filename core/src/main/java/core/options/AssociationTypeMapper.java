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
 * Manages mappings from field names to collection types
 * 
 * @author dschoenicke
 *
 */
public class AssociationTypeMapper {

	private AssociationTypeMapper() {
		throw new IllegalStateException("utility class");
	}
	
	/**
	 * The {@link org.slf4j.Logger} to be used in the methods
	 */
	private static final Logger LOG = LoggerFactory.getLogger("");
	
	/**
	 * Creates the {@link org.apache.commons.cli.Option}s for the association type mapping administration
	 * 
	 * @param options the {@link org.apache.commons.cli.Options} instance to add the {@link org.apache.commons.cli.Option}s to
	 */
	public static void addAssociationTypeMapperOptions(Options options) {
		options.addOption(Option.builder("aat")
				.longOpt("addassociationtype")
				.desc("add a collection type for a given attribute")
				.numberOfArgs(2)
				.argName("attribute collection-type")
				.build());
		
		options.addOption(Option.builder("rat")
				.longOpt("replaceassociationtype")
				.desc("replace a collection type for a given attribute")
				.numberOfArgs(2)
				.argName("attribute collection-type")
				.build());
		
		options.addOption(Option.builder("dat")
				.longOpt("deleteassociationtype")
				.desc("delete the mapping with the given attribute")
				.numberOfArgs(1)
				.argName("attribute")
				.build());
		
		options.addOption(Option.builder("cat")
				.longOpt("clearassociationtypes")
				.desc("delete all mappings of attributes to collection types")
				.build());
		
		options.addOption(Option.builder("sat")
				.longOpt("showassociationtypes")
				.desc("show all mappings of attributes to collection types")
				.build());
	}
	
	/**
	 * Evaluates the input arguments whether they match the {@link org.apache.commons.cli.Options}.
	 * 
	 * @param cmd the parsed {@link org.apache.commons.cli.CommandLine} containing the arguments
	 * @param args the command line input arguments to be parsed
	 * @return true, if the given arguments belong to the association type mapping administration {@link org.apache.commons.cli.Options}.
	 */
	public static boolean parseOptions(CommandLine cmd, String[] args) {
		if (cmd.hasOption("aat")) {
			addAssociationType(args[1], args[2]);
			return true;
		}
		else if (cmd.hasOption("rat")) {
			replaceAssociationType(args[0], args[1]);
			return true;
		}
		else if (cmd.hasOption("dat")) {
			deleteAssociationType(args[0]);
			return true;
		}
		else if (cmd.hasOption("cat")) {
			clearAssociationTypes();
			return true;
		}
		else if (cmd.hasOption("sat")) {
			showAssociationTypes();
			return true;
		}
			
		return false;
	}
	
	/**
	 * Checks a thrown {@link org.apache.commons.cli.ParseException} whether it is associated with association type commands
	 * 
	 * @param e the {@link org.apache.commons.cli.ParseException} to be parsed.
	 */
	public static void checkAssociationTypeParseException(ParseException e) {
		if (e instanceof MissingArgumentException) {
			if (((MissingArgumentException) e).getOption().getOpt().equals("aat")) {
				LOG.error("Error: -addassociationtype requires arguments <attribute> <collection-type>");
				LOG.error("Example: -addassociationtype Person.friends ArrayList");
			}
			else if (((MissingArgumentException) e).getOption().getOpt().equals("rat")) {
				LOG.error("-replaceassociationtype requires arguments <attribute> <new-collection-type>");
			}
			else if (((MissingArgumentException) e).getOption().getOpt().equals("dat")) {
				LOG.error("-deleteassociationtype requires argument <attribute>");
			}
		}
	}
	
	/**
	 * Creates a new entry for a given argument and collection type
	 * 
	 * @param attribute the attribute as the key
	 * @param collectionType the collection type as the object
	 */
	static void addAssociationType(String attribute, String collectionType) {
		DB database = DBMaker.fileDB(Core.DB_PATH).make();
		BTreeMap<String, String> associationTypes = null;
		
		try {
			associationTypes = loadAssociationTypesDB(database);
			
			if (associationTypes.containsKey(attribute)) {
				LOG.info("Error: There is already a mapping for the attribute {}!", attribute);
				LOG.info("The mapping for {} is {}.", attribute, associationTypes.get(attribute));
				return;
			}
			
			associationTypes.put(attribute, collectionType);
			LOG.info("The mapping {} -> {} was added.", attribute, collectionType);
		} finally {
			if (associationTypes != null) {
				associationTypes.close();
			}
			
			database.close();
		}
	}
	
	/**
	 * Replaces the value of an entry for the given key with the new value
	 * 
	 * @param attribute the key of the entry to be replaced
	 * @param collectionType the new value to be set for the entry
	 */
	static void replaceAssociationType(String attribute, String collectionType) {
		DB database = DBMaker.fileDB(Core.DB_PATH).make();
		BTreeMap<String, String> associationTypes = null;
		
		try {
			associationTypes = loadAssociationTypesDB(database);
			
			if (!associationTypes.containsKey(attribute)) {
				LOG.error("There is no mapping for the attribute {} to be replaced!", attribute);
				return;
			}
			
			String oldValue = associationTypes.get(attribute);
			associationTypes.replace(attribute, collectionType);
			LOG.info("The mapping {} -> {} was replaced by {} -> {}.", attribute, oldValue, attribute, collectionType);
		} finally {
			if (associationTypes != null) {
				associationTypes.close();
			}
			
			database.close();
		}
	}
	
	/**
	 * Deletes an entry with the given key attribute
	 * 
	 * @param attribute the key to be deleted
	 */
	static void deleteAssociationType(String attribute) {
		DB database = DBMaker.fileDB(Core.DB_PATH).make();
		BTreeMap<String, String> associationTypes = null;
		
		try {
			associationTypes = loadAssociationTypesDB(database);
		
			if (!associationTypes.containsKey(attribute)) {
				LOG.error("There is no mapping for the attribute {} to be deleted!", attribute);
				return;
			}
		
			String oldValue = associationTypes.get(attribute);
			associationTypes.remove(attribute);
			LOG.info("The mapping {} -> {} was deleted.", attribute, oldValue);
		} finally {
			if (associationTypes != null) {
				associationTypes.close();
			}
			
			database.close();
		}
	}
	
	/**
	 * Deletes all entries
	 */
	static void clearAssociationTypes() {
		DB database = DBMaker.fileDB(Core.DB_PATH).make();	
		BTreeMap<String, String> associationTypes = null;
		
		try {
			associationTypes = loadAssociationTypesDB(database);
			LOG.info("All association type mappings were deleted.");
		} finally {
			if (associationTypes != null) {
				associationTypes.close();
			}
			
			database.close();
		}
	}
	
	/**
	 * Prints out a list of all mappings to the console
	 */
	static void showAssociationTypes() {
		DB database = DBMaker.fileDB(Core.DB_PATH).make();
		BTreeMap<String, String> associationTypes = null;
		
		try {
			associationTypes = loadAssociationTypesDB(database);
			
			if (associationTypes.isEmpty()) {
				LOG.info("There have no mappings been stored yet!");
				database.close();
				return;
			}
			
			associationTypes.forEach((attribute, collectionType) -> 
				LOG.info("{} -> {}", attribute, collectionType)
			);
		} finally {
			if (associationTypes != null) {
				associationTypes.close();
			}
			
			database.close();
		}
	}
	
	/**
	 * Loads the association types database map
	 * 
	 * @param database the mapDB database
	 * @return the loaded qualified names database map
	 */
	static BTreeMap<String, String> loadAssociationTypesDB(DB database) {
		return database.treeMap("associationTypes")
				.keySerializer(Serializer.STRING)
				.valueSerializer(Serializer.STRING)
				.createOrOpen();
	}
}
