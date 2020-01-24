package outputjunit.converter;

import junit.JunitTemplateParameterUnderTest;
import junit.JunitTestClass;
import lombok.experimental.UtilityClass;
import test.testobjects.ClassUnderTest;

/**
 * Provides a static method to convert {@link test.testobjects.TemplateParameterUnderTest} to {@link junit.JunitTemplateParameterUnderTest}.
 * 
 * @author dschoenicke
 *
 */
@UtilityClass
public class TemplateParameterConverter {
	
	/**
	 * Converts the {@link test.testobjects.TemplateParameterUnderTest}s of a given {@link test.testobjects.ClassUnderTest} to {@link junit.JunitTemplateParameterUnderTest}.
	 * 
	 * @param classUnderTest the {@link test.testobjects.ClassUnderTest} containing the {@link test.testobjects.TemplateParameterUnderTest}s to be converted
	 * @param testClass the {@link junit.JunitTestClass} to which the converted {@link junit.JunitTemplateParameterUnderTest}s should be added
	 */
	static void convertTemplateParameters(ClassUnderTest classUnderTest, JunitTestClass testClass) {
		classUnderTest.getTemplateParameters().forEach(templateParameter -> {
			JunitTemplateParameterUnderTest junitTemplateParameter = new JunitTemplateParameterUnderTest(templateParameter.getParameterName(), templateParameter.getBoundedType());
			testClass.addTemplateParameter(junitTemplateParameter);
			AssertionConverter.createTemplateParameterAssertions(classUnderTest, junitTemplateParameter);
		});
	}
}
