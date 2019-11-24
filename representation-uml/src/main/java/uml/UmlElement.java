package uml;

import java.util.ArrayList;

import core.representation.Node;

/**
 * Abstract class extended by {@link UmlClass}es, {@link UmlInterface}s and {@link UmlEnumeration}s
 * 
 * @author dschoenicke
 *
 */
public abstract class UmlElement implements Node {

	/**
	 * The name of the element
	 */
	private String name;
	
	/**
	 * The {@link UmlVisibility} of the element
	 */
	private UmlVisibility visibility;
	
	/**
	 * List of {@link UmlAttribute}s of the element
	 */
	private ArrayList<UmlAttribute> attributes;
	
	/**
	 * List of {@link UmlOperation}s of the element
	 */
	private ArrayList<UmlOperation> operations;
	
	/**
	 * List of {@link UmlTemplateParameter}s of the element
	 */
	private ArrayList<UmlTemplateParameter> templateParameters;
	
	/**
	 * List of {@link UmlTemplateBinding}s of the element
	 */
	private ArrayList<UmlTemplateBinding> templateBindings;
	
	/**
	 * List of inner elements of the element
	 */
	private ArrayList<UmlElement> innerElements;
	
	/**
	 * Constructor with name and {@link UmlVisibility}, initializes the list of {@link UmlTemplateBinding}s, {@link UmlTemplateParameter}s, {@link UmlAttribute}s, {@link UmlOperation}s and inner elements 
	 * 
	 * @param name the name of the element
	 * @param visibility the {@link UmlVisibility} of the element
	 */
	protected UmlElement(String name, UmlVisibility visibility) {
		this.name = name;
		this.visibility = visibility;
		templateBindings = new ArrayList<>();
		attributes = new ArrayList<UmlAttribute>();
		operations = new ArrayList<UmlOperation>();
		templateParameters = new ArrayList<UmlTemplateParameter>();
		innerElements = new ArrayList<>();
	}
	
	/**
	 * Constructor with name, {@link UmlVisibility} and static-classifier, initializes the list of {@link UmlTemplateBinding}s, {@link UmlTemplateParameter}s, {@link UmlAttribute}s, {@link UmlOperation}s and inner elements 
	 * 
	 * @param name the name of the element
	 * @param visibility the {@link UmlVisibility} of the element
	 * @param isStatic true if the class is static
	 */
	protected UmlElement(String name, UmlVisibility visibility, boolean isStatic) {
		this.name = name;
		this.visibility = visibility;
		this.isStatic = isStatic;
		templateBindings = new ArrayList<>();
		attributes = new ArrayList<UmlAttribute>();
		operations = new ArrayList<UmlOperation>();
		templateParameters = new ArrayList<UmlTemplateParameter>();
		innerElements = new ArrayList<>();
	}
	
	/**
	 * Gets the name of the element
	 * 
	 * @return the name of the element
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the element
	 * 
	 * @param name the name of the element
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the {@link UmlVisibility} of the element
	 * 
	 * @return the {@link UmlVisibility} of the element
	 */
	public UmlVisibility getVisibility() {
		return visibility;
	}
	
	/**
	 * Sets the {@link UmlVisibility} of the element
	 * 
	 * @param visibility the {@link UmlVisibility} of the element
	 */
	public void setVisibility(UmlVisibility visibility) {
		this.visibility = visibility;
	}
	

	/**
	 * Returns the list of {@link UmlTemplateBinding}s
	 * 
	 * @return the list of {@link UmlTemplateBinding}s
	 */
	public ArrayList<UmlTemplateBinding> getUmlTemplateBindings() {
		return templateBindings;
	}
	
	/**
	 * Adds an {@link UmlTemplateBinding} to the list
	 * 
	 * @param templateBinding the {@link UmlTemplateBinding} to add
	 */
	public void addUmlTemplateBinding(UmlTemplateBinding templateBinding) {
		templateBindings.add(templateBinding);
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
	
	/**
	 * Returns the list of inner elements
	 * 
	 * @return the list of inner elements
	 */
	public ArrayList<UmlElement> getInnerElements() {
		return innerElements;
	}
	
	/**
	 * Adds an inner element to the list
	 * 
	 * @param element the inner element to add to the list
	 */
	public void addInnerElement(UmlElement element) {
		innerElements.add(element);
	}
	
	/**
	 * Determines whether the interface is static
	 */
	private boolean  isStatic;
	
	/**
	 * Returns true if the element is static
	 * 
	 * @return true if the element is static
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
}
