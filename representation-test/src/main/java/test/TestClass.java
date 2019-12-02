package test;

import java.util.ArrayList;

/**
 * Represents a test class, which contains reflection bases {@link TestMethod}s for its properties, fields, constructors and methods
 * 
 * @author dschoenicke
 *
 */
public class TestClass {

	/**
	 * The name of the test class
	 */
	private String name;
	
	/**
	 * The {@link TestPackage} containing this test class
	 */
	private TestPackage parent;
	
	/**
	 * The list of {@link TestMethod}s executed in this test class
	 */
	private ArrayList<TestMethod> methods;
	
	/**
	 * Constructor with name and parent {@link TestPackage}, initializes the list of {@link TestMethod}s
	 * 
	 * @param name the name of the test class
	 * @param parent the {@link TestPackage} containing the test class
	 */
	public TestClass(String name, TestPackage parent) {
		this.name = name;
		this.parent = parent;
		methods = new ArrayList<>();
	}

	/**
	 * Gets the name of the test class
	 * 
	 * @return the name of the test class
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the test class
	 * 
	 * @param name the name of the test class
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the parent {@link TestPackage} of the test class
	 * 
	 * @return the parent {@link TestPackage} of the test class
	 */
	public TestPackage getParent() {
		return parent;
	}

	/**
	 * Sets the parent {@link TestPackage} of the test class
	 * 
	 * @param parent the parent {@link TestPackage} of the test class
	 */
	public void setParent(TestPackage parent) {
		this.parent = parent;
	}

	/**
	 * Gets the list of {@link TestMethod}s of the test class
	 * 
	 * @return the list of {@link TestMethod}s of the test class
	 */
	public ArrayList<TestMethod> getMethods() {
		return methods;
	}

	/**
	 * Adds a {@link TestMethod} to the list
	 * 
	 * @param method the {@link TestMethod} to add to the list
	 */
	public void addMethod(TestMethod method) {
		methods.add(method);
	}
}
