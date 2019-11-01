package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class OwnedTemplateSignature {

	private String id;
	private ArrayList<Parameter> parameters;
	private ArrayList<OwnedParameter> ownedParameters;
	
	public OwnedTemplateSignature() {
		parameters = new ArrayList<Parameter>();
		ownedParameters = new ArrayList<OwnedParameter>();
	}

	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlElement(name = "parameter")
	public ArrayList<Parameter> getParameters() {
		return parameters;
	}

	public void setParameters(ArrayList<Parameter> parameters) {
		this.parameters = parameters;
	}

	@XmlElement(name = "ownedParameter")
	public ArrayList<OwnedParameter> getOwnedParameters() {
		return ownedParameters;
	}

	public void setOwnedParameters(ArrayList<OwnedParameter> ownedParameters) {
		this.ownedParameters = ownedParameters;
	}
}
