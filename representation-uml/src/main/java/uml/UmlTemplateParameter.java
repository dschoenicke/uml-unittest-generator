package uml;

/**
 * Represents an template parameter of a generic {@link UmlClass} or {@link UmlInterface}
 * 
 * @author dschoenicke
 *
 */
public class UmlTemplateParameter {
	
	/**
	 * The name of the template parameter
	 */
	private String name;
	
	/**
	 * The constraining type of the template parameter
	 * Is 'java.lang.Object' if there is no constrain
	 */
	private String type;
	
	/**
	 * Constructor with the name and a constraining type
	 * 
	 * @param name the name of the template parameter
	 * @param type the constraining type of the template parameter
	 */
	public UmlTemplateParameter(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	/**
	 * Gets the name of the template parameter
	 * 
	 * @return the name of the template parameter
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the template parameter
	 * 
	 * @param name the name of the template parameter
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the constraining type of the template parameter
	 * 
	 * @return the constraining type of the template parameter
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Sets the constraining type of the template parameter
	 * 
	 * @param type the constraining type of the template parameter
	 */
	public void setType(String type) {
		this.type = type;
	}
}
