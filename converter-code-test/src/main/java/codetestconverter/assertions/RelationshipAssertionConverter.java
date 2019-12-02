package codetestconverter.assertions;

import java.util.ArrayList;

import code.CodeClass;
import code.CodeElement;
import code.CodeEnumeration;
import code.CodeInterface;
import test.TestAssertion;
import test.TestAssertionType;
import test.TestMethod;

/**
 * Provides a static method to create {@link test.TestAssertion}s for the super classes and super interfaces of a given {@link code.CodeElement}.
 * 
 * @author dschoenicke
 *
 */
public class RelationshipAssertionConverter {

	/**
	 * Static method checking the type of the given {@link code.CodeElement} and getting the super {@link code.CodeClass} if the {@link code.CodeElement}
	 * is of type {@link code.CodeClass} and a list of super interfaces if the {@link code.CodeElement} is of type {@link code.CodeClass} or {@link code.CodeInterface}.<br>
	 * The creation of {@link test.TestAssertion}s is delegated to the corresponding methods {@link codetestconverter.assertions.RelationshipAssertionConverter#createSuperClassAssertion} 
	 * and {@link codetestconverter.assertions.RelationshipAssertionConverter#createSuperInterfaceAssertions}.
	 * 
	 * @param codeElement the {@link code.CodeElement} to create {@link test.TestAssertion}s for.
	 * @param testMethod the {@link test.TestMethod} to add the generated {@link test.TestAssertion}s to.
	 */
	public static void createRelationshipAssertions(CodeElement codeElement, TestMethod testMethod) {
		CodeElement superClass = null;
		ArrayList<CodeElement> superInterfaces = new ArrayList<>();
		
		if (codeElement instanceof CodeClass) {
			superClass = ((CodeClass) codeElement).getSuperClass();
			superInterfaces.addAll(((CodeClass) codeElement).getInterfaces());
			testMethod.addAssertion(createSuperClassAssertion(codeElement, superClass));
			
			for (TestAssertion interfaceAssertion : createSuperInterfaceAssertions(codeElement, superInterfaces)) {
				testMethod.addAssertion(interfaceAssertion);
			}
		}
		else if (codeElement instanceof CodeInterface) {
			superInterfaces.addAll(((CodeInterface) codeElement).getInterfaces());

			for (TestAssertion interfaceAssertion : createSuperInterfaceAssertions(codeElement, superInterfaces)) {
				testMethod.addAssertion(interfaceAssertion);
			}
		}
		else {
			superInterfaces.addAll(((CodeEnumeration) codeElement).getInterfaces());

			for (TestAssertion interfaceAssertion : createSuperInterfaceAssertions(codeElement, superInterfaces)) {
				testMethod.addAssertion(interfaceAssertion);
			}
		}
	}
	
	/**
	 * Static method to create a {@link test.TestAssertion} for a given super class of a {@link code.CodeElement}.<br>
	 * If the given super class is {@literal null}, a {@link test.TestAssertion} to check, that the implemented class extends no super class, is created.
	 * If the given super class is not {@literal null}, a {@link test.TestAssertion} to check, that the implemented class extends the given super class, is created.
	 * 
	 * @param codeElement the {@link code.CodeElement} which super class should be checked.
	 * @param superClass the {@link code.CodeElement} acting as the super class, can be {@literal null}
	 * @return the created {@link test.TestAssertion}
	 */
	private static TestAssertion createSuperClassAssertion(CodeElement codeElement, CodeElement superClass) {
		TestAssertion assertion = null;
		
		if (superClass == null) {
			assertion = new TestAssertion(TestAssertionType.HASSUPERCLASS,
					codeElement.getName() + " is expected to extend no super class!");
		}
		else {
			assertion = new TestAssertion(TestAssertionType.HASSUPERCLASS,
					codeElement.getName() + " is expected to extend " + superClass.getQualifiedName() + "!");	
		}
		
		return assertion;
	}
	
	/**
	 * Static method to create {@link test.TestAssertion}s for given super interfaces of a {@link code.CodeElement} concerning the amount of super interfaces
	 * and whether the {@link code.CodeElement} implements a specific super interface.
	 * 
	 * @param codeElement the {@link code.CodeElement} which super interfaces should be checked.
	 * @param superInterfaces a list of {@link code.CodeElement}s acting as super interfaces of the given {@link code.CodeElement}, for which the {@link test.TestAssertion}s should be created.
	 * @return the list of created {@link test.TestAssertion}s
	 */
	private static ArrayList<TestAssertion> createSuperInterfaceAssertions(CodeElement codeElement, ArrayList<CodeElement> superInterfaces) {
		ArrayList<TestAssertion> assertions = new ArrayList<TestAssertion>();
		String keyword = (codeElement instanceof CodeInterface ? "extend" : "implement");
		assertions.add(new TestAssertion(TestAssertionType.COUNT,
				codeElement.getName() + " is expected to " + keyword + " " + superInterfaces.size() + " Interfaces!"));
		
		
		for (CodeElement superInterface : superInterfaces) {
			assertions.add(new TestAssertion(TestAssertionType.HASSUPERINTERFACE,
					codeElement.getName() + " is expected to " + keyword + " the interface " + superInterface.getName() + "!"));
		}
		
		return assertions;
	}
}
