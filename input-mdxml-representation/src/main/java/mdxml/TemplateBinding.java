package mdxml;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a template binding by an {@link OwnedOperation} or {@link PackagedElement}
 * 
 * @author dschoenicke
 *
 */
@Data
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class TemplateBinding {

	/**
	 * The id of the template binding
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	private String id;
	
	/**
	 * References the {@link OwnedTemplateSignature} used by this template binding
	 */
	@XmlAttribute(name = "signature")
	private String signature;
	
	/**
	 * The list of {@link ParameterSubstitution}s of this template binding
	 */
	@XmlElement(name = "parameterSubstitution")
	private ArrayList<ParameterSubstitution> parameterSubstitutions;
}
