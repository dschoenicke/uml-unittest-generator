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
	 * @param modifiers the modifier value of the class
	 */
	public CodeInterface(String name,
			CodeParent parent,
			int modifiers) {
		
		super(name, parent, modifiers);
	}
}
