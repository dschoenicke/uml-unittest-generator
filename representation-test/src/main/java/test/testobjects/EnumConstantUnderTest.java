package test.testobjects;

import lombok.Getter;

/**
 * Represents an enum constant of a {@link ClassUndeTest}.
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
	 */
	public EnumConstantUnderTest(String name, ClassUnderTest parent) {
		this.name = name;
		parent.getEnumConstants().add(this);
	}
}
