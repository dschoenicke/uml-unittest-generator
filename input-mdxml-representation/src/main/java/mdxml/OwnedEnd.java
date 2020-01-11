package mdxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Describes the owned end of an association
 * 
 * @author dschoenicke
 *
 */
@Data
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class OwnedEnd {

	/**
	 * Id of the ownedEnd
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	private String id;
	
	/**
	 * Type of the end, e.g. property or method parameter
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "type")
	private String endType;
	
	/**
	 * The reference to the owned end. Could be the id of an {@link OwnedAttribute} or {@link OwnedParameter}
	 */
	@XmlAttribute(name = "type")
	private String associationType;
	
	/**
	 * The visibility of the owned end
	 */
	@XmlAttribute(name = "visibility")
	private String visibility;
	
	/**
	 * Id of the {@link PackagedElement} which represents the association which holds this ownedEnd
	 */
	@XmlAttribute(name = "association")
	private String association;
}
