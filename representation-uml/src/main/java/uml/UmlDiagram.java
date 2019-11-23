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
	 * The list of {@link UmlRelationship}s of the diagram
	 */
	private ArrayList<UmlRelationship> relationships;
	
	/**
	 * The list of {@link UmlPackage}s
	 */
	private ArrayList<UmlPackage> packages;
	
	/**
	 * Constructor with the name of the diagram, initializes the lists of elements, packages and relationships
	 * 
	 * @param name the name of the diagram
	 */
	public UmlDiagram(String name) {
		this.name = name;
		elements = new ArrayList<UmlElement>();
		relationships = new ArrayList<UmlRelationship>();
		packages = new ArrayList<UmlPackage>();
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
	 * Gets the list of the diagram's {@link UmlRelationship}s
	 * 
	 * @return the list of {@link UmlRelationship}s
	 */
	public ArrayList<UmlRelationship> getRelationships() {
		return relationships;
	}
	
	/**
	 * Adds an {@link UmlRelationship} to the list
	 * 
	 * @param relationship the {@link UmlRelationship} to add to the list
	 */
	public void addRelationship(UmlRelationship relationship) {
		relationships.add(relationship);
	}
	
	/**
	 * Gets the list of the diagram's {@link UmlPackage}s
	 * 
	 * @return the list of {@link UmlPackage}s
	 */
	public ArrayList<UmlPackage> getPackages() {
		return packages;
	}
	
	/**
	 * Adds an {@link UmlPackage} to the list
	 * 
	 * @param umlPackage the {@link UmlPackage} to add to the list
	 */
	public void addPackage(UmlPackage umlPackage) {
		packages.add(umlPackage);
	}
 }
