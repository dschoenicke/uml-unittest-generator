package model;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Represents the lower value of an {@link OwnedParameter} or an {@link OwnedAttribute}
 * 
 * @author dschoenicke
 *
 */
public class LowerValue {

	/**
	 * The id of the value
	 */
	private String id;
	
	/**
	 * The lower value (0, 1 or *)
	 */
	private String value;
	
	/**
	 * Default constructor
	 */
	public LowerValue() {}
	
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
	 * Gets the lower value
	 * 
	 * @return the lower value
	 */
	@XmlAttribute(name = "value")
	public String getValue() {
		return value;
	}
	
	/**
	 * Sets the lower value
	 * 
	 * @param value the lower value
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
