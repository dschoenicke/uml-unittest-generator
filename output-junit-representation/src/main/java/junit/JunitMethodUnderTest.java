package junit;

import java.util.ArrayList;

import lombok.Getter;

@Getter
public class JunitMethodUnderTest {

	/**
	 * The name of the method
	 */
	private String methodName;
	
	/**
	 * The return type of the method
	 */
	private String returnType;
	
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
	 * Constructor with method name, return type and parameter type classes.<br>
	 * Initializes the list of {@link JunitParameterUnderTest} and {@link JunitAssertion}s
	 * 
	 * @param parameterTypeClasses
	 */
	public JunitMethodUnderTest(String methodName, String returnType, String parameterTypeClasses) {
		this.methodName = methodName;
		this.returnType = returnType;
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
