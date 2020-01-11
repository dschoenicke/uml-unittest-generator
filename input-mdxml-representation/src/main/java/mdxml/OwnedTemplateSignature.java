package mdxml;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a template signature of a {@link PackagedElement} which represents a class or an interface
 * 
 * @author dschoenicke
 *
 */
@Data
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class OwnedTemplateSignature {

	/**
	 * The id of the template signature
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	private String id;
	
	/**
	 * A list of {@link Parameter}s which reference the actual {@link OwnedParameter}s
	 */
	@XmlElement(name = "parameter")
	private ArrayList<Parameter> parameters;
	
	/**
	 * A list of {@link OwnedParameter}s of the template signature
	 */
	@XmlElement(name = "ownedParameter")
	private ArrayList<OwnedParameter> ownedParameters;
}
