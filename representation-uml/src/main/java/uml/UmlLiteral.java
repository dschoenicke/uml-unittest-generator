package uml;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Represents a literal of an {@link UmlEnumeration}
 * 
 * @author dschoenicke
 *
 */

@Getter
@RequiredArgsConstructor
public class UmlLiteral {
	
	/**
	 * Name of the literal
	 */
	@NonNull private String name;
}
