package model;

import java.util.ArrayList;

/**
 * Represents a class
 * 
 * @author dschoenicke
 *
 */
public class UmlClass extends UmlElement {
	
	/**
	 * Determines whether the interface is static
	 */
	private boolean  isStatic;
	
	/**
	 * Determines whether the class is final
	 */
	private boolean  isFinal;
	
	/**
	 * Determines whether the class is abstract
	 */
	private boolean  isAbstract;
	
	/**
	 * List of {@link UmlAttribute}s of the class
	 */
	private ArrayList<UmlAttribute> attributes;
	
	/**
	 * List of {@link UmlOperation}s of the class
	 */
	private ArrayList<UmlOperation> operations;
	
	/**
	 * List of {@link TemplateParameter}s of the class
	 */
	private ArrayList<UmlTemplateParameter> templateParameters;
	
	/**
	 * Constructor with name and visibility, initializes the lists for {@link UmlAttribute}s, {@link UmlOperation}s and {@link UmlTemplateParameter}s 
	 * 
	 * @param name the name of the class
	 * @param visibility the {@link UmlVisibility} of the class, initializes the list for {@link UmlAttribute}s and {@link UmlOperation}s
	 */
	public UmlClass(String name, UmlVisibility visibility) {
		super(name, visibility);
		attributes = new ArrayList<UmlAttribute>();
		operations = new ArrayList<UmlOperation>();
		templateParameters = new ArrayList<UmlTemplateParameter>();
	}
	
	/**
	 * Constructor with name, visibility and static-, final-, and abstract-classifiers, initializes the lists for {@link UmlAttribute}s, {@link UmlOperation}s and {@link UmlTemplateParameter}s 
	 * 
	 * @param name the name of the class
	 * @param visibility the {@link UmlVisibility} of the class
	 * @param isStatic true if the class is static
	 * @param isFinal true if the class is final
	 * @param isAbstract true if the class is abstract
	 */
	public UmlClass(String name, UmlVisibility visibility, boolean isStatic, boolean isFinal, boolean isAbstract) {
		super(name, visibility);
		this.isStatic = isStatic;
		this.isFinal = isFinal;
		this.isAbstract = isAbstract;
		attributes = new ArrayList<UmlAttribute>();
		operations = new ArrayList<UmlOperation>();
		templateParameters = new ArrayList<UmlTemplateParameter>();
	}
	
	/**
	 * Returns true if the class is static
	 * 
	 * @return true if the class is static
	 */
	public boolean isStatic() {
		return isStatic;
	}

	/**
	 * Sets the static value
	 * 
	 * @param isStatic the static value
	 */
	public void setStatic(boolean isStatic) {
		this.isStatic = isStatic;
	}

	/**
	 * Returns true if the class is final
	 * 
	 * @return true if the class is final
	 */
	public boolean isFinal() {
		return isFinal;
	}

	/**
	 * Sets the final value
	 * 
	 * @param isFinal the final value
	 */
	public void setFinal(boolean isFinal) {
		this.isFinal = isFinal;
	}

	/**
	 * Returns true if the class is abstract
	 * 
	 * @return true if the class is abstract
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
	 * Returns the list of {@link UmlAttribute}s
	 * 
	 * @return the list of {@link UmlAttribute}s
	 */
	public ArrayList<UmlAttribute> getAttributes() {
		return attributes;
	}

	/**
	 * Adds an {@link UmlAttribute} to the list
	 * 
	 * @param attribute the {@link UmlAttribute} to add
	 */
	public void addAttribute(UmlAttribute attribute) {
		attributes.add(attribute);
	}

	/**
	 * Returns the list of {@link UmlOperation}s
	 * 
	 * @return the list of {@link UmlOperation}s
	 */
	public ArrayList<UmlOperation> getOperations() {
		return operations;
	}

	/**
	 * Adds an {@link UmlOperation} to the list
	 * 
	 * @param operation the {@link UmlOperation} to add
	 */
	public void addOperation(UmlOperation operation) {
		operations.add(operation);
	}
	
	/**
	 * Returns the list of {@link UmlTemplateParameter}s
	 * 
	 * @return the list of {@link UmlTemplateParameter}s
	 */
	public ArrayList<UmlTemplateParameter> getTemplateParameters() {
		return templateParameters;
	}
	
	/**
	 * Adds an {@link UmlTemplateParameter} to the list
	 * 
	 * @param templateParameter the {@link UmlTemplateParameter} to add
	 */
	public void addTemplateParameter(UmlTemplateParameter templateParameter) {
		templateParameters.add(templateParameter);
	}
}
