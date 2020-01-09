package outputjunit.files;

import test.testobjects.ClassUnderTest;

public class ClassUnderTestCreator {

	public static String createClassUnderTest(ClassUnderTest classUnderTest) {
		return "\tprivate static Class<?> classUnderTest;\n\n"
				+ "\t@BeforeAll\n"
				+ "\tpublic static void loadClass() {\n" 
				+ "\t\ttry {\n"
				+ "\t\t\tclassUnderTest = Class.forName(\"" + classUnderTest.getQualifiedName() + "\");\n"
				+ "\t\t} catch (ClassNotFoundException e) {\n"
				+ "\t\t\tfail(\"The class " + classUnderTest.getQualifiedName() + " was not found!\");\n"
				+ "\t\t}\n"
				+ "\t}\n";
	}
}
