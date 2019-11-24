package code;

import java.util.ArrayList;

/**
 * Root element of the code representation, has a list of {@link CodePackage}s which contain all of the elements.
 * 
 * @author dschoenicke
 *
 */
public class CodeRepresentation implements CodeParent {
	
	/**
	 * The list of all {@link CodePackage}s of the model
	 */
	private ArrayList<CodePackage> packages;
	
	/**
	 * Default constructor, initializes the list of {@link CodePackage}s
	 */
	public CodeRepresentation() {
		packages = new ArrayList<>();
	}
	
	/**
	 * Gets the list of all top level {@link CodePackage}s
	 * 
	 * @return the list of all top level {@link CodePackage}s
	 */
	public ArrayList<CodePackage> getPackages() {
		return packages;
	}
	
	/**
	 * Adds a {@link CodePackage} to the list
	 * 
	 * @param codePackage the {@link CodePackage} to add to the list
	 */
	public void addPackage(CodePackage codePackage) {
		packages.add(codePackage);
	}
}
