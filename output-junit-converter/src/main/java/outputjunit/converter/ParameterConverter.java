package outputjunit.converter;

import java.lang.reflect.Modifier;
import java.util.ArrayList;

import junit.JunitAssertion;
import junit.JunitParameterUnderTest;
import junit.JunitTestClass;
import test.testobjects.ConstructorUnderTest;
import test.testobjects.MethodUnderTest;
import test.testobjects.ParameterUnderTest;

/**
 * Provides static methods to convert {@link test.testobjects.ParameterUnderTest} to {@link junit.JunitParameterUnderTest} and 
 * creating Strings with the parameter types and parameter type classes
 * 
 * @author dschoenicke
 *
 */
public class ParameterConverter {

	/**
	 * Converts {@link junit.JunitParameterUnderTest}s out of the {@link test.testobjects.ParameterUnderTest} of a given {@link test.testobjects.ConstructorUnderTest}
	 * 
	 * @param constructor the {@link test.testobjects.ConstructorUnderTest} which {@link test.testobjects.ParameterUnderTest} should be converted
	 * @param testClass the {@link junit.JunitTestClass} owning the constructor
	 * @return a list of converted {@link junit.JunitParameterUnderTest}s
	 */
	static ArrayList<JunitParameterUnderTest> createParameters(ConstructorUnderTest constructor, JunitTestClass testClass) {
		ArrayList<JunitParameterUnderTest> junitParameters = new ArrayList<>();
		constructor.getParameters().forEach(param -> {
			boolean isFinal = Modifier.isFinal(param.getModifiers());
			junitParameters.add(new JunitParameterUnderTest(param.getName(), isFinal, 
					new JunitAssertion(String.valueOf(isFinal), "Modifier.isFinal(parameterUnderTest.getModifiers())", "The parameter " + param.getName() + " of the constructor with parameters (" + createParameterTypes(constructor.getParameters()) + ") in " + testClass.getClassName() + " must " + (isFinal ? "" : "not ") + "be final!")));
		});
		
		return junitParameters;
	}
	
	/**
	 * Converts {@link junit.JunitParameterUnderTest}s out of the {@link test.testobjects.ParameterUnderTest} of a given {@link test.testobjects.MethodUnderTest}
	 * 
	 * @param method the {@link test.testobjects.MethodUnderTest} which {@link test.testobjects.ParameterUnderTest} should be converted
	 * @param testClass the {@link junit.JunitTestClass} owning the method
	 * @return a list of converted {@link junit.JunitParameterUnderTest}s
	 */
	static ArrayList<JunitParameterUnderTest> createParameters(MethodUnderTest method, JunitTestClass testClass) {
		ArrayList<JunitParameterUnderTest> junitParameters = new ArrayList<>();
		method.getParameters().forEach(param -> {
			boolean isFinal = Modifier.isFinal(param.getModifiers());
			junitParameters.add(new JunitParameterUnderTest(param.getName(), isFinal, 
					new JunitAssertion(String.valueOf(isFinal), "Modifier.isFinal(parameterUnderTest.getModifiers())", "The parameter " + param.getName() + " of the method " + method.getName() + " with parameters (" + createParameterTypes(method.getParameters()) + ") in " + testClass.getClassName() + " must " + (isFinal ? "" : "not ") + "be final!")));
		});
		
		return junitParameters;
	}
	
	/**
	 * Creates a String with the parameter type classes of the given {@link test.testobjects.ParameterUnderTest}s.
	 * 
	 * @param parameters the {@link test.testobjects.ParameterUnderTest}s to be converted
	 * @return the String with the parameter type classes
	 */
	static String createParameterTypeClasses(ArrayList<ParameterUnderTest> parameters) {
		if (parameters.isEmpty()) {
			return "";
		}
		
		String parameterTypeClasses = "";

		for (ParameterUnderTest param : parameters) {
			parameterTypeClasses += param.getType() + ".class, ";
		}
		
		return parameterTypeClasses.substring(0, parameterTypeClasses.length() - 2);
	}
	
	/**
	 * Creates a String with the parameter types of the given {@link test.testobjects.ParameterUnderTest}s.
	 * 
	 * @param parameters the {@link test.testobjects.ParameterUnderTest}s to be converted
	 * @return the String with the parameter types
	 */
	static String createParameterTypes(ArrayList<ParameterUnderTest> parameters) {
		if (parameters.isEmpty()) {
			return "";
		}
		
		String parameterTypeClasses = "";

		for (ParameterUnderTest param : parameters) {
			parameterTypeClasses += param.getType() + ", ";
		}
		
		return parameterTypeClasses.substring(0, parameterTypeClasses.length() - 2);
	}
}
