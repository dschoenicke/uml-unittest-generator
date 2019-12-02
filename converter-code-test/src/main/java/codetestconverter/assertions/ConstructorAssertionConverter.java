package codetestconverter.assertions;

import code.CodeConstructor;
import code.CodeElement;
import code.CodeModifier;
import codetestconverter.testclass.ParameterConverter;
import test.TestAssertion;
import test.TestAssertionType;
import test.TestMethod;

/**
 * Provides a static method to create {@link test.TestAssertion}s for the {@link code.CodeConstructor}s of a given {@link code.CodeElement}.
 * 
 * @author dschoenicke
 *
 */
public class ConstructorAssertionConverter {

	/**
	 * Static method to create {@link test.TestAssertion}s for the {@link code.CodeConstructor}s of a given {@link code.CodeElement} and adding them to a given {@link test.TestMethod}.<br>
	 * Creates {@link TestAssertion}s for the amount of {@link code.CodeConstructor}s, whether a {@link code.CodeConstructor} is
	 * defined and whether the modifiers of a defined {@link code.CodeConstructor} match.
	 * 
	 * @param codeElement the {@link code.CodeElement} containing the {@link code.CodeConstructor}s
	 * @param testMethod the {@link test.TestMethod} to add the created {@link test.TestAssertion}s to.
	 */
	public static void createConstructorAssertions(CodeElement codeElement, TestMethod testMethod) {
		testMethod.addAssertion(new TestAssertion(TestAssertionType.COUNT,
				codeElement.getQualifiedName() + " is expected to have exactly " + 
					codeElement.getConstructors().size() + " constructors!"));

		for (CodeConstructor codeConstructor : codeElement.getConstructors()) {
			String parameterList = ParameterConverter.createParameterList(codeConstructor.getParameters());
			
			testMethod.addAssertion(new TestAssertion(TestAssertionType.HASCONSTRUCTOR,
				codeElement.getQualifiedName() + " is expected to have a constructor with\n" + 
					"parameters (" +  parameterList + ")!"));
			
			testMethod.addAssertion(new TestAssertion(TestAssertionType.MODIFIERS, 
					"The modifiers of constructor" + codeElement.getQualifiedName() + "with parameters (" + parameterList +
					") do not match the defined ones. \n" + "Expected " + CodeModifier.toString(codeConstructor.getModifiers()) + "."));
		}
	}
}
