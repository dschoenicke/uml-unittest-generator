package test.testobjects;

import lombok.Getter;

/**
 * Represents an enum constant of a {@link ClassUnderTest}.
 * 
 * @author dschoenicke
 *
 */
@Getter
public class EnumConstantUnderTest {

	/**
	 * The name of the enum constant under test.
	 */
	private String name;
	
	/**
	 * Constructor with name
	 * 
	 * @param name the name of the enum constant under test.
	 * @param parent the {@link ClassUnderTest} owning this enum constant
	 */
	public EnumConstantUnderTest(String name, ClassUnderTest parent) {
		this.name = name;
		parent.getEnumConstants().add(this);
	}
}
