package mdxml;

import java.util.ArrayList;

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
	 * The list of {@link ParameterSubstitution}s of this template binding
	 */
	private ArrayList<ParameterSubstitution> parameterSubstitutions;
	
	/**
	 * Default constructor, initializes the list of {@link ParameterSubstitution}s
	 */
	public TemplateBinding() {
		parameterSubstitutions = new ArrayList<>();
	}

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
	 * Gets the {@link ParameterSubstitution}s
	 * 
	 * @return the {@link ParameterSubstitution}s
	 */
	@XmlElement(name = "parameterSubstitution")
	public ArrayList<ParameterSubstitution> getParameterSubstitutions() {
		return parameterSubstitutions;
	}

	/**
	 * Sets the {@link ParameterSubstitution}s
	 * 
	 * @param parameterSubstitutions the {@link ParameterSubstitution}s
	 */
	public void setParameterSubstitutions(ArrayList<ParameterSubstitution> parameterSubstitutions) {
		this.parameterSubstitutions = parameterSubstitutions;
	}
}
