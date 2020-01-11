package mdxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an auxiliary node in the XML tree held by an {@link Extension}
 * Holds {@link LowerValue}s and {@link UpperValue}s when used by an {@link OwnedAttribute}
 * 
 * @author dschoenicke
 *
 */
@Data
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class ModelExtension {
	
	/**
	 * The {@link LowerValue} of the {@link OwnedAttribute} which uses the {@link Extension} which holds this model extension
	 */
	@XmlElement(name = "lowerValue")
	private LowerValue lowerValue;
	
	/**
	 * The {@link UpperValue} of the {@link OwnedAttribute} which uses the {@link Extension} which holds this model extension
	 */
	@XmlElement(name = "upperValue")
	private UpperValue upperValue;
}
