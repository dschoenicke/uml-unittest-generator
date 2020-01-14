package junit;

import java.util.ArrayList;

import lombok.Getter;

/**
 * Represents the junit representation which is used to fill the mustache template
 * 
 * @author dschoenicke
 *
 */
@Getter
public class JunitRepresentation implements JunitParent {

	/**
	 * The name of the representation
	 */
	private String name;
	
	/**
	 * List of {@link JunitPackage}s of the representation
	 */
	private ArrayList<JunitPackage> packages;
	
	/**
	 * Constructor with name, initializes the list of {@link JunitPackage}s
	 * 
	 * @param name the name of the representation
	 */
	public JunitRepresentation(String name) {
		this.name = name;
		packages = new ArrayList<>();
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
	 * Gets all {@link JunitTestClass}es of the representation, regardless of their hierarchy
	 * 
	 * @return all {@link JunitTestClass}es of the representation, regardless of their hierarchy
	 */
	public ArrayList<JunitTestClass> getTestClassesAsList() {
		ArrayList<JunitTestClass> ownedTestClasses = new ArrayList<>();
		
		for (JunitPackage subPackage : this.getPackages()) {
			ownedTestClasses.addAll(subPackage.getTestClassesAsList());
		}
		
		return ownedTestClasses;
	}
}
