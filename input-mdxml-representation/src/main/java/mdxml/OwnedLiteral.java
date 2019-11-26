package mdxml;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Represents enumeration literals held by a {@link PackagedElement} representing the enumeration
 * 
 * @author dschoenicke
 *
 */
public class OwnedLiteral {

	/**
	 * The id of the literal
	 */
	private String id;
	
	/**
	 * The name of the literal
	 */
	private String name;
	
	/**
	 * Default constructor
	 */
	public OwnedLiteral() {}

	/**
	 * Gets the id of the literal
	 * 
	 * @return the id of the literal
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	public String getId() {
		return id;
	}

	/**
	 * Sets the id of the literal
	 * 
	 * @param id the id of the literal
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the name of the literal
	 * 
	 * @return the name of the literal
	 */
	@XmlAttribute
	public String getName() {
		return name;
	}

	/** Sets the name of the literal
	 * 
	 * @param name the name of the literal
	 */
	public void setName(String name) {
		this.name = name;
	}
}
