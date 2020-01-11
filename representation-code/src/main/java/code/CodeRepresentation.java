package code;

import java.util.ArrayList;

import lombok.Getter;

/**
 * Root element of the code representation, has a list of {@link CodePackage}s which contain all of the elements.
 * 
 * @author dschoenicke
 *
 */
@Getter
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
	 * Adds a {@link CodePackage} to the list
	 * 
	 * @param codePackage the {@link CodePackage} to add to the list
	 */
	public void addPackage(CodePackage codePackage) {
		packages.add(codePackage);
	}
	
	/**
	 * Returns a list of all {@link CodePackage}s regardless of their hierarchy
	 * 
	 * @return a list of all {@link CodePackage}s
	 */
	public ArrayList<CodePackage> getPackagesAsList() {
		ArrayList<CodePackage> ownedPackages = new ArrayList<>();
		
		for (CodePackage codePackage : getPackages()) {
			ownedPackages.add(codePackage);
			ownedPackages.addAll(codePackage.getPackagesAsList());
		}
		
		return ownedPackages;
	}
	
	/**
	 * Returns a list of all {@link CodeElement}s regardless of their hierarchy
	 * 
	 * @return a list of all {@link CodeElement}s
	 */
	public ArrayList<CodeElement> getElementsAsList() {
		ArrayList<CodeElement> ownedElements = new ArrayList<>();
		
		for (CodePackage codePackage : getPackagesAsList()) {
			ownedElements.addAll(codePackage.getElements());
		}
		
		return ownedElements;
	}
}
