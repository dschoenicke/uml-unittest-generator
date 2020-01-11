package code;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Represents a field of a {@link CodeElement}
 * 
 * @author dschoenicke
 *
 */
@Getter
@RequiredArgsConstructor
public class CodeField {
	
	/**
	 * The name of the field
	 */
	@NonNull private String name;
	
	/**
	 * The data type of the field
	 */
	@NonNull private String type;
	
	/**
	 * An integer representing the {@link CodeModifier} determining the fields modifiers
	 */
	@NonNull private Integer modifiers;
	
	/**
	 * The default value of the field
	 */
	@NonNull private String defaultValue;
	
	/**
	 * Determines whether the field is allowed to be {@literal null}
	 */
	@NonNull private Boolean canBeNull;
	
	/**
	 * Determines whether the field has a multiplicity
	 */
	@NonNull private Boolean hasMultiplicity;
	
	/**
	 * The {@link CodeParent} of the field
	 */
	@NonNull private CodeParent parent;
}
