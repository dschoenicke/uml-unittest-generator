package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Describes a diagram which is further specified by a {@link DiagramRepresentation}, {@link DiagramRepresentationObject}
 * and {@link DiagramContents} which are held by an {@link Extension}
 * 
 * @author dschoenicke
 *
 */
public class OwnedDiagram {

	/**
	 * The id of the diagram,
	 */
	private String id;
	
	/**
	 * The name of the diagram
	 */
	private String name;
	
	/**
	 * The {@link Extension} which holds the {@link DiagramRepresentation}
	 */
	private Extension extension;
	
	/**
	 * Default constructor
	 */
	public OwnedDiagram() {}
	
	/**
	 * Gets the id of the diagram
	 * 
	 * @return the id of the diagram
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	public String getId() {
		return id;
	}
	
	/**
	 * Sets the id of the diagram
	 * 
	 * @param id the id of the diagram
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Gets the name of the diagram
	 * 
	 * @return the name of the diagram
	 */
	@XmlAttribute(name = "name")
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the diagram
	 * 
	 * @param name the name of the diagram
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the {@link Extension} which holds further specifications of the diagram
	 * 
	 * @return the {@link Extension}
	 */
	@XmlElement(namespace = "http://www.omg.org/spec/XMI/20131001", name = "Extension")
	public Extension getExtension() {
		return extension;
	}
	
	/**
	 * Sets the {@link Extension} which holds further specifications of the diagram
	 * 
	 * @param extension the {@link Extension}
	 */
	public void setExtension(Extension extension) {
		this.extension = extension;
	}
}
