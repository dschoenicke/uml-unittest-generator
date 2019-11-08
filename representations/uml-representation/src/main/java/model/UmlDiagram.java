package model;

import java.util.ArrayList;

/**
 * Represents a class diagram of the {@link UmlModel}
 * 
 * @author dschoenicke
 *
 */
public class UmlDiagram {

	/**
	 * The name of the diagram
	 */
	private String name;
	
	/**
	 * The list of {@link UmlElement}s of the diagram
	 */
	private ArrayList<UmlElement> elements;
	
	/**
	 * The list of {@link UmlAssociation}s of the diagram
	 */
	private ArrayList<UmlAssociation> associations;
	
	/**
	 * Constructor with the name of the diagram, initializes the lists of elements and associations
	 * 
	 * @param name the name of the diagram
	 */
	public UmlDiagram(String name) {
		this.name = name;
		elements = new ArrayList<UmlElement>();
		associations = new ArrayList<UmlAssociation>();
	}
	
	/**
	 * Gets the name of the diagram
	 * 
	 * @return the name of the diagram
	 */
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
	 * Gets the list of the diagram's {@link UmlElement}s
	 * 
	 * @return the list of {@link UmlElement}s
	 */
	public ArrayList<UmlElement> getElements() {
		return elements;
	}
	
	/**
	 * Adds an {@link UmlElement} to the list
	 * 
	 * @param element the {@link UmlElement} to add to the list
	 */
	public void addElement(UmlElement element) {
		elements.add(element);
	}
	
	/**
	 * Gets the list of the diagram's {@link UmlAssociation}s
	 * 
	 * @return the list of {@link UmlAssociation}s
	 */
	public ArrayList<UmlAssociation> getAssociations() {
		return associations;
	}
	
	/**
	 * Adds an {@link UmlAssociation} to the list
	 * 
	 * @param association the {@link UmlAssociation} to add to the list
	 */
	public void addAssociation(UmlAssociation association) {
		associations.add(association);
	}
 }
