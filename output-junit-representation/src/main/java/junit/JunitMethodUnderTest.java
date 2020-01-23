package junit;

import java.util.ArrayList;
import java.util.List;

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
	 * String representing the list of parameter types of the constructor
	 */
	private String parameterTypes;
	
	/**
	 * String representing the list of parameter type classes of the constructor
	 */
	private String parameterTypeClasses;
	
	/**
	 * Determines whether the return type of the method can be {@literal null}
	 */
	private boolean optional;
	
	/**
	 * Determines whether the return type of the method has a multiplicity
	 */
	private boolean multiplicity;
	
	/**
	 * The list of {@link JunitParameterUnderTest} of the constructor
	 */
	private List<JunitParameterUnderTest> parameters;
	
	/**
	 * The list of {@link JunitAssertion}s of the constructor
	 */
	private List<JunitAssertion> assertions;
	
	/**
	 * Constructor with method name, return type, parameter type classes and parameter types.<br>
	 * Initializes the list of {@link JunitParameterUnderTest} and {@link JunitAssertion}s
	 * 
	 * @param methodName the name of the method
	 * @param returnType the return type of the method
	 * @param parameterTypeClasses the parameter type classes of the method
	 * @param parameterTypes the parameter types of the method
	 * @param optional true if the return type of the method can be {@literal null}
	 * @param multiplicity true if the return type of the method has a multiplicity
	 */
	public JunitMethodUnderTest(String methodName, String returnType, String parameterTypeClasses, String parameterTypes, boolean optional, boolean multiplicity) {
		this.methodName = methodName;
		this.returnType = returnType;
		this.parameterTypeClasses = parameterTypeClasses;
		this.parameterTypes = parameterTypes;
		this.optional = optional;
		this.multiplicity = multiplicity;
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
