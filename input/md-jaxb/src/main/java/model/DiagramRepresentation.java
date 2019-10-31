package model;

import javax.xml.bind.annotation.XmlElement;

public class DiagramRepresentation {

	private DiagramRepresentationObject diagramRepresentationObject;
	
	public DiagramRepresentation() {}
	
	@XmlElement(namespace = "http://www.nomagic.com/ns/magicdraw/core/diagram/1.0", name = "DiagramRepresentationObject")
	public DiagramRepresentationObject getDiagramRepresentationObject() {
		return diagramRepresentationObject;
	}
	
	public void setDiagramRepresentationObject(DiagramRepresentationObject diagramRepresentationObject) {
		this.diagramRepresentationObject = diagramRepresentationObject;
	}
}
