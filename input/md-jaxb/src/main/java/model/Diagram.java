package model;

import javax.xml.bind.annotation.XmlAttribute;

public class Diagram {

	private String name;
	
	public Diagram() {}
	
	@XmlAttribute
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Diagram: " + name;
	}
}
