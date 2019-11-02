package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Represents a template binding by an {@link OwnedOperation} or {@link PackagedElement}
 * 
 * @author dschoenicke
 *
 */
public class TemplateBinding {

	/**
	 * The id of the template binding
	 */
	private String id;
	
	/**
	 * References the {@link OwnedTemplateSignature} used by this template binding
	 */
	private String signature;
	
	/**
	 * The {@link ParameterSubstitution} of this template binding
	 */
	private ParameterSubstitution parameterSubstitution;
	
	/**
	 * Default constructor
	 */
	public TemplateBinding() {}

	/**
	 * Gets the id of the template binding
	 * 
	 * @return the id of the template binding
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	public String getId() {
		return id;
	}

	/**
	 * Sets the id of the template binding
	 * 
	 * @param id the id of the template binding
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the id of the {@link OwnedTemplateSignature} used by this template binding
	 * 
	 * @return the id of the {@link OwnedTemplateSignature}
	 */
	@XmlAttribute(name = "signature")
	public String getSignature() {
		return signature;
	}

	/**
	 * Sets the id of the {@link OwnedTemplateSignature} used by this template binding
	 * 
	 * @param signature the id of the {@link OwnedTemplateSignature}
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}

	/**
	 * Gets the {@link ParameterSubstitution}
	 * 
	 * @return the {@link ParameterSubstitution}
	 */
	@XmlElement(name = "parameterSubstitution")
	public ParameterSubstitution getParameterSubstitution() {
		return parameterSubstitution;
	}

	/**
	 * Sets the {@link ParameterSubstitution}
	 * 
	 * @param parameterSubstitution the {@link ParameterSubstitution}
	 */
	public void setParameterSubstitution(ParameterSubstitution parameterSubstitution) {
		this.parameterSubstitution = parameterSubstitution;
	}
}
