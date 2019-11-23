package uml;

/**
 * Represents a class
 * 
 * @author dschoenicke
 *
 */
public class UmlClass extends UmlElement {
	/**
	 * Determines whether the class is final
	 */
	private boolean  isFinal;
	
	/**
	 * Determines whether the class is abstract
	 */
	private boolean  isAbstract;
	
	/**
	 * Constructor with name and visibility
	 * 
	 * @param name the name of the class
	 * @param visibility the {@link UmlVisibility} of the class, initializes the list for {@link UmlAttribute}s and {@link UmlOperation}s
	 */
	public UmlClass(String name, UmlVisibility visibility) {
		super(name, visibility);
	}
	
	/**
	 * Constructor with name, visibility and static-, final-, and abstract-classifiers
	 * 
	 * @param name the name of the class
	 * @param visibility the {@link UmlVisibility} of the class
	 * @param isStatic true if the class is static
	 * @param isFinal true if the class is final
	 * @param isAbstract true if the class is abstract
	 */
	public UmlClass(String name, UmlVisibility visibility, boolean isStatic, boolean isFinal, boolean isAbstract) {
		super(name, visibility, isStatic);
		this.isFinal = isFinal;
		this.isAbstract = isAbstract;
	}

	/**
	 * Returns true if the class is final
	 * 
	 * @return true if the class is final
	 */
	public boolean isFinal() {
		return isFinal;
	}

	/**
	 * Sets the final value
	 * 
	 * @param isFinal the final value
	 */
	public void setFinal(boolean isFinal) {
		this.isFinal = isFinal;
	}

	/**
	 * Returns true if the class is abstract
	 * 
	 * @return true if the class is abstract
	 */
	public boolean isAbstract() {
		return isAbstract;
	}

	/**
	 * Sets the abstract value
	 * 
	 * @param isAbstract the abstract value
	 */
	public void setAbstract(boolean isAbstract) {
		this.isAbstract = isAbstract;
	}
}
