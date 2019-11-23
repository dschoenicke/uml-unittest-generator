package uml;

import core.representation.Node;

/**
 * Represents a parameter substitution of an {@link UmlTemplateBinding}
 * 
 * @author dschoenicke
 *
 */
public class UmlParameterSubstitution implements Node {
	
	/**
	 * The {@link UmlTemplateParameter}s replaced by this template binding
	 */
	private UmlTemplateParameter templateParameter;
	
	/**
	 * The name of the class replacing the {@link UmlTemplateParameter}
	 */
	private String substitutionType;
	
	/**
	 * Constructor with template parameter and substitution type
	 * 
	 * @param templateParameter the {@link UmlTemplateParameter} replaced in this binding
	 * @param substitutionType the name of the class replacing the {@link UmlTemplateParameter}
	 */
	public UmlParameterSubstitution(UmlTemplateParameter templateParameter, String substitutionType) {
		this.templateParameter = templateParameter;
		this.substitutionType = substitutionType;
	}
	
	/**
	 * Gets the {@link UmlTemplateParameter}
	 * 
	 * @return the {@link UmlTemplateParameter}
	 */
	public UmlTemplateParameter getTemplateParameter() {
		return templateParameter;
	}
	
	/**
	 * Sets the {@link UmlTemplateParameter}
	 * 
	 * @param templateParameter the {@link UmlTemplateParameter}
	 */
	public void setTemplateParameter(UmlTemplateParameter templateParameter) {
		this.templateParameter = templateParameter;
	}
	
	/**
	 * Gets the name of the class replacing the {@link UmlTemplateParameter}
	 * 
	 * @return the name of the class replacing the {@link UmlTemplateParameter}
	 */
	public String getSubstitutionType() {
		return substitutionType;
	}
	
	/**
	 * Sets the name of the class replacing the {@link UmlTemplateParameter}
	 * 
	 * @param substitutionType the name of the class replacing the {@link UmlTemplateParameter}
	 */
	public void setSubstitutionType(String substitutionType) {
		this.substitutionType = substitutionType;
	}
}
