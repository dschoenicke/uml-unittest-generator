package model;

import javax.xml.bind.annotation.XmlAttribute;

public class OwnedLiteral {

	private String id;
	private String name;
	
	public OwnedLiteral() {}

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
}
