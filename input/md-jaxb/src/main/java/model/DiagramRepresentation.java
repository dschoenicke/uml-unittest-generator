package model;

import javax.xml.bind.annotation.XmlElement;

/**
 * Describes the representation of a diagram by a {@link DiagramRepresentationObject}.
 * 
 * @author dschoenicke
 *
 */
public class DiagramRepresentation {

	/**
	 * The {@link DiagramRepresentationObject} which describes the diagram's content and type
	 */
	private DiagramRepresentationObject diagramRepresentationObject;
	
	/**
	 * Default constructor
	 */
	public DiagramRepresentation() {}
	
	/**
	 * Gets the {@link DiagramRepresentationObject}
	 * 
	 * @return the diagram's {@link DiagramRepresentationObject}
	 */
	@XmlElement(namespace = "http://www.nomagic.com/ns/magicdraw/core/diagram/1.0", name = "DiagramRepresentationObject")
	public DiagramRepresentationObject getDiagramRepresentationObject() {
		return diagramRepresentationObject;
	}
	
	/**
	 * Sets the {@link DiagramRepresentationObject}
	 * 
	 * @param diagramRepresentationObject the diagram's {@link DiagramRepresentationObject}
	 */
	public void setDiagramRepresentationObject(DiagramRepresentationObject diagramRepresentationObject) {
		this.diagramRepresentationObject = diagramRepresentationObject;
	}
}
