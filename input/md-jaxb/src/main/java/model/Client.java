package model;

import javax.xml.bind.annotation.XmlAttribute;

public class Client {

	private String id;
	
	public Client() {}
	
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "idref")
	public String getId() {
		return id;
	}
}
