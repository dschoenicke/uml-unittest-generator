package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

/**
 * Represents a list of ids of {@link PackagedElement}s which are used in each diagram.
 * 
 * @author dschoenicke
 *
 */
public class DiagramContents {

	/**
	 * List of ids which reference {@link PackagedElement}s used in the diagram
	 */
	private ArrayList<String> usedElements;
	
	/**
	 * Default constructor
	 */
	public DiagramContents() {}
	
	/**
	 * Gets the list of ids
	 * 
	 * @return the list of ids
	 */
	@XmlElement(name = "usedElements")
	public ArrayList<String> getUsedElements() {
		return usedElements;
	}
	
	/**
	 * Sets the list of ids
	 * 
	 * @param usedElements the list of ids
	 */
	public void setUsedElements(ArrayList<String> usedElements) {
		this.usedElements = usedElements;
	}
}
