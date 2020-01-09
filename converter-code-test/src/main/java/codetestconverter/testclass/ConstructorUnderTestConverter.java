package codetestconverter.testclass;

import code.CodeConstructor;
import code.CodeElement;
import test.testobjects.ClassUnderTest;
import test.testobjects.ConstructorUnderTest;

/**
 * Provides a static method to convert {@link code.CodeConstructor}s of a {@link code.CodeElement} to {@link test.testobjects.ConstructorUnderTest} and adding them to a {@link test.testobjects.ClassUnderTest}.
 * 
 * @author dschoenicke
 *
 */
public class ConstructorUnderTestConverter {

	/**
	 * Static method to convert {@link code.CodeConstructor}s of a given {@link code.CodeElement} to {@link test.testobjects.ConstructorUnderTest} and adding them to a given {@link test.testobjects.ClassUnderTest}.
	 * 
	 * @param codeElement the {@link code.CodeElement} containing the {@link code.CodeConstructors} to be converted.
	 * @param classUnderTest the {@link test.testobjects.ClassUnderTest} to which the converted {@link test.testobjects.ConstructorUnderTest} should be added to.
	 */
	public static void convertConstructorsUnderTest(CodeElement codeElement, ClassUnderTest classUnderTest) {
		for (CodeConstructor constructor : codeElement.getConstructors()) {
			ConstructorUnderTest constructorUnderTest  = new ConstructorUnderTest(constructor.getModifiers(), classUnderTest);
			constructorUnderTest.getParameters().addAll(ParameterUnderTestConverter.convertParametersUnderTest(constructor.getParameters()));
		}
	}
}
