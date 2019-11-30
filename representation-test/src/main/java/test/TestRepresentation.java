package test;

import java.util.ArrayList;

/**
 * Represents the root class of the test representation which has the project name as name and a list of {@link TestPackage}s.
 * 
 * @author dscho
 *
 */
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
	* Gets the name of the representation
	* 
	* @return the name of the representation
	*/
	public String getName() {
		return name;
	}
	   
	/**
	* Sets the name of the representation
	* 
	* @param name the name of the representation
	*/
	public void setName(String name) {
		this.name = name;
	}
	   
	/**
	* Gets the list of {@link TestPackage}s
	* 
	* @return the list of {@link TestPackage}s
	*/
	public ArrayList<TestPackage> getPackages() {
		return packages;
	}
	   
	/**
	* Adds a {@link TestPackage} to the list
	* 
	* @param testPackage the {@link TestPackage} to be added to the list
	*/ 
	public void addPackage(TestPackage testPackage) {
		packages.add(testPackage);
	}
}
