package outputjunit.testmethod;

import java.util.ArrayList;

import test.testobjects.ConstructorUnderTest;
import test.testobjects.MethodUnderTest;
import test.testobjects.ParameterUnderTest;
import test.testobjects.TestObject;

public class ParameterTestConverter {

	public static String createParameterList(ArrayList<ParameterUnderTest> parameters) {
		String parameterList = "";
		
		for (ParameterUnderTest parameter : parameters) {
			parameterList += parameter.getType() + ", ";
		}
		
		return parameterList.isEmpty() ? parameterList : parameterList.substring(0, parameterList.length() - 2);
	}
	
	public static String createParameterClassList(ArrayList<ParameterUnderTest> parameters) {
		String parameterClassList = createParameterList(parameters);
		return parameterClassList.isEmpty() ? parameterClassList : parameterClassList.replace(",", ".class,") + ".class";
	}
	
	public static String createParameterTests(TestObject testObject, ArrayList<ParameterUnderTest> parameters) {
		String parameterTestParent = "";
		String parameterParent = "";
		int index = 0;
		String parameterTestString = "\t\t\tParameter parameterUnderTest;\n";
		
		if (testObject instanceof ConstructorUnderTest) {
			parameterTestParent = "constructorUnderTest";
			parameterParent = "constructor with parameters " + createParameterList(parameters) + " in " + ((ConstructorUnderTest) testObject).getParent().getQualifiedName();
		}
		else if (testObject instanceof MethodUnderTest) {
			parameterTestParent = "methodUnderTest";
			parameterParent = "method " + ((MethodUnderTest) testObject).getName() + " with parameters " + createParameterList(parameters) + " in " + ((MethodUnderTest) testObject).getParent().getQualifiedName();
		}
		else {
			return "";
		}
		
		for (ParameterUnderTest parameterUnderTest : parameters) {
			parameterTestString += "\t\t\tparameterUnderTest = " + parameterTestParent + ".getParameters()[" + index + "];\n"
					+ "\t\t\tassertEquals(\"" + parameterUnderTest.getName() + "\", parameterUnderTest.getName(), "
					+ "\"The name of the " + (index + 1) + ". parameter of the " + parameterParent + " does not match!\");\n"
					+ "\t\t\tassertEquals(" + parameterUnderTest.getModifiers() + ", parameterUnderTest.getModifiers(), "
					+ "\"The modifiers of the " + (index + 1) + ". parameter of the " + parameterParent + " do not match!\");\n";
					
			index ++;
		}
		
		return parameterTestString;
	}
}
