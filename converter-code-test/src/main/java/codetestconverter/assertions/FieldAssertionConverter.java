package codetestconverter.assertions;

import code.CodeElement;
import code.CodeEnumeration;
import code.CodeField;
import code.CodeLiteral;
import code.CodeModifier;
import test.TestAssertion;
import test.TestAssertionType;
import test.TestMethod;

/**
 * Provides a static method to create {@link test.TestAssertion}s for the {@link code.CodeField}s of a given {@link code.CodeElement}. And a static method to
 * create {@link test.TestAssertion}s for the {@link code.CodeLiteral}s of a given {@link code.CodeEnumeration}.
 * 
 * @author dschoenicke
 *
 */
public class FieldAssertionConverter {

	/**
	 * Static method to create {@link test.TestAssertion}s for the {@link code.CodeField}s of a given {@link code.CodeElement} and adding them to a given {@link test.TestMethod}.<br>
	 * Creates {@link TestAssertion}s for the amount of {@link code.CodeField}s, whether a {@link code.CodeField} is
	 * defined, whether the type of a {@link code.CodeField} matches and whether the modifiers of a defined {@link code.CodeField} match.
	 * 
	 * @param codeElement the {@link code.CodeElement} containing the {@link code.CodeField}s
	 * @param testMethod the {@link test.TestMethod} to add the created {@link test.TestAssertion}s to.
	 */
	public static void createFieldAssertions(CodeElement codeElement, TestMethod testMethod) {
		testMethod.addAssertion(new TestAssertion(TestAssertionType.COUNT,
				codeElement.getQualifiedName() + " is expected to have exactly " + 
					codeElement.getFields().size() + " fields!"));
	
		for (CodeField codeField : codeElement.getFields()) {
			testMethod.addAssertion(new TestAssertion(TestAssertionType.HASFIELD,
				codeElement.getQualifiedName() + " is expected to have a field with name " + codeField.getName() + "!"));
			
			testMethod.addAssertion(new TestAssertion(TestAssertionType.HASTYPE, 
				"The type of field" + codeElement.getQualifiedName() + "." + codeField.getName() +
					" is expected to be " + codeField.getType() + "!"));
			
			testMethod.addAssertion(new TestAssertion(TestAssertionType.MODIFIERS, 
				"The modifiers of field" + codeElement.getQualifiedName() + "." + codeField.getName() +
					" do not match the defined ones.\n" + "Expected " + CodeModifier.toString(codeField.getModifiers()) + "."));
		}
	}

	/**
	 * Static method to create {@link test.TestAssertion}s for the {@link code.CodeLiteral}s of a given {@link code.CodeEnumeration} and adding them to a given {@link test.TestMethod}.<br>
	 * Creates {@link TestAssertion}s for the amount of {@link code.CodeLiteral}s and whether a {@link code.CodeLiteral} is defined.
	 * 
	 * @param codeEnumeration the {@link code.CodeEnumeration} containing the {@link code.CodeLiteral}s
	 * @param testMethod the {@link test.TestMethod} to add the created {@link test.TestAssertion}s to.
	 */
	public static void createEnumConstantAssertions(CodeEnumeration codeEnumeration, TestMethod testMethod) {
		testMethod.addAssertion(new TestAssertion(TestAssertionType.COUNT,
				codeEnumeration.getQualifiedName() + " is expected to have exactly " + 
					codeEnumeration.getCodeLiterals().size() + " enumeration constants!"));
		
		for (CodeLiteral codeLiteral : codeEnumeration.getCodeLiterals()) {
			testMethod.addAssertion(new TestAssertion(TestAssertionType.HASENUMCONSTANT,
				codeEnumeration.getQualifiedName() + " is expected to have an enumeration constant " + codeLiteral.getName() + "!"));
		}
	}
}
