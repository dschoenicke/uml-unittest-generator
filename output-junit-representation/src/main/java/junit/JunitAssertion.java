package junit;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Represents an junit assertion which will be printed in the mustache template
 * 
 * @author dschoenicke
 *
 */
@Getter
@AllArgsConstructor
public class JunitAssertion {

	/**
	 * The expected value which should be matched
	 */
	private String expectedValue;
	
	/**
	 * The actual value which should be checked
	 */
	private String actualValue;
	
	/**
	 * The error message to be printed if the assertion is wrong
	 */
	private String message;
}
