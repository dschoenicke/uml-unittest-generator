package umlcodeconverter.temporary;

import java.util.HashMap;
import java.util.List;

import code.CodeElement;
import code.CodePackage;
import code.CodeTemplateBinding;
import code.CodeTemplateParameter;
import lombok.Getter;
import uml.UmlElement;
import uml.UmlPackage;
import uml.UmlParameterSubstitution;
import uml.UmlTemplateParameter;

/**
 * Auxiliary class providing a map of incompletely converted {@link code.CodeTemplateBinding}s as value
 * and a list of {@link uml.UmlParameterSubstitution}s as value, and the map of {@link uml.UmlTemplateParameter}s
 * as key and {@link code.CodeTemplateParameter}s as value.<br>
 * Furthermore, this class holds a map of {@link uml.UmlPackage} and {@link code.CodePackage}s to be used by the {@link umlcodeconverter.element.ElementConverter}, 
 * as well as a map of{@link uml.UmlElement}s and {@link code.CodeElement}s to be used by the {@link umlcodeconverter.relationship.RelationshipConverter}
 * 
 * @author dschoenicke
 *
 */
@Getter
public class TemporaryModel {

	/**
	 * The map containing the {@link uml.UmlPackage}s as key and the corresponding converted {@link code.CodePackage} as value.
	 */
	private HashMap<UmlPackage, CodePackage> convertedPackages;
	
	/**
	 * The map containing incompletely converted {@link uml.UmlTemplateBinding}s as key and a list of {@link uml.UmlParameterSubstitution}s as value
	 */
	private HashMap<CodeTemplateBinding, List<UmlParameterSubstitution>> temporaryTemplateBindings;
	
	/**
	 * The map containing the {@link uml.UmlTemplateParameter}s as key and the corresponding converted {@link code.CodeTemplateParameter}s as value
	 */
	private HashMap<UmlTemplateParameter, CodeTemplateParameter> convertedTemplateParameters;
	
	/**
	 * The map containing the {@link uml.UmlElement}s as key and the corresponding converted {@link code.CodeElement}s
	 */
	private HashMap<UmlElement, CodeElement> convertedElements;
	
	/**
	 * Constructor, initializing the map of incompletely converted template bindings, converted template parameters, converted packages and converted elements
	 */
	public TemporaryModel() {
		convertedPackages = new HashMap<>();
		temporaryTemplateBindings = new HashMap<>();
		convertedTemplateParameters = new HashMap<>();
		convertedElements = new HashMap<>();
	}

	/**
	 * Adds a temporary {@link code.CodeTemplateBinding} and the {@link uml.UmlParameterSubstitution}s to the list
	 * 
	 * @param templateBinding the temporary {@link code.CodeTemplateBinding}
	 * @param parameterSubstitutions the list of {@link uml.UmlParameterSubstitution}s
	 */
	public void addTemporaryTemplateBinding(CodeTemplateBinding templateBinding, List<UmlParameterSubstitution> parameterSubstitutions) {
		temporaryTemplateBindings.put(templateBinding, parameterSubstitutions);
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
	 * Adds an {@link uml.UmlPackage} and the corresponding {@link code.CodePackage} to the map
	 * 
	 * @param umlPackage the {@link uml.UmlPackage} as key 
	 * @param codePackage the converted {@link code.CodePackage} as value
	 */
	public void addConvertedPackage(UmlPackage umlPackage, CodePackage codePackage) {
		convertedPackages.put(umlPackage, codePackage);
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
