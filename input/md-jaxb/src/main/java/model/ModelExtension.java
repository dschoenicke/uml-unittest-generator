package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

public class ModelExtension {

	private ArrayList<OwnedDiagram> ownedDiagrams;
	private LowerValue lowerValue;
	private UpperValue upperValue;
	
	public ModelExtension() {
		ownedDiagrams = new ArrayList<OwnedDiagram>();
	}
	
	@XmlElement(name = "ownedDiagram")
	public ArrayList<OwnedDiagram> getOwnedDiagrams() {
		return ownedDiagrams;
	}
	
	public void setOwnedDiagrams(ArrayList<OwnedDiagram> ownedDiagrams) {
		this.ownedDiagrams = ownedDiagrams;
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
}
