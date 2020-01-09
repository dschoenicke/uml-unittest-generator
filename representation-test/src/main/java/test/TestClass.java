package test;

import test.testobjects.ClassUnderTest;

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
	 * The {@link test.testobjects.ClassUnderTest} which this test class contains the tests for.
	 */
	private ClassUnderTest classUnderTest;
	
	/**
	 * Constructor with name and parent {@link TestPackage}, initializes the list of {@link TestMethod}s
	 * 
	 * @param name the name of the test class
	 * @param parent the {@link TestPackage} containing the test class
	 */
	public TestClass(String name, TestPackage parent) {
		this.name = name;
		this.parent = parent;
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
	 * Gets the {@link test.testobjects.ClassUnderTest} which this test class contains the tests for.
	 * 
	 * @return the {@link test.testobjects.ClassUnderTest} which this test class contains the tests for.
	 */
	public ClassUnderTest getClassUnderTest() {
		return classUnderTest;
	}
	
	/**
	 * Sets the {@link test.testobjects.ClassUnderTest} which this test class contains the tests for.
	 * 
	 * @param classUnderTest the {@link test.testobjects.ClassUnderTest} which this test class contains the tests for.
	 */
	public void setClassUnderTest(ClassUnderTest classUnderTest) {
		this.classUnderTest = classUnderTest;
	}
	
	/**
	 * Gets the qualified name of the test class
	 * 
	 * @return the qualified name of the test class
	 */
	public String getQualifiedName() {
		return this.parent.getQualifiedName() + "." + this.name;
	}
}
