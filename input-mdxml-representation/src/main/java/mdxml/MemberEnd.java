package mdxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * References the end of an association with the id of the corresponding {@link PackagedElement}
 * 
 * @author dschoenicke
 *
 */
@Data
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class MemberEnd {

	/**
	 * The id of the {@link PackagedElement} which acts as the association end
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "idref")
	private String idref;
}
