package code;

import java.util.ArrayList;

import lombok.Getter;

/**
 * A package containing {@link CodeElement}s and other sub-{@link CodePackage}s
 * 
 * @author dschoenicke
 *
 */
@Getter
public class CodePackage implements CodeParent {
	
	/**
	 * The name of the package
	 */
	private String name;
	
	/**
	 * List of sub packages of the package
	 */
	private ArrayList<CodePackage> packages;
	
	/**
	 * List of {@link CodeElement}s of the package
	 */
	private ArrayList<CodeElement> elements;
	
	/**
	 * Reference to the {@link CodeParent} element of the package
	 */
	private CodeParent parent;
	
	/**
	 * Constructor with name and {@link CodeParent}, initializes the lists of {@link CodePackage}s and {@link CodeElement}s
	 * 
	 * @param name the name of the package
	 * @param parent the {@link CodeParent} of the package
	 */
	public CodePackage(String name, CodeParent parent) {
		packages = new ArrayList<>();
		elements = new ArrayList<>();
		this.name = name;
		this.parent = parent;
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
	 * Adds a {@link CodeElement} to the list
	 * 
	 * @param codeElement the {@link CodeElement} to add to the list
	 */
	public void addElement(CodeElement codeElement) {
		elements.add(codeElement);
	}
	
	/**
	 * Returns a list of all sub {@link CodePackage}s regardless of their hierarchy
	 * 
	 * @return a list of all sub {@link CodePackage}s
	 */
	public ArrayList<CodePackage> getPackagesAsList() {
		ArrayList<CodePackage> ownedpackages = new ArrayList<CodePackage>();
		
		for (CodePackage codePackage : this.getPackages()) {
			ownedpackages.add(codePackage);
			ownedpackages.addAll(codePackage.getPackagesAsList());
		}
		
		return ownedpackages;
	}
}
