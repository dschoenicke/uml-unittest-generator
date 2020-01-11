package uml;

import java.util.ArrayList;

import lombok.Getter;

/**
 * Represents a template binding of an {@link UmlElement} or {@link UmlOperation}
 * 
 * @author dschoenicke
 *
 */
@Getter
public class UmlTemplateBinding {

	/**
	 * List of {@link UmlParameterSubstitution}s of the template binding
	 */
	private ArrayList<UmlParameterSubstitution> parameterSubstitutions;
	
	/**
	 * Constructor, initializes the list of {@link UmlParameterSubstitution}s
	 */
	public UmlTemplateBinding() {
		parameterSubstitutions = new ArrayList<>();
	}
	
	/**
	 * Adds an {@link UmlParameterSubstitution} to the list
	 * 
	 * @param parameterSubstitution the {@link UmlParameterSubstitution} to add to the list
	 */
	public void addParameterSubstitution(UmlParameterSubstitution parameterSubstitution) {
		parameterSubstitutions.add(parameterSubstitution);
	}
}
