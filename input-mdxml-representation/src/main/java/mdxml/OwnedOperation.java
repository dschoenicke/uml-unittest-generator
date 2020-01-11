package mdxml;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import lombok.Data;

/**
 * Represents an operation inside a {@link PackagedElement}
 * 
 * @author dschoenicke
 *
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class OwnedOperation {
	
	/**
	 * The id of the operation
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	private String id;
	
	/**
	 * The name of the operation
	 */
	@XmlAttribute(name = "name")
	private String name;
	
	/**
	 * The visibility of the operation
	 */
	@XmlAttribute(name = "visibility")
	private String visibility;
	
	/**
	 * Set to "true" if the operation is static, null otherwise
	 */
	@XmlAttribute(name = "isStatic")
	private String isStatic;
	
	/**
	 * Set to "true" if the operation is abstract, null otherwise
	 */
	@XmlAttribute(name = "isAbstract")
	private String isAbstract;
	
	/**
	 * Set to "true" if the operation is final, null otherwise
	 */
	@XmlAttribute(name = "isFinal")
	private String isFinal;
	
	/**
	 * List of the operation's {@link OwnedParameter}s
	 */
	@XmlElement(name = "ownedParameter")
	private ArrayList<OwnedParameter> ownedParameters;
	
	/**
	 * The operation's {@link TemplateBinding}s
	 */
	@XmlElement(name = "templateBinding")
	private ArrayList<TemplateBinding> templateBindings;
	
	/**
	 * The operation's {@link OwnedTemplateSignature}
	 */
	@XmlElement(name = "ownedTemplateSignature")
	private OwnedTemplateSignature ownedTemplateSignature;
	
	/**
	 * Default constructor, initializes the list of {@link OwnedParameter}s and {@link TemplateBinding}s
	 */
	public OwnedOperation() {
		ownedParameters = new ArrayList<>();
		templateBindings = new ArrayList<>();
	}
}
