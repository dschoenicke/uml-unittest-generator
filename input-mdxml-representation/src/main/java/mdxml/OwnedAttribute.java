package mdxml;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents attributes of classes which are described by {@link PackagedElement}s
 * 
 * @author dschoenicke
 *
 */
@Data
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class OwnedAttribute {

	/**
	 * The id of the attribute
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	private String id;
	
	/**
	 * The name of the attribute
	 */
	@XmlAttribute
	private String name;
	
	/**
	 * The visibility of the attribute
	 */
	@XmlAttribute
	private String visibility;
	
	/**
	 * The {@link LowerValue} of the attribute
	 */
	@XmlElement(name = "lowerValue")
	private LowerValue lowerValue;
	
	/**
	 * The {@link UpperValue} of the attribute
	 */
	@XmlElement(name = "upperValue")
	private UpperValue upperValue;
	
	/**
	 * The default value of the attribute
	 */
	@XmlElement(name = "defaultValue")
	private DefaultValue defaultValue;
	
	/**
	 * Id of the {@link PackagedElement} which represents the association if 
	 * this attribute is determined by an association
	 */
	@XmlAttribute(name = "association")
	private String association;
	
	/**
	 * Set to "true" if the attribute is static, null otherwise
	 */
	@XmlAttribute(name = "isStatic")
	private String isStatic;
	
	/**
	 * Set to "true" if the attribute is final, null otherwise
	 */
	@XmlAttribute(name = "isReadOnly")
	private String isFinal;
	
	/**
	 * Describes the type of the aggregation if this attribute is determined by an aggregation
	 */
	@XmlAttribute(name = "aggregation")
	private String aggregation;
	
	/**
	 * Id of the {@link PackagedElement} which represents the data type of this attribute
	 * if the attribute is determined by an association
	 */
	@XmlAttribute(name = "type")
	private String associationType;
	
	/**
	 * The {@link DataType} of the attribute if it is a primitve type
	 */
	@XmlElement(name = "type")
	private DataType dataType;
	
	/**
	 * List of {@link Extension}s which hold the {@link LowerValue} and {@link UpperValue} of the attribute if their value is '1'
	 */
	@XmlElement(namespace = "http://www.omg.org/spec/XMI/20131001", name = "Extension")
	private ArrayList<Extension> extensions;
	
	/**
	 * The {@link TemplateBinding} of the attribute
	 */
	@XmlElement(name = "templateBinding")
	private TemplateBinding templateBinding;
}
