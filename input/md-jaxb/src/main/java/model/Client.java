package model;

import javax.xml.bind.annotation.XmlAttribute;

public class Client {

	private String idref;
	
	public Client() {}
	
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "idref")
	public String getIdref() {
		return idref;
	}
	
	public void setIdref(String idref) {
		this.idref = idref;
	}
}
