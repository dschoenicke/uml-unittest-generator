package codetest.converters;

import code.CodeElement;
import code.CodeMethod;
import lombok.experimental.UtilityClass;
import test.testobjects.ClassUnderTest;
import test.testobjects.MethodUnderTest;

/**
 * Provides a static method to convert {@link code.CodeMethod}s of a {@link code.CodeElement} to {@link test.testobjects.MethodUnderTest} and adding them to a {@link test.testobjects.ClassUnderTest}.
 * 
 * @author dschoenicke
 *
 */
@UtilityClass
public class MethodUnderTestConverter {
	
	/**
	 * Static method to convert {@link code.CodeMethod}s of a given {@link code.CodeElement} to {@link test.testobjects.MethodUnderTest} and adding them to a given {@link test.testobjects.ClassUnderTest}.
	 * 
	 * @param codeElement the {@link code.CodeElement} containing the {@link code.CodeMethod}s to be converted.
	 * @param classUnderTest the {@link test.testobjects.ClassUnderTest} to which the converted {@link test.testobjects.MethodUnderTest} should be added to.
	 */
	public static void convertMethodsUnderTest(CodeElement codeElement, ClassUnderTest classUnderTest) {
		for (CodeMethod method : codeElement.getMethods()) {
			MethodUnderTest methodUnderTest  = new MethodUnderTest(method.getName(),
					method.getModifiers(), 
					classUnderTest,
					ParameterUnderTestConverter.convertParameterUnderTest(method.getReturnType()));
			
			methodUnderTest.getParameters().addAll(ParameterUnderTestConverter.convertParametersUnderTest(method.getParameters()));
		}
	}
}
