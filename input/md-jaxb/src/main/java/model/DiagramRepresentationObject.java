package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Object to represent a diagram and holds the {@link DiagramContents} of the diagram.
 * 
 * @author dschoenicke
 *
 */
public class DiagramRepresentationObject {

	/**
	 * Determines the type of the diagram, e.g. whether it is a class diagram
	 */
	private String type;
	/**
	 * Object which holds the list of the used {@link PackagedElement}s in the diagram
	 */
	private DiagramContents diagramContents;
	
	/**
	 * Default constructor
	 */
	public DiagramRepresentationObject() {}
	
	/**
	 * Gets the type of the diagram
	 * 
	 * @return the type of the diagram
	 */
	@XmlAttribute(name = "type")
	public String getType() {
		return type;
	}
	
	/**
	 * Sets the type of the diagram
	 * 
	 * @param type the type of the diagram
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Gets the {@link DiagramContents} object
	 * 
	 * @return the {@link DiagramContents} object
	 */
	@XmlElement(name = "diagramContents") 
	public DiagramContents getDiagramContents() {
		return diagramContents;
	}
	
	/**
	 * Sets the {@link DiagramContents} object
	 * 
	 * @param diagramContents the {@link DiagramContents} object
	 */
	public void setDiagramContents(DiagramContents diagramContents) {
		this.diagramContents = diagramContents;
	}
}
