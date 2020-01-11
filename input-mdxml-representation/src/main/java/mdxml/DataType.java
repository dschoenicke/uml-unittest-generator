package mdxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a primitive data type which is described by a reference to its specification.
 * 
 * @author dschoenicke
 *
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
public class DataType {

	/**
	 * {@link Extension} holding a reference to the specification of the datatype
	 */
	@XmlElement(namespace = "http://www.omg.org/spec/XMI/20131001", name = "Extension")
	private Extension extension;
}
