package outputjunit.testmethod;

import test.testobjects.ClassUnderTest;
import test.testobjects.ConstructorUnderTest;

public class ConstructorTestConverter {

	public static String createTestClassConstructorTests(ClassUnderTest classUnderTest) {
		String constructorTestString = "\n\t@Test\n"
				+ "\tpublic void testClassConstructors() {\n"
				+ "\t\tassertEquals(" + classUnderTest.getConstructors().size() + ", classUnderTest.getDeclaredConstructors().length, "
				+ "\"" + classUnderTest.getQualifiedName() + " is expected to have exactly " + classUnderTest.getConstructors().size() + " constructors!\");\n";
		
		for (ConstructorUnderTest constructorUnderTest : classUnderTest.getConstructors()) {
			constructorTestString += "\n\t\ttry {\n"
					+ "\t\t\tConstructor<?> constructorUnderTest = classUnderTest.getDeclaredConstructor(" + ParameterTestConverter.createParameterClassList(constructorUnderTest.getParameters()) + ");\n"
					+ "\t\t\tassertEquals(" + constructorUnderTest.getModifiers() + ", constructorUnderTest.getModifiers(), \"The modifiers of the constructor with "
					+ (constructorUnderTest.getParameters().isEmpty() ? "no parameters" : "parameters " + ParameterTestConverter.createParameterList(constructorUnderTest.getParameters()))
					+ " in " + classUnderTest.getQualifiedName() + " do not match!\");\n";
			
			if (!constructorUnderTest.getParameters().isEmpty()) {
				constructorTestString += "\n" + ParameterTestConverter.createParameterTests(constructorUnderTest, constructorUnderTest.getParameters());
			}
				
			constructorTestString += "\t\t} catch (NoSuchMethodException | SecurityException e) {\n"
					+ "\t\t\tfail(\"" + classUnderTest.getQualifiedName() + " is expected to have a constructor with "
					+ (constructorUnderTest.getParameters().isEmpty() ? "no parameters" : "parameters " + ParameterTestConverter.createParameterList(constructorUnderTest.getParameters())) + "!\");\n"
					+ "\t\t}\n";
		}
		
		return constructorTestString + "\t}\n";
	}
}
