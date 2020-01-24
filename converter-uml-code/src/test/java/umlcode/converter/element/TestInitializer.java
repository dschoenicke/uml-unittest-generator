package umlcode.converter.element;

import org.junit.Before;

import code.CodeClass;
import code.CodeConstructor;
import code.CodeMethod;
import code.CodeParameter;
import code.CodeTemplateBinding;
import code.CodeTemplateParameter;
import uml.UmlClass;
import uml.UmlOperation;
import uml.UmlParameterSubstitution;
import uml.UmlTemplateBinding;
import uml.UmlTemplateParameter;
import uml.UmlVisibility;
import umlcode.TemporaryModel;

public class TestInitializer {

	TemporaryModel mockTmpModel;
	UmlClass mockUmlClass;
	UmlTemplateBinding mockUmlTemplateBinding;
	UmlParameterSubstitution mockUmlParameterSubstitution;
	UmlTemplateParameter mockUmlTemplateParameter;
	UmlOperation mockUmlOperation;
	UmlOperation mockUmlConstructor;
	CodeClass mockCodeClass;
	CodeMethod mockCodeMethod;
	CodeConstructor mockCodeConstructor;
	CodeTemplateParameter mockCodeTemplateParameter;
	CodeTemplateBinding mockCodeTemplateBinding;
	
	@Before
	public void init() {
		mockTmpModel = new TemporaryModel();
		mockUmlClass = new UmlClass("umlClass", UmlVisibility.PUBLIC, false, false, false);
		mockUmlOperation = new UmlOperation("umlOperation", UmlVisibility.PUBLIC);
		mockUmlConstructor = new UmlOperation("umlClass", UmlVisibility.PUBLIC);
		mockUmlClass.addOperation(mockUmlOperation);
		mockUmlClass.addOperation(mockUmlConstructor);
		
		mockUmlTemplateParameter = new UmlTemplateParameter("T", "java.lang.Object");
		mockUmlTemplateBinding = new UmlTemplateBinding();
		mockUmlParameterSubstitution = new UmlParameterSubstitution(mockUmlTemplateParameter, "mockClass");
		mockUmlTemplateBinding.addParameterSubstitution(mockUmlParameterSubstitution);
		
		mockUmlClass.addTemplateBinding(mockUmlTemplateBinding);
		mockUmlClass.addTemplateParameter(mockUmlTemplateParameter);
		mockUmlOperation.addTemplateBinding(mockUmlTemplateBinding);
		mockUmlOperation.addTemplateParameter(mockUmlTemplateParameter);
		mockUmlConstructor.addTemplateBinding(mockUmlTemplateBinding);
		mockUmlConstructor.addTemplateParameter(mockUmlTemplateParameter);
		
		mockCodeClass = new CodeClass("codeClass", null, 1);
		mockCodeMethod = new CodeMethod("mockCodeMethod", mockCodeClass, null, false, 1);
		mockCodeMethod.setReturnType(new CodeParameter("", "String", 0, false, false, mockCodeMethod));
		mockCodeConstructor = new CodeConstructor(mockCodeClass, 2);
		
		mockCodeTemplateParameter = new CodeTemplateParameter("T", mockCodeClass, "java.lang.Object");
		mockCodeTemplateBinding = new CodeTemplateBinding();
		mockTmpModel.addConvertedTemplateParameter(mockUmlTemplateParameter, mockCodeTemplateParameter);
		mockTmpModel.addTemporaryTemplateBinding(mockCodeTemplateBinding, mockUmlTemplateBinding.getParameterSubstitutions());
	}
}
