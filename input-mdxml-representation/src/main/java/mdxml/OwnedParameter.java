package mdxml;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import core.representation.Node;

/**
 * Represents parameters of {@link OwnedOperation}s and {@link OwnedTemplateSignature}s
 * 
 * @author dschoenicke
 *
 */
public class OwnedParameter implements Node {
	
	/**
	 * The id of the parameter
	 */
	private String id;
	
	/**
	 * The name of the parameter
	 */
	private String name;
	
	/**
	 * The direction of the parameter
	 */
	private String direction;
	
	/**
	 * Reference to the id of the {@link PackagedElement} if it determines the data type of this parameter
	 */
	private String associationType;
	
	/**
	 * Determines whether the parameter belongs to an {@link OwnedOperation} or {@link OwnedTemplateSignature}
	 */
	private String parameterType;
	
	/**
	 * The {@link DataType} of the parameter, if it is a primitive type
	 */
	private DataType dataType;
	
	/**
	 * The {@link LowerValue} of the parameter
	 */
	private LowerValue lowerValue;
	
	/**
	 * The {@link UpperValue} of the parameter
	 */
	private UpperValue upperValue;
	
	/**
	 * The {@link ConstrainingClassifier} of the parameter if it is held by an {@link OwnedTemplateSignature}
	 */
	private ConstrainingClassifier constrainingClassifier;
	
	/**
	 * The element which is parametered by this parameter
	 */
	private OwnedParameteredElement ownedParameteredElement;
	
	/**
	 * The list of {@link Extension}s holding a {@link LowerValue} or an {@link UpperValue} with the value '1'
	 */
	private ArrayList<Extension> extensions;
	
	/**
	 * Set to "true" if the parameter is final, null otherwise
	 */
	private String isFinal;
	
	/**
	 * Default constructor, initializes the list of {@link Extension}s
	 */
	public OwnedParameter() {
		extensions = new ArrayList<>();
	}
	
	/**
	 * Gets the id of the parameter
	 * 
	 * @return the id of the parameter
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	public String getId() {
		return id;
	}
	
	/**
	 * Sets the id of the parameter
	 * 
	 * @param id the id of the parameter
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Gets the name of the parameter
	 * 
	 * @return the name of the parameter
	 */
	@XmlAttribute
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the parameter
	 * 
	 * @param name the name of the parameter
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the direction of the parameter
	 * 
	 * @return the direction of the parameter
	 */
	@XmlAttribute(name = "direction")
	public String getDirection() {
		return direction;
	}
	
	/**
	 * Sets the direction of the parameter
	 * 
	 * @param direction the direction of the parameter
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	/**
	 * Gets the id of the {@link PackagedElement} if it determines the parameters data type
	 * 
	 * @return the id of the {@link PackagedElement}
	 */
	@XmlAttribute(name = "type")
	public String getAssociationType() {
		return associationType;
	}

	/**
	 * Sets the id of the {@link PackagedElement} if it determines the parameters data type
	 * 
	 * @param associationType the id of the {@link PackagedElement}
	 */
	public void setAssociationType(String associationType) {
		this.associationType = associationType;
	}
	
	/**
	 * Gets the type of the parameter
	 * 
	 * @return the type of the parameter
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "type")
	public String getParameterType() {
		return parameterType;
	}
	
	/**
	 * Sets the type of the parameter
	 * 
	 * @param parameterType the type of the parameter
	 */
	public void setParameterType(String parameterType) {
		this.parameterType = parameterType;
	}
	
	/**
	 * Gets the {@link DataType} of the parameter, if it is a primitive type
	 * 
	 * @return the {@link DataType} of the parameter
	 */
	@XmlElement(name = "type")
	public DataType getDataType() {
		return dataType;
	}

	/**
	 * Sets the {@link DataType} of the parameter, if it is a primitive type
	 * 
	 * @param dataType the {@link DataType}
	 */
	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}
	
	/**
	 * Gets the {@link LowerValue} of the parameter
	 * 
	 * @return the {@link LowerValue} of the parameter
	 */
	@XmlElement(name = "lowerValue")
	public LowerValue getLowerValue() {
		return lowerValue;
	}
	
	/**
	 * Sets the {@link LowerValue} of the parameter
	 * 
	 * @param lowerValue the {@link LowerValue} of the parameter
	 */
	public void setLowerValue(LowerValue lowerValue) {
		this.lowerValue = lowerValue;
	}
	
	/**
	 * Gets the {@link UpperValue} of the parameter
	 * 
	 * @return the {@link UpperValue} of the parameter
	 */
	@XmlElement(name = "upperValue")
	public UpperValue getUpperValue() {
		return upperValue;
	}
	
	/**
	 * Sets the {@link UpperValue} of the parameter
	 * 
	 * @param upperValue the {@link UpperValue} of the parameter
	 */
	public void setUpperValue(UpperValue upperValue) {
		this.upperValue = upperValue;
	}
	
	/**
	 * Gets the parametered element
	 * 
	 * @return the parametered element
	 */
	@XmlElement(name = "ownedParameteredElement") 
	public OwnedParameteredElement getOwnedParameteredElement() {
		return ownedParameteredElement;
	}
	
	/**
	 * Sets the parametered element
	 * 
	 * @param ownedParameteredElement the parametered element
	 */
	public void setOwnedParameteredElement(OwnedParameteredElement ownedParameteredElement) {
		this.ownedParameteredElement = ownedParameteredElement;
	}
	
	/**
	 * Gets the {@link ConstrainingClassifier}
	 * 
	 * @return the {@link ConstrainingClassifier}
	 */
	@XmlElement(name = "constrainingClassifier") 
	public ConstrainingClassifier getConstrainingClassifier() {
		return constrainingClassifier;
	}
	
	/**
	 * Sets the {@link ConstrainingClassifier}
	 * 
	 * @param constrainingClassifier the {@link ConstrainingClassifier}
	 */
	public void setConstrainingClassifier(ConstrainingClassifier constrainingClassifier) {
		this.constrainingClassifier = constrainingClassifier;
	}
	
	/**
	 * Gets the String which classifies whether the parameter is final
	 * 
	 * @return "true" if the parameter is final, null otherwise
	 */
	@XmlAttribute(name = "isFinal")
	public String getIsFinal() {
		return isFinal;
	}
	
	/**
	 * Sets the String which classifies whether the parameter is final
	 * 
	 * @param isFinal "true" if the parameter is final, null otherwise
	 */
	public void setIsFinal(String isFinal) {
		this.isFinal = isFinal;
	}
	
	/**
	 * Gets the {@link Extension}s which hold the {@link LowerValue} and {@link UpperValue} of the parameter
	 * 
	 * @return the list of {@link Extension}s
	 */
	@XmlElement(namespace = "http://www.omg.org/spec/XMI/20131001", name = "Extension")
	public ArrayList<Extension> getExtensions() {
		return extensions;
	}
	
	/**
	 * Sets the {@link Extension}s which hold the {@link LowerValue} and {@link UpperValue} of the parameter
	 * 
	 * @param extensions the list of {@link Extension}s
	 */
	public void setExtensions(ArrayList<Extension> extensions) {
		this.extensions = extensions;
	}
}
