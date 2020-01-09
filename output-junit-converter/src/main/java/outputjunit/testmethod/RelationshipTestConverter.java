package outputjunit.testmethod;

import test.testobjects.ClassUnderTest;

public class RelationshipTestConverter {

	public static String createTestClassRelationshipTests(ClassUnderTest classUnderTest) {
		String propertyTestString = "\n\t@Test\n" 
				+ "\tpublic void testClassRelationships() {\n";
		propertyTestString += createSuperClassTests(classUnderTest);
		propertyTestString += createInterfaceTests(classUnderTest);
		return propertyTestString + "\t}\n";
	}
	
	static String createSuperClassTests(ClassUnderTest classUnderTest) {
		if (classUnderTest.getSuperClass().isPresent()) {
			return "\t\tassertEquals(\"" + classUnderTest.getSuperClass().get() + "\", classUnderTest.getSuperclass().getName(), "
					+ "\"" + classUnderTest.getQualifiedName() + " is expected to extend " + classUnderTest.getSuperClass().get() + "!\");\n";
		}

		return "\t\tassertEquals(classUnderTest.getSuperclass().getName(), \"java.lang.Object\", \"" + classUnderTest.getQualifiedName() + " is expected to extend no superclass!\");\n";
	}
	
	static String createInterfaceTests(ClassUnderTest classUnderTest) {
		String interfaceTestString = "\t\tassertEquals(" + classUnderTest.getInterfaces().size() + ", classUnderTest.getInterfaces().length, "
				+ "\"" + classUnderTest.getQualifiedName() + " is expected to implement " + classUnderTest.getInterfaces().size() + " interfaces!\");\n";
		
		if (!classUnderTest.getInterfaces().isEmpty()) {
			interfaceTestString += "\n\t\t//Auxiliary Array to store the implemented interfaces of the class diagram\n"
					+ "\t\tString[] interfacesToCheck = {";
	
			for (String interfaceName: classUnderTest.getInterfaces()) {
				interfaceTestString += "\"" + interfaceName + "\", ";
			}
			
			interfaceTestString = interfaceTestString.substring(0, interfaceTestString.length() - 2) + "};\n\n"
					+ "\t\tfor (int i = 0; i < classUnderTest.getInterfaces().length; i++) {\n"
					+ "\t\t\tassertTrue(Arrays.asList(interfacesToCheck).contains(classUnderTest.getInterfaces()[i].getName()), "
					+ "\"" + classUnderTest.getQualifiedName() + " is expected to implement \" + classUnderTest.getInterfaces()[i].getName() + \"!\");\n"
					+ "\t\t}\n";
		}
		
		return interfaceTestString;
	}
}
