package codetestconverter.testclass;

import java.util.ArrayList;

import code.CodeMethod;
import code.CodeParameter;

/**
 * Provides static methods to convert a list of {@link code.CodeParameter}s to a string.
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
	
	/**
	 * Static method converting a list of {@link code.CodeParameter}s to a string of the types.
	 * 
	 * @param parameters the {@link code.CodeParameter}s to be converted into a string.
	 * @return the converted string enumerating the given {@link code.CodeParameter} types.
	 */
	public static String createParameterTypeList(ArrayList<CodeParameter> parameters) {
		String parameterList = "";
		
		for (CodeParameter parameter : parameters) {
			if (parameterList.length() > 0) {
				parameterList += ", ";
			}
			
			parameterList += parameter.getType() + ".class";
			
			if (parameter.hasMultiplicity()) {
				parameterList += "[]";
			}
		}
		
		return parameterList;
	}
	
	/**
	 * Static method converting a {@link code.CodeMethod} to a string of the method name and {@link code.CodeParameter} types.
	 * 
	 * @param method the {@link code.CodeMethod} which name and {@link code.CodeParameter}s to be converted to a string of the types.
	 * @return the converted string with the name of the {@link code.CodeMethod} and an enumeration of the given {@link code.CodeParameter} types.
	 */
	public static String createParameterTypeList(CodeMethod method) {
		String parameterList = method.getName();
		
		for (CodeParameter parameter : method.getParameters()) {
			if (parameterList.length() > 0) {
				parameterList += ", ";
			}
			
			parameterList += parameter.getType() + ".class";
			
			if (parameter.hasMultiplicity()) {
				parameterList += "[]";
			}
		}
		
		return parameterList;
	}
}
