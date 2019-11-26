package mdxml;

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
	 * The operation's {@link TemplateBinding}s
	 */
	private ArrayList<TemplateBinding> templateBindings;
	
	/**
	 * The operation's {@link OwnedTemplateSignature}
	 */
	private OwnedTemplateSignature ownedTemplateSignature;
	
	/**
	 * Default constructor, initializes the lists for {@link OwnedParameter}s and {@link TemplateBinding}s
	 */
	public OwnedOperation() {
		ownedParameters = new ArrayList<>();
		templateBindings = new ArrayList<>();
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
	 * Gets the {@link TemplateBinding}s of the operation
	 * 
	 * @return the {@link TemplateBinding}s
	 */
	@XmlElement(name = "templateBinding")
	public ArrayList<TemplateBinding> getTemplateBindings() {
		return templateBindings;
	}

	/**
	 * Sets the {@link TemplateBinding}s of the operation
	 * 
	 * @param templateBindings the {@link TemplateBinding}s
	 */
	public void setTemplateBindings(ArrayList<TemplateBinding> templateBindings) {
		this.templateBindings = templateBindings;
	}
	
	/**
	 * Gets the {@link OwnedTemplateSignature} of the operation
	 * 
	 * @return the {@link OwnedTemplateSignature} of the operation
	 */
	@XmlElement(name = "ownedTemplateSignature")
	public OwnedTemplateSignature getOwnedTemplateSignature() {
		return ownedTemplateSignature;
	}
	
	/**
	 * Sets the {@link OwnedTemplateSignature} of the operation
	 * 
	 * @param ownedTemplateSignature the {@link OwnedTemplateSignature} of the operation
	 */
	public void setOwnedTemplateSignature(OwnedTemplateSignature ownedTemplateSignature) {
		this.ownedTemplateSignature = ownedTemplateSignature;
	}
}
