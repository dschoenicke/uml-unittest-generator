package codetestconverter.testclass;

import java.util.ArrayList;

import code.CodeParameter;

/**
 * Provides a static method to convert a list of {@link code.CodeParameter}s to a string.
 * 
 * @author dschoenicke
 *
 */
public class ParameterConverter {
	
	/**
	 * Static method converting a list of {@link code.CodeParameter}s to a string.
	 * 
	 * @param parameters the {@link code.CodeParameter}s to be converted into a string.
	 * @return the converted string enumerating the given {@link code.CodeParameter}s.
	 */
	public static String createParameterList(ArrayList<CodeParameter> parameters) {
		String parameterList = "";
		
		for (CodeParameter parameter : parameters) {
			if (parameterList.length() > 0) {
				parameterList += ", ";
			}
			
			parameterList += parameter.getType();
			
			if (parameter.hasMultiplicity()) {
				parameterList += "[]";
			}
		}
		
		return parameterList;
	}
}
