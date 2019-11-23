package mdxml;

import javax.xml.bind.annotation.XmlAttribute;

import core.representation.Node;

/**
 * Represents the upper value of an {@link OwnedParameter} or an {@link OwnedAttribute}
 * 
 * @author dschoenicke
 *
 */
public class UpperValue implements Node {

	/**
	 * The id of the value
	 */
	private String id;
	
	/**
	 * The upper value (0, 1 or *)
	 */
	private String value;
	
	/**
	 * The type of the value
	 */
	private String type;
	
	/**
	 * Default constructor
	 */
	public UpperValue() {}
	
	/**
	 * Gets the id of the value
	 * 
	 * @return the id of the value
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	public String getId() {
		return id;
	}
	
	/** Sets the id of the value
	 * 
	 * @param id the id of the value
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Gets the upper value
	 * 
	 * @return the upper value
	 */
	@XmlAttribute(name = "value")
	public String getValue() {
		return value;
	}
	
	/**
	 * Sets the upper value
	 * 
	 * @param value the upper value
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * Gets the type of the value
	 * 
	 * @return the type of the value
	 */
	@XmlAttribute(namespace = "http://omg.org/spec/XMI/20131001", name = "type")
	public String getType() {
		return type;
	}
	
	/**
	 * Sets the type of the value
	 * 
	 * @param type the type of the value
	 */
	public void setType(String type) {
		this.type = type;
	}
}
