package test;

/**
 * Represents an assertion with an error message, actual value, expected value and {@link TestAssertionType},
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
	 * The actual value checked in the assertion
	 */
	private String actualValue;
	
	/**
	 * The expected value of the assertion
	 */
	private String expectedValue;
	
	/**
	 * Constructor with {@link TestAssertionType}, message, actualValue and expectedValue
	 * 
	 * @param assertionType the {@link TestAssertionType} which determines the assertion which should be used
	 * @param message the error message which should be shown if the assertion is false
	 * @param actualValue the value to be checked
	 * @param expectedValue the expected value which should be matched
	 */
	public TestAssertion(TestAssertionType assertionType, String message, String actualValue, String expectedValue) {
		this.assertionType = assertionType;
		this.message = message;
		this.actualValue = actualValue;
		this.expectedValue = expectedValue;
	}

	public TestAssertionType getAssertionType() {
		return assertionType;
	}

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

	/**
	 * Gets the actual value
	 * 
	 * @return the actual value
	 */
	public String getActualValue() {
		return actualValue;
	}

	/**
	 * Sets the actual value
	 * 
	 * @param actualValue the actual value
	 */
	public void setActualValue(String actualValue) {
		this.actualValue = actualValue;
	}

	/**
	 * Gets the expected value
	 * 
	 * @return the expected value
	 */
	public String getExpectedValue() {
		return expectedValue;
	}

	/**
	 * Sets the expected value
	 * 
	 * @param expectedValue the expected value
	 */
	public void setExpectedValue(String expectedValue) {
		this.expectedValue = expectedValue;
	}
}
