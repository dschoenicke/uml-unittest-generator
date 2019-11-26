package mdxml;

import javax.xml.bind.annotation.XmlElement;

/**
 * Represents an auxiliary node in the XML tree to extend the Magic Draw specification
 * Used to hold a {@link ModelExtension} or a {@link ReferenceExtension}
 * 
 * @author dschoenicke
 *
 */
public class Extension {
	
	/**
	 * A {@link ModelExtension} which is an auxiliary class to hold values
	 */
	private ModelExtension modelExtension;
	
	/**
	 * Determines the data type of a primitive type
	 */
	private ReferenceExtension referenceExtension;
	
	/**
	 * Default constructor
	 */
	public Extension() {}
	
	/**
	 * Gets the {@link ModelExtension}
	 * 
	 * @return the {@link ModelExtension}
	 */
	@XmlElement(name = "modelExtension")
	public ModelExtension getModelExtension() {
		return modelExtension;
	}
	
	/**
	 * Sets the {@link ModelExtension}
	 * 
	 * @param modelExtension the {@link ModelExtension}
	 */
	public void setModelExtension(ModelExtension modelExtension) {
		this.modelExtension = modelExtension;
	}
	
	/**
	 * Gets the {@link ReferenceExtension}
	 * 
	 * @return the {@link ReferenceExtension}
	 */
	@XmlElement(name = "referenceExtension")
	public ReferenceExtension getReferenceExtension() {
		return referenceExtension;
	}
	
	/**
	 * Sets the {@link ReferenceExtension}
	 * 
	 * @param referenceExtension the {@link ReferenceExtension}
	 */
	public void setReferenceExtension(ReferenceExtension referenceExtension) {
		this.referenceExtension = referenceExtension;
	}
}
