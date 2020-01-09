package outputjunit.testmethod;

import test.testobjects.ClassUnderTest;
import test.testobjects.MethodUnderTest;

public class MethodTestConverter {

	public static String createTestClassMethodTests(ClassUnderTest classUnderTest) {
		String methodTestString = "\n\t@Test\n"
				+ "\tpublic void testClassMethods() {\n"
				+ "\t\tassertEquals(" + classUnderTest.getMethods().size() + ", classUnderTest.getDeclaredMethods().length, "
				+ "\"" + classUnderTest.getQualifiedName() + " is expected to have exactly " + classUnderTest.getMethods().size() + " methods!\");\n";
		
		for (MethodUnderTest methodUnderTest : classUnderTest.getMethods()) {
			methodTestString += "\n\t\ttry {\n"
					+ "\t\t\tMethod methodUnderTest = classUnderTest.getDeclaredMethod(\"" + methodUnderTest.getName() + "\""
					+ (methodUnderTest.getParameters().isEmpty() ? "" : (", " + ParameterTestConverter.createParameterClassList(methodUnderTest.getParameters()))) + ");\n"
					+ "\t\t\tassertEquals(" + methodUnderTest.getModifiers() + ", methodUnderTest.getModifiers(), \"The modifiers of the method " + methodUnderTest.getName() + " with "
					+ (methodUnderTest.getParameters().isEmpty() ? "no parameters" : "parameters " + ParameterTestConverter.createParameterList(methodUnderTest.getParameters()))
					+ " in " + classUnderTest.getQualifiedName() + " do not match!\");\n"
					+ "\t\t\t//TODO: Check return type\n";

					if (!methodUnderTest.getParameters().isEmpty()) {
						methodTestString += "\n" + ParameterTestConverter.createParameterTests(methodUnderTest, methodUnderTest.getParameters());
					}
					
					methodTestString += "\t\t} catch (NoSuchMethodException | SecurityException e) {\n"
					+ "\t\t\tfail(\"" + classUnderTest.getQualifiedName() + " is expected to have a method named " + methodUnderTest.getName() + " with "
					+ (methodUnderTest.getParameters().isEmpty() ? "no parameters" : "parameters " + ParameterTestConverter.createParameterList(methodUnderTest.getParameters())) + "!\");\n"
					+ "\t\t}\n";
		}
		
		return methodTestString + "\t}\n";
	}
}
