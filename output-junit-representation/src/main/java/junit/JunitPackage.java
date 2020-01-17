package junit;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

/**
 * A package containing one or more {@link JunitTestClass}es.
 * 
 * @author dschoenicke
 *
 */
@Getter
public class JunitPackage implements JunitParent {

	/**
	 * The name of the package
	 */
	private String name;
	
	/**
	 * The parent element of the package
	 */
	private JunitParent parent;
	
	/**
	 * List of sub {@link JunitPackage}s
	 */
	private List<JunitPackage> packages;
	
	/**
	 * List of {@link JunitTestClass}es of the package
	 */
	private List<JunitTestClass> testClasses;
	
	/**
	 * Constructor with name and parent, initializes the list of sub {@link JunitPackage}s and {@link JunitTestClass}es.
	 * 
	 * @param name the name of the package
	 * @param parent the parent element of the package
	 */
	public JunitPackage(String name, JunitParent parent) {
		this.name = name;
		this.parent = parent;
		packages = new ArrayList<>();
		testClasses = new ArrayList<>();
	}
	
	/**
	 * Adds a {@link JunitPackage} to the list
	 * 
	 * @param junitPackage the {@link JunitPackage} to be added
	 */
	public void addPackage(JunitPackage junitPackage) {
		packages.add(junitPackage);
	}
	
	/**
	 * Adds a {@link JunitTestClass} to the list
	 * 
	 * @param testClass the {@link JunitTestClass} to be added
	 */
	public void addTestClass(JunitTestClass testClass) {
		testClasses.add(testClass);
	}
	
	/**
	 * Creates the qualified name of the package
	 * 
	 * @return the qualified name of the package
	 */
	public String getQualifiedName() {
		if (parent instanceof JunitPackage) {
			return ((JunitPackage) parent).getQualifiedName() + "." + name;
		}
		
		return name;
	}
	
	/**
	 * Gets all {@link JunitTestClass}es of the package and its sub packages.
	 * 
	 * @return all {@link JunitTestClass}es of the package and its sub packages.
	 */
	public List<JunitTestClass> getTestClassesAsList() {
		List<JunitTestClass> returnTestClasses = new ArrayList<>();
		returnTestClasses.addAll(this.getTestClasses());
		
		for (JunitPackage subPackage : this.getPackages()) {
			returnTestClasses.addAll(subPackage.getTestClassesAsList());
		}
		
		return returnTestClasses;
	}
}
