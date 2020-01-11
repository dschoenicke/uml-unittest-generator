package mdxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Determines the data type of a primitive type by holding a reference to its specification
 * 
 * @author dschoenicke
 *
 */
@Data
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class ReferenceExtension {

	/**
	 * Reference to the primitive type
	 */
	@XmlAttribute(name = "referentPath")
	private String referentPath;
}
