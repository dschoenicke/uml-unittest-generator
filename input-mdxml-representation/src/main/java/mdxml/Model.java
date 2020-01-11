package mdxml;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a model in the given Magic Draw project
 * 
 * @author dschoenicke
 *
 */
@Data
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Model {

	/**
	 * The id of the model
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	private String id;
	
	/**
	 * The name of the model
	 */
	@XmlAttribute
	private String name;
	
	/**
	 * The list of all {@link PackagedElement}s which occur in the model
	 */
	@XmlElement(name = "packagedElement")
	private ArrayList<PackagedElement> packagedElements;
}
