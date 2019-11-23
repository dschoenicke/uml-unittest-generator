package converter.temporary;

import java.util.ArrayList;
import java.util.HashMap;

import uml.UmlAttribute;
import uml.UmlElement;
import uml.UmlPackage;
import uml.UmlParameter;
import uml.UmlRelationship;
import uml.UmlTemplateParameter;

public class TemporaryModel {

	private String name;
	private HashMap<String, UmlElement> elementIDs;
	private HashMap<String, UmlPackage> packageIDs;
	private HashMap<String, UmlTemplateParameter> templateParameterIDs;
	private ArrayList<UmlRelationship> relationships;
	private HashMap<String, UmlAttribute> attributeIDs;
	private ArrayList<UmlParameter> parameters;
	
	public TemporaryModel(String name) {
		this.name = name;
		elementIDs = new HashMap<>();
		packageIDs = new HashMap<>();
		templateParameterIDs = new HashMap<>();
		relationships = new ArrayList<>();
		attributeIDs = new HashMap<>();
		parameters = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
	
	public ArrayList<UmlRelationship> getRelationships() {
		return relationships;
	}
	
	public void addRelationship(UmlRelationship relationship) {
		relationships.add(relationship);
	}
	
	public HashMap<String, UmlAttribute> getAttributeIDs() {
		return attributeIDs;
	}
	
	public void addAttribute(String attributeID, UmlAttribute attribute) {
		attributeIDs.put(attributeID, attribute);
	}
	
	public ArrayList<UmlParameter> getParameters() {
		return parameters;
	}
	
	public void addParameter(UmlParameter parameter) {
		parameters.add(parameter);
	}
}
