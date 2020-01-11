package uml;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * Represents an attribute of an {@link UmlClass}
 * 
 * @author dschoenicke
 *
 */
@Getter
@AllArgsConstructor
public class UmlAttribute {

	/**
	 * The name of the attribute
	 */
	@NonNull private String name;
	
	/**
	 * The {@link UmlVisibility} of the attribute
	 */
	@NonNull private UmlVisibility visibility;
	
	/**
	 * The data type of the attribute
	 */
	@NonNull @Setter private String type;
	
	/**
	 * Determines whether the attribute is static
	 */
	@NonNull private Boolean isStatic;
	
	/**
	 * Determines whether the attribute is final
	 */
	@NonNull private Boolean isFinal;
	
	/**
	 * The default value of the attribute
	 */
	private String defaultValue;
	
	/**
	 * The lower {@link UmlMultiplicityValue} of the attribute
	 */
	@NonNull private UmlMultiplicityValue lowerValue;
	
	/**
	 * The upper {@link UmlMultiplicityValue} of the attribute, cannot be {@literal UmlMultiplicityValue.ZERO}
	 */
	@NonNull private UmlMultiplicityValue upperValue;
}
