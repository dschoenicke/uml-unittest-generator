package test;

/**
 * Represents an assertion with an error message and {@link TestAssertionType},
 * which determines, what actual assertion should be used in the test method for these values.
 * 
 * @author dschoenicke
 *
 */
public class TestAssertion {
	
	/**
	 * The {@link TestAssertionType} determining which assertion should be used
	 */
	private TestAssertionType assertionType;

	/**
	 * The error message which is shown if the assertion is false
	 */
	private String message;
	
	/**
	 * Constructor with {@link TestAssertionType}, message, actualValue and expectedValue
	 * 
	 * @param assertionType the {@link TestAssertionType} which determines the assertion which should be used
	 * @param message the error message which should be shown if the assertion is false
	 */
	public TestAssertion(TestAssertionType assertionType, String message) {
		this.assertionType = assertionType;
		this.message = message;
	}

	/**
	 * Gets the {@link TestAssertionType} of the assertion
	 * 
	 * @return the {@link TestAssertionType} of the assertion
	 */
	public TestAssertionType getAssertionType() {
		return assertionType;
	}

	/**
	 * Sets the {@link TestAssertionType} of the assertion
	 * 
	 * @param assertionType the {@link TestAssertionType} of the assertion
	 */
	public void setAssertionType(TestAssertionType assertionType) {
		this.assertionType = assertionType;
	}

	/**
	 * Gets the error message to be shown if the assertion is false
	 * 
	 * @return the error message to be shown if the assertion is false
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the error message to be shown if the assertion is false
	 * 
	 * @param message the error message to be shown if the assertion is false
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
