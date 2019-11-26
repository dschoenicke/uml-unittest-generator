package uml;

/**
 * Represents a literal of an {@link UmlEnumeration}
 * 
 * @author dschoenicke
 *
 */
public class UmlLiteral {
	
	/**
	 * Name of the literal
	 */
	private String name;
	
	/**
	 * Constructor with the literals name as a parameter
	 * 
	 * @param name the name of the literal
	 */
	public UmlLiteral(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the name of the literal
	 * 
	 * @return the name of the literal
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the literal
	 * 
	 * @param name the name of the literal
	 */
	public void setName(String name) {
		this.name = name;
	}
}
