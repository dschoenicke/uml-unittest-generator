package test;

import java.util.ArrayList;

/**
 * Represents a package which contains several {@link TestClass}es
 * 
 * @author dschoenicke
 *
 */
public class TestPackage implements TestParent {

	/**
	 * The name of the package
	 */
	private String name;
	
	/**
	 * The parent element of the package
	 */
	private TestParent parent;
	
	/**
	 * The list of sub {@link TestPackage}s of the package
	 */
	private ArrayList<TestPackage> packages;
	
	/**
	 * The list of {@link TestClass}es of the package
	 */
	private ArrayList<TestClass> testClasses;
	
	/**
	 * Constructor with name and {@link TestParent}, initializes the list of {@link TestPackage}s and {@link TestClass}es.
	 * @param name the name of the package
	 * @param parent the {@link TestParent} of the package
	 */
	public TestPackage(String name, TestParent parent) {
		this.name = name;
		this.parent = parent;
		packages = new ArrayList<>();
		testClasses = new ArrayList<>();
	}
	
	/**
	 * Gets the name of the package
	 * 
	 * @return the name of the package
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the package
	 * 
	 * @param name the name of the package
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the qualified name of the package by creating it out of its name and the name of the parent elements
	 * 
	 * @return the qualified name of the package
	 */
	public String getQualifiedName() {
		if (this.parent instanceof TestRepresentation) {
			return this.parent.getName() + "." + this.name;
		}
		
		return ((TestPackage) this.parent).getQualifiedName() + "." + this.name;
	}
	
	/**
	 * Gets the {@link TestParent} of the package
	 * 
	 * @return the {@link TestParent} of the package
	 */
	public TestParent getParent() {
		return parent;
	}
	
	/**
	 * Sets the {@link TestParent} of the package
	 * 
	 * @param parent the {@link TestParent} of the package
	 */
	public void setParent(TestParent parent) {
		this.parent = parent;
	}
	
	/**
	 * Gets the list of {@link TestPackage}s of the package
	 * 
	 * @return the list of {@link TestPackage}s of the package
	 */
	public ArrayList<TestPackage> getPackages() {
		return packages;
	}
	
	/**
	 * Adds a {@link TestPackage} to the list
	 * 
	 * @param testPackage the {@link TestPackage} to add to the list
	 */
	public void addPackage(TestPackage testPackage) {
		packages.add(testPackage);
	}
	
	/**
	 * Gets the list of {@link TestClass}es of the package
	 * 
	 * @return the list of {@link TestClass}es of the package
	 */
	public ArrayList<TestClass> getTestClasses() {
		return testClasses;
	}
	
	/**
	 * Adds a {@link TestClass} to the list
	 * 
	 * @param testClass the {@link TestClass} to add to the list
	 */
	public void addTestClass(TestClass testClass) {
		testClasses.add(testClass);
	}
}
