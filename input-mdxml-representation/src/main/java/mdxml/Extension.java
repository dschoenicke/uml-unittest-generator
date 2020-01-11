package mdxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an auxiliary node in the XML tree to extend the Magic Draw specification
 * Used to hold a {@link ModelExtension} or a {@link ReferenceExtension}
 * 
 * @author dschoenicke
 *
 */
@Data
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Extension {
	
	/**
	 * A {@link ModelExtension} which is an auxiliary class to hold values
	 */
	@XmlElement(name = "modelExtension")
	private ModelExtension modelExtension;
	
	/**
	 * Determines the data type of a primitive type
	 */
	@XmlElement(name = "referenceExtension")
	private ReferenceExtension referenceExtension;
}
