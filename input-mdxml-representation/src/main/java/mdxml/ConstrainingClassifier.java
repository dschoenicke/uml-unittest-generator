package mdxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Describes a constraining classifier of an {@link OwnedParameter} in an {@link OwnedTemplateSignature}.
 * 
 * @author dschoenicke
 *
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
public class ConstrainingClassifier {

	/**
	 * References the {@link PackagedElement} which acts as the constraining classifier
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "idref")
	private String idref;
	
	/**
	 * The extension holding the {@link ReferenceExtension} if the constraining classifier is a primitive type
	 */
	@XmlElement(namespace = "http://www.omg.org/spec/XMI/20131001", name = "Extension")
	private Extension extension;
}
