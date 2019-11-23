package mdxml;

import javax.xml.bind.annotation.XmlAttribute;

import core.representation.Node;

/**
 * Determines the data type of a primitive type by holding a reference to its specification
 * 
 * @author dschoenicke
 *
 */
public class ReferenceExtension implements Node {

	/**
	 * Reference to the primitive type
	 */
	private String referentPath;
	
	/**
	 * Default constructor
	 */
	public ReferenceExtension() {}
	
	/**
	 * Gets the referentPath determining the data type
	 * 
	 * @return the referentPath
	 */
	@XmlAttribute(name = "referentPath")
	public String getReferentPath() {
		return referentPath;
	}
	
	/**
	 * Sets the referentPath determining the data type
	 * 
	 * @param referentPath the referentPath
	 */
	public void setReferentPath(String referentPath) {
		this.referentPath = referentPath;
	}
}
