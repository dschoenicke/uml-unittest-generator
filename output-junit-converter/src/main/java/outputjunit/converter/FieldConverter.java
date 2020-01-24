package outputjunit.converter;

import junit.JunitFieldUnderTest;
import junit.JunitTestClass;
import lombok.experimental.UtilityClass;
import test.testobjects.ClassUnderTest;

/**
 * Provides a static method to convert {@link test.testobjects.FieldUnderTest} to {@link junit.JunitFieldUnderTest}.
 * 
 * @author dschoenicke
 *
 */
@UtilityClass
public class FieldConverter {

	/**
	 * Converts the {@link test.testobjects.FieldUnderTest}s of a given {@link test.testobjects.ClassUnderTest} to {@link junit.JunitFieldUnderTest}.
	 * 
	 * @param classUnderTest the {@link test.testobjects.ClassUnderTest} containing the {@link test.testobjects.FieldUnderTest}s to be converted
	 * @param testClass the {@link junit.JunitTestClass} to which the converted {@link junit.JunitFieldUnderTest} should be added
	 */
	static void convertFields(ClassUnderTest classUnderTest, JunitTestClass testClass) {
		classUnderTest.getFields().forEach(field -> {
			JunitFieldUnderTest junitField = new JunitFieldUnderTest(field.getName(), field.getType(), field.isCanBeNull() && !field.isHasMultiplicity(), field.isHasMultiplicity());
			testClass.addField(junitField);
			AssertionConverter.createFieldAssertions(field, classUnderTest, junitField);
		});
	}
}
