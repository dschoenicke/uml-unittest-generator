package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class OwnedOperation {
	
	private String id;
	private String name;
	private String visibility;
	private String isStatic;
	private String isAbstract;
	private String isFinal;
	private ArrayList<OwnedParameter> ownedParameters;
	private ArrayList<TemplateBinding> templateBindings;
	
	public OwnedOperation() {
		ownedParameters = new ArrayList<OwnedParameter>();
		templateBindings = new ArrayList<TemplateBinding>();
	}
	
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
	
	@XmlAttribute
	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
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
	
	@XmlElement(name = "ownedParameter")
	public ArrayList<OwnedParameter> getOwnedParameters() {
		return ownedParameters;
	}
	
	public void setOwnedParameters(ArrayList<OwnedParameter> ownedParameters) {
		this.ownedParameters = ownedParameters;
	}
	
	@XmlElement(name = "templateBinding")
	public ArrayList<TemplateBinding> getTemplateBinding() {
		return templateBindings;
	}
	
	public void setTemplateBindings(ArrayList<TemplateBinding> templateBindings) {
		this.templateBindings = templateBindings;
	}
}
