package core.options;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.Serializer;

import core.Core;

public class QualifiedNamesMapper {
	
	public static void addQualifiedName(String shortcut, String qualifiedName) {
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
	
	public static void replaceQualifiedName(String shortcut, String qualifiedName) {
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
	
	public static void deleteQualifiedName(String shortcut) {
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
	
	public static void clearQualifiedNames() {
		DB database = DBMaker.fileDB(Core.dbPath).make();
		
		BTreeMap<String, String> qualifiedNames = database.treeMap("qualifiedNames")
				.keySerializer(Serializer.STRING)
				.valueSerializer(Serializer.STRING)
				.createOrOpen();
		
		qualifiedNames.clear();
		database.close();
		System.out.println("\tAll qualified name mappings were deleted.");
	}
	
	public static void showQualifiedNames() {
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
}
