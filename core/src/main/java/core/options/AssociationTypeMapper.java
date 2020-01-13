package core.options;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.Serializer;

import core.Core;

public class AssociationTypeMapper {

	public static void addAssociationType(String attribute, String collectionType) {
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
	
	public static void replaceAssociationType(String attribute, String collectionType) {
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
	
	public static void deleteAssociationType(String attribute) {
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
	
	public static void clearAssociationTypes() {
		DB database = DBMaker.fileDB(Core.dbPath).make();
		
		BTreeMap<String, String> associationTypes = database.treeMap("associationTypes")
				.keySerializer(Serializer.STRING)
				.valueSerializer(Serializer.STRING)
				.createOrOpen();
		
		associationTypes.clear();
		database.close();
		System.out.println("\tAll association type mappings were deleted.");
	}
	
	public static void showAssociationTypes() {
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
}
