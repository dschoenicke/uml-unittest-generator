package outputjunit.testmethod;

import test.testobjects.ClassUnderTest;
import test.testobjects.EnumConstantUnderTest;
import test.testobjects.FieldUnderTest;

public class FieldTestConverter {

	public static String createTestClassFieldTests(ClassUnderTest classUnderTest) {
		String fieldTestString = "";
		int fieldAmountOffset = 0;
		
		if (!classUnderTest.getEnumConstants().isEmpty()) {
			fieldTestString += createTestClassEnumConstantTests(classUnderTest);
			fieldAmountOffset = 1 + classUnderTest.getEnumConstants().size();
		}
		
		fieldTestString += "\n\t@Test\n"
				+ "\tpublic void testClassFields() {\n"
				+ "\t\tassertEquals(" + classUnderTest.getFields().size() + ", classUnderTest.getDeclaredFields().length - " + fieldAmountOffset + ", \""
				+ classUnderTest.getQualifiedName() + " is expected to have " + classUnderTest.getFields().size() + " fields!\");\n";
		
		for (FieldUnderTest fieldUnderTest : classUnderTest.getFields()) {
			fieldTestString += "\n\t\ttry {\n"
					+ "\t\t\tField fieldUnderTest = classUnderTest.getDeclaredField(\"" + fieldUnderTest.getName() + "\");\n"
					+ "\t\t\tassertEquals(" + fieldUnderTest.getModifiers() + ", fieldUnderTest.getModifiers(), "
					+ "\"The modifiers of " + classUnderTest.getQualifiedName() + "." + fieldUnderTest.getName() + " do not match!\");\n";
			
			if (fieldUnderTest.canBeNull() && !fieldUnderTest.hasMultiplicity()) {
				fieldTestString += "\t\t\tassertEquals(\"Optional\", fieldUnderTest.getType().getSimpleName(), "
						+ "\"The field " + fieldUnderTest.getName() + " in " + classUnderTest.getQualifiedName() + " is expected to be an Optional!\");";
			}
			else if (fieldUnderTest.hasMultiplicity()) {
				fieldTestString += "\n\t\t\tif (fieldUnderTest.getClass().isArray()) {\n" 
						+ "\t\t\t\tassertEquals(\"" + fieldUnderTest.getType() + "[]\", fieldUnderTest.getType().getSimpleName(), "
						+ "\"" + classUnderTest.getQualifiedName() + "." + fieldUnderTest.getName() + " is expected to have type " + fieldUnderTest.getType() + "[]!\");\n"
						+ "\t\t\t} else {\n"
						+ "\t\t\t\ttry {\n"
						+ "\t\t\t\t\tString genericType = ((ParameterizedType) fieldUnderTest.getGenericType()).getActualTypeArguments()[0].getTypeName();\n"
						+ "\t\t\t\t\tassertEquals(\"" + fieldUnderTest.getType() + "\", genericType.substring(genericType.lastIndexOf(\".\") + 1), "
						+ "\"" + classUnderTest.getQualifiedName() + "." + fieldUnderTest.getName() + " is expected to have type " + fieldUnderTest.getType() + "!\");\n"
						+ "\t\t\t\t} catch (ClassCastException e) {\n"
						+ "\t\t\t\t\tfail(\"" + classUnderTest.getQualifiedName() + "." + fieldUnderTest.getName() + " is expected to be in a collection!\");\n"
						+ "\t\t\t\t}\n"
						+ "\t\t\t}\n";
			}
			else {
				fieldTestString += "\t\t\tassertEquals(\"" + fieldUnderTest.getType() + "\", fieldUnderTest.getType().getSimpleName(), "
						+ "\"" + classUnderTest.getQualifiedName() + "." + fieldUnderTest.getName() + " is expected to have type " + fieldUnderTest.getType() + "!\");\n";
			}
			
			fieldTestString += "\t\t} catch (NoSuchFieldException | SecurityException e) {\n"
					+ "\t\t\tfail(\"" + classUnderTest.getQualifiedName() + " is expected to have a field " + fieldUnderTest.getName() + "!\");\n"
					+ "\t\t}\n";
		}
		
		return fieldTestString + "\t}\n";
	}
	
	static String createTestClassEnumConstantTests(ClassUnderTest classUnderTest) {
		String enumConstantTestString = "\t@Test\n"
				+ "\tpublic void testClassEnumConstants() {\n"
				+ "\t\tassertEquals(" + classUnderTest.getEnumConstants().size() + ", classUnderTest.getEnumConstants().length, "
				+ "\"" + classUnderTest.getQualifiedName() + " is expected to have " + classUnderTest.getEnumConstants().size() + " enum constants!\");\n\n"
				+ "\t\t//Auxiliary Array to store the enum constants of the class diagram\n"
				+ "\t\tString[] enumConstantsToCheck = {";

		for (EnumConstantUnderTest enumConstant: classUnderTest.getEnumConstants()) {
			enumConstantTestString += "\"" + enumConstant.getName() + "\", ";
		}

		enumConstantTestString = enumConstantTestString.substring(0, enumConstantTestString.length() - 2) + "};\n\n"
				+ "\t\tfor (int i = 0; i < classUnderTest.getEnumConstants().length; i++) {\n"
				+ "\t\t\tassertTrue(Arrays.asList(enumConstantsToCheck).contains(classUnderTest.getEnumConstants()[i].toString()), "
				+ "\"" + classUnderTest.getQualifiedName() + " is expected to have an enum constant \" + classUnderTest.getEnumConstants()[i].toString() + \"!\");\n"
				+ "\t\t}\n";
		
		return enumConstantTestString + "\t}\n";
	}
}
