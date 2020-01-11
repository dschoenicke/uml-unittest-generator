package mdxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents the lower value of an {@link OwnedParameter} or an {@link OwnedAttribute}
 * 
 * @author dschoenicke
 *
 */
@Data
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class LowerValue {

	/**
	 * The id of the value
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	private String id;
	
	/**
	 * The lower value (0, 1 or *)
	 */
	@XmlAttribute(name = "value")
	private String value;
	
	/**
	 * The type of the value
	 */
	@XmlAttribute(namespace = "http://omg.org/spec/XMI/20131001", name = "type")
	private String type;
}
