package code;

import java.util.ArrayList;

/**
 * Class representing a class, extending {@link CodeElement}
 * 
 * @author dschoenicke
 *
 */
public class CodeClass extends CodeElement {

	/**
	 * The superclass of the class, can be {@literal null}
	 */
	private CodeClass superClass;
	
	/**
	 * The list of {@link CodeInterface}s implemented by this class
	 */
	private ArrayList<CodeInterface> interfaces;
	
	/**
	 * Constructor with name, {@link CodeParent} and modifiers.<br>
	 * For further information see {@link CodeElement#CodeElement}
	 * Initializes the list of {@link CodeInterface}s implemented by this class
	 * 
	 * @param name the name of the class
	 * @param parent the {@link CodeParent} of the class
	 * @param visibility the {@link CodeVisibility} value representing the access modifier of the class
	 * @param isAbstract determines whether the class is abstract
	 * @param isStatic determines whether the class is static
	 * @param isFinal determines whether the class is final
	 */
	public CodeClass(String name, 
			CodeParent parent,
			CodeVisibility visibility, 
			boolean isAbstract, 
			boolean isStatic, 
			boolean isFinal) {
		
		super(name, parent, visibility, isAbstract, isStatic, isFinal);
		interfaces = new ArrayList<>();
	}
	
	/**
	 * Gets the super class of the class
	 * 
	 * @return the super class of the class
	 */
	public CodeClass getSuperClass() {
		return superClass;
	}
	
	/**
	 * Sets the super class of the class
	 * 
	 * @param superClass the super class of the class
	 */
	public void setSuperClass(CodeClass superClass) {
		this.superClass = superClass;
	}
	
	/**
	 * Gets the list of implemented {@link CodeInterface}s
	 * 
	 * @return the list of implemented {@link CodeInterface}s
	 */
	public ArrayList<CodeInterface> getInterfaces() {
		return interfaces;
	}
	
	/**
	 * Adds a implemented {@link CodeInterface} to the list
	 * 
	 * @param codeInterface the implemented {@link CodeInterface} to add to the list
	 */
	public void addInterface(CodeInterface codeInterface) {
		interfaces.add(codeInterface);
	}
}
