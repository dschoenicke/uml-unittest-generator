package code;

import java.util.ArrayList;

/**
 * Class representing an interface, extending {@link CodeElement}
 * 
 * @author dschoenicke
 *
 */
public class CodeInterface extends CodeElement {

	/**
	 * The list of {@link CodeInterface}s extended by this interface
	 */
	private ArrayList<CodeInterface> superInterfaces;
	
	/**
	 * Constructor with name, {@link CodeParent} and modifiers.<br>
	 * For further information see {@link CodeElement#CodeElement}
	 * Initializes the list of super interfaces
	 * 
	 * @param name the name of the interface
	 * @param parent the {@link CodeParent} of the interface
	 * @param visibility the {@link CodeVisibility} value representing the access modifier of the interface
	 * @param isAbstract determines whether the interface is abstract
	 * @param isStatic determines whether the interface is static
	 * @param isFinal determines whether the interface is final
	 */
	public CodeInterface(String name, 
			CodeParent parent,
			CodeVisibility visibility, 
			boolean isAbstract, 
			boolean isStatic, 
			boolean isFinal) {
		
		super(name, parent, visibility, isAbstract, isStatic, isFinal);
		superInterfaces = new ArrayList<>();
	}	
	
	/**
	 * Gets the list of extended {@link CodeInterface}s
	 * 
	 * @return the list of extended {@link CodeInterface}s
	 */
	public ArrayList<CodeInterface> getInterfaces() {
		return superInterfaces;
	}
	
	/**
	 * Adds a extended {@link CodeInterface} to the list
	 * 
	 * @param codeInterface the extended {@link CodeInterface} to add to the list
	 */
	public void addInterface(CodeInterface codeInterface) {
		superInterfaces.add(codeInterface);
	}
}
