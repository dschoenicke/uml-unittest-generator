package mdxml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import core.representation.Node;

/**
 * Class representing the root node of the xml file
 * 
 * @author dschoenicke
 *
 */
@XmlRootElement(namespace = "http://www.omg.org/spec/XMI/20131001", name = "XMI")
public class Xmi implements Node {
	
	/**
	 * The {@link Model} of the Magic Draw project
	 */
	private Model model;
	
	/**
	 * Default constructor
	 */
	public Xmi() {}
	
	/**
	 * Gets the {@link Model} which represents the model of the Magic Draw project
	 * 
	 * @return the {@link Model}
	 */
	@XmlElement(namespace = "http://www.omg.org/spec/UML/20131001", name = "Model")
	public Model getModel() {
		return model;
	}

	/**
	 * Sets the {@link Model} which represents the model of the Magic Draw project
	 * 
	 * @param model the {@link Model}
	 */
	public void setModel(Model model) {
		this.model = model;
	}
}