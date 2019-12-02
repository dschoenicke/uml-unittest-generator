package codetestconverter.testclass;

import code.CodeElement;
import code.CodeEnumeration;
import codetestconverter.assertions.ConstructorAssertionConverter;
import codetestconverter.assertions.FieldAssertionConverter;
import codetestconverter.assertions.MethodAssertionConverter;
import codetestconverter.assertions.PropertyAssertionConverter;
import codetestconverter.assertions.RelationshipAssertionConverter;
import codetestconverter.assertions.TemplateParameterAssertionConverter;
import test.TestClass;
import test.TestMethod;

/**
 * Provides a static method to create {@link test.TestMethod}s and their {@link test.TestAssertion}s and adds them to a given {@link test.TestClass}.
 * 
 * @author dschoenicke
 *
 */
public class TestMethodConverter {

	/**
	 * Creates {@link test.TestMethod}s and {@link test.TestAssertion}s for a given {@link code.CodeElement} and adds them to the given {@link test.TestClass}.<br>
	 * Delegates the conversion of {@link test.TestAssertion}s for the {@link code.CodeElement}s properties to the {@link codetestconverter.assertions.PropertyAssertionConverter}.<br>
	 * Delegates the conversion of {@link test.TestAssertion}s for the {@link code.CodeElement}s super classes and interfaces to the {@link codetestconverter.assertions.RelationshipAssertionConverter}.<br>
	 * Delegates the conversion of {@link test.TestAssertion}s for the {@link code.CodeElement}s {@link code.CodeTemplateParameter}s to the {@link codetestconverter.assertions.TemplateParameterAssertionConverter}.<br>
	 * Delegates the conversion of {@link test.TestAssertion}s for the {@link code.CodeElement}s {@link code.CodeField}s to the {@link codetestconverter.assertions.FieldAssertionConverter}.<br>
	 * Delegates the conversion of {@link test.TestAssertion}s for the {@link code.CodeElement}s {@link code.CodeLiteral}s to the {@link codetestconverter.assertions.FieldAssertionConverter}.<br>
	 * Delegates the conversion of {@link test.TestAssertion}s for the {@link code.CodeElement}s {@link code.CodeConstructor}s to the {@link codetestconverter.assertions.ConstructorAssertionConverter}.<br>
	 * Delegates the conversion of {@link test.TestAssertion}s for the {@link code.CodeElement}s {@link code.CodeMethod}s to the {@link codetestconverter.assertions.MethodAssertionConverter}.<br>
	 * 
	 * @param codeElement the {@link code.CodeElement} to create the {@link test.TestAssertion}s for.
	 * @param testClass the {@link test.TestClass} to which the created {@link test.TestMethod}s should be added to.
	 */
	public static void createTestMethods(CodeElement codeElement, TestClass testClass) {
		TestMethod propertyTestMethod = new TestMethod("testClassProperties", testClass);
		PropertyAssertionConverter.createPropertyAssertions(codeElement, propertyTestMethod);
		testClass.addMethod(propertyTestMethod);
		
		TestMethod relationshipTestMethod = new TestMethod("testClassRelationships", testClass);
		RelationshipAssertionConverter.createRelationshipAssertions(codeElement, relationshipTestMethod);
		testClass.addMethod(relationshipTestMethod);
		
		TestMethod templateParameterTestMethod = new TestMethod("testTemplateParameters", testClass);
		TemplateParameterAssertionConverter.createTemplateParameterAssertions(codeElement, templateParameterTestMethod);
		testClass.addMethod(templateParameterTestMethod);
		
		TestMethod fieldTestMethod = new TestMethod("testClassFields", testClass);
		FieldAssertionConverter.createFieldAssertions(codeElement, fieldTestMethod);
		testClass.addMethod(fieldTestMethod);
		
		if (codeElement instanceof CodeEnumeration) {
			TestMethod enumConstantTestMethod = new TestMethod("testEnumerationConstants", testClass);
			FieldAssertionConverter.createEnumConstantAssertions((CodeEnumeration) codeElement, enumConstantTestMethod);
			testClass.addMethod(enumConstantTestMethod);
		}
		
		TestMethod constructorTestMethod = new TestMethod("testClassConstructors", testClass);
		ConstructorAssertionConverter.createConstructorAssertions(codeElement, constructorTestMethod);
		testClass.addMethod(constructorTestMethod);
		
		TestMethod methodTestMethod = new TestMethod("testClassMethods", testClass);
		MethodAssertionConverter.createMethodAssertions(codeElement, methodTestMethod);
		testClass.addMethod(methodTestMethod);
	}
}
