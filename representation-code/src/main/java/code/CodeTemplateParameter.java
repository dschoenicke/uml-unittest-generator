package code;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Represents a template parameter of a {@link CodeElement}, {@link CodeMethod} or {@link CodeConstructor}
 * 
 * @author dschoenicke
 *
 */
@Getter
@RequiredArgsConstructor
public class CodeTemplateParameter {

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
