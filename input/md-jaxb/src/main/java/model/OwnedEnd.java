package model;

import javax.xml.bind.annotation.XmlAttribute;

public class OwnedEnd {

	private String id;
	private String endType;
	private String associationType;
	private String visibility;
	private String association;
	
	public OwnedEnd() {}

	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "type")
	public String getEndType() {
		return endType;
	}

	public void setEndType(String endType) {
		this.endType = endType;
	}

	@XmlAttribute(name = "type")
	public String getAssociationType() {
		return associationType;
	}

	public void setAssociationType(String associationType) {
		this.associationType = associationType;
	}

	@XmlAttribute(name = "visibility")
	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	@XmlAttribute(name = "association")
	public String getAssociation() {
		return association;
	}

	public void setAssociation(String association) {
		this.association = association;
	}
}
