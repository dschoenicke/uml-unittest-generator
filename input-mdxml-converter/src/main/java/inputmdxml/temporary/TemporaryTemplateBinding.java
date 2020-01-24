package inputmdxml.temporary;

import java.util.HashMap;

import lombok.Getter;
import uml.UmlTemplateBinding;

/**
 * Extends the {@link uml.UmlTemplateBinding} with a map containing references to the {@link uml.UmlTemplateParameter} and type of the {@link uml.UmlTemplateBinding}s parameter substitution
 * 
 * @author dschoenicke
 *
 */
@Getter
public class TemporaryTemplateBinding extends UmlTemplateBinding {
	
	/**
	 * Contains references to the {@link uml.UmlTemplateParameter} and the data type of the substitutions of the binding
	 */
	private HashMap<String, String> parameterSubstitutionMap;
	
	/**
	 * Default constructor, initializes the parameter substitution map
	 */
	public TemporaryTemplateBinding() {
		parameterSubstitutionMap = new HashMap<>();
	}	
	
	/**
	 * Adds a reference to an {@link uml.UmlTemplateParameter} and the data type of the substitution to the map
	 * 
	 * @param templateParameter the id referencing the {@link uml.UmlTemplateParameter}
	 * @param substitutionType the reference to the data type
	 */
	public void addTemporarySubstitution(String templateParameter, String substitutionType) {
		parameterSubstitutionMap.put(templateParameter, substitutionType);
	}
}
