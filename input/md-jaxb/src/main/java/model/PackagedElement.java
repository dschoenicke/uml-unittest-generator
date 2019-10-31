package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class PackagedElement {

	private String id;
	private String name;
	private String visibility;
	private String type;
	private ArrayList<OwnedAttribute> ownedAttributes;
	private ArrayList<OwnedOperation> ownedOperations;
	private ArrayList<OwnedLiteral> ownedLiterals;
	private ArrayList<PackagedElement> packagedElements;
 	
	public PackagedElement() {}
	
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
}
