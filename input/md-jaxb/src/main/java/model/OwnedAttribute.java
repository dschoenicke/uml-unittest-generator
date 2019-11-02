package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class OwnedAttribute {

	private String id;
	private String name;
	private String visibility;
	private String aggregation;
	private String associationType;
	private DataType dataType;
	private ArrayList<Extension> extensions;
	
	public OwnedAttribute() {
		extensions = new ArrayList<Extension>();
	}
	
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

	@XmlAttribute
	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	
	@XmlAttribute
	public String getAggregation() {
		return aggregation;
	}

	public void setAggregation(String aggregation) {
		this.aggregation = aggregation;
	}
	
	@XmlAttribute(name = "type")
	public String getAssociationType() {
		return associationType;
	}

	public void setAssociationType(String type) {
		this.associationType = type;
	}
	
	@XmlElement(name = "type")
	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}
	
	@XmlElement(namespace = "http://www.omg.org/spec/XMI/20131001", name = "Extenstion")
	public ArrayList<Extension> getExtensions() {
		return extensions;
	}
	
	public void setExtensions(ArrayList<Extension> extensions) {
		this.extensions = extensions;
	}
}
