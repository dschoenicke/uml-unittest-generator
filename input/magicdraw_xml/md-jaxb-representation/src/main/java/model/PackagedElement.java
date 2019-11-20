package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Represents an element in the diagram. Can describe a package, a class, an interface, an enumeration or an association
 * 
 * @author dschoenicke
 *
 */
public class PackagedElement {

	/**
	 * The id of the element
	 */
	private String id;
	
	/**
	 * The name of the element
	 */
	private String name;
	
	/**
	 * The visibility of the element
	 */
	private String visibility;
	
	/**
	 * The type of the element
	 */
	private String type;
	
	/**
	 * Set to "true" if the element is static, null otherwise
	 */
	private String isStatic;
	
	/**
	 * Set to "true" if the element is abstract, null otherwise
	 */
	private String isAbstract;
	
	/**
	 * Set to "true" if the element is final, null otherwise
	 */
	private String isFinal;
	
	/**
	 * The list of the {@link OwnedAttribute}s if the packaged element describes a class
	 */
	private ArrayList<OwnedAttribute> ownedAttributes;
	
	/**
	 * The list of the {@link OwnedOperation}s if the packaged element describes a class or an interface
	 */
	private ArrayList<OwnedOperation> ownedOperations;
	
	/**
	 * The list of the {@link OwnedLiteral}s if the packaged element describes an enumeration
	 */
	private ArrayList<OwnedLiteral> ownedLiterals;
	
	/**
	 * The list of the {@link PackagedElement}s if the packaged element describes a package
	 */
	private ArrayList<PackagedElement> packagedElements;
	
	/**
	 * The list of {@link TemplateBinding}s if the packaged element describes a class or an interface
	 */
	private ArrayList<TemplateBinding> templateBindings;
	
	/**
	 * The list of the {@link OwnedTemplateSignature}s if the packaged element describes a class or an interface
	 */
	private OwnedTemplateSignature ownedTemplateSignature;
	
	/**
	 * The object describing a {@link Generalization} if the packaged element is a class which extends another class
	 */
	private Generalization generalization;
	
	/**
	 * The list of {@link InterfaceRealization}s if the packaged element describes an element which implements interfaces
	 */
	private ArrayList<InterfaceRealization> interfaceRealizations;
	
	/**
	 * The {@link Client} description if the packaged element describes an association
	 */
	private Client client;
	
	/**
	 * The {@link Supplier} description if the packaged element describes an association
	 */
	private Supplier supplier;
	
	/**
	 * The {@link MemberEnd} descriptions if the packaged element describes an association
	 */
	private ArrayList<MemberEnd> memberEnds;
	
	/**
	 * The {@link ownedEnd} description if the packaged element describes an association
	 */
	private OwnedEnd ownedEnd;
	
	/**
	 * List of inner classes of the element
	 */
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
	
	/**
	 * Gets the id of the element
	 * 
	 * @return the id of the element
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	public String getId() {
		return id;
	}
	
	/**
	 * Sets the id of the element
	 * 
	 * @param id the id of the element
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Gets the name of the element
	 * 
	 * @return the name of the element
	 */
	@XmlAttribute
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the element
	 * 
	 * @param name the name of the element
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the visibility of the element
	 * 
	 * @return the visibility of the element
	 */
	@XmlAttribute
	public String getVisibility() {
		return visibility;
	}

	/**
	 * Sets the visibility of the element
	 * 
	 * @param visibility the visibility of the element
	 */
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	
	/**
	 * Gets the type of the element
	 * 
	 * @return the type of the element
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "type")
	public String getType() {
		return type;
	}
	
	/**
	 * Sets the type of the element
	 * 
	 * @param type the type of the element
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Gets the String which classifies whether the element is static
	 * 
	 * @return "true" if the element is static, null otherwise
	 */
	@XmlAttribute(name = "isStatic")
	public String getIsStatic() {
		return isStatic;
	}
	
	/**
	 * Sets the String which classifies whether the element is static
	 * 
	 * @param isStatic "true" if the element is static, null otherwise
	 */
	public void setIsStatic(String isStatic) {
		this.isStatic = isStatic;
	}
	
