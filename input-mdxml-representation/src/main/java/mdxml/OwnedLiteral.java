package mdxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents enumeration literals held by a {@link PackagedElement} representing the enumeration
 * 
 * @author dschoenicke
 *
 */
@Data
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class OwnedLiteral {

	/**
	 * The id of the literal
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	private String id;
	
	/**
	 * The name of the literal
	 */
	@XmlAttribute
	private String name;
}
