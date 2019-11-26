package mdxml;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Represents a generalization relationship of a {@link PackagedElement} and its general
 * 
 * @author dschoenicke
 *
 */
public class Generalization {

	/**
	 * The id of the generalization
	 */
	private String id;
	
	/**
	 * Reference to the general {@link PackagedElement}
	 */
	private String general;

	/**
	 * Default constructor
	 */
	public Generalization() {}
	
	/**
	 * Gets the id of the generalization
	 * 
	 * @return the id of the generalization
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	public String getId() {
		return id;
	}

	/**
	 * Sets the id of the generalization
	 * 
	 * @param id the id of the generalization
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the id of the general
	 * 
	 * @return the id of the general
	 */
	@XmlAttribute
	public String getGeneral() {
		return general;
	}

	/** Sets the id of the general
	 * 
	 * @param general the id of the general
	 */
	public void setGeneral(String general) {
		this.general = general;
	}
}
