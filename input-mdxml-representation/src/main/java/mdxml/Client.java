package mdxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents the client class of an {@link InterfaceRealization} or Association.
 * Associations are represented as {@link PackagedElement}.
 * 
 * @author dschoenicke
 *
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
public class Client {

	/**
	 * References the {@link PackagedElement} which acts as a client by its id
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "idref")
	private String idref;
}
