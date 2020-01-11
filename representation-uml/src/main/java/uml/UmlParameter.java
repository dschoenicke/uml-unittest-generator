package uml;

import lombok.Getter;
import lombok.Setter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Represents a parameter of an {@link UmlOperation}
 * 
 * @author dschoenicke
 *
 */
@Getter
@RequiredArgsConstructor
public class UmlParameter {

	/**
	 * The name of the parameter
	 */
	@NonNull private String name;
	
	/**
	 * The data type of the parameter
	 */
	@NonNull @Setter private String type;
	
	/**
	 * The {@link UmlParameterDirection} of the parameter
	 */
	@NonNull private UmlParameterDirection direction;
	
	/**
	 * Determines whether the parameter is final
	 */
	@NonNull private Boolean isFinal;
	
	/**
	 * The lower {@link UmlMultiplicityValue} of the attribute
	 */
	@NonNull private UmlMultiplicityValue lowerValue;
	
	/**
	 * The upper {@link UmlMultiplicityValue} of the attribute, cannot be {@literal UmlMultiplicityValue.ZERO}
	 */
	@NonNull private UmlMultiplicityValue upperValue;
}
