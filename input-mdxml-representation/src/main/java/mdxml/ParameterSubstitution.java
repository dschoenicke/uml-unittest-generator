package mdxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a substitution of a template {@link Parameter}
 * 
 * @author dschoenicke
 *
 */
@Data
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class ParameterSubstitution {
	
	/**
	 * The id of the substitution
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	private String id;
	
	/**
	 * References the {@link Parameter} used in this substitution by its id
	 */
	@XmlAttribute(name = "formal")
	private String formal;
	
	/**
	 * References the {@link PackagedElement} which replaces the {@link Parameter} by its id
	 */
	@XmlAttribute(name = "actual")
	private String actual;
	
	/**
	 * Reference to the type replacing the {@link Parameter} if it is a primitive type
	 */
	@XmlElement(name = "actual")
	private Actual primitiveActual;
}
