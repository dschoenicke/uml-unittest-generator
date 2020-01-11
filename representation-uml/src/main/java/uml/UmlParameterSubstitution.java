package uml;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Represents a parameter substitution of an {@link UmlTemplateBinding}
 * 
 * @author dschoenicke
 *
 */
@Getter
@RequiredArgsConstructor
public class UmlParameterSubstitution {
	
	/**
	 * The {@link UmlTemplateParameter}s replaced by this template binding
	 */
	@NonNull private UmlTemplateParameter templateParameter;
	
	/**
	 * The name of the class replacing the {@link UmlTemplateParameter}
	 */
	@NonNull private String substitutionType;
}
