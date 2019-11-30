package uml;

import java.util.ArrayList;

/**
 * Represents a package in an {@link UmlModel}
 * 
 * @author dschoenicke
 *
 */
public class UmlPackage implements UmlParent {

	/**
	 * The name of the package
	 */
	private String name;
	
	/**
	 * A list of {@link UmlElement}s of the package
	 */
	private ArrayList<UmlElement> elements;
	
	/**
	 * A list of {@link UmlRelationship}s of the package
	 */
	private ArrayList<UmlRelationship> relationships;
	
	/**
	 * A list of {@link UmlPackage}s of the package
	 */
	private ArrayList<UmlPackage> packages;
	
	/**
	 * Constructor with name, initializes the list of {@link UmlElement}s, {@link UmlPackage}s and {@link UmlRelationship}s
	 * 
	 * @param name the name of the package
	 */
	public UmlPackage(String name) {
		this.name = name;
		elements = new ArrayList<>();
		relationships = new ArrayList<>();
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
	public void addElement(UmlElement element) {
		elements.add(element);
	}
	
	/**
	 * Gets the list of the package's {@link UmlRelationship}s
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
	
	/**
	 * Returns a list of all sub {@link UmlPackage}s regardless of their hierarchy
	 * 
	 * @return a list of all sub {@link UmlPackage}s
	 */
	public ArrayList<UmlPackage> getPackagesAsList() {
		ArrayList<UmlPackage> ownedpackages = new ArrayList<UmlPackage>();
		
		for (UmlPackage umlPackage : this.getPackages()) {
			ownedpackages.add(umlPackage);
			ownedpackages.addAll(umlPackage.getPackagesAsList());
		}
		
		return ownedpackages;
	}
}
