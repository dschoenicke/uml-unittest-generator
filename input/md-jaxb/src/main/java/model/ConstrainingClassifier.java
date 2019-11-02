package model;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Describes a constraining classifier of an {@link OwnedParameter} in an {@link OwnedTemplateSignature}.
 * 
 * @author dschoenicke
 *
 */
public class ConstrainingClassifier {

	/**
	 * References the {@link PackagedElement} which acts as the constraining classifier
	 */
	private String idref;
	
	/**
	 * Default constructor
	 */
	public ConstrainingClassifier() {}
	
	/**
	 * Gets the id as a reference to the {@link PackagedElement} which acts as the constraining classifier
	 * 
	 * @return the id of the {@link PackagedElement}
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "idref")
	public String getIdref() {
		return idref;
	}
	
	/**
	 * Sets the id as a reference to the {@link PackagedElement} which acts as the constraining classifier
	 * 
	 * @param idref the id of the {@link PackagedElement}
	 */
	public void setIdref(String idref) {
		this.idref = idref;
	}
}
