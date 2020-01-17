package uml;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

/**
 * Represents a package in an {@link UmlModel}
 * 
 * @author dschoenicke
 *
 */
@Getter
public class UmlPackage implements UmlParent {

	/**
	 * The name of the package
	 */
	private String name;
	
	/**
	 * A list of {@link UmlElement}s of the package
	 */
	private List<UmlElement> elements;
	
	/**
	 * A list of {@link UmlRelationship}s of the package
	 */
	private List<UmlRelationship> relationships;
	
	/**
	 * A list of {@link UmlPackage}s of the package
	 */
	private List<UmlPackage> packages;
	
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
	 * Adds an {@link UmlElement} to the list
	 * 
	 * @param element the {@link UmlElement} to add
	 */
	public void addElement(UmlElement element) {
		elements.add(element);
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
	public List<UmlPackage> getPackagesAsList() {
		List<UmlPackage> ownedpackages = new ArrayList<>();
		
		for (UmlPackage umlPackage : this.getPackages()) {
			ownedpackages.add(umlPackage);
			ownedpackages.addAll(umlPackage.getPackagesAsList());
		}
		
		return ownedpackages;
	}
}
