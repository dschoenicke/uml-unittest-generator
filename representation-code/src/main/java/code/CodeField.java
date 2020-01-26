package code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * Represents a field of a {@link CodeElement}
 * 
 * @author dschoenicke
 *
 */
@Getter
@AllArgsConstructor
public class CodeField {
	
	/**
	 * The name of the field
	 */
	@NonNull private String name;
	
	/**
	 * The data type of the field
	 */
	@NonNull @Setter private String type;
	
	/**
	 * An integer representing the modifier value
	 */
	@NonNull private Integer modifiers;
	
	/**
	 * The default value of the field
	 */
	private String defaultValue;
	
	/**
	 * Determines whether the field is allowed to be {@literal null}
	 */
	@NonNull private Boolean canBeNull;
	
	/**
	 * Determines whether the field has a multiplicity
	 */
	@NonNull private Boolean hasMultiplicity;
}
