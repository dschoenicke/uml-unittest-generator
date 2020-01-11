package mdxml;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents parameters of {@link OwnedOperation}s and {@link OwnedTemplateSignature}s
 * 
 * @author dschoenicke
 *
 */
@Data
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class OwnedParameter {
	
	/**
	 * The id of the parameter
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	private String id;
	
	/**
	 * The name of the parameter
	 */
	@XmlAttribute(name = "name")
	private String name;
	
	/**
	 * The direction of the parameter
	 */
	@XmlAttribute(name = "direction")
	private String direction;
	
	/**
	 * Reference to the id of the {@link PackagedElement} if it determines the data type of this parameter
	 */
	@XmlAttribute(name = "type")
	private String associationType;
	
	/**
	 * Determines whether the parameter belongs to an {@link OwnedOperation} or {@link OwnedTemplateSignature}
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "type")
	private String parameterType;
	
	/**
	 * The {@link DataType} of the parameter, if it is a primitive type
	 */
	@XmlElement(name = "type")
	private DataType dataType;
	
	/**
	 * The {@link LowerValue} of the parameter
	 */
	@XmlElement(name = "lowerValue")
	private LowerValue lowerValue;
	
	/**
	 * The {@link UpperValue} of the parameter
	 */
	@XmlElement(name = "upperValue")
	private UpperValue upperValue;
	
	/**
	 * The {@link ConstrainingClassifier} of the parameter if it is held by an {@link OwnedTemplateSignature}
	 */
	@XmlElement(name = "constrainingClassifier")
	private ConstrainingClassifier constrainingClassifier;
	
	/**
	 * The element which is parametered by this parameter
	 */
	@XmlElement(name = "ownedParameteredElement")
	private OwnedParameteredElement ownedParameteredElement;
	
	/**
	 * The list of {@link Extension}s holding a {@link LowerValue} or an {@link UpperValue} with the value '1'
	 */
	@XmlElement(namespace = "http://www.omg.org/spec/XMI/20131001", name = "Extension")
	private ArrayList<Extension> extensions;
	
	/**
	 * Set to "true" if the parameter is final, null otherwise
	 */
	@XmlAttribute(name = "isFinal")
	private String isFinal;
}
