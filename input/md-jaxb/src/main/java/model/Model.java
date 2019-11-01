package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Model {

	private String id;
	private String name;
	private ArrayList<PackagedElement> packagedElements;
	private Extension extension;
	
	public Model() {}
	
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
	
	@XmlElement(name = "packagedElement")
	public ArrayList<PackagedElement> getPackagedElements() {
		return packagedElements;
	}
	
	public void setPackagedElements(ArrayList<PackagedElement> packagedElements) {
		this.packagedElements = packagedElements;
	}
	
	@XmlElement(namespace = "http://www.omg.org/spec/XMI/20131001", name = "Extension")
	public Extension getExtension() {
		return extension;
	}
	
	public void setExtension(Extension extension) {
		this.extension = extension;
	}
}
