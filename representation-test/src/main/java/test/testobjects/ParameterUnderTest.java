package test.testobjects;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Represents a parameter of a {@link ConstructorUnderTest} or a {@link MethodUnderTest}.
 * 
 * @author dschoenicke
 *
 */
@Data
@RequiredArgsConstructor
public class ParameterUnderTest implements TestObject {

	/**
	 * The name of the parameter under test.
	 */
	@NonNull private String name;
	
	/**
	 * The fully qualified name of the type of the parameter under test.
	 */
	@NonNull private String type;
	
	/**
	 * The modifier value of the parameter under test.
	 */
	@NonNull private Integer modifiers;
	
	/**
	 * Determines whether the parameter can be {@literal null} to indicate a check for type Optional.
	 */
	@NonNull private Boolean canBeNull;
	
	/**
	 * Determines whether the parameter has a multiplicity to indicate a check for Collections or Arrays.
	 */
	@NonNull private Boolean hasMultiplicity;
}
