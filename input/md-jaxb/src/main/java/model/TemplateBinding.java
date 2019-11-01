package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class TemplateBinding {

	private String id;
	private String signature;
	private ParameterSubstitution parameterSubstitution;
	
	TemplateBinding() {}

	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlAttribute(name = "signature")
	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	@XmlElement(name = "parameterSubstitution")
	public ParameterSubstitution getParameterSubstitution() {
		return parameterSubstitution;
	}

	public void setParameterSubstitution(ParameterSubstitution parameterSubstitution) {
		this.parameterSubstitution = parameterSubstitution;
	}
}
