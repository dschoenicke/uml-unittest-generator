package model;

import javax.xml.bind.annotation.XmlAttribute;

public class Supplier {

	private String id;
	
	public Supplier() {}
	
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "idref")
	public String getId() {
		return id;
	}
}
