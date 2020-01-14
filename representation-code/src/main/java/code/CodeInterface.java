package code;

/**
 * Class representing an interface, extending {@link CodeElement}
 * 
 * @author dschoenicke
 *
 */
public class CodeInterface extends CodeElement {
	
	/**
	 * Constructor with name, {@link CodeParent} and modifiers.<br>
	 * For further information see {@link CodeElement#CodeElement}
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
	}
}