	/**
	 * Gets the String which classifies whether the element is abstract
	 * 
	 * @return "true" if the element is abstract, null otherwise
	 */
	@XmlAttribute(name = "isAbstract")
	public String getIsAbstract() {
		return isAbstract;
	}
	
	/**
	 * Sets the String which classifies whether the element is abstract
	 * 
	 * @param isAbstract "true" if the element is abstract, null otherwise
	 */
	public void setIsAbstract(String isAbstract) {
		this.isAbstract = isAbstract;
	}
	
	/**
	 * Gets the String which classifies whether the element is final
	 * 
	 * @return "true" if the element is final, null otherwise
	 */
	@XmlAttribute(name = "isFinal")
	public String getIsFinal() {
		return isFinal;
	}
	
	/**
	 * Sets the String which classifies whether the element is final
	 * 
	 * @param isFinal "true" if the element is final, null otherwise
	 */
	public void setIsFinal(String isFinal) {
		this.isFinal = isFinal;
	}
	
	/**
	 * Gets the list of the {@link OwnedAttribute}s
	 * 
	 * @return the list of the {@link OwnedAttribute}s
	 */
	@XmlElement(name = "ownedAttribute")
	public ArrayList<OwnedAttribute> getOwnedAttributes() {
		return ownedAttributes;
	}
	
	/**
	 * Sets the list of the {@link OwnedAttribute}s
	 * 
	 * @param attributes the list of the {@link OwnedAttribute}s
	 */
	public void setOwnedAttributes(ArrayList<OwnedAttribute> attributes) {
		this.ownedAttributes = attributes;
	}
	
	/**
	 * Gets the list of the {@link OwnedOperation}s
	 * 
	 * @return the list of the {@link OwnedOperation}s
	 */
	@XmlElement(name = "ownedOperation") 
	public ArrayList<OwnedOperation> getOwnedOperations() {
		return ownedOperations;
	}
	
	/**
	 * Sets the list of the {@link OwnedOperation}s
	 * 
	 * @param operations the list of the {@link OwnedOperation}s
	 */
	public void setOwnedOperations(ArrayList<OwnedOperation> operations) {
		this.ownedOperations = operations;
	}
	
	/**
	 * Gets the list of the {@link OwnedLiteral}s
	 * 
	 * @return the list of the {@link OwnedLiteral}s
	 */
	@XmlElement(name = "ownedLiteral")
	public ArrayList<OwnedLiteral> getOwnedLiterals() {
		return ownedLiterals;
	}
	
	/**
	 * Sets the list of the {@link OwnedLiteral}s
	 * 
	 * @param ownedLiterals the list of the {@link OwnedLiteral}s
	 */
	public void setOwnedLiterals(ArrayList<OwnedLiteral> ownedLiterals) {
		this.ownedLiterals = ownedLiterals;
	}
	
	/**
	 * Gets the list of the {@link PackagedElement}s
	 * 
	 * @return the list of the {@link PackagedElement}s
	 */
	@XmlElement(name = "packagedElement")
	public ArrayList<PackagedElement> getPackagedElements() {
		return packagedElements;
	}
	
	/**
	 * Sets the list of the {@link PackagedElement}s
	 * 
	 * @param packagedElements the list of the {@link PackagedElement}s
	 */
	public void setPackagedElements(ArrayList<PackagedElement> packagedElements) {
		this.packagedElements = packagedElements;
	}
	
	/**
	 * Gets the {@link TemplateBinding}s of the element
	 * 
	 * @return the {@link TemplateBinding}s
	 */
	@XmlElement(name = "templateBinding")
	public ArrayList<TemplateBinding> getTemplateBindings() {
		return templateBindings;
	}

	/**
	 * Sets the {@link TemplateBinding} of the element
	 * 
	 * @param templateBinding the {@link TemplateBinding}
	 */
	public void setTemplateBindings(ArrayList<TemplateBinding> templateBindings) {
		this.templateBindings = templateBindings;
	}
	
	/**
	 * Gets the {@link OwnedTemplateSignature} of the element
	 * 
	 * @return the {@link OwnedTemplateSignature} of the element
	 */
	@XmlElement(name = "ownedTemplateSignature")
	public OwnedTemplateSignature getOwnedTemplateSignature() {
		return ownedTemplateSignature;
	}
	
