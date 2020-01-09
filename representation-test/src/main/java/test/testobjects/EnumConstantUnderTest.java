package test.testobjects;

/**
 * Represents an enum constant of a {@link ClassUndeTest}.
 * 
 * @author dschoenicke
 *
 */
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
	public EnumConstantUnderTest(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the name of the enum constant under test.
	 * 
	 * @return the name of the enum constant under test.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the enum constant under test.
	 * 
	 * @param the name of the enum constant under test.
	 */
	public void setName(String name) {
		this.name = name;
	}
}
