package mdxml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

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
	 * The extension holding the {@link ReferenceExtension} if the constraining classifier is a primitive type
	 */
	private Extension extension;
	
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
	
	/**
	 * Gets the {@link Extension} holding the {@link ReferenceExtension} to the primitive type acting as the constraining classifier
	 * 
	 * @return the {@link Extension} holding the {@link ReferenceExtension} to the primitive type acting as the constraining classifier
	 */
	@XmlElement(namespace = "http://www.omg.org/spec/XMI/20131001", name = "Extension")
	public Extension getExtension() {
		return extension;
	}
	
	/**
	 * Sets the {@link Extension} holding the {@link ReferenceExtension} to the primitive type acting as the constraining classifier
	 * 
	 * @param extension the {@link Extension} holding the {@link ReferenceExtension} to the primitive type acting as the constraining classifier
	 */
	public void setExtension(Extension extension) {
		this.extension = extension;
	}
}
