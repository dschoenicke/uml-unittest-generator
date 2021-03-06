package outputjunit.converter;

import junit.JunitMethodUnderTest;
import junit.JunitTestClass;
import lombok.experimental.UtilityClass;
import test.testobjects.ClassUnderTest;

/**
 * Provides a static method to convert {@link test.testobjects.MethodUnderTest} to {@link junit.JunitMethodUnderTest}.
 * 
 * @author dschoenicke
 *
 */
@UtilityClass
public class MethodConverter {
	
	/**
	 * Converts the {@link test.testobjects.MethodUnderTest}s of a given {@link test.testobjects.ClassUnderTest} to {@link junit.JunitMethodUnderTest}.
	 * 
	 * @param classUnderTest the {@link test.testobjects.ClassUnderTest} containing the {@link test.testobjects.MethodUnderTest}s to be converted
	 * @param testClass the {@link junit.JunitTestClass} to which the converted {@link junit.JunitMethodUnderTest}s should be added
	 */
	static void convertMethods(ClassUnderTest classUnderTest, JunitTestClass testClass) {
		classUnderTest.getMethods().forEach(method -> {
			String returnType = method.getReturnType().getType().replace("$", ".");
			
			if (returnType.contains(".")) {
				returnType = returnType.substring(returnType.lastIndexOf('.') + 1);
			}
			
			JunitMethodUnderTest junitMethod = new JunitMethodUnderTest(method.getName(), 
					returnType,
					ParameterConverter.createParameterTypeClasses(method.getParameters()),
					ParameterConverter.createParameterTypes(method.getParameters()),
					method.getReturnType().getCanBeNull() && !method.getReturnType().getHasMultiplicity(),
					method.getReturnType().getHasMultiplicity());
			
			junitMethod.getParameters().addAll(ParameterConverter.createParameters(method, testClass));
			testClass.addMethod(junitMethod);
			AssertionConverter.createMethodAssertions(method, classUnderTest, junitMethod);
		});
	}
}
