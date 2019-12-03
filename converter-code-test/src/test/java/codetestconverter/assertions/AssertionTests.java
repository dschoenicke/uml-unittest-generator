package codetestconverter.assertions;

import org.junit.Before;

import code.CodeClass;
import code.CodeConstructor;
import code.CodeEnumeration;
import code.CodeField;
import code.CodeInterface;
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

	TestMethod mockTestMethod;
	
	CodePackage mockCodePackage;
	
	CodeClass mockCodeClass;
	
	CodeInterface mockCodeInterface;
	
	CodeEnumeration mockCodeEnumeration;
	
	CodeParameter mockCodeParameter;
	
	CodeField mockCodeField;
	
	CodeField mockMultiplicityCodeField;
	
	CodeTemplateParameter mockCodeTemplateParameter;
	
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
		
		mockCodeTemplateParameter = new CodeTemplateParameter("T", mockCodeClass, "java.lang.Object");
		mockCodeClass.addTemplateParameter(mockCodeTemplateParameter);
	}
}
