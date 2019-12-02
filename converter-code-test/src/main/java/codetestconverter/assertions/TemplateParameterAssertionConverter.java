package codetestconverter.assertions;

import code.CodeElement;
import code.CodeTemplateParameter;
import test.TestAssertion;
import test.TestAssertionType;
import test.TestMethod;

/**
 * Provides a static method to create {@link test.TestAssertion}s for the {@link code.CodeTemplateParameter}s of a given {@link code.CodeElement}.
 * 
 * @author dschoenicke
 *
 */
public class TemplateParameterAssertionConverter {

	/**
	 * Static method to create {@link test.TestAssertion}s for the {@link code.CodeTemplateParameter}s of a given {@link code.CodeElement} and adding them to a given {@link test.TestMethod}.<br>
	 * Creates {@link TestAssertion}s for the amount of {@link code.CodeTemplateParameter}s and whether a template parameter with the
	 * {@link code.CodeTemplateParameter}s name and bounded type is defined.
	 * 
	 * @param codeElement the {@link code.CodeElement} containing the {@link code.CodeTemplateParameter}s
	 * @param testMethod the {@link test.TestMethod} to add the created {@link test.TestAssertion}s to.
	 */
	public static void createTemplateParameterAssertions(CodeElement codeElement, TestMethod testMethod) {
		testMethod.addAssertion(new TestAssertion(TestAssertionType.COUNT,
				codeElement.getName() + " is expected to have exactly " + codeElement.getTemplateParameters().size() + " template parameters!"));
		
		for (CodeTemplateParameter templateParameter : codeElement.getTemplateParameters()) {
			testMethod.addAssertion(new TestAssertion(TestAssertionType.HASTEMPLATEPARAMETER,
				codeElement.getName() + " is expected to have a template parameter with name "
				+ templateParameter.getName() + " and constraining type " + templateParameter.getType() + "!"));
		}
	}
}
