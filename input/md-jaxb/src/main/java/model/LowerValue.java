package model;

import javax.xml.bind.annotation.XmlAttribute;

public class LowerValue {

	private String id;
	private String value;
	
	public LowerValue() {}
	
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	@XmlAttribute(name = "value")
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
}
