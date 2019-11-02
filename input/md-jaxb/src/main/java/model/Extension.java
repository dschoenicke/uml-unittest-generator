package model;

import javax.xml.bind.annotation.XmlElement;

/**
 * Represents an auxiliary node in the XML tree to extend the Magic Draw specification
 * Used to hold a {@link DiagramRepresentation} or a {@link ModelExtension}
 * 
 * @author dschoenicke
 *
 */
public class Extension {
	
	/**
	 * A {@link ModelExtension} which is an auxiliary class to hold values or {@link OwnedDiagram}s
	 */
	private ModelExtension modelExtension;
	
	/**
	 * Represents a diagram
	 */
	private DiagramRepresentation diagramRepresentation;
	
	/**
	 * Default constructor
	 */
	public Extension() {}
	
	/**
	 * Gets the {@link ModelExtension}
	 * 
	 * @return the {@link ModelExtension}
	 */
	@XmlElement(name = "modelExtension")
	public ModelExtension getModelExtension() {
		return modelExtension;
	}
	
	/**
	 * Sets the {@link ModelExtension}
	 * 
	 * @param modelExtension the {@link ModelExtension}
	 */
	public void setModelExtension(ModelExtension modelExtension) {
		this.modelExtension = modelExtension;
	}
	
	/**
	 * Gets the {@link DiagramRepresentation}
	 * 
	 * @return the {@link DiagramRepresentation}
	 */
	@XmlElement(name = "diagramRepresentation")
	public DiagramRepresentation getDiagramRepresentation() {
		return diagramRepresentation;
	}
	
	/**
	 * Sets the {@link DiagramRepresentation}
	 * 
	 * @param diagramRepresentation the {@link DiagramRepresentation}
	 */
	public void setDiagramRepresentation(DiagramRepresentation diagramRepresentation) {
		this.diagramRepresentation = diagramRepresentation;
	}
}
