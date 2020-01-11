package code;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Represents a parameter of a {@link CodeMethod}
 * 
 * @author dschoenicke
 *
 */
@Getter
@RequiredArgsConstructor
public class CodeParameter {

	/**
	 * The name of the parameter
	 */
	@NonNull private String name;
	
	/**
	 * The data type of the parameter
	 */
	@NonNull private String type;
	
	/**
	 * An integer representing the {@link CodeModifier} determining the parameter's modifiers
	 */
	@NonNull private Integer modifiers;
	
	/**
	 * Determines whether the parameter can be {@literal null}
	 */
	@NonNull private Boolean canBeNull;
	
	/**
	 * Determines whether the parameter has a multiplicity
	 */
	@NonNull private Boolean hasMultiplicity;
	
	/**
	 * The {@link CodeParent} of the parameter
	 */
	@NonNull @Setter private CodeParent parent;
}
