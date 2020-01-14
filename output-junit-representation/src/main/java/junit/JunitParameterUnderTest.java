package junit;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Represents a parameter of a {@link JunitConstructorUnderTest} or {@link JunitMethodUnderTest} with its final modifier value.
 * 
 * @author dschoenicke
 *
 */
@Getter
@AllArgsConstructor
public class JunitParameterUnderTest {

	/**
	 * The name of the parameter
	 */
	private String name;
	
	/**
	 * True, if the parameter is final
	 */
	private Boolean isFinal;
	
	/**
	 * The {@link junit.JunitAssertion} checking the parameter
	 */
	private JunitAssertion assertion;
}
