package model;

import java.util.ArrayList;

/**
 * Represents an interface
 * 
 * @author dschoenicke
 *
 */
public class UmlInterface extends UmlElement {

	/**
	 * Determines whether the interface is abstract
	 */
	private boolean  isAbstract;
	
	/**
	 * List of {@link UmlTemplateParameter}s of the interface
	 */
	private ArrayList<UmlTemplateParameter> templateParameters;
	
	/**
	 * Constructor with name and visibility, initializes the list of {@link UmlTemplateParameter}s
	 *  
	 * @param name the name of the interface
	 * @param visibility the {@link UmlVisibility} of the interface
	 */
	public UmlInterface(String name, UmlVisibility visibility) {
		super(name, visibility);
		templateParameters = new ArrayList<UmlTemplateParameter>();
	}
	
	/**
	 * Constructor with name, visibility and the abstract classifier, initializes the list of {@link UmlTemplateParameter}s
	 *  
	 * @param name the name of the interface
	 * @param visibility the {@link UmlVisibility} of the interface
	 * @param isAbstract true if the interface is abstract
	 */
	public UmlInterface(String name, UmlVisibility visibility, boolean isAbstract) {
		super(name, visibility);
		this.isAbstract = isAbstract;
		templateParameters = new ArrayList<UmlTemplateParameter>();
	}
	
	/**
	 * Returns true if the interface is abstract
	 * 
	 * @return true if the interface is abstract
	 */
	public boolean isAbstract() {
		return isAbstract;
	}
	
	/**
	 * Sets the abstract value
	 * 
	 * @param isAbstract the abstract value
	 */
	public void setAbstract(boolean isAbstract) {
		this.isAbstract = isAbstract;
	}


	/**
	 * Returns the list of {@link UmlTemplateParameter}s
	 * 
	 * @return the list of {@link UmlTemplateParameter}s
	 */
	public ArrayList<UmlTemplateParameter> getUmlTemplateParameters() {
		return templateParameters;
	}
	
	/**
	 * Adds an {@link UmlTemplateParameter} to the list
	 * 
	 * @param templateBinding the {@link UmlTemplateParameter} to add
	 */
	public void addUmlTemplateParameter(UmlTemplateParameter templateParameter) {
		templateParameters.add(templateParameter);
	}
}
