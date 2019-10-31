package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class OwnedDiagram {

	private String id;
	private String name;
	private Extension extension;
	
	public OwnedDiagram() {}
	
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	@XmlAttribute(name = "name")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement(namespace = "http://www.omg.org/spec/XMI/20131001", name = "Extension")
	public Extension getExtension() {
		return extension;
	}
	
	public void setExtension(Extension extension) {
		this.extension = extension;
	}
}
