package codetestconverter.testclass;

import java.util.Optional;

import code.CodeClass;
import code.CodeElement;
import code.CodeEnumeration;
import code.CodeInterface;
import test.testobjects.ClassUnderTest;

/**
 * Converts a given {@link code.CodeElement} to a {@link test.testobjects.ClassUnderTest}.
 * 
 * @author dschoenicke
 *
 */
public class ClassUnderTestConverter {

	/**
	 * Static method converting a given {@link code.CodeElement} to a {@link test.testobjects.ClassUnderTest}.
	 */
	public static ClassUnderTest convertClassUnderTest(CodeElement codeElement) {
		CodeClass superClass = null;
		
		if (codeElement instanceof CodeClass) {
			superClass = ((CodeClass) codeElement).getSuperClass();
		}
		
		ClassUnderTest classUnderTest = new ClassUnderTest(codeElement.getQualifiedName(), 
				codeElement.getModifiers(), 
				(superClass == null) ? Optional.empty() : Optional.of(superClass.getName()));
		
		for (CodeInterface superInterface : codeElement.getInterfaces()) {
			classUnderTest.addInterface(superInterface.getQualifiedName());
		}
		
		TemplateParameterUnderTestConverter.convertTemplateParameters(codeElement, classUnderTest);
		FieldUnderTestConverter.convertFieldsUnderTest(codeElement, classUnderTest);
		ConstructorUnderTestConverter.convertConstructorsUnderTest(codeElement, classUnderTest);
		MethodUnderTestConverter.convertMethodsUnderTest(codeElement, classUnderTest);
		
		if (codeElement instanceof CodeEnumeration) {
			FieldUnderTestConverter.convertEnumConstantsUnderTest((CodeEnumeration) codeElement, classUnderTest);
		}
		
		return classUnderTest;
	}
}
