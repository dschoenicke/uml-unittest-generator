package model;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Represents the supplier class of an {@link InterfaceRealization} or Association.
 * Associations are represented as {@link PackagedElement}.
 * 
 * @author dschoenicke
 *
 */
public class Supplier {

	/**
	 * References the {@link PackagedElement} which acts as a supplier by its id
	 */
	private String idref;
	
	/**
	 * Default constructor
	 */
	public Supplier() {}
	
	/**
	 * Gets the id as a reference to the {@link PackagedElement} which acts as the supplier
	 * 
	 * @return the id of the {@link PackagedElement}
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "idref")
	public String getIdref() {
		return idref;
	}
	
	/**
	 * Sets the id as a reference to the {@link PackagedElement} which acts as the supplier
	 * 
	 * @param idref the id of the {@link PackagedElement}
	 */
	public void setIdref(String idref) {
		this.idref = idref;
	}
}
