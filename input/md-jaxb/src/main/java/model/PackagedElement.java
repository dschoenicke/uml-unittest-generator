package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class PackagedElement {

	private String id;
	private String name;
	private String visibility;
	private String type;
	private String isStatic;
	private String isAbstract;
	private String isFinal;
	private ArrayList<OwnedAttribute> ownedAttributes;
	private ArrayList<OwnedOperation> ownedOperations;
	private ArrayList<OwnedLiteral> ownedLiterals;
	private ArrayList<PackagedElement> packagedElements;
	private ArrayList<TemplateBinding> templateBindings;
	private OwnedTemplateSignature ownedTemplateSignature;
	private Generalization generalization;
	private InterfaceRealization interfaceRealization;
	private Client client;
	private Supplier supplier;
	private ArrayList<MemberEnd> memberEnds;
	private OwnedEnd ownedEnd;
	private ArrayList<PackagedElement> nestedClassifiers;
 	
	public PackagedElement() {
		ownedAttributes = new ArrayList<OwnedAttribute>();
		ownedOperations = new ArrayList<OwnedOperation>();
		ownedLiterals = new ArrayList<OwnedLiteral>();
		packagedElements = new ArrayList<PackagedElement>();
		templateBindings = new ArrayList<TemplateBinding>();
		nestedClassifiers = new ArrayList<PackagedElement>();
	}
	
	@XmlElement(name = "ownedAttribute")
	public ArrayList<OwnedAttribute> getOwnedAttributes() {
		return ownedAttributes;
	}
	
	public void setOwnedAttributes(ArrayList<OwnedAttribute> attributes) {
		this.ownedAttributes = attributes;
	}
	
	@XmlElement(name = "ownedOperation") 
	public ArrayList<OwnedOperation> getOwnedOperations() {
		return ownedOperations;
	}
	
	public void setOwnedOperations(ArrayList<OwnedOperation> operations) {
		this.ownedOperations = operations;
	}
	
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	@XmlAttribute
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlAttribute
	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "type")
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	@XmlAttribute(name = "isStatic")
	public String getIsStatic() {
		return isStatic;
	}
	
	public void setIsStatic(String isStatic) {
		this.isStatic = isStatic;
	}
	
	@XmlAttribute(name = "isAbstract")
	public String getIsAbstract() {
		return isAbstract;
	}
	
	public void setIsAbstract(String isAbstract) {
		this.isAbstract = isAbstract;
	}
	
	@XmlAttribute(name = "isFinal")
	public String getIsFinal() {
		return isFinal;
	}
	
	public void setIsFinal(String isFinal) {
		this.isFinal = isFinal;
	}
	
	@XmlElement(name = "ownedLiteral")
	public ArrayList<OwnedLiteral> getOwnedLiterals() {
		return ownedLiterals;
	}
	
	public void setOwnedLiterals(ArrayList<OwnedLiteral> ownedLiterals) {
		this.ownedLiterals = ownedLiterals;
	}
	
	@XmlElement(name = "packagedElement")
	public ArrayList<PackagedElement> getPackagedElements() {
		return packagedElements;
	}
	
	public void setPackagedElements(ArrayList<PackagedElement> packagedElements) {
		this.packagedElements = packagedElements;
	}
	
	@XmlElement(name = "templateBinding")
	public ArrayList<TemplateBinding> getTemplateBindings() {
		return templateBindings;
	}
	
	public void setTemplateBindings(ArrayList<TemplateBinding> templateBindings) {
		this.templateBindings = templateBindings;
	}
	
	@XmlElement(name = "ownedTemplateSignature")
	public OwnedTemplateSignature getOwnedTemplateSignature() {
		return ownedTemplateSignature;
	}
	
	public void setOwnedTemplateSignature(OwnedTemplateSignature ownedTemplateSignature) {
		this.ownedTemplateSignature = ownedTemplateSignature;
	}
	
	@XmlElement(name = "generalization")
	public Generalization getGeneralization() {
		return generalization;
	}
	
	public void setGeneralization(Generalization generalization) {
		this.generalization = generalization;
	}
	
	@XmlElement(name = "interfaceRealization")
	public InterfaceRealization getInterfaceRealization() {
		return interfaceRealization;
	}
	
	public void setInterfaceRealization(InterfaceRealization interfaceRealization) {
		this.interfaceRealization = interfaceRealization;
	}
	
	@XmlElement(name = "client")
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	@XmlElement(name = "supplier")
	public Supplier getSupplier() {
		return supplier;
	}
	
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	@XmlElement(name = "memberEnd")
	public ArrayList<MemberEnd> getMemberEnds() {
		return memberEnds;
	}
	
	public void setMemberEnds(ArrayList<MemberEnd> memberEnds) {
		this.memberEnds = memberEnds;
	}
	
	@XmlElement(name = "ownedEnd")
	public OwnedEnd getOwnedEnd() {
		return ownedEnd;
	}
	
	public void setOwnedEnd(OwnedEnd ownedEnd) {
		this.ownedEnd = ownedEnd;
	}
	
	@XmlElement(name = "nestedClassifier")
	public ArrayList<PackagedElement> getNestedClassifiers() {
		return nestedClassifiers;
	}
	
	public void setNestedClassifiers(ArrayList<PackagedElement> nestedClassifiers) {
		this.nestedClassifiers = nestedClassifiers;
	}
}
