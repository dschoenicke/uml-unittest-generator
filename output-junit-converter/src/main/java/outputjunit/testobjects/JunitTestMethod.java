package outputjunit.testobjects;

import java.util.ArrayList;

import lombok.Getter;

@Getter
public class JunitTestMethod {

	private String name;
	
	private int modifiers;
	
	private String returnType;
	
	private ArrayList<JunitTestParameter> parameters;
	
	public JunitTestMethod(String name, int modifiers, String returnType) {
		this.name = name;
		this.modifiers = modifiers;
		this.returnType = returnType;
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
			return "\"" + name + "\"";
		}
		
		String definitionString = "\"" + name + "\"";
		
		for (JunitTestParameter parameter : parameters) {
			definitionString += ", " + parameter.getType() + ".class";
		}
		
		return definitionString;
	}
}
