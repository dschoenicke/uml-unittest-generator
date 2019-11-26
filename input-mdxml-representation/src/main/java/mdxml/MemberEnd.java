package mdxml;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * References the end of an association with the id of the corresponding {@link PackagedElement}
 * 
 * @author dschoenicke
 *
 */
public class MemberEnd {

	/**
	 * The id of the {@link PackagedElement} which acts as the association end
	 */
	private String idref;
	
	/**
	 * Default constructor
	 */
	public MemberEnd() {}
	
	/**
	 * Gets the id of the {@link PackagedElement}
	 * 
	 * @return the id of the {@link PackagedElement}
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "idref")
	public String getIdref() {
		return idref;
	}
	
	/**
	 * Sets the id of the {@link PackagedElement}
	 * 
	 * @param idref the id of the {@link PackagedElement}
	 */
	public void setIdref(String idref) {
		this.idref = idref;
	}
}
