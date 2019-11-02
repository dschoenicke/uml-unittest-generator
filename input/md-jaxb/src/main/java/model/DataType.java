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
	 * {@link Extension} holding a reference to the specification of the datatype
	 */
	private Extension extension;
	
	/**
	 * Default constructor
	 */
	public DataType() {}
	
	/**
	 * Gets the {@link Extension} holding the specification of the data type
	 * 
	 * @return the {@link Extension} holding the specification of the data type
	 */
	@XmlAttribute
	public Extension getExtension() {
		return extension;
	}
	
	/**
	 * Sets the {@link Extension} holding the specification of the data type
	 * 
	 * @param extension the {@link Extension} holding the specification of the data type
	 */
	public void setExtension(Extension extension) {
		this.extension = extension;
	}
}
