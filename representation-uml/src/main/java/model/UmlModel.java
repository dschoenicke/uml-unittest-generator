package model;

import java.util.ArrayList;

/**
 * Represents the UML model with its {@link UmlDiagram}s
 * 
 * @author dschoenicke
 *
 */
public class UmlModel 
{
	/**
	 * Name of the moodel
	 */
	private String name;
	
	/**
	 * List of {@link UmlDiagram}s
	 */
	private ArrayList<UmlDiagram> diagrams;
	
	/**
	 * Constructor with name
	 * 
	 * @param name the name of the model
	 */
	public UmlModel(String name) {
		this.name = name;
		diagrams = new ArrayList<UmlDiagram>();
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
	 * Gets the list of {@link UmlDiagram}s
	 * 
	 * @return the list of {@link UmlDiagram}s
	 */
	public ArrayList<UmlDiagram> getDiagrams() {
		return diagrams;
	}
	
	/**
	 * Adds a {@link UmlDiagram} to the list
	 * 
	 * @param diagram the {@link UmlDiagram} to add to the list
	 */
	public void addDiagram(UmlDiagram diagram) {
		diagrams.add(diagram);
	}
}
