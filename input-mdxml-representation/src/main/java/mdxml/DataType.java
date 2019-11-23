package mdxml;

import javax.xml.bind.annotation.XmlElement;

import core.representation.Node;

/**
 * Represents a primitive data type which is described by a reference to its specification.
 * 
 * @author dschoenicke
 *
 */
public class DataType implements Node {

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
	@XmlElement(namespace = "http://www.omg.org/spec/XMI/20131001", name = "Extension")
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
