package codetestconverter.testclass;

import java.util.ArrayList;

import code.CodeParameter;
import test.testobjects.ParameterUnderTest;

/**
 * Provides a static method to convert {@link code.CodeParameter}s to {@link test.testobjects.ParameterUnderTest}.
 * 
 * @author dschoenicke
 *
 */
public class ParameterUnderTestConverter {

	/**
	 * Static method to convert a list of {@link code.CodeParameter}s to a list of {@link test.testobjects.ParameterUnderTest}.
	 * 
	 * @param parameters the {@link code.CodeParameter}s to be converted.
	 */
	public static ArrayList<ParameterUnderTest> convertParametersUnderTest(ArrayList<CodeParameter> parameters) {
		ArrayList<ParameterUnderTest> parametersUnderTest = new ArrayList<>();
		
		for (CodeParameter parameter : parameters) {
			parametersUnderTest.add(convertParameterUnderTest(parameter));
		}
		
		return parametersUnderTest;
	}
	
	/**
	 * Static method to convert a given {@link code.CodeParameter}s to a {@link test.testobjects.ParameterUnderTest}.
	 * 
	 * @param parameter the {@link code.CodeParameter} to be converted.
	 */
	public static ParameterUnderTest convertParameterUnderTest(CodeParameter parameter) {
		return new ParameterUnderTest(parameter.getName(),
				parameter.getType(),
				parameter.getModifiers(),
				parameter.getCanBeNull(),
				parameter.getHasMultiplicity());
	}
}
