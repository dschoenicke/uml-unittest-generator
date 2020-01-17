package codetestconverter.testclass;

import java.util.Optional;

import code.CodeClass;
import code.CodeElement;
import code.CodeEnumeration;
import code.CodeInterface;
import test.testobjects.ClassUnderTest;
import test.testobjects.ClassUnderTest.ClassUnderTestType;

/**
 * Converts a given {@link code.CodeElement} to a {@link test.testobjects.ClassUnderTest}.
 * 
 * @author dschoenicke
 *
 */
public class ClassUnderTestConverter {

	private ClassUnderTestConverter() {
		throw new IllegalStateException("utility class");
	}
	
	/**
	 * Static method converting a given {@link code.CodeElement} to a {@link test.testobjects.ClassUnderTest}.
	 * 
	 * @param codeElement the {@link code.CodeElement} to be converted
	 * @return the converted {@link test.testobjects.ClassUnderTest}
	 */
	public static ClassUnderTest convertClassUnderTest(CodeElement codeElement) {
		CodeClass superClass = null;
		ClassUnderTestType type;
		
		if (codeElement instanceof CodeClass) {
			superClass = ((CodeClass) codeElement).getSuperClass();
			type = ClassUnderTestType.CLASS;
		}
		else if (codeElement instanceof CodeEnumeration) {
			type = ClassUnderTestType.ENUM;
		}
		else {
			type = ClassUnderTestType.INTERFACE;
		}
		
		ClassUnderTest classUnderTest = new ClassUnderTest(codeElement.getQualifiedName(),
				type,
				codeElement.getModifiers(), 
				(superClass == null) ? Optional.empty() : Optional.of(superClass.getName()));
		
		for (CodeInterface superInterface : codeElement.getInterfaces()) {
			classUnderTest.getInterfaces().add(superInterface.getName());
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
