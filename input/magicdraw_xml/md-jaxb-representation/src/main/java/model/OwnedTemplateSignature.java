package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Represents a template signature of a {@link PackagedElement} which represents a class or an interface
 * 
 * @author dschoenicke
 *
 */
public class OwnedTemplateSignature {

	/**
	 * The id of the template signature
	 */
	private String id;
	
	/**
	 * A list of {@link Parameter}s which reference the actual {@link OwnedParameter}s
	 */
	private ArrayList<Parameter> parameters;
	
	/**
	 * A list of {@link OwnedParameter}s of the template signature
	 */
	private ArrayList<OwnedParameter> ownedParameters;
	
	/**
	 * Default constructor, initializes lists for {@link Parameter}s and {@link OwnedParameter}s 
	 */
	public OwnedTemplateSignature() {
		parameters = new ArrayList<Parameter>();
		ownedParameters = new ArrayList<OwnedParameter>();
	}

	/**
	 * Gets the id of the template signature
	 * 
	 * @return the id of the template signature
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	public String getId() {
		return id;
	}

	/**
	 * Sets the id of the template signature
	 * 
	 * @param id the id of the template signature
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the list of {@link Parameter}s
	 * 
	 * @return the list of the {@link Parameter}s
	 */
	@XmlElement(name = "parameter")
	public ArrayList<Parameter> getParameters() {
		return parameters;
	}

	/**
	 * Sets the list of {@link Parameter}s
	 * 
	 * @param parameters the list of the {@link Parameter}s
	 */
	public void setParameters(ArrayList<Parameter> parameters) {
		this.parameters = parameters;
	}

	/**
	 * Gets the list of {@link OwnedParameter}s
	 * 
	 * @return the list of the {@link OwnedParameter}s
	 */
	@XmlElement(name = "ownedParameter")
	public ArrayList<OwnedParameter> getOwnedParameters() {
		return ownedParameters;
	}

	/**
	 * Sets the list of {@link OwnedParameter}s
	 * 
	 * @param ownedParameters the list of the {@link OwnedParameter}s
	 */
	public void setOwnedParameters(ArrayList<OwnedParameter> ownedParameters) {
		this.ownedParameters = ownedParameters;
	}
}
