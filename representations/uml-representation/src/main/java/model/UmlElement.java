package model;

import java.util.ArrayList;

/**
 * Abstract class extended by {@link UmlClass}es, {@link UmlInterface}s and {@link UmlEnumeration}s
 * 
 * @author dschoenicke
 *
 */
public abstract class UmlElement {

	/**
	 * The name of the element
	 */
	private String name;
	
	/**
	 * The {@link UmlVisibility} of the element
	 */
	private UmlVisibility visibility;
	
	/**
	 * List of {@link UmlTemplateBinding}s of the element
	 */
	private ArrayList<UmlTemplateBinding> templateBindings;
	
	/**
	 * Constructor with name and {@link UmlVisibility}, initializes the list of {@link UmlTemplateBinding}s
	 * 
	 * @param name the name of the element
	 * @param visibility the {@link UmlVisibility} of the element
	 */
	protected UmlElement(String name, UmlVisibility visibility) {
		this.name = name;
		this.visibility = visibility;
		templateBindings = new ArrayList<UmlTemplateBinding>();
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
}
