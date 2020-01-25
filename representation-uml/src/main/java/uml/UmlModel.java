package uml;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

/**
 * Represents the UML model with its {@link UmlPackage}s, {@link UmlElement}s and {@link UmlRelationship}s
 * 
 * @author dschoenicke
 *
 */
@Getter
public class UmlModel implements UmlParent {
	/**
	 * Name of the model
	 */
	private String name;
	
	/**
	 * List of {@link UmlPackage}s
	 */
	private List<UmlPackage> packages;
	
	/**
	 * List of {@link UmlElement}s
	 */
	private List<UmlElement> elements;
	
	/**
	 * List of {@link UmlRelationship}s
	 */
	private List<UmlRelationship> relationships;
	
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
	 * Adds a {@link UmlPackage} to the list
	 * 
	 * @param umlPackage the {@link UmlPackage} to add to the list
	 */
	public void addPackage(UmlPackage umlPackage) {
		packages.add(umlPackage);
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
	 * Adds a {@link UmlRelationship} to the list
	 * 
	 * @param relationship the {@link UmlRelationship} to add to the list
	 */
	public void addRelationship(UmlRelationship relationship) {
		relationships.add(relationship);
	}
}
