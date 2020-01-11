package uml;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Represents an template parameter of a generic {@link UmlClass} or {@link UmlInterface}
 * 
 * @author dschoenicke
 *
 */
@Getter
@RequiredArgsConstructor
public class UmlTemplateParameter {
	
	/**
	 * The name of the template parameter
	 */
	@NonNull private String name;
	
	/**
	 * The constraining type of the template parameter
	 * Is 'java.lang.Object' if there is no constrain
	 */
	@NonNull @Setter private String type;
}
