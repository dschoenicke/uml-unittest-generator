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
 * Manages mappings from field names to collection types
 * 
 * @author dschoenicke
 *
 */
public class AssociationTypeMapper {

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
	 * @param options the {@link org.apache.commons.cli.Options} to be checked
	 * @param args the input arguments to be checked
	 * @return true, if the given arguments belong to the association type mapping administration {@link org.apache.commons.cli.Options}.
	 */
	public static boolean parseOptions(Options options, String[] args) {
		try {
			CommandLine cmd = new DefaultParser().parse(options, args);
			
			if (cmd.hasOption("aat")) {
				addAssociationType(args[1], args[2]);
				return true;
			}
			else if (cmd.hasOption("rat")) {
				replaceAssociationType(args[1], args[2]);
				return true;
			}
			else if (cmd.hasOption("dat")) {
				deleteAssociationType(args[1]);
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
		} catch (ParseException e) {
			
			if (((MissingArgumentException) e).getOption().getOpt().equals("aat")) {
				System.out.println("\tError: -addassociationtype requires arguments <attribute> <collection-type>");
				System.out.println("\tExample: -addassociationtype Person.friends ArrayList");
				return true;
			}
			else if (((MissingArgumentException) e).getOption().getOpt().equals("rat")) {
				System.out.println("\tError: -replaceassociationtype requires arguments <attribute> <new-collection-type>");
				return true;
			}
			else if (((MissingArgumentException) e).getOption().getOpt().equals("dat")) {
				System.out.println("\tError: -deleteassociationtype requires argument <attribute>");
				return true;
			}
			
			return false;
		}
	}
	
	/**
	 * Creates a new entry for a given argument and collection type
	 * 
	 * @param attribute the attribute as the key
	 * @param collectionType the collection type as the object
	 */
	static void addAssociationType(String attribute, String collectionType) {
		DB database = DBMaker.fileDB(Core.dbPath).make();
		
		BTreeMap<String, String> associationTypes = database.treeMap("associationTypes")
				.keySerializer(Serializer.STRING)
				.valueSerializer(Serializer.STRING)
				.createOrOpen();
		
		if (associationTypes.containsKey(attribute)) {
			System.out.println("\tError: There is already a mapping for the attribute " + attribute + "!");
			System.out.println("\tThe mapping for " + attribute + " is " + associationTypes.get(attribute) + ".");
			return;
		}
		
		associationTypes.put(attribute, collectionType);
		database.close();
		System.out.println("\tThe mapping " + attribute + " -> " + collectionType + " was added.");
	}
	
	/**
	 * Replaces the value of an entry for the given key with the new value
	 * 
	 * @param attribute the key of the entry to be replaced
	 * @param collectionType the new value to be set for the entry
	 */
	static void replaceAssociationType(String attribute, String collectionType) {
		DB database = DBMaker.fileDB(Core.dbPath).make();
		
		BTreeMap<String, String> associationTypes = database.treeMap("associationTypes")
				.keySerializer(Serializer.STRING)
				.valueSerializer(Serializer.STRING)
				.createOrOpen();
		
		if (!associationTypes.containsKey(attribute)) {
			System.out.println("\tError: There is no mapping for the attribute " + attribute + " to be replaced!");
			return;
		}
		
		String oldValue = associationTypes.get(attribute);
		associationTypes.replace(attribute, collectionType);
		database.close();
		System.out.println("\tThe mapping " + attribute + " -> " + oldValue + " was replaced by " + attribute + " -> " + collectionType + ".");
	}
	
	/**
	 * Deletes an entry with the given key attribute
	 * 
	 * @param attribute the key to be deleted
	 */
	static void deleteAssociationType(String attribute) {
		DB database = DBMaker.fileDB(Core.dbPath).make();
		
		BTreeMap<String, String> associationTypes = database.treeMap("associationTypes")
				.keySerializer(Serializer.STRING)
				.valueSerializer(Serializer.STRING)
				.createOrOpen();
		
		if (!associationTypes.containsKey(attribute)) {
			System.out.println("\tError: There is no mapping for the attribute " + attribute + " to be deleted!");
			return;
		}
		
		String oldValue = associationTypes.get(attribute);
		associationTypes.remove(attribute);
		database.close();
		System.out.println("\tThe mapping " + attribute + " -> " + oldValue + " was deleted.");
	}
	
	/**
	 * Deletes all entries
	 */
	static void clearAssociationTypes() {
		DB database = DBMaker.fileDB(Core.dbPath).make();
		
		BTreeMap<String, String> associationTypes = database.treeMap("associationTypes")
				.keySerializer(Serializer.STRING)
				.valueSerializer(Serializer.STRING)
				.createOrOpen();
		
		associationTypes.clear();
		database.close();
		System.out.println("\tAll association type mappings were deleted.");
	}
	
	/**
	 * Prints out a list of all mappings to the console
	 */
	static void showAssociationTypes() {
		DB database = DBMaker.fileDB(Core.dbPath).make();
		
		BTreeMap<String, String> associationTypes = database.treeMap("associationTypes")
				.keySerializer(Serializer.STRING)
				.valueSerializer(Serializer.STRING)
				.createOrOpen();
		
		if (associationTypes.isEmpty()) {
			System.out.println("\tThere have no mappings been stored yet!");
			database.close();
			return;
		}
		
		associationTypes.forEach((attribute, collectionType) -> {
			System.out.println("\t" + attribute + " -> " + collectionType);
		});
		
		database.close();
	}
}
