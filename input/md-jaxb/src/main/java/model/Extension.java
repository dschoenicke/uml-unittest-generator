package model;

import javax.xml.bind.annotation.XmlElement;

public class Extension {
	
	private ModelExtension modelExtension;
	private DiagramRepresentation diagramRepresentation;
	
	public Extension() {}
	
	@XmlElement(name = "modelExtension")
	public ModelExtension getModelExtension() {
		return modelExtension;
	}
	
	public void setModelExtension(ModelExtension modelExtension) {
		this.modelExtension = modelExtension;
	}
	
	@XmlElement(name = "diagramRepresentation")
	public DiagramRepresentation getDiagramRepresentation() {
		return diagramRepresentation;
	}
	
	public void setDiagramRepresentation(DiagramRepresentation diagramRepresentation) {
		this.diagramRepresentation = diagramRepresentation;
	}
}
