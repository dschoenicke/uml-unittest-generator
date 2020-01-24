package junit;

import java.util.ArrayList;

import lombok.Getter;

/**
 * Represents a constructor with its {@link JunitParameterUnderTest}s to be tested in a {@link JunitTestClass}.
 * 
 * @author dschoenicke
 *
 */
@Getter
public class JunitConstructorUnderTest {

	/**
	 * String representing the list of parameter type classes of the constructor
	 */
	private String parameterTypeClasses;
	
	/**
	 * String representing the list of parameter types of the constructor
	 */
	private String parameterTypes;
	
	/**
	 * The list of {@link JunitParameterUnderTest} of the constructor
	 */
	private ArrayList<JunitParameterUnderTest> parameters;
	
	/**
	 * The list of {@link JunitAssertion}s of the constructor
	 */
	private ArrayList<JunitAssertion> assertions;
	
	/**
	 * Constructor with parameter type classes and parameter types, initializes the list of {@link JunitParameterUnderTest} and {@link JunitAssertion}s
	 * 
	 * @param parameterTypeClasses the parameter type classes of the constructor
	 * @param parameterTypes the parameter types of the constructor
	 */
	public JunitConstructorUnderTest(String parameterTypeClasses, String parameterTypes) {
		this.parameterTypeClasses = parameterTypeClasses;
		this.parameterTypes = parameterTypes;
		parameters = new ArrayList<>();
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
