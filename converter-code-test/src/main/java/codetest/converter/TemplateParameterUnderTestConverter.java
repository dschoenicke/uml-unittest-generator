package codetest.converter;

import code.CodeElement;
import code.CodeTemplateParameter;
import lombok.experimental.UtilityClass;
import test.testobjects.ClassUnderTest;
import test.testobjects.TemplateParameterUnderTest;

/**
 * Provides a static method to convert {@link code.CodeTemplateParameter}s of a given {@link code.CodeElement} to {@link test.testobjects.TemplateParameterUnderTest} and adding them to a {@link test.testobjects.ClassUnderTest}.
 * 
 * @author dschoenicke
 *
 */
@UtilityClass
public class TemplateParameterUnderTestConverter {

	/**
	 * Static method to convert {@link code.CodeTemplateParameter}s of a given {@link code.CodeElement} to {@link test.testobjects.TemplateParameterUnderTest} and adding them to a {@link test.testobjects.ClassUnderTest}.
	 * 
	 * @param codeElement the {@link code.CodeElement} containing the {@link code.CodeTemplateParameter}s to be converted.
	 * @param classUnderTest the {@link test.testobjects.ClassUnderTest} to which the converted {@link test.testobjects.TemplateParameterUnderTest} should be added to.
	 */
	public static void convertTemplateParameters(CodeElement codeElement, ClassUnderTest classUnderTest) {
		for (CodeTemplateParameter templateParameter : codeElement.getTemplateParameters()) {
			new TemplateParameterUnderTest(templateParameter.getName(), templateParameter.getType(), classUnderTest);
		}
	}
}
