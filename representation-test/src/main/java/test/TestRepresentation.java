package test;

import java.util.ArrayList;

import lombok.Getter;

/**
 * Represents the root class of the test representation which has the project name as name and a list of {@link TestPackage}s.
 * 
 * @author dschoenicke
 *
 */
@Getter
public class TestRepresentation implements TestParent {
	/**
	 * 
	 */
	private String name;
   
	/**
	* List of {@link TestPackage}s of the representation
	*/
	private ArrayList<TestPackage> packages;
	   
	/**
	* Constructor with name, initializes the list of {@link TestPackage}s
	* 
	* @param name the name of the representation
	*/
	public TestRepresentation(String name) {
		this.name = name;
		packages = new ArrayList<>();
	}
	
	/**
	* Adds a {@link TestPackage} to the list
	* 
	* @param testPackage the {@link TestPackage} to be added to the list
	*/ 
	public void addPackage(TestPackage testPackage) {
		packages.add(testPackage);
	}
	
	/**
	 * Gets all {@link TestClass}es of the representation and its {@link TestPackages}.
	 * 
	 * @return all {@link TestClass}es of the representation and its {@link TestPackages}.
	 */
	public ArrayList<TestClass> getTestClassesAsList() {
		ArrayList<TestClass> returnTestClasses = new ArrayList<>();
		
		for (TestPackage subPackage : this.getPackages()) {
			returnTestClasses.addAll(subPackage.getTestClassesAsList());
		}
		
		return returnTestClasses;
	}
}
