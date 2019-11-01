package model;

import javax.xml.bind.annotation.XmlAttribute;

public class OwnedParameteredElement {

	private String id;
	private String name;
	private String templateParameter;
	
	public OwnedParameteredElement() {}

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

	@XmlAttribute(name = "templateParameter")
	public String getTemplateParameter() {
		return templateParameter;
	}

	public void setTemplateParameter(String templateParameter) {
		this.templateParameter = templateParameter;
	}
}
