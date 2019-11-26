package mdxml;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Represents the default value of an {@link OwnedAttribute}
 * 
 * @author dschoenicke
 *
 */
public class DefaultValue {

	/**
	 * The id of the default value
	 */
	private String id;
	
	/**
	 * The type of the default value
	 */
	private String type;
	
	/**
	 * The default value
	 */
	private String value;
	
	/**
	 * Default constructor
	 */
	public DefaultValue() {}
	
	/**
	 * Gets the id of the default value
	 * 
	 * @return the id of the default value
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	public String getId() {
		return id;
	}
	
	/**
	 * Sets the id of the default value
	 * 
	 * @param id the id of the default value
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Gets the type of the default value
	 * 
	 * @return the type of the default value
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "type")
	public String getType() {
		return type;
	}
	
	/**
	 * Sets the type of the default value
	 * 
	 * @param type the type of the default value
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Gets the default value
	 * 
	 * @return the default value
	 */
	@XmlAttribute(name = "value")
	public String getValue() {
		return value;
	}
	
	/**
	 * Sets the default value
	 * 
	 * @param value the default value
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
