package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://www.omg.org/spec/XMI/20131001", name = "XMI")
public class Xmi {
	
	private Model model;
	
	public Xmi() {}
	
	@XmlElement(namespace = "http://www.omg.org/spec/UML/20131001", name = "Model")
	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
}