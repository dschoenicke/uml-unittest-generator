package junit;

import java.util.ArrayList;

import lombok.Getter;

@Getter
public class JunitTemplateParameterUnderTest {

	/**
	 * The name of the template parameter
	 */
	private String name;
	
	/**
	 * The type of the template parameter
	 */
	private String boundedType;
	
	/**
	 * List of {@link JunitAssertion}s checking the field
	 */
	private ArrayList<JunitAssertion> assertions;
	
	/**
	 * Constructor with name and bounded type.<br>
	 * Initializes the list of {@link JunitAssertion}s.
	 * 
	 * @param name the name of the template Parameter
	 * @param boundedType the bounded type of the template parameter
	 */
	public JunitTemplateParameterUnderTest(String name, String boundedType) {
		this.name = name;
		this.boundedType = boundedType;
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
