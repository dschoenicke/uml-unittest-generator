package mdxml;

import javax.xml.bind.annotation.XmlAttribute;

import core.representation.Node;

/**
 * Represents a reference to an {@link OwnedParameter} in an {@link OwnedTemplateSignature}
 * 
 * @author dschoenicke
 *
 */
public class Parameter implements Node {

	/**
	 * The id referencing the {@link OwnedParameter}
	 */
	private String idref;
	
	/**
	 * Default constructor
	 */
	public Parameter() {}
	
	/**
	 * Gets the id referencing the {@link OwnedParameter}
	 * 
	 * @return the id referencing the {@link OwnedParameter}
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "idref")
	public String getIdref() {
		return idref;
	}
	
	/**
	 * Sets the id referencing the {@link OwnedParameter}
	 * 
	 * @param idref the id referencing the {@link OwnedParameter}
	 */
	public void setIdref(String idref) {
		this.idref = idref;
	}
}
