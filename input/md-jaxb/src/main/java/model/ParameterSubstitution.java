package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class ParameterSubstitution {

	private String id;
	private String formal;
	private String actual;
	
	public ParameterSubstitution() {}

	@XmlElement(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlAttribute(name = "formal")
	public String getFormal() {
		return formal;
	}

	public void setFormal(String formal) {
		this.formal = formal;
	}

	@XmlAttribute(name = "actual")
	public String getActual() {
		return actual;
	}

	public void setActual(String actual) {
		this.actual = actual;
	}
}
