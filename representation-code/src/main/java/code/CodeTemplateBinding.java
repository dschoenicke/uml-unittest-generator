package code;

import java.util.HashMap;

/**
 * Represents a template binding of a {@link CodeElement} or {@link CodeMethod}
 * 
 * @author dschoenicke
 *
 */
public class CodeTemplateBinding {

	/**
	 * A map containing substituted {@link CodeTemplateParameter}s and the data type replacing the {@link CodeTemplateParameter}
	 */
	private HashMap<CodeTemplateParameter, String> parameterSubstitutions;
	
	/**
	 * Constructor, initializes the map for {@link CodeTemplateBinding#parameterSubstitutions}
	 */
	public CodeTemplateBinding() {
		parameterSubstitutions = new HashMap<>();
	}
	
	/**
	 * Gets the map of parameter substitutions
	 * 
	 * @return the map of parameter substitutions
	 */
	public HashMap<CodeTemplateParameter, String> getParameterSubstitutions() {
		return parameterSubstitutions;
	}
	
	/**
	 * Adds a {@link CodeTemplateParameter} and data type to the map of parameter substitutions
	 * 
	 * @param templateParameter the {@link CodeTemplateParameter} to add to the map
	 * @param substitute the data type which substitutes the {@link CodeTemplateParameter}
	 */
	public void addParameterSubstitution(CodeTemplateParameter templateParameter, String substitute) {
		parameterSubstitutions.put(templateParameter, substitute);
	}
}
