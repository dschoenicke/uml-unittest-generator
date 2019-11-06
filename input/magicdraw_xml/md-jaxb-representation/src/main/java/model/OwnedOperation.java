package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Represents an operation inside a {@link PackagedElement}
 * 
 * @author dschoenicke
 *
 */
public class OwnedOperation {
	
	/**
	 * The id of the operation
	 */
	private String id;
	
	/**
	 * The name of the operation
	 */
	private String name;
	
	/**
	 * The visibility of the operation
	 */
	private String visibility;
	
	/**
	 * Set to "true" if the operation is static, null otherwise
	 */
	private String isStatic;
	
	/**
	 * Set to "true" if the operation is abstract, null otherwise
	 */
	private String isAbstract;
	
	/**
	 * Set to "true" if the operation is final, null otherwise
	 */
	private String isFinal;
	
	/**
	 * List of the operation's {@link OwnedParameter}s
	 */
	private ArrayList<OwnedParameter> ownedParameters;
	
	/**
	 * The operation's {@link TemplateBinding}
	 */
	private TemplateBinding templateBinding;
	
	/**
	 * Default constructor, initializes the list for {@link OwnedParameter}s
	 */
	public OwnedOperation() {
		ownedParameters = new ArrayList<OwnedParameter>();
	}
	
	/**
	 * Gets the id of the operation
	 * 
	 * @return the id of the operation
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	public String getId() {
		return id;
	}
	
	/**
	 * Sets the id of the operation
	 * 
	 * @param id the id of the operation
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Sets the name of the operation
	 * 
	 * @return the name of the operation
	 */
	@XmlAttribute(name = "name")
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the operation
	 * 
	 * @param name the name of the operation
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Sets the visibility of the operation
	 * 
	 * @return the visibility of the operation
	 */
	@XmlAttribute
	public String getVisibility() {
		return visibility;
	}

	/**
	 * Gets the visibility of the operation
	 * 
	 * @param visibility the visibility of the operation
	 */
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	
	/**
	 * Gets the String which classifies whether the operation is static
	 * 
	 * @return "true" if the operation is static, null otherwise
	 */
	@XmlAttribute(name = "isStatic")
	public String getIsStatic() {
		return isStatic;
	}
	
	/**
	 * Sets the String which classifies whether the operation is static
	 * 
	 * @param isStatic "true" if the operation is static, null otherwise
	 */
	public void setIsStatic(String isStatic) {
		this.isStatic = isStatic;
	}
	
	/**
	 * Gets the String which classifies whether the operation is abstract
	 * 
	 * @return "true" if the operation is abstract, null otherwise
	 */
	@XmlAttribute(name = "isAbstract")
	public String getIsAbstract() {
		return isAbstract;
	}
	
	/**
	 * Sets the String which classifies whether the operation is abstract
	 * 
	 * @param isAbstract "true" if the operation is abstract, null otherwise
	 */
	public void setIsAbstract(String isAbstract) {
		this.isAbstract = isAbstract;
	}
	
	/**
	 * Gets the String which classifies whether the operation is final
	 * 
	 * @return "true" if the operation is final, null otherwise
	 */
	@XmlAttribute(name = "isFinal")
	public String getIsFinal() {
		return isFinal;
	}
	
	/**
	 * Sets the String which classifies whether the operation is final
	 * 
	 * @param isFinal "true" if the operation is final, null otherwise
	 */
	public void setIsFinal(String isFinal) {
		this.isFinal = isFinal;
	}
	
	/**
	 * Gets the list of the operation's {@link OwnedParameter}s
	 * 
	 * @return the list of the operation's {@link OwnedParameter}s
	 */
	@XmlElement(name = "ownedParameter")
	public ArrayList<OwnedParameter> getOwnedParameters() {
		return ownedParameters;
	}
	
	/**
	 * Sets the list of the operation's {@link OwnedParameter}s
	 * 
	 * @param ownedParameters the list of the operation's {@link OwnedParameter}s
	 */
	public void setOwnedParameters(ArrayList<OwnedParameter> ownedParameters) {
		this.ownedParameters = ownedParameters;
	}
	
	/**
	 * Gets the {@link TemplateBinding} of the operation
	 * 
	 * @return the {@link TemplateBinding}s
	 */
	@XmlElement(name = "templateBinding")
	public TemplateBinding getTemplateBinding() {
		return templateBinding;
	}

	/**
	 * Sets the {@link TemplateBinding} of the operation
	 * 
	 * @param templateBinding the {@link TemplateBinding}
	 */
	public void setTemplateBinding(TemplateBinding templateBinding) {
		this.templateBinding = templateBinding;
	}
}
