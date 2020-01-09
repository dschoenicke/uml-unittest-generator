package test;

import java.util.ArrayList;

/**
 * Represents a method inside of a test class
 * 
 * @author dschoenicke
 *
 */
public class TestMethod {

	/**
	 * The name of the test method
	 */
	private String name;
	
	/**
	 * List of {@link TestAssertion}s which are checked in this method
	 */
	private ArrayList<TestAssertion> assertions;
	
	/**
	 * The parent {@link TestClass} which contains this method
	 */
	private TestClass parent;
	
	/**
	 * Constructor with name and parent {@link TestClass}, initializes the list of {@link TestAssertion}s
	 * 
	 * @param name the name of the method
	 * @param parent the parent {@link TestClass} of the method
	 */
	public TestMethod(String name, TestClass parent) {
		this.name = name;
		this.parent = parent;
		assertions = new ArrayList<>();
	}
	
	/**
	 * Gets the name of the method
	 * 
	 * @return the name of the method
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the method
	 * 
	 * @param name the name of the method
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the list of {@link TestAssertion}s to be checked in this method
	 * 
	 * @return the list of {@link TestAssertion}s to be checked in this method
	 */
	public ArrayList<TestAssertion> getAssertions() {
		return assertions;
	}
	
	/**
	 * Adds a {@link TestAssertion} to the list
	 * 
	 * @param assertion the {@link TestAssertion} to be added to the list
	 */
	public void addAssertion(TestAssertion assertion) {
		assertions.add(assertion);
	}
	
	/**
	 * Gets the parent {@link TestClass} which contains this method
	 * 
	 * @return the parent {@link TestClass} which contains this method
	 */
	public TestClass getParent() {
		return parent;
	}
	
	/**
	 * Sets the parent {@link TestClass} which contains this method
	 * 
	 * @param parent the parent {@link TestClass} which contains this method
	 */
	public void setParent(TestClass parent) {
		this.parent = parent;
	}
}
