package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

public class ModelExtension {

	private ArrayList<OwnedDiagram> ownedDiagrams;
	
	public ModelExtension() {}
	
	@XmlElement(name = "ownedDiagram")
	public ArrayList<OwnedDiagram> getOwnedDiagrams() {
		return ownedDiagrams;
	}
	
	public void setOwnedDiagrams(ArrayList<OwnedDiagram> ownedDiagrams) {
		this.ownedDiagrams = ownedDiagrams;
	}
}
