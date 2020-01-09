package outputjunit.testmethod;

import test.testobjects.ClassUnderTest;

public class PropertyTestConverter {

	public static String createTestClassPropertyTests(ClassUnderTest classUnderTest) {
		return "\n\t@Test\n"
				+ "\tpublic void testClassProperties() {\n"
				+ "\t\tassertEquals(" + classUnderTest.getModifiers() + ", classUnderTest.getModifiers(), "
				+ "\"The modifiers of " + classUnderTest.getQualifiedName() + " do not match!\");\n"
				+ "\t}\n";
	}
}
