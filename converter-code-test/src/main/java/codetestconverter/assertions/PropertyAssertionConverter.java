package codetestconverter.assertions;

import code.CodeClass;
import code.CodeElement;
import code.CodeEnumeration;
import code.CodeInterface;
import code.CodeModifier;
import test.TestAssertion;
import test.TestAssertionType;
import test.TestMethod;

/**
 * Provides a static method to create {@link test.TestAssertion}s for a given {@link code.CodeElement}.
 * 
 * @author dschoenicke
 *
 */
public class PropertyAssertionConverter {

	/**
	 * Static method to create {@link test.TestAssertion}s for a given {@link code.CodeElement} and adding them to a given {@link test.TestMethod}.<br>
	 * Creates {@link test.TestAssertion}s to check whether a class with the name of the {@link code.CodeElement} is defined,
	 * whether its modifiers match, whether it is a class, interface or enumeration and whether its potential nest host matches.
	 * 
	 * @param codeElement the {@link code.CodeElement} to create the {@link test.TestAssertion}s for.
	 * @param testMethod the {@link test.TestMethod} to add the created {@link test.TestAssertion}s to.
	 */
	public static void createPropertyAssertions(CodeElement codeElement, TestMethod testMethod) {
		testMethod.addAssertion(new TestAssertion(TestAssertionType.CLASSEXISTS,
				"The class " + codeElement.getQualifiedName() + " has not been implemented!\n" + 
						"Maybe you missspelled the class name."));
		
		testMethod.addAssertion(new TestAssertion(TestAssertionType.MODIFIERS,
				"The modifiers of " + codeElement.getQualifiedName() + " do not match the defined ones.\n" + 
					"Expected " + CodeModifier.toString(codeElement.getModifiers()) + "."));
		
		if (codeElement instanceof CodeClass) {
			testMethod.addAssertion(new TestAssertion(TestAssertionType.ISCLASS, 
			codeElement.getQualifiedName() + " is expected to be a class!"));
		} 
		else if (codeElement instanceof CodeInterface) {
			testMethod.addAssertion(new TestAssertion(TestAssertionType.ISINTERFACE, 
			codeElement.getQualifiedName() + " is expected to be an interface!"));
		} 
		else if (codeElement instanceof CodeEnumeration) {
			testMethod.addAssertion(new TestAssertion(TestAssertionType.ISENUMERATION, 
			codeElement.getQualifiedName() + " is expected to be an enumeration!"));
		}
		
		if (codeElement.getParent() instanceof CodeElement) {
			testMethod.addAssertion(new TestAssertion(TestAssertionType.HASNESTHOST, 
			codeElement.getQualifiedName() + " is expected to be a nested member of " + ((CodeElement) codeElement.getParent()).getQualifiedName() + "!"));
		}
	}
}
