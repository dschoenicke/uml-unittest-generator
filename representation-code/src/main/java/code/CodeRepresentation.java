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
	 * The name of the representation
	 */
	private String name;
	
	/**
	 * The list of all {@link CodePackage}s of the model
	 */
	private ArrayList<CodePackage> packages;
	
	/**
	 * Constructor with name, initializes the list of {@link CodePackage}s
	 * 
	 * @param name the name of the representation
	 */
	public CodeRepresentation(String name) {
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
