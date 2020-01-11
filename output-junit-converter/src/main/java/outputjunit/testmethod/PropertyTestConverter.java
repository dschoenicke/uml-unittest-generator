package outputjunit.testmethod;

import test.testobjects.ClassUnderTest;

public class PropertyTestConverter {

	public static String createTestClassPropertyTests(ClassUnderTest classUnderTest) {
		String propertyTestString = "\n\t@Test\n"
				+ "\tpublic void testClassProperties() {\n"
				+ "\t\tassertEquals(" + classUnderTest.getModifiers() + ", classUnderTest.getModifiers(), "
				+ "\"The modifiers of " + classUnderTest.getQualifiedName() + " do not match!\");\n";
		
		if (classUnderTest.getNestHost().isPresent()) {
			propertyTestString += "\t\tassertEquals(\"" + classUnderTest.getNestHost().get().getQualifiedName() + "\", classUnderTest.getNestHost().getName(), "
					+ "\"" + classUnderTest.getQualifiedName() + " is expected to be an inner class of " + classUnderTest.getNestHost().get().getQualifiedName() + "!\");\n";
		}
		else {
			propertyTestString += "\t\tassertEquals(\"" + classUnderTest.getQualifiedName() + "\", classUnderTest.getNestHost().getName(), "
					+ "\"" + classUnderTest.getQualifiedName() + " must not be an inner class!\");\n";
		}
		
		switch (classUnderTest.getType()) {
			case ENUM: {
				propertyTestString += "\t\tassertTrue(classUnderTest.isEnum(), \"" + classUnderTest.getQualifiedName() + " is expected to be an enumeration!\");\n";
				break;
			}
			case INTERFACE: {
				propertyTestString += "\t\tassertTrue(classUnderTest.isInterface(), \"" + classUnderTest.getQualifiedName() + " is expected to be an interface!\");\n";
				break;
			}
			default: {
				propertyTestString += "\t\tassertFalse(classUnderTest.isEnum() || classUnderTest.isInterface(), \"" + classUnderTest.getQualifiedName() + " is expected to be a class!\");\n";
				break;
			}
		}
				
		return propertyTestString + "\t}\n";
	}
}
