package model;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Represents the upper value of an {@link OwnedParameter} or an {@link OwnedAttribute}
 * 
 * @author dschoenicke
 *
 */
public class UpperValue {

	/**
	 * The id of the value
	 */
	private String id;
	
	/**
	 * The upper value (0, 1 or *)
	 */
	private String value;
	
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
}
