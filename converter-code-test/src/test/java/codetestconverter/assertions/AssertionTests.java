package codetestconverter.assertions;

import java.util.List;

import org.junit.Before;

import code.CodeClass;
import code.CodeConstructor;
import code.CodeEnumeration;
import code.CodeField;
import code.CodeInterface;
import code.CodeLiteral;
import code.CodeMethod;
import code.CodePackage;
import code.CodeParameter;
import code.CodeRepresentation;
import code.CodeTemplateParameter;
import code.CodeVisibility;
import test.TestMethod;

/**
 * Provides and initializes mock elements to be used in the tests.
 * 
 * @author dschoenicke
 *
 */
public class AssertionTests {

	/**
	 * Mocks the {@link test.TestMethod} to which the tested {@link test.TestAssertion}s will be added.
	 */
	TestMethod mockTestMethod;
	
	/**
	 * Mocks a {@link code.CodePackage} to be used in the tests.
	 */
	CodePackage mockCodePackage;
	
	/**
	 * Mocks a {@link code.CodeClass} to be used in the tests.
	 */
	CodeClass mockCodeClass;
	
	/**
	 * Mocks a {@link code.CodeInterface} to be used in the tests.
	 */
	CodeInterface mockCodeInterface;
	
	/**
	 * Mocks a {@link code.CodeEnumeration} to be used in the tests.
	 */
	CodeEnumeration mockCodeEnumeration;
	
	/**
	 * Mocks a {@link code.CodeParameter} to be used in the tests.
	 */
	CodeParameter mockCodeParameter;
	
	/**
	 * Mocks a second {@link code.CodeField} to be used in the tests.
	 */
	CodeField mockCodeField1;
	
	/**
	 * Mocks a second {@link code.CodeField} to be used in the tests.
	 */
	CodeField mockCodeField2;
	
	/**
	 * Mocks a {@link code.CodeLiteral} to be used in the tests.
	 */
	CodeLiteral mockCodeLiteral1;
	
	/**
	 * Mocks a second {@link code.CodeLiteral} to be used in the tests.
	 */
	CodeLiteral mockCodeLiteral2;
	
	/**
	 * Mocks a {@link code.CodeTemplateParameter} to be used in the tests.
	 */
	CodeTemplateParameter mockCodeTemplateParameter;
	
	/**
	 * Mocks a {@link code.CodeMethod} to be used in the tests.
	 */
	CodeMethod mockCodeMethod1;
	
	/**
	 * Mocks a second {@link code.CodeMethod} to be used in the tests.
	 */
	CodeMethod mockCodeMethod2;
	
	/**
	 * Initializes the mock elements.
	 */
	@Before
	public void init() {
		mockTestMethod = new TestMethod("TestMethod", null);
		mockCodePackage = new CodePackage("package", new CodeRepresentation(""));
		mockCodeClass = new CodeClass("CodeClass", mockCodePackage, CodeVisibility.PUBLIC, true, false, true);
		mockCodeInterface = new CodeInterface("CodeInterface", mockCodePackage, CodeVisibility.PUBLIC, true, false, false);
		mockCodeEnumeration = new CodeEnumeration("CodeEnumeration", mockCodeClass, CodeVisibility.PRIVATE, false, true, false);
		mockCodeClass.addNestedElement(mockCodeEnumeration);
		mockCodeClass.addConstructor(new CodeConstructor(mockCodeClass, CodeVisibility.PROTECTED));
		mockCodeClass.addConstructor(new CodeConstructor(mockCodeClass, CodeVisibility.PROTECTED));
		mockCodeClass.addInterface(mockCodeInterface);
		
		mockCodeParameter = new CodeParameter("param", mockCodeClass, "String", true, true);
		mockCodeClass.getConstructors().get(1).addParameter(mockCodeParameter);
		
		mockCodeMethod1 = new CodeMethod("method1", mockCodeClass, "void", false, CodeVisibility.PRIVATE, false, false, false);
		mockCodeMethod2 = new CodeMethod("method2", mockCodeClass, "String", false, CodeVisibility.PRIVATE, false, false, false);
		mockCodeMethod1.addParameter(mockCodeParameter);
		mockCodeClass.getMethods().addAll(List.of(mockCodeMethod1, mockCodeMethod2));
		
		mockCodeTemplateParameter = new CodeTemplateParameter("T", mockCodeClass, "java.lang.Object");
		mockCodeClass.addTemplateParameter(mockCodeTemplateParameter);
		
		mockCodeField1 = new CodeField("field1", mockCodeClass, "String", "default", true, false, CodeVisibility.PRIVATE, false, false);
		mockCodeField2 = new CodeField("field2", mockCodeClass, "Integer", null, false, true, CodeVisibility.PRIVATE, false, false);
		mockCodeClass.getFields().addAll(List.of(mockCodeField1, mockCodeField2));
		
		mockCodeLiteral1 = new CodeLiteral("Literal1", mockCodeEnumeration);
		mockCodeLiteral2 = new CodeLiteral("Literal1", mockCodeEnumeration);
		mockCodeEnumeration.getCodeLiterals().addAll(List.of(mockCodeLiteral1, mockCodeLiteral2));
	}
}
