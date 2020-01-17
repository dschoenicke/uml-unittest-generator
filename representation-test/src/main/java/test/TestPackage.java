package test;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

/**
 * Represents a package which contains several {@link TestClass}es
 * 
 * @author dschoenicke
 *
 */
@Getter
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
	private List<TestPackage> packages;
	
	/**
	 * The list of {@link TestClass}es of the package
	 */
	private List<TestClass> testClasses;
	
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
	 * Gets the qualified name of the package by creating it out of its name and the name of the parent elements
	 * 
	 * @return the qualified name of the package
	 */
	public String getQualifiedName() {
		if (this.parent instanceof TestRepresentation) {
			return this.name;
		}
		
		return ((TestPackage) this.parent).getQualifiedName() + "." + this.name;
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
	 * Adds a {@link TestClass} to the list
	 * 
	 * @param testClass the {@link TestClass} to add to the list
	 */
	public void addTestClass(TestClass testClass) {
		testClasses.add(testClass);
	}
	
	/**
	 * Gets all {@link TestClass}es of the package and its sub packages.
	 * 
	 * @return all {@link TestClass}es of the package and its sub packages.
	 */
	public List<TestClass> getTestClassesAsList() {
		List<TestClass> returnTestClasses = new ArrayList<>();
		returnTestClasses.addAll(this.getTestClasses());
		
		for (TestPackage subPackage : this.getPackages()) {
			returnTestClasses.addAll(subPackage.getTestClassesAsList());
		}
		
		return returnTestClasses;
	}
}
