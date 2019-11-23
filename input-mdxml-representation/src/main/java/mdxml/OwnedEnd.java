package mdxml;

import javax.xml.bind.annotation.XmlAttribute;

import core.representation.Node;

/**
 * Describes the owned end of an association
 * 
 * @author dschoenicke
 *
 */
public class OwnedEnd implements Node {

	/**
	 * Id of the ownedEnd
	 */
	private String id;
	
	/**
	 * Type of the end, e.g. property or method parameter
	 */
	private String endType;
	
	/**
	 * The reference to the owned end. Could be the id of an {@link OwnedAttribute} or {@link OwnedParameter}
	 */
	private String associationType;
	
	/**
	 * The visibility of the owned end
	 */
	private String visibility;
	
	/**
	 * Id of the {@link PackagedElement} which represents the association which holds this ownedEnd
	 */
	private String association;
	
	/**
	 * Default constructor
	 */
	public OwnedEnd() {}

	/**
	 * Gets the id of the ownedEnd
	 * 
	 * @return the id of the ownedEnd
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	public String getId() {
		return id;
	}

	/**
	 * Sets the id of the ownedEnd
	 * 
	 * @param id the id of the ownedEnd
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the reference to the owned end
	 * 
	 * @return the reference to the owned end
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "type")
	public String getEndType() {
		return endType;
	}

	/**
	 * Sets the reference to the owned end
	 * 
	 * @param endType the reference to the owned end
	 */
	public void setEndType(String endType) {
		this.endType = endType;
	}

	/**
	 * Gets the reference to the actual owned end
	 * 
	 * @return the reference to the actual owned end
	 */
	@XmlAttribute(name = "type")
	public String getAssociationType() {
		return associationType;
	}

	/**
	 * Sets the reference to the actual owned end
	 * 
	 * @param associationType the reference to the actual owned end
	 */
	public void setAssociationType(String associationType) {
		this.associationType = associationType;
	}

	/**
	 * Sets the visibility of the owned end
	 * 
	 * @return the visibility of the owned end
	 */
	@XmlAttribute(name = "visibility")
	public String getVisibility() {
		return visibility;
	}

	/**
	 * Sets the visibility of the owned end
	 * 
	 * @param visibility the visibility of the owned end
	 */
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	/**
	 * Gets the id of the {@link PackagedElement} which represents the association
	 * 
	 * @return the id of the association
	 */
	@XmlAttribute(name = "association")
	public String getAssociation() {
		return association;
	}

	/**
	 * Sets the id of the {@link PackagedElement} which represents the association
	 * 
	 * @param association the id of the association
	 */
	public void setAssociation(String association) {
		this.association = association;
	}
}
