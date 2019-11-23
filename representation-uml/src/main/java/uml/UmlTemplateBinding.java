package uml;

import java.util.ArrayList;

import core.representation.Node;

/**
 * Represents a template binding of an {@link UmlElement} or {@link UmlOperation}
 * 
 * @author dschoenicke
 *
 */
public class UmlTemplateBinding implements Node {

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
