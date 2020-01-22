package uml;

import lombok.Getter;

/**
 * Represents an interface
 * 
 * @author dschoenicke
 *
 */
@Getter
public class UmlInterface extends UmlElement {

	/**
	 * Determines whether the interface is abstract
	 */
	private boolean isAbstract;
	
	/**
	 * Constructor with name and visibility
	 *  
	 * @param name the name of the interface
	 * @param visibility the {@link UmlVisibility} of the interface
	 */
	public UmlInterface(String name, UmlVisibility visibility) {
		super(name, visibility, false);
	}
	
	/**
	 * Constructor with name, visibility and the abstract classifier
	 *  
	 * @param name the name of the interface
	 * @param visibility the {@link UmlVisibility} of the interface
	 * @param isAbstract true if the interface is abstract
	 */
	public UmlInterface(String name, UmlVisibility visibility, boolean isAbstract) {
		super(name, visibility, false);
		this.isAbstract = isAbstract;
	}
}
