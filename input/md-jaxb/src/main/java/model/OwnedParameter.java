package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class OwnedParameter {
	
	private String id;
	private String name;
	private String direction;
	private String associationType;
	private String parameterType;
	private DataType dataType;
	private LowerValue lowerValue;
	private UpperValue upperValue;
	private ConstrainingClassifier constrainingClassifier;
	private OwnedParameteredElement ownedParameteredElement;
	
	public OwnedParameter() {}
	
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	@XmlAttribute
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlAttribute(name = "direction")
	public String getDirection() {
		return direction;
	}
	
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	@XmlAttribute(name = "type")
	public String getAssociationType() {
		return associationType;
	}

	public void setAssociationType(String associationType) {
		this.associationType = associationType;
	}
	
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "type")
	public String getParameterType() {
		return parameterType;
	}
	
	public void setParameterType(String parameterType) {
		this.parameterType = parameterType;
	}
	
	@XmlElement(name = "type")
	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}
	
	@XmlElement(name = "lowerValue")
	public LowerValue getLowerValue() {
		return lowerValue;
	}
	
	public void setLowerValue(LowerValue lowerValue) {
		this.lowerValue = lowerValue;
	}
	
	@XmlElement(name = "upperValue")
	public UpperValue getUpperValue() {
		return upperValue;
	}
	
	public void setUpperValue(UpperValue upperValue) {
		this.upperValue = upperValue;
	}
	
	@XmlElement(name = "ownedParameteredElement") 
	public OwnedParameteredElement getOwnedParameteredElement() {
		return ownedParameteredElement;
	}
	
	public void setOwnedParameteredElement(OwnedParameteredElement ownedParameteredElement) {
		this.ownedParameteredElement = ownedParameteredElement;
	}
	
	@XmlElement(name = "constrainingClassifier") 
	public ConstrainingClassifier getConstrainingClassifier() {
		return constrainingClassifier;
	}
	
	public void setConstrainingClassifier(ConstrainingClassifier constrainingClassifier) {
		this.constrainingClassifier = constrainingClassifier;
	}
}
