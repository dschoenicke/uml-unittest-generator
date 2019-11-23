package uml;

import java.util.ArrayList;

import core.representation.Node;

/**
 * Represents the UML model with its {@link UmlPackage}s, {@link UmlElement}s and {@link UmlRelationship}s
 * 
 * @author dschoenicke
 *
 */
public class UmlModel implements Node {
	/**
	 * Name of the model
	 */
	private String name;
	
	/**
	 * List of {@link UmlPackage}s
	 */
	private ArrayList<UmlPackage> packages;
	
	/**
	 * List of {@link UmlElement}s
	 */
	private ArrayList<UmlElement> elements;
	
	/**
	 * List of {@link UmlRelationship}s
	 */
	private ArrayList<UmlRelationship> relationships;
	
	/**
	 * Constructor with name, initializes the lists of {@link UmlPackage}s, {@link UmlElement}s and {@link UmlRelationship}s
	 * 
	 * @param name the name of the model
	 */
	public UmlModel(String name) {
		this.name = name;
		packages = new ArrayList<>();
		elements = new ArrayList<>();
		relationships = new ArrayList<>();
	}
	
	/**
	 * Gets the name of the model
	 * 
	 * @return the name of the model
	 */
	public String getName() {
		return name;
	}
	
	/** 
	 * Sets the name of the model
	 * 
	 * @param name the name of the model
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the list of {@link UmlPackage}s
	 * 
	 * @return the list of {@link UmlPackage}s
	 */
	public ArrayList<UmlPackage> getPackages() {
		return packages;
	}
	
	/**
	 * Adds a {@link UmlPackage} to the list
	 * 
	 * @param umlPackage the {@link UmlPackage} to add to the list
	 */
	public void addPackage(UmlPackage umlPackage) {
		packages.add(umlPackage);
	}
	
	/**
	 * Gets the list of {@link UmlElement}s
	 * 
	 * @return the list of {@link UmlElement}s
	 */
	public ArrayList<UmlElement> getElements() {
		return elements;
	}
	
	/**
	 * Adds a {@link UmlElement} to the list
	 * 
	 * @param element the {@link UmlElement} to add to the list
	 */
	public void addElement(UmlElement element) {
		elements.add(element);
	}
	
	/**
	 * Gets the list of {@link UmlRelationship}s
	 * 
	 * @return the list of {@link UmlRelationship}s
	 */
	public ArrayList<UmlRelationship> getRelationships() {
		return relationships;
	}
	
	/**
	 * Adds a {@link UmlRelationship} to the list
	 * 
	 * @param relationship the {@link UmlRelationship} to add to the list
	 */
	public void addRelationship(UmlRelationship relationship) {
		relationships.add(relationship);
	}
}
