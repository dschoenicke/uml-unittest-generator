package model;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Represents a primitive data type which is described by a reference to its specification.
 * 
 * @author dschoenicke
 *
 */
public class DataType {

	/**
	 * Reference to the specification of the datatype
	 */
	private String href;
	
	/**
	 * Default constructor
	 */
	public DataType() {}
	
	/**
	 * Gets the reference to the specification of the data type
	 * 
	 * @return the reference to the specification
	 */
	@XmlAttribute
	public String getHref() {
		return href;
	}
	
	/**
	 * Sets the reference to the specification of the data type
	 * 
	 * @param href the reference to the specification
	 */
	public void setHref(String href) {
		this.href = href;
	}
}
