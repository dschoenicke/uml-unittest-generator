package mdxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class representing the root node of the xml file
 * 
 * @author dschoenicke
 *
 */
@Data
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace = "http://www.omg.org/spec/XMI/20131001", name = "XMI")
public class Xmi {
	
	/**
	 * The {@link Model} of the Magic Draw project
	 */
	@XmlElement(namespace = "http://www.omg.org/spec/UML/20131001", name = "Model")
	private Model model;
}