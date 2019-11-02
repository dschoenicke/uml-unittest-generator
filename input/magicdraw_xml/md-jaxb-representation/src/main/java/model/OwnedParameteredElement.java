package model;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Describes an element which is parametered by an {@link OwnedParameter}
 * 
 * @author dschoenicke
 *
 */
public class OwnedParameteredElement {

	/**
	 * The id of the OwnedParameteredElement
	 */
	private String id;
	
	/**
	 * The name of the element
	 */
	private String name;
	
	/**
	 * The id of the {@link OwnedParameter} which parameters this element
	 */
	private String templateParameter;
	
	/**
	 * Default constructor
	 */
	public OwnedParameteredElement() {}

	/**
	 * Gets the id of the OwnedParameteredElement
	 * 
	 * @return the id of the OwnedParameteredElement
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	public String getId() {
		return id;
	}

	/**
	 * Sets the id of the OwnedParameteredElement
	 * 
	 * @param id the id of the OwnedParameteredElement
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the name of the OwnedParameteredElement
	 * 
	 * @return the name of the OwnedParameteredElement
	 */
	@XmlAttribute(name = "name")
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the OwnedParameteredElement
	 * 
	 * @param name the name of the OwnedParameteredElement
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the id of the {@link OwnedParameter}
	 * 
	 * @return the id of the {@link OwnedParameter}
	 */
	@XmlAttribute(name = "templateParameter")
	public String getTemplateParameter() {
		return templateParameter;
	}

	/**
	 * Sets the id of the {@link OwnedParameter}
	 * 
	 * @param templateParameter the id of the {@link OwnedParameter}
	 */
	public void setTemplateParameter(String templateParameter) {
		this.templateParameter = templateParameter;
	}
}
