package umlcodeconverter.temporary;

import java.util.ArrayList;
import java.util.HashMap;

import code.CodeElement;
import code.CodeTemplateBinding;
import code.CodeTemplateParameter;
import uml.UmlElement;
import uml.UmlParameterSubstitution;
import uml.UmlTemplateParameter;

/**
 * Auxiliary class providing a map of incompletely converted {@link code.CodeTemplateBinding}s as value
 * and a list of {@link uml.UmlParameterSubstitution}s as value, and the map of {@link uml.UmlTemplateParameter}s
 * as key and {@link code.CodeTemplateParameter}s as value.<br>
 * Furthermore, this class holds a list of {@link uml.UmlElement}s and {@link code.CodeElement}s to be used by the {@link umlcodeconverter.relationship.RelationshipConverter}
 * 
 * @author dschoenicke
 *
 */
public class TemporaryModel {

	/**
	 * The map containing incompletely converted {@link uml.UmlTemplateBinding}s as key and a list of {@link uml.UmlParameterSubstitution}s as value
	 */
	private HashMap<CodeTemplateBinding, ArrayList<UmlParameterSubstitution>> temporaryTemplateBindings;
	
	/**
	 * The map containing the {@link uml.UmlTemplateParameter}s as key and the corresponding converted {@link code.CodeTemplateParameter}s as value
	 */
	private HashMap<UmlTemplateParameter, CodeTemplateParameter> convertedTemplateParameters;
	
	/**
	 * The map containing the {@link uml.UmlElement}s as key and the corresponding converted {@link code.CodeElement}s
	 */
	private HashMap<UmlElement, CodeElement> convertedElements;
	
	/**
	 * Constructor, initializing the map of incompletely converted template bindings, converted template parameters and converted elements
	 */
	public TemporaryModel() {
		temporaryTemplateBindings = new HashMap<>();
		convertedTemplateParameters = new HashMap<>();
		convertedElements = new HashMap<>();
	}
	
	/**
	 * Gets the map of temporary {@link code.CodeTemplateBinding}s and their {@link uml.UmlParameterSubstitution}s
	 * 
	 * @return the map of temporary {@link code.CodeTemplateBinding}s and their {@link uml.UmlParameterSubstitution}s
	 */
	public HashMap<CodeTemplateBinding, ArrayList<UmlParameterSubstitution>> getTemporaryTemplateBindings() {
		return temporaryTemplateBindings;
	}
	
	/**
	 * Adds a temporary {@link code.CodeTemplateBinding} and the {@link uml.UmlParameterSubstitution}s to the list
	 * 
	 * @param templateBinding the temporary {@link code.CodeTemplateBinding}
	 * @param parameterSubstitutions the list of {@link uml.UmlParameterSubstitution}s
	 */
	public void addTemporaryTemplateBinding(CodeTemplateBinding templateBinding, ArrayList<UmlParameterSubstitution> parameterSubstitutions) {
		temporaryTemplateBindings.put(templateBinding, parameterSubstitutions);
	}
	
	/**
	 * Gets the map of {@link uml.UmlTemplateParameter}s and {@link code.CodeTemplateParameter}s
	 * 
	 * @return the map of {@link uml.UmlTemplateParameter}s and {@link code.CodeTemplateParameter}s
	 */
	public HashMap<UmlTemplateParameter, CodeTemplateParameter> getConvertedTemplateParameters() {
		return convertedTemplateParameters;
	}
	
	/**
	 * Adds an {@link uml.UmlTemplateParameter} and the corresponding {@link code.CodeTemplateParameter} to the map
	 * 
	 * @param umlTemplateParameter the {@link uml.UmlTemplateParameter} as key 
	 * @param codeTemplateParameter the converted {@link code.CodeTemplateParameter} as value
	 */
	public void addConvertedTemplateParameter(UmlTemplateParameter umlTemplateParameter, CodeTemplateParameter codeTemplateParameter) {
		convertedTemplateParameters.put(umlTemplateParameter, codeTemplateParameter);
	}
	
	/**
	 * Gets the map of {@link uml.UmlElement}s and {@link code.CodeElement}s
	 * 
	 * @return the map of {@link uml.UmlElement}s and {@link code.CodeElement}s
	 */
	public HashMap<UmlElement, CodeElement> getConvertedElements() {
		return convertedElements;
	}
	
	/**
	 * Adds an {@link uml.UmlElement} and the corresponding {@link code.CodeElement} to the map
	 * 
	 * @param umlElement the {@link uml.UmlElement} as key 
	 * @param codeElement the converted {@link code.CodeElement} as value
	 */
	public void addConvertedElement(UmlElement umlElement, CodeElement codeElement) {
		convertedElements.put(umlElement, codeElement);
	}
}
