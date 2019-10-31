package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

public class DiagramContents {

	private ArrayList<String> usedElements;
	
	public DiagramContents() {}
	
	@XmlElement(name = "usedElements")
	public ArrayList<String> getUsedElements() {
		return usedElements;
	}
	
	public void setUsedElements(ArrayList<String> usedElements) {
		this.usedElements = usedElements;
	}
}
