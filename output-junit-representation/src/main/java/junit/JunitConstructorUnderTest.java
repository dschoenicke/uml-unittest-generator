package junit;

import java.util.ArrayList;

import lombok.Getter;

@Getter
public class JunitConstructorUnderTest {

	/**
	 * String representing the list of parameter type classes of the constructor
	 */
	private String parameterTypeClasses;
	
	/**
	 * The list of {@link JunitParameterUnderTest} of the constructor
	 */
	private ArrayList<JunitParameterUnderTest> parameters;
	
	/**
	 * The list of {@link JunitAssertion}s of the constructor
	 */
	private ArrayList<JunitAssertion> assertions;
	
	/**
	 * Constructor with parameter type classes, initializes the list of {@link JunitParameterUnderTest} and {@link JunitAssertion}s
	 * 
	 * @param parameterTypeClasses the parameter type classes of the constructor
	 */
	public JunitConstructorUnderTest(String parameterTypeClasses) {
		this.parameterTypeClasses = parameterTypeClasses;
		parameters = new ArrayList<>();
		assertions = new ArrayList<>();
	}
	
	/**
	 * Adds a {@link JunitParameterUnderTest} to the list
	 * 
	 * @param parameter the {@link JunitParameterUnderTest} to be added to the list
	 */
	public void addParameter(JunitParameterUnderTest parameter) {
		parameters.add(parameter);
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
