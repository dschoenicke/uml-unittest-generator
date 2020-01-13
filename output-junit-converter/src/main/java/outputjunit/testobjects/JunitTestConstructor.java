package outputjunit.testobjects;

import java.util.ArrayList;

import lombok.Getter;

@Getter
public class JunitTestConstructor {

	private int modifiers;
	
	private ArrayList<JunitTestParameter> parameters;
	
	public JunitTestConstructor(int modifiers) {
		this.modifiers = modifiers;
		parameters = new ArrayList<>();
	}
	
	public void addParameter(JunitTestParameter parameter) {
		parameters.add(parameter);
	}
	
	public String getParametersAsString() {
		if (parameters.isEmpty()) {
			return "";
		}
		
		String parameterString = "";
		
		for (JunitTestParameter parameter : parameters) {
			parameterString += parameter.getType() + ", ";
		}
		
		return parameterString.substring(0, parameterString.length() - 2);
	}
	
	public String getReflectionDefinition() {
		if (parameters.isEmpty()) {
			return "";
		}
		
		String definitionString = "";
		
		for (JunitTestParameter parameter : parameters) {
			definitionString += parameter.getType() + ".class, ";
		}
		
		return definitionString.substring(0, definitionString.length() - 2);
	}
}
