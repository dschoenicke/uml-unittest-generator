package model;

import java.util.ArrayList;

/**
 * Represents a template binding of an {@link UmlElement} or {@link UmlOperation}
 * 
 * @author dschoenicke
 *
 */
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
	 * Gets the list of {@link UmlParameterSubstitution}s
	 * 
	 * @return the list of {@link UmlParameterSubstitution}s
	 */
	public ArrayList<UmlParameterSubstitution> getParameterSubstitutions() {
		return parameterSubstitutions;
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
