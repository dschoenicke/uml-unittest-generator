package uml;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Abstract class extended by {@link UmlClass}es, {@link UmlInterface}s and {@link UmlEnumeration}s
 * 
 * @author dschoenicke
 *
 */
@Getter
public abstract class UmlElement implements UmlParent {

	/**
	 * The name of the element
	 */
	@Setter private String name;
	
	/**
	 * The {@link UmlVisibility} of the element
	 */
	private UmlVisibility visibility;
	
	/**
	 * Determines whether the element is static
	 */
	private boolean isStatic;
	
	/**
	 * List of {@link UmlAttribute}s of the element
	 */
	private List<UmlAttribute> attributes;
	
	/**
	 * List of {@link UmlOperation}s of the element
	 */
	private List<UmlOperation> operations;
	
	/**
	 * List of {@link UmlTemplateParameter}s of the element
	 */
	private List<UmlTemplateParameter> templateParameters;
	
	/**
	 * List of {@link UmlTemplateBinding}s of the element
	 */
	private List<UmlTemplateBinding> templateBindings;
	
	/**
	 * List of inner elements of the element
	 */
	private List<UmlElement> innerElements;
	
	/**
	 * Constructor with name, {@link UmlVisibility} and static-classifier, initializes the list of {@link UmlTemplateBinding}s, {@link UmlTemplateParameter}s, {@link UmlAttribute}s, {@link UmlOperation}s and inner elements 
	 * 
	 * @param name the name of the element
	 * @param visibility the {@link UmlVisibility} of the element
	 * @param isStatic true if the element is static
	 */
	protected UmlElement(String name, UmlVisibility visibility, boolean isStatic) {
		this.name = name;
		this.visibility = visibility;
		this.isStatic = isStatic;
		templateBindings = new ArrayList<>();
		attributes = new ArrayList<>();
		operations = new ArrayList<>();
		templateParameters = new ArrayList<>();
		innerElements = new ArrayList<>();
	}
	
	/**
	 * Adds an {@link UmlTemplateBinding} to the list
	 * 
	 * @param templateBinding the {@link UmlTemplateBinding} to add
	 */
	public void addTemplateBinding(UmlTemplateBinding templateBinding) {
		templateBindings.add(templateBinding);
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
	 * Adds an {@link UmlOperation} to the list
	 * 
	 * @param operation the {@link UmlOperation} to add
	 */
	public void addOperation(UmlOperation operation) {
		operations.add(operation);
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
	 * Adds an inner element to the list
	 * 
	 * @param element the inner element to add to the list
	 */
	public void addInnerElement(UmlElement element) {
		innerElements.add(element);
	}
}
