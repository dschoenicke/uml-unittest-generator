package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class DiagramRepresentationObject {

	private String type;
	private DiagramContents diagramContents;
	
	public DiagramRepresentationObject() {}
	
	@XmlAttribute(name = "type")
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	@XmlElement(name = "diagramContents") 
	public DiagramContents getDiagramContents() {
		return diagramContents;
	}
	
	public void setDiagramContents(DiagramContents diagramContents) {
		this.diagramContents = diagramContents;
	}
}
