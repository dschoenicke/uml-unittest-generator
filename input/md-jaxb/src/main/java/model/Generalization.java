package model;

import javax.xml.bind.annotation.XmlAttribute;

public class Generalization {

	private String id;
	private String general;

	public Generalization() {}
	
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlAttribute
	public String getGeneral() {
		return general;
	}

	public void setGeneral(String general) {
		this.general = general;
	}
}
