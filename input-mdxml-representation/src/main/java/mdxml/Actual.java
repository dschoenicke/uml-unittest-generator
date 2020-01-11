package mdxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Auxiliary class representing the type replacing a {@link Parameter} in a {@link ParameterSubstitution} if the replacing type is a primitive type
 * 
 * @author dschoenicke
 *
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
public class Actual {

	/**
	 * The {@link Extension} holding the {@link ReferenceExtension} which determines the data type
	 */
	@XmlElement(namespace = "http://www.omg.org/spec/XMI/20131001", name = "Extension")
	private Extension extension;
}
