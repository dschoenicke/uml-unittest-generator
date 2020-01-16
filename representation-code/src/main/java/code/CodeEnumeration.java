package code;

import java.util.ArrayList;

import lombok.Getter;

/**
 * Class representing an enumeration, extending {@link CodeElement}, has a additional list of {@link CodeLiteral}s
 * 
 * @author dschoenicke
 *
 */
@Getter
public class CodeEnumeration extends CodeElement {

	/**
	 * List of {@link CodeLiteral}s
	 */
	private ArrayList<CodeLiteral> literals;
	
	/**
	 * Constructor with name, {@link CodeParent} and modifiers.<br>
	 * For further information see {@link CodeElement#CodeElement}
	 * Initializes the list of {@link CodeLiteral}s
	 * 
	 * @param name the name of the enumeration
	 * @param parent the {@link CodeParent} of the enumeration
	 * @param modifiers the modifier value of the class
	 */
	public CodeEnumeration(String name, 
			CodeParent parent,
			int modifiers) {
		
		super(name, parent, modifiers);
		literals = new ArrayList<>();
	}
	
	/**
	 * Adds a {@link CodeLiteral} to the list
	 * 
	 * @param literal the {@link CodeLiteral} to add to the list
	 */
	public void addCodeLiteral(CodeLiteral literal) {
		literals.add(literal);
	}
}
