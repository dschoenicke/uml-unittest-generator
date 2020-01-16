package code;

import lombok.Getter;
import lombok.Setter;

/**
 * Class representing a class, extending {@link CodeElement}
 * 
 * @author dschoenicke
 *
 */
@Getter
@Setter
public class CodeClass extends CodeElement {

	/**
	 * The superclass of the class, can be {@literal null}
	 */
	private CodeClass superClass;
	
	/**
	 * Constructor with name, {@link CodeParent} and modifiers.<br>
	 * For further information see {@link CodeElement#CodeElement}
	 * 
	 * @param name the name of the class
	 * @param parent the parent {@link CodeParent} of the class
	 * @param modifiers the modifier value of the class
	 */
	public CodeClass(String name, 
			CodeParent parent,
			int modifiers) {
		
		super(name, parent, modifiers);
	}
}
