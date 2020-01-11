package umlcodeconverter.element;

import org.junit.Before;

import code.CodeClass;
import code.CodeConstructor;
import code.CodeEnumeration;
import code.CodeInterface;
import code.CodeMethod;
import code.CodePackage;
import code.CodeParameter;
import code.CodeRepresentation;
import code.CodeTemplateBinding;
import code.CodeTemplateParameter;
import code.CodeVisibility;
import uml.UmlAttribute;
import uml.UmlClass;
import uml.UmlEnumeration;
import uml.UmlInterface;
import uml.UmlLiteral;
import uml.UmlModel;
import uml.UmlMultiplicityValue;
import uml.UmlOperation;
import uml.UmlPackage;
import uml.UmlParameter;
import uml.UmlParameterDirection;
import uml.UmlParameterSubstitution;
import uml.UmlTemplateBinding;
import uml.UmlTemplateParameter;
import uml.UmlVisibility;
import umlcodeconverter.temporary.TemporaryModel;

public class TestInitializer {

	/**
	 * Mocks a {@link umlcodeconverter.temporary.TemporaryModel} to be used in the tests.
	 */
	TemporaryModel mockTmpModel;
	
	/**
	 * Mocks an {@link uml.UmlModel} to be used in the tests.
	 */
	UmlModel mockUmlModel;
	
	/**
	 * Mocks an {@link uml.UmlPackage} to be used in the tests.
	 */
	UmlPackage umlPackage;
	
	/**
	 * Mocks a sub {@link uml.UmlPackage} to be used in the tests.
	 */
	UmlPackage umlSubPackage;
	
	/**
	 * Mocks an {@link uml.UmlClass} to be used in the tests.
	 */
	UmlClass mockUmlClass;
	
	/**
	 * Mocks an inner {@link uml.UmlClass} to be used in the tests.
	 */
	UmlClass mockInnerUmlClass;
	
	/**
	 * Mocks an {@link uml.UmlInterface} to be used in the tests.
	 */
	UmlInterface mockUmlInterface;
	
	/**
	 * Mocks an {@link uml.UmlEnumeration} to be used in the tests.
	 */
	UmlEnumeration mockUmlEnumeration;
	
	/**
	 * Mocks an {@link uml.UmlLiteral} to be used in the tests.
	 */
	UmlLiteral mockUmlLiteral;
	
	/**
	 * Mocks an {@link uml.UmlTemplateBinding} to be used in the tests.
	 */
	UmlTemplateBinding mockUmlTemplateBinding;
	
	/**
	 * Mocks an {@link uml.UmlParameterSubstitution} to be used in the tests.
	 */
	UmlParameterSubstitution mockUmlParameterSubstitution;
	
	/**
	 * Mocks an {@link uml.UmlTemplateParameter} to be used in the tests.
	 */
	UmlTemplateParameter mockUmlTemplateParameter;
	
	/**
	 * Mocks an {@link uml.UmlOperation} to be used in the tests.
	 */
	UmlOperation mockUmlOperation;
	
	/**
	 * Mocks an {@link uml.UmlOperation} which acts as a constructor.
	 */
	UmlOperation mockUmlConstructor;
	
	/**
	 * Mocks an {@link uml.UmlParameter} for an {@link uml.UmlOperation} to be used in the tests.
	 */
	UmlParameter mockUmlParameter;
	
	/**
	 * Mocks an {@link uml.UmlParameter} as a return parameter for an {@link uml.UmlOperation} to be used in the tests.
	 */
	UmlParameter mockUmlReturnParameter;
	
	/**
	 * Mocks an {@link uml.UmlAttribute} to be used in the tests.
	 */
	UmlAttribute mockUmlAttribute;
	
	/**
	 * Mocks an {@link uml.UmlAttribute} with a multiplicity to be used in the tests.
	 */
	UmlAttribute mockMultiplicityUmlAttribute;
	
	/**
	 * Mocks a {@link code.CodeRepresentation} to be used in the tests.
	 */
	CodeRepresentation mockCodeRepresentation;
	
	/**
	 * Mocks a {@link code.CodePackage} to be used in the tests.
	 */
	CodePackage mockCodePackage;
	
	/**
	 * Mocks a {@link code.CodeClass} to be used in the tests.
	 */
	CodeClass mockCodeClass;
	
	/**
	 * Mocks a {@link code.CodeInterface} to be used in the test.
	 */
	CodeInterface mockCodeInterface;
	
	/**
	 * Mocks a {@link code.CodeEnumeration} to be used in the tests.
	 */
	CodeEnumeration mockCodeEnumeration;
	
	/**
	 * Mocks a {@link code.CodeMethod} to be used in the tests.
	 */
	CodeMethod mockCodeMethod;
	
	/**
	 * Mocks a {@link code.CodeConstructor} to be used in the tests.
	 */
	CodeConstructor mockCodeConstructor;
	
	/**
	 * Mocks a {@link code.CodeTemplateParameter} to be used in the tests.
	 */
	CodeTemplateParameter mockCodeTemplateParameter;
	
