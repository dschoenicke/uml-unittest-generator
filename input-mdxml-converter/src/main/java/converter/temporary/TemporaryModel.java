package converter.temporary;

import java.util.ArrayList;
import java.util.HashMap;

import model.UmlAttribute;
import model.UmlElement;
import model.UmlModel;
import model.UmlPackage;
import model.UmlRelationship;
import model.UmlTemplateParameter;

public class TemporaryModel extends UmlModel {

	private ArrayList<TemporaryDiagram> tmpDiagrams;
	private HashMap<String, UmlElement> elementIDs;
	private HashMap<String, UmlPackage> packageIDs;
	private HashMap<String, UmlTemplateParameter> templateParameterIDs;
	private HashMap<String, UmlRelationship> relationshipIDs;
	private HashMap<String, UmlAttribute> attributeIDs;
	
	public TemporaryModel(String name) {
		super(name);
		tmpDiagrams = new ArrayList<>();
		elementIDs = new HashMap<>();
		packageIDs = new HashMap<>();
		templateParameterIDs = new HashMap<>();
		relationshipIDs = new HashMap<>();
		attributeIDs = new HashMap<>();
	}
	
	public ArrayList<TemporaryDiagram> getTemporaryDiagrams() {
		return tmpDiagrams;
	}
	
	public void addTemporaryDiagram(TemporaryDiagram tmpDiagram) {
		tmpDiagrams.add(tmpDiagram);
	}
	
	public HashMap<String, UmlElement> getElementIDs() {
		return elementIDs;
	}
	
	public void addElementID(String elementID) {
		elementIDs.putIfAbsent(elementID, null);
	}
	
	public void addElement(String elementID, UmlElement element) {
		elementIDs.put(elementID, element);
	}
	
	public HashMap<String, UmlPackage> getPackageIDs() {
		return packageIDs;
	}
	
	public void addPackage(String packageID, UmlPackage umlPackage) {
		packageIDs.put(packageID, umlPackage);
	}
	
	public HashMap<String, UmlTemplateParameter> getSubstitutionIDs() {
		return templateParameterIDs;
	}
	
	public void addTemplateParameter(String parameterID, UmlTemplateParameter parameter) {
		templateParameterIDs.put(parameterID, parameter);
	}
	
	public HashMap<String, UmlRelationship> getRelationshipIDs() {
		return relationshipIDs;
	}
	
	public void addRelationship(String relationshipID, UmlRelationship relationship) {
		relationshipIDs.put(relationshipID, relationship);
	}
	
	public HashMap<String, UmlAttribute> getAttributeIDs() {
		return attributeIDs;
	}
	
	public void addAttribute(String attributeID, UmlAttribute attribute) {
		attributeIDs.put(attributeID, attribute);
	}
}
