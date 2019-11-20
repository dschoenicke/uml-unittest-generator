package model;

import java.util.ArrayList;

/**
 * Represents a package in an {@link UmlDiagram}
 * 
 * @author dschoenicke
 *
 */
public class UmlPackage {

	/**
	 * The name of the package
	 */
	private String name;
	
	/**
	 * A list of {@link UmlElement}s of the package
	 */
	private ArrayList<UmlElement> elements;
	
	/**
	 * A list of {@link UmlAssociation}s of the package
	 */
	private ArrayList<UmlAssociation> associations;
	
	/**
	 * A list of {@link UmlPackage}s of the package
	 */
	private ArrayList<UmlPackage> packages;
	
	/**
	 * Constructor with name, initializes the list of {@link UmlElement}s, {@link UmlPackage}s and {@link UmlAssociation}s
	 * 
	 * @param name the name of the package
	 */
	public UmlPackage(String name) {
		this.name = name;
		elements = new ArrayList<>();
		associations = new ArrayList<>();
		packages = new ArrayList<>();
	}
	
	/**
	 * Gets the name of the package
	 * 
	 * @return the name of the package
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the package
	 * 
	 * @param name the name of the package
	 */
	public void setName(String name) {
		this.name = name;
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
	 * Adds an {@link UmlElement} to the list
	 * 
	 * @param element the {@link UmlElement} to add
	 */
	public void addUmlElement(UmlElement element) {
		elements.add(element);
	}
	
	/**
	 * Gets the list of the package's {@link UmlAssociation}s
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
	
	/**
	 * Gets the list of the package's {@link UmlPackage}s
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
