package outputjunit.converter;

import java.lang.reflect.Modifier;

import lombok.experimental.UtilityClass;

/**
 * Provides static methods to generate messages for modifier {@link junit.JunitAssertion}s
 * 
 * @author dschoenicke
 *
 */
@UtilityClass
class AssertionMessageConverter {

	/**
	 * Generates the message for a modifier {@link junit.JunitAssertion} of a {@link junit.JunitTestClass}
	 * 
	 * @param className the name of the class, the modifier value belongs to
	 * @param expectedValue true if the modifier is expected to be set, false otherwise
	 * @param modifier the modifier value representing the modifier
	 * @return the generated message
	 */
	static String getClassModifierAssertionMessage(String className, boolean expectedValue, int modifier) {
		return className + " " + getMustString(expectedValue) + Modifier.toString(modifier) + "!";
	}
	
	/**
	 * Generates the message for a modifier {@link junit.JunitAssertion} of a {@link junit.JunitFieldUnderTest}
	 * 
	 * @param className the name of the class, the {@link junit.JunitFieldUnderTest} belongs to
	 * @param fieldName the name of the field, the modifier value belongs to
	 * @param expectedValue true if the modifier is expected to be set, false otherwise
	 * @param modifier the modifier value representing the modifier
	 * @return the generated message
	 */
	static String getFieldModifierAssertionMessage(String className, String fieldName, boolean expectedValue, int modifier) {
		return className + "#" + fieldName + " " +getMustString(expectedValue) + Modifier.toString(modifier) + "!";
	}
	
	/**
	 * Generates the message for a modifier {@link junit.JunitAssertion} of a {@link junit.JunitConstructorUnderTest}
	 * 
	 * @param className the name of the class, the {@link junit.JunitConstructorUnderTest} belongs to
	 * @param parameters the string enumerating the {@link junit.JunitParameterUnderTest}s of the constructor
	 * @param expectedValue true if the modifier is expected to be set, false otherwise
	 * @param modifier the modifier value representing the modifier
	 * @return the generated message
	 */
	static String getConstructorModifierAssertionMessage(String className, String parameters, boolean expectedValue, int modifier) {
		return "The constructor with parameters (" + parameters + ") in " + className + " " + getMustString(expectedValue) + Modifier.toString(modifier) + "!";
	}
	
	/**
	 * Generates the message for a modifier {@link junit.JunitAssertion} of a {@link junit.JunitMethodUnderTest}
	 * 
	 * @param className the name of the class, the {@link junit.JunitMethodUnderTest} belongs to
	 * @param methodName the name of the {@link junit.JunitMethodUnderTest} the modfier belongs to
	 * @param parameters the string enumerating the {@link junit.JunitParameterUnderTest}s of the method
	 * @param expectedValue true if the modifier is expected to be set, false otherwise
	 * @param modifier the modifier value representing the modifier
	 * @return the generated message
	 */
	static String getMethodModifierAssertionMessage(String className, String methodName, String parameters, boolean expectedValue, int modifier) {
		return "The method " + methodName + " with parameters (" + parameters + ") in " + className + " " + getMustString(expectedValue) + Modifier.toString(modifier) + "!";
	}
	
	/**
	 * Constructs the 'must' clause for the {link junit.JunitAssertion} messages
	 * 
	 * @param expectedValue the boolean value
	 * @return 'must be ' if the value is true, 'must not be ' otherwise
	 */
	static String getMustString(boolean expectedValue) {
		return "must" + (expectedValue ? "" : " not") + " be ";
	}
}
