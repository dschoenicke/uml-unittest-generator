package outputjunit.converter;

import junit.JunitMethodUnderTest;
import junit.JunitTestClass;
import test.testobjects.ClassUnderTest;

/**
 * Provides a static method to convert {@link test.testobjects.MethodUnderTest} to {@link junit.JunitMethodUnderTest}.
 * 
 * @author dschoenicke
 *
 */
public class MethodConverter {

	/**
	 * Converts the {@link test.testobjects.MethodUnderTest}s of a given {@link test.testobjects.ClassUnderTest} to {@link junit.JunitMethodUnderTest}.
	 * 
	 * @param classUnderTest the {@link test.testobjects.ClassUnderTest} containing the {@link test.testobjects.MethodUnderTest}s to be converted
	 * @param testClass the {@link junit.JunitTestClass} to which the converted {@link junit.JunitMethodUnderTest}s should be added
	 */
	static void convertMethods(ClassUnderTest classUnderTest, JunitTestClass testClass) {
		classUnderTest.getMethods().forEach(method -> {
			JunitMethodUnderTest junitMethod = new JunitMethodUnderTest(method.getName(), 
					method
						.getReturnType()
						.getType()
						.replace("$", ".")
						.substring(method.getReturnType().getType().lastIndexOf(".")), 
					ParameterConverter.createParameterTypeClasses(method.getParameters()));
			
			junitMethod.getParameters().addAll(ParameterConverter.createParameters(method, testClass));
			testClass.addMethod(junitMethod);
			AssertionConverter.createMethodAssertions(method, classUnderTest, junitMethod);
		});
	}
}
