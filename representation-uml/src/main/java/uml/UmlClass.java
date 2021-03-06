package uml;

import lombok.Getter;

/**
 * Represents a class
 * 
 * @author dschoenicke
 *
 */
@Getter
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
}
