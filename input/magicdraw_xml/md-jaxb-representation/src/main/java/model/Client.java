package model;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Represents the client class of an {@link InterfaceRealization} or Association.
 * Associations are represented as {@link PackagedElement}.
 * 
 * @author dschoenicke
 *
 */
public class Client {

	/**
	 * References the {@link PackagedElement} which acts as a client by its id
	 */
	private String idref;
	
	/**
	 * Default constructor
	 */
	public Client() {}
	
	/**
	 * Gets the id as a reference to the {@link PackagedElement} which acts as the client
	 * 
	 * @return the id of the {@link PackagedElement}
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "idref")
	public String getIdref() {
		return idref;
	}
	
	/**
	 * Sets the id as a reference to the {@link PackagedElement} which acts as the client
	 * 
	 * @param idref the id of the {@link PackagedElement}
	 */
	public void setIdref(String idref) {
		this.idref = idref;
	}
}