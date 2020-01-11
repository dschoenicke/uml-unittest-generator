package mdxml;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import lombok.Data;

/**
 * Represents an element in the diagram. Can describe a package, a class, an interface, an enumeration or an association
 * 
 * @author dschoenicke
 *
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class PackagedElement {

	/**
	 * The id of the element
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	private String id;
	
	/**
	 * The name of the element
	 */
	@XmlAttribute
	private String name;
	
	/**
	 * The visibility of the element
	 */
	@XmlAttribute
	private String visibility;
	
	/**
	 * The type of the element
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "type")
	private String type;
	
	/**
	 * Set to "true" if the element is static, null otherwise
	 */
	@XmlAttribute(name = "isStatic")
	private String isStatic;
	
	/**
	 * Set to "true" if the element is abstract, null otherwise
	 */
	@XmlAttribute(name = "isAbstract")
	private String isAbstract;
	
	/**
	 * Set to "true" if the element is final, null otherwise
	 */
	@XmlAttribute(name = "isFinal")
	private String isFinal;
	
	/**
	 * The list of the {@link OwnedAttribute}s if the packaged element describes a class
	 */
	@XmlElement(name = "ownedAttribute")
	private ArrayList<OwnedAttribute> ownedAttributes;
	
	/**
	 * The list of the {@link OwnedOperation}s if the packaged element describes a class or an interface
	 */
	@XmlElement(name = "ownedOperation")
	private ArrayList<OwnedOperation> ownedOperations;
	
	/**
	 * The list of the {@link OwnedLiteral}s if the packaged element describes an enumeration
	 */
	@XmlElement(name = "ownedLiteral")
	private ArrayList<OwnedLiteral> ownedLiterals;
	
	/**
	 * The list of the {@link PackagedElement}s if the packaged element describes a package
	 */
	@XmlElement(name = "packagedElement")
	private ArrayList<PackagedElement> packagedElements;
	
	/**
	 * The list of {@link TemplateBinding}s if the packaged element describes a class or an interface
	 */
	@XmlElement(name = "templateBinding")
	private ArrayList<TemplateBinding> templateBindings;
	
	/**
	 * The list of the {@link OwnedTemplateSignature}s if the packaged element describes a class or an interface
	 */
	@XmlElement(name = "ownedTemplateSignature")
	private OwnedTemplateSignature ownedTemplateSignature;
	
	/**
	 * The object describing a {@link Generalization} if the packaged element is a class which extends another class
	 */
	@XmlElement(name = "generalization")
	private Generalization generalization;
	
	/**
	 * The list of {@link InterfaceRealization}s if the packaged element describes an element which implements interfaces
	 */
	@XmlElement(name = "interfaceRealization")
	private ArrayList<InterfaceRealization> interfaceRealizations;
	
	/**
	 * The {@link Client} description if the packaged element describes an association
	 */
	@XmlElement(name = "client")
	private Client client;
	
	/**
	 * The {@link Supplier} description if the packaged element describes an association
	 */
	@XmlElement(name = "supplier")
	private Supplier supplier;
	
	/**
	 * The {@link MemberEnd} descriptions if the packaged element describes an association
	 */
	@XmlElement(name = "memberEnd")
	private ArrayList<MemberEnd> memberEnds;
	
	/**
	 * The {@link ownedEnd} description if the packaged element describes an association
	 */
	@XmlElement(name = "ownedEnd")
	private OwnedEnd ownedEnd;
	
	/**
	 * List of inner classes of the element
	 */
	@XmlElement(name = "nestedClassifier")
	private ArrayList<PackagedElement> nestedClassifiers;
 	
	/**
	 * Default constructor
	 * Initializes lists for {@link OwnedAttribute}s, {@link OwnedOperation}s, {@link OwnedLiteral}s, {@link TemplateBinding}s, {@link PackagedElement}s, {@link InterfaceRealization}s and {@link MemberEnd}s
	 */
	public PackagedElement() {
		ownedAttributes = new ArrayList<OwnedAttribute>();
		ownedOperations = new ArrayList<OwnedOperation>();
		ownedLiterals = new ArrayList<OwnedLiteral>();
		packagedElements = new ArrayList<PackagedElement>();
		nestedClassifiers = new ArrayList<PackagedElement>();
		templateBindings = new ArrayList<TemplateBinding>();
		interfaceRealizations = new ArrayList<InterfaceRealization>();
	}
}
