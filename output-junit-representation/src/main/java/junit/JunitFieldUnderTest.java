package junit;

import java.util.ArrayList;

import lombok.Getter;

/**
 * Represents a field with to be tested in a {@link JunitTestClass}.
 * 
 * @author dschoenicke
 *
 */
@Getter
public class JunitFieldUnderTest {

	/**
	 * The name of the field
	 */
	private String name;
	
	/**
	 * The type of the field
	 */
	private String type;
	
	/**
	 * True, if the field is an Optional
	 */
	private boolean optional;
	
	/**
	 * True, if the field has a multiplicity
	 */
	private boolean multiplicity;
	
	/**
	 * List of {@link JunitAssertion}s checking the field
	 */
	private ArrayList<JunitAssertion> assertions;
	
	/**
	 * Constructor with name, type, checkForOptional value and hasMultiplicity value.<br>
	 * Initializes the list of {@link JunitAssertion}s.
	 * 
	 * @param name the name of the field
	 * @param type the type of the field
	 * @param optional true, if the field is an Optional
	 * @param multiplicity true, if the field has a multiplicity
	 */
	public JunitFieldUnderTest(String name, String type, boolean optional, boolean multiplicity) {
		this.name = name;
		this.type = type;
		this.optional = optional;
		this.multiplicity = multiplicity;
		assertions = new ArrayList<>();
	}
	
	/**
	 * Adds a {@link JunitAssertion} to the list
	 * 
	 * @param assertion the {@link JunitAssertion} to be added to the list
	 */
	public void addAssertion(JunitAssertion assertion) {
		assertions.add(assertion);
	}
}
