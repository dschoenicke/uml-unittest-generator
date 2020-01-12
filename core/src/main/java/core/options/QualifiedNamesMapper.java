package core.options;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;
import org.mapdb.Serializer;

public class QualifiedNamesMapper {

	private static final String dbPath = "qualifiedNames.db";
	
	public static void addQualifiedName(String shortcut, String qualifiedName) {
		DB database = DBMaker.fileDB(dbPath).make();
		
		HTreeMap<String, String> qualifiedNames = database.hashMap("qualifiedNames")
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
		DB database = DBMaker.fileDB(dbPath).make();
		
		HTreeMap<String, String> qualifiedNames = database.hashMap("qualifiedNames")
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
		DB database = DBMaker.fileDB(dbPath).make();
		
		HTreeMap<String, String> qualifiedNames = database.hashMap("qualifiedNames")
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
		DB database = DBMaker.fileDB(dbPath).make();
		
		HTreeMap<String, String> qualifiedNames = database.hashMap("qualifiedNames")
				.keySerializer(Serializer.STRING)
				.valueSerializer(Serializer.STRING)
				.createOrOpen();
		
		qualifiedNames.clear();
		database.close();
		System.out.println("\tAll qualified name mappings were deleted.");
	}
	
	public static void showQualifiedNames() {
		DB database = DBMaker.fileDB(dbPath).make();
		
		HTreeMap<String, String> qualifiedNames = database.hashMap("qualifiedNames")
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
