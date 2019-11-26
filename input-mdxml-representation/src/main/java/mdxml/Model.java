package mdxml;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Represents a model in the given Magic Draw project
 * 
 * @author dschoenicke
 *
 */
public class Model {

	/**
	 * The id of the model
	 */
	private String id;
	
	/**
	 * The name of the model
	 */
	private String name;
	
	/**
	 * The list of all {@link PackagedElement}s which occur in the model
	 */
	private ArrayList<PackagedElement> packagedElements;
	
	/**
	 * Default constructor
	 */
	public Model() {}
	
	/**
	 * Gets the id of the model
	 * 
	 * @return the id of the model
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	public String getId() {
		return id;
	}

	/**
	 * Sets the id of the model
	 * 
	 * @param id the id of the model
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the name of the model
	 * 
	 * @return the name of the model
	 */
	@XmlAttribute
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
	 * Gets the list of {@link PackagedElement}s
	 * 
	 * @return the list of {@link PackagedElement}s
	 */
	@XmlElement(name = "packagedElement")
	public ArrayList<PackagedElement> getPackagedElements() {
		return packagedElements;
	}
	
	/** Sets the list of {@link PackagedElement}s
	 * 
	 * @param packagedElements the list of {@link PackagedElement}s
	 */
	public void setPackagedElements(ArrayList<PackagedElement> packagedElements) {
		this.packagedElements = packagedElements;
	}
}
