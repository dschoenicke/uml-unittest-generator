package codetestconverter.assertions;

import code.CodeElement;
import code.CodeMethod;
import code.CodeModifier;
import codetestconverter.testclass.ParameterConverter;
import test.TestAssertion;
import test.TestAssertionType;
import test.TestMethod;

/**
 * Provides a static method to create {@link test.TestAssertion}s for the {@link code.CodeMethod}s of a given {@link code.CodeElement}.
 * 
 * @author dschoenicke
 *
 */
public class MethodAssertionConverter {

	/**
	 * Static method to create {@link test.TestAssertion}s for the {@link code.CodeMethod}s of a given {@link code.CodeElement} and adding them to a given {@link test.TestMethod}.<br>
	 * Creates {@link TestAssertion}s for the amount of {@link code.CodeMethod}s, whether a {@link code.CodeMethod} is
	 * defined, whether the return type of a {@link code.CodeMethod} matches and whether the modifiers of a defined {@link code.CodeMethod} match.
	 * 
	 * @param codeElement the {@link code.CodeElement} containing the {@link code.CodeMethod}s
	 * @param testMethod the {@link test.TestMethod} to add the created {@link test.TestAssertion}s to.
	 */
	public static void createMethodAssertions(CodeElement codeElement, TestMethod testMethod) {
		testMethod.addAssertion(new TestAssertion(TestAssertionType.COUNT,
				codeElement.getQualifiedName() + " is expected to have exactly " + 
					codeElement.getMethods().size() + " methods!"));
	
		for (CodeMethod codeMethod : codeElement.getMethods()) {
			String parameterList = ParameterConverter.createParameterList(codeMethod.getParameters());
			
			testMethod.addAssertion(new TestAssertion(TestAssertionType.HASMETHOD,
				codeElement.getQualifiedName() + " is expected to have a method " + codeMethod.getName() + 
					" with parameters (" +  parameterList + ")!"));
			
			testMethod.addAssertion(new TestAssertion(TestAssertionType.HASTYPE,
				codeElement.getQualifiedName() + "." +  codeMethod.getName() + " with parameters (" +  parameterList + ")" + 
					"is expected to have return type " + codeMethod.getReturnType() + "!"));
			
			testMethod.addAssertion(new TestAssertion(TestAssertionType.MODIFIERS, 
				"The modifiers of method" + codeElement.getQualifiedName() + "." + codeMethod.getName() + 
					"() with parameters (" + parameterList + ") do not match the defined ones.\n" + 
					"Expected " + CodeModifier.toString(codeMethod.getModifiers()) + "."));
		}
	}
}
