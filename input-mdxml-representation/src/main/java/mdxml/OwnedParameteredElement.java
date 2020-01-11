package mdxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Describes an element which is parametered by an {@link OwnedParameter}
 * 
 * @author dschoenicke
 *
 */
@Data
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class OwnedParameteredElement {

	/**
	 * The id of the OwnedParameteredElement
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	private String id;
	
	/**
	 * The name of the element
	 */
	@XmlAttribute(name = "name")
	private String name;
	
	/**
	 * The id of the {@link OwnedParameter} which parameters this element
	 */
	@XmlAttribute(name = "templateParameter")
	private String templateParameter;
}
