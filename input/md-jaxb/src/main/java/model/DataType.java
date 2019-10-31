package model;

import javax.xml.bind.annotation.XmlAttribute;

public class DataType {

	private String href;
	
	public DataType() {}
	
	@XmlAttribute
	public String getHref() {
		return href;
	}
	
	public void setHref(String href) {
		this.href = href;
	}
	
}