	/**
	 * Sets the {@link OwnedTemplateSignature} of the element
	 * 
	 * @param ownedTemplateSignature the {@link OwnedTemplateSignature} of the element
	 */
	public void setOwnedTemplateSignature(OwnedTemplateSignature ownedTemplateSignature) {
		this.ownedTemplateSignature = ownedTemplateSignature;
	}
	
	/**
	 * Gets the {@link Generalization} of the element
	 * 
	 * @return the {@link Generalization} of the element
	 */
	@XmlElement(name = "generalization")
	public Generalization getGeneralization() {
		return generalization;
	}
	
	/**
	 * Sets the {@link Generalization} of the element
	 * 
	 * @param generalization the {@link Generalization} of the element
	 */
	public void setGeneralization(Generalization generalization) {
		this.generalization = generalization;
	}
	
	/**
	 * Gets the {@link InterfaceRealization}s of the element
	 * 
	 * @return the {@link InterfaceRealization}s of the element
	 */
	@XmlElement(name = "interfaceRealization")
	public ArrayList<InterfaceRealization> getInterfaceRealizations() {
		return interfaceRealizations;
	}
	
	/**
	 * Sets the {@link InterfaceRealization}s of the element
	 * 
	 * @param interfaceRealization the {@link InterfaceRealization}s of the element
	 */
	public void setInterfaceRealizations(ArrayList<InterfaceRealization> interfaceRealizations) {
		this.interfaceRealizations = interfaceRealizations;
	}
	
	/**
	 * Gets the {@link Client} of the element if it describes an association
	 * 
	 * @return the {@link Client} of the element
	 */
	@XmlElement(name = "client")
	public Client getClient() {
		return client;
	}
	
	/**
	 * Sets the {@link Client} of the element if it describes an association
	 * 
	 * @param client the {@link Client} of the element
	 */
	public void setClient(Client client) {
		this.client = client;
	}
	
	/**
	 * Gets the {@link Supplier} of the element if it describes an association
	 * 
	 * @return the {@link Supplier} of the element
	 */
	@XmlElement(name = "supplier")
	public Supplier getSupplier() {
		return supplier;
	}
	
	/**
	 * Sets the {@link Supplier} of the element if it describes an association
	 * 
	 * @param supplier the {@link Supplier} of the element
	 */
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	/**
	 * Gets the list of {@link MemberEnd}s of the element if it describes an association
	 * 
	 * @return the list {@link MemberEnd}s of the element
	 */
	@XmlElement(name = "memberEnd")
	public ArrayList<MemberEnd> getMemberEnds() {
		return memberEnds;
	}
	
	/**
	 * Sets the list of {@link MemberEnd}s of the element if it describes an association
	 * 
	 * @param memberEnds the list {@link MemberEnd}s of the element
	 */
	public void setMemberEnds(ArrayList<MemberEnd> memberEnds) {
		this.memberEnds = memberEnds;
	}
	
	/**
	 * Gets the {@link OwnedEnd} of the element if it describes an association
	 * 
	 * @return the {@link OwnedEnd} of the element
	 */
	@XmlElement(name = "ownedEnd")
	public OwnedEnd getOwnedEnd() {
		return ownedEnd;
	}
	
	/**
	 * Sets the {@link OwnedEnd} of the element if it describes an association
	 * 
	 * @param ownedEnd the {@link OwnedEnd} of the element
	 */
	public void setOwnedEnd(OwnedEnd ownedEnd) {
		this.ownedEnd = ownedEnd;
	}
	
	/**
	 * Gets the list of {@link PackagedElement}s representing inner elements of the element
	 * 
	 * @return the list of {@link PackagedElement}s representing inner elements
	 */
	@XmlElement(name = "nestedClassifier")
	public ArrayList<PackagedElement> getNestedClassifiers() {
		return nestedClassifiers;
	}
	
	/**
	 * Sets the list of {@link PackagedElement}s representing inner elements of the element
	 * 
	 * @param nestedClassifiers the list of {@link PackagedElement}s representing inner elements
	 */
	public void setNestedClassifiers(ArrayList<PackagedElement> nestedClassifiers) {
		this.nestedClassifiers = nestedClassifiers;
	}
}
