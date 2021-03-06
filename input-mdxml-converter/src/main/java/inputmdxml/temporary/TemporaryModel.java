package inputmdxml.temporary;

import java.util.ArrayList;
import java.util.HashMap;

import lombok.Getter;
import uml.UmlAttribute;
import uml.UmlElement;
import uml.UmlParameter;
import uml.UmlRelationship;
import uml.UmlTemplateParameter;

/**
 * Auxiliary class managing references of {@link uml.UmlElement}s, {@link uml.UmlTemplateParameter}s, {@link uml.UmlRelationship}s, {@link uml.UmlAttribute}s and {@link uml.UmlParameter}s<br>
 * These references are used for the replacement with the actual elements
 * 
 * @author dschoenicke
 *
 */
@Getter
public class TemporaryModel {

	/**
	 * A map containing {@link uml.UmlElement}s and references to their corresponding {@link mdxml.PackagedElement}s
	 */
	private HashMap<String, UmlElement> elementIDs;
	
	/**
	 * A map containing {@link uml.UmlTemplateParameter}s and references to their corresponding {@link mdxml.Parameter}s
	 */
	private HashMap<String, UmlTemplateParameter> templateParameterIDs;
	
	/**
	 * A list containing all converted {@link uml.UmlRelationship}s
	 */
	private ArrayList<UmlRelationship> relationships;
	
	/**
	 * A map containing {@link uml.UmlAttribute}s and references to their corresponding {@link mdxml.OwnedAttribute}s
	 */
	private HashMap<String, UmlAttribute> attributeIDs;
	
	/**
	 * A list containing all converted {@link uml.UmlParameter}s
	 */
	private ArrayList<UmlParameter> parameters;
	
	/**
	 * Constructor, initializes classes' maps and lists
	 */
	public TemporaryModel() {
		elementIDs = new HashMap<>();
		templateParameterIDs = new HashMap<>();
		relationships = new ArrayList<>();
		attributeIDs = new HashMap<>();
		parameters = new ArrayList<>();
	}
	
	/**
	 * Adds an id of an {@link mdxml.PackagedElement} and the corresponding {@link uml.UmlElement} to the map
	 * 
	 * @param elementID the id of the {@link mdxml.PackagedElement}
	 * @param element the {@link uml.UmlElement}
	 */
	public void addElement(String elementID, UmlElement element) {
		elementIDs.put(elementID, element);
	}

	/**
	 * Adds an id of an {@link mdxml.Parameter} and the corresponding {@link uml.UmlTemplateParameter} to the map
	 * 
	 * @param parameterID the id of the {@link mdxml.Parameter}
	 * @param parameter the {@link uml.UmlTemplateParameter}
	 */
	public void addTemplateParameter(String parameterID, UmlTemplateParameter parameter) {
		templateParameterIDs.put(parameterID, parameter);
	}
	
	/**
	 * Adds an {@link uml.UmlRelationship} to the list
	 * 
	 * @param relationship the {@link uml.UmlRelationship} to add to the list
	 */
	public void addRelationship(UmlRelationship relationship) {
		relationships.add(relationship);
	}

	/**
	 * Adds an id of an {@link mdxml.OwnedAttribute} and the corresponding {@link uml.UmlAttribute} to the map
	 * 
	 * @param attributeID the id of the {@link mdxml.OwnedAttribute}
	 * @param attribute the {@link uml.UmlAttribute}
	 */
	public void addAttribute(String attributeID, UmlAttribute attribute) {
		attributeIDs.put(attributeID, attribute);
	}
	
	/**
	 * Adds an {@link uml.UmlParameter} to the list
	 * 
	 * @param parameter the {@link uml.UmlParameter} to add to the list
	 */
	public void addParameter(UmlParameter parameter) {
		parameters.add(parameter);
	}
}
