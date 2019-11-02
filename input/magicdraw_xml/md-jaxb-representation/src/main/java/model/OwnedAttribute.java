package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Represents attributes of classes which are described by {@link PackagedElement}s
 * 
 * @author dschoenicke
 *
 */
public class OwnedAttribute {

	/**
	 * The id of the attribute
	 */
	private String id;
	
	/**
	 * The name of the attribute
	 */
	private String name;
	
	/**
	 * The visibility of the attribute
	 */
	private String visibility;
	
	/**
	 * The {@link LowerValue} of the attribute
	 */
	private LowerValue lowerValue;
	
	/**
	 * The {@link UpperValue} of the attribute
	 */
	private UpperValue upperValue;
	
	/**
	 * The default value of the attribute
	 */
	private DefaultValue defaultValue;
	
	/**
	 * Id of the {@link PackagedElement} which represents the association if 
	 * this attribute is determined by an association
	 */
	private String association;
	
	/**
	 * Set to "true" if the attribute is static, null otherwise
	 */
	private String isStatic;
	
	/**
	 * Set to "true" if the attribute is final, null otherwise
	 */
	private String isFinal;
	
	/**
	 * Describes the type of the aggregation if this attribute is determined by an aggregation
	 */
	private String aggregation;
	
	/**
	 * Id of the {@link PackagedElement} which represents the data type of this attribute
	 * if the attribute is determined by an association
	 */
	private String associationType;
	
	/**
	 * The {@link DataType} of the attribute if it is a primitve type
	 */
	private DataType dataType;
	
	/**
	 * List of {@link Extension}s which hold the {@link LowerValue} and {@link UpperValue} of the attribute
	 */
	private ArrayList<Extension> extensions;
	
	/**
	 * Default constructor
	 */
	public OwnedAttribute() {
		extensions = new ArrayList<Extension>();
	}
	
	/**
	 * Gets the id of the attribute
	 * 
	 * @return the id of the attribute
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	public String getId() {
		return id;
	}
	
	/**
	 * Sets the id of the attribute
	 * 
	 * @param id the id of the attribute
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Gets the name of the attribute
	 * 
	 * @return the name of the attribute
	 */
	@XmlAttribute
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the attribute
	 * 
	 * @param name the name of the attribute
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the visibility of the attribute
	 * 
	 * @return the visibility of the attribute
	 */
	@XmlAttribute
	public String getVisibility() {
		return visibility;
	}

	/**
	 * Sets the visibility of the attribute
	 * 
	 * @param visibility the visibility of the attribute
	 */
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	
	/**
	 * Gets the {@link LowerValue} of the attribute
	 * 
	 * @return the {@link LowerValue} of the attribute
	 */
	@XmlElement(name = "lowerValue")
	public LowerValue getLowerValue() {
		return lowerValue;
	}
	
	/**
	 * Sets the {@link LowerValue} of the attribute
	 * 
	 * @param lowerValue the {@link LowerValue} of the attribute
	 */
	public void setLowerValue(LowerValue lowerValue) {
		this.lowerValue = lowerValue;
	}
	
	/**
	 * Gets the {@link UpperValue} of the attribute
	 * 
	 * @return the {@link UpperValue} of the attribute
	 */
	@XmlElement(name = "upperValue")
	public UpperValue getUpperValue() {
		return upperValue;
	}
	
	/**
	 * Sets the {@link UpperValue} of the attribute
	 * 
	 * @param upperValue the {@link UpperValue} of the attribute
	 */
	public void setUpperValue(UpperValue upperValue) {
		this.upperValue = upperValue;
	}
	
	/**
	 * Gets the {@link DefaultValue} of the attribute
	 * 
	 * @return the {@link DefaultValue} of the attribute
	 */
	@XmlElement(name = "defaultValue")
	public DefaultValue getDefaultValue() {
		return defaultValue;
	}
	
	/**
	 * Sets the {@link DefaultValue} of the attribute
	 * 
	 * @param defaultValue the {@link DefaultValue} of the attribute
	 */
	public void setDefaultValue(DefaultValue defaultValue) {
		this.defaultValue = defaultValue;
	}
	
	/**
	 * Gets the String which classifies whether the attribute is static
	 * 
	 * @return "true" if the attribute is static, null otherwise
	 */
	@XmlAttribute(name = "isStatic")
	public String getIsStatic() {
		return isStatic;
	}
	
	/**
	 * Sets the String which classifies whether the attribute is static
	 * 
	 * @param isStatic "true" if the attribute is static, null otherwise
	 */
	public void setIsStatic(String isStatic) {
		this.isStatic = isStatic;
	}
	
	/**
	 * Gets the String which classifies whether the attribute is final
	 * 
	 * @return "true" if the attribute is final, null otherwise
	 */
	@XmlAttribute(name = "isFinal")
	public String getIsFinal() {
		return isFinal;
	}
	
	/**
	 * Sets the String which classifies whether the attribute is final
	 * 
	 * @param isFinal "true" if the attribute is final, null otherwise
	 */
	public void setIsFinal(String isFinal) {
		this.isFinal = isFinal;
	}
	
	/**
	 * Gets the id of the {@link PackagedElement} which represents the association
	 * 
	 * @return the id of the {@link PackagedElement}
	 */
	@XmlAttribute(name = "association")
	public String getAssociation() {
		return association;
	}

	/**
	 * Sets the id of the {@link PackagedElement} which represents the association
	 * 
	 * @param association the id of the {@link PackagedElement}
	 */
	public void setAssociation(String association) {
		this.association = association;
	}
	
	/**
	 * Gets the type of the aggregation
	 * 
	 * @return the type of the aggregation
	 */
	@XmlAttribute(name = "aggregation")
	public String getAggregation() {
		return aggregation;
	}

	/**
	 * Sets the type of the aggregation
	 * 
	 * @param aggregation the type of the aggregation
	 */
	public void setAggregation(String aggregation) {
		this.aggregation = aggregation;
	}
	
	/**
	 * Gets the id of the {@link PackagedElement} which represents the association end
	 * 
	 * @return the id of the {@link PackagedElement}
	 */
	@XmlAttribute(name = "type")
	public String getAssociationType() {
		return associationType;
	}

	/**
	 * Sets the id of the {@link PackagedElement} which represents the association end
	 * 
	 * @param type the id of the {@link PackagedElement}
	 */
	public void setAssociationType(String type) {
		this.associationType = type;
	}
	
	/**
	 * Gets the {@link DataType} of the attribute if it is a primitive type
	 * 
	 * @return the {@link DataType} of the attribute
	 */
	@XmlElement(name = "type")
	public DataType getDataType() {
		return dataType;
	}

	/**
	 * Sets the {@link DataType} of the attribute if it is a primitive type
	 * 
	 * @param dataType the {@link DataType} of the attribute
	 */
	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}
	
	/**
	 * Gets the {@link Extension}s which hold the {@link LowerValue} and {@link UpperValue} of the attribute
	 * 
	 * @return the list of {@link Extension}s
	 */
	@XmlElement(namespace = "http://www.omg.org/spec/XMI/20131001", name = "Extension")
	public ArrayList<Extension> getExtensions() {
		return extensions;
	}
	
	/**
	 * Sets the {@link Extension}s which hold the {@link LowerValue} and {@link UpperValue} of the attribute
	 * 
	 * @param extensions the list of {@link Extension}s
	 */
	public void setExtensions(ArrayList<Extension> extensions) {
		this.extensions = extensions;
	}
}
