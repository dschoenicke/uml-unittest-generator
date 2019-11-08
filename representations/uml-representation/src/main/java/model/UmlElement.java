package model;

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
	 * Constructor with name and {@link UmlVisibility}
	 * 
	 * @param name the name of the element
	 * @param visibility the {@link UmlVisibility} of the element
	 */
	protected UmlElement(String name, UmlVisibility visibility) {
		this.name = name;
		this.visibility = visibility;
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
}
