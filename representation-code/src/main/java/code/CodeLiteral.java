package code;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Represents a literal of a {@link CodeEnumeration}
 * 
 * @author dschoenicke
 *
 */
@Getter
@RequiredArgsConstructor
public class CodeLiteral {

	/**
	 * The name of the literal
	 */
	@NonNull private String name;
}