	/**
	 * Mocks a {@link code.CodeTemplateBinding} to be used in the tests.
	 */
	CodeTemplateBinding mockCodeTemplateBinding;
	
	/**
	 * Initializes the mock elements.
	 */
	@Before
	public void init() {
		mockTmpModel = new TemporaryModel();
		mockUmlModel = new UmlModel("UmlModel");
		umlPackage = new UmlPackage("package");
		umlSubPackage = new UmlPackage("subPackage");
		umlPackage.addPackage(umlSubPackage);
		mockUmlModel.addPackage(umlPackage);
		
		mockUmlClass = new UmlClass("umlClass", UmlVisibility.PUBLIC);
		mockInnerUmlClass = new UmlClass("innerClass", UmlVisibility.PACKAGE);
		mockUmlClass.addInnerElement(mockInnerUmlClass);
		umlPackage.addElement(mockUmlClass);
		umlPackage.addElement(mockInnerUmlClass);
		
		mockUmlInterface = new UmlInterface("umlInterface", UmlVisibility.PUBLIC);
		
		mockUmlEnumeration = new UmlEnumeration("umlEnumeration", UmlVisibility.PUBLIC);
		mockUmlLiteral = new UmlLiteral("LITERAL");
		mockUmlEnumeration.addUmlLiteral(mockUmlLiteral);
		
		mockUmlModel.addElement(mockUmlEnumeration);
		umlSubPackage.addElement(mockUmlInterface);
		
		mockUmlOperation = new UmlOperation("umlOperation", UmlVisibility.PUBLIC);
		mockUmlParameter = new UmlParameter("param", "int", UmlParameterDirection.IN, false);
		mockUmlReturnParameter = new UmlParameter("", "String", UmlParameterDirection.RETURN, false);
		mockUmlOperation.addParameter(mockUmlParameter);
		mockUmlOperation.addParameter(mockUmlReturnParameter);
		mockUmlConstructor = new UmlOperation("umlClass", UmlVisibility.PUBLIC);
		mockUmlConstructor.addParameter(mockUmlParameter);
		mockUmlClass.addOperation(mockUmlOperation);
		mockUmlClass.addOperation(mockUmlConstructor);
		
		mockUmlAttribute = new UmlAttribute("attribute", UmlVisibility.PRIVATE, "long", false, false, "", UmlMultiplicityValue.ONE, UmlMultiplicityValue.ONE);
		mockMultiplicityUmlAttribute = new UmlAttribute("multiattribute", UmlVisibility.PRIVATE, "float", false, false, "1.0", UmlMultiplicityValue.ZERO, UmlMultiplicityValue.INFINITE);
		mockUmlClass.addAttribute(mockUmlAttribute);
		mockUmlClass.addAttribute(mockMultiplicityUmlAttribute);
		
		mockUmlTemplateParameter = new UmlTemplateParameter("T", "java.lang.Object");
		mockUmlTemplateBinding = new UmlTemplateBinding();
		mockUmlParameterSubstitution = new UmlParameterSubstitution(mockUmlTemplateParameter, "mockClass");
		mockUmlTemplateBinding.addParameterSubstitution(mockUmlParameterSubstitution);
		
		mockUmlClass.addUmlTemplateBinding(mockUmlTemplateBinding);
		mockUmlClass.addTemplateParameter(mockUmlTemplateParameter);
		mockUmlOperation.addUmlTemplateBinding(mockUmlTemplateBinding);
		mockUmlOperation.addTemplateParameter(mockUmlTemplateParameter);
		mockUmlConstructor.addUmlTemplateBinding(mockUmlTemplateBinding);
		mockUmlConstructor.addTemplateParameter(mockUmlTemplateParameter);
		
		mockCodeRepresentation = new CodeRepresentation("codeRepresentation");
		mockCodePackage = new CodePackage("package", mockCodeRepresentation);
		mockCodeRepresentation.addPackage(mockCodePackage);
		mockCodeClass = new CodeClass("codeClass", mockCodePackage, CodeVisibility.PUBLIC, false, false, false);
		mockCodeEnumeration = new CodeEnumeration("codeEnumeration", mockCodePackage, CodeVisibility.PUBLIC, false, false, false);
		mockCodeMethod = new CodeMethod("mockCodeMethod", mockCodeClass, null, false, CodeVisibility.PUBLIC, false, false, false);
		mockCodeMethod.setReturnType(new CodeParameter("", "String", 0, false, false, mockCodeMethod));
		mockCodeConstructor = new CodeConstructor(mockCodeClass, CodeVisibility.PRIVATE);
		
		mockCodeTemplateParameter = new CodeTemplateParameter("T", mockCodeClass, "java.lang.Object");
		mockCodeTemplateBinding = new CodeTemplateBinding();
		mockTmpModel.addConvertedTemplateParameter(mockUmlTemplateParameter, mockCodeTemplateParameter);
		mockTmpModel.addTemporaryTemplateBinding(mockCodeTemplateBinding, mockUmlTemplateBinding.getParameterSubstitutions());
	}
}
