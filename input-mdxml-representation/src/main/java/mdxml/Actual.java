package mdxml;

import javax.xml.bind.annotation.XmlElement;

/**
 * Auxiliary class representing the type replacing a {@link Parameter} in a {@link ParameterSubstitution} if the replacing type is a primitive type
 * 
 * @author dschoenicke
 *
 */
public class Actual {

	/**
	 * The {@link Extension} holding the {@link ReferenceExtension} which determines the data type
	 */
	private Extension extension;
	
	/**
	 * Default constructor
	 */
	public Actual() {}
	
	/**
	 * Gets the {@link Extension} holding the {@link ReferenceExtension}
	 * 
	 * @return the {@link Extension}
	 */
	@XmlElement(namespace = "http://www.omg.org/spec/XMI/20131001", name = "Extension")
	public Extension getExtension() {
		return extension;
	}
	
	/**
	 * Sets the {@link Extension} holding the {@link ReferenceExtension}
	 * 
	 * @param extension the {@link Extension}
	 */
	public void setExtension(Extension extension) {
		this.extension = extension;
	}
}
