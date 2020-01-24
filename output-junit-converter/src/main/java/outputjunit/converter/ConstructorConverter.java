package outputjunit.converter;

import junit.JunitConstructorUnderTest;
import junit.JunitTestClass;
import lombok.experimental.UtilityClass;
import test.testobjects.ClassUnderTest;

/**
 * Provides a static method to convert {@link test.testobjects.ConstructorUnderTest} to {@link junit.JunitConstructorUnderTest}.
 * 
 * @author dschoenicke
 *
 */
@UtilityClass
public class ConstructorConverter {

	/**
	 * Converts the {@link test.testobjects.ConstructorUnderTest}s of a given {@link test.testobjects.ClassUnderTest} to {@link junit.JunitConstructorUnderTest}.
	 * 
	 * @param classUnderTest the {@link test.testobjects.ClassUnderTest} containing the {@link test.testobjects.ConstructorUnderTest}s to be converted
	 * @param testClass the {@link junit.JunitTestClass} to which the converted {@link junit.JunitConstructorUnderTest}s should be added
	 */
	static void convertConstructors(ClassUnderTest classUnderTest, JunitTestClass testClass) {
		classUnderTest.getConstructors().forEach(constructor -> {
			JunitConstructorUnderTest junitConstructor = new JunitConstructorUnderTest(
					ParameterConverter.createParameterTypeClasses(constructor.getParameters()),
					ParameterConverter.createParameterTypes(constructor.getParameters())
			);
			
			junitConstructor.getParameters().addAll(ParameterConverter.createParameters(constructor, testClass));
			testClass.addConstructor(junitConstructor);
			AssertionConverter.createConstructorAssertions(constructor, classUnderTest, junitConstructor);
		});
	}
}
