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
	 * @param visibility the {@link CodeVisibility} value representing the access modifier of the enumeration
	 * @param isAbstract determines whether the enumeration is abstract
	 * @param isStatic determines whether the enumeration is static
	 * @param isFinal determines whether the enumeration is final
	 */
	public CodeEnumeration(String name, 
			CodeParent parent,
			CodeVisibility visibility, 
			boolean isAbstract, 
			boolean isStatic, 
			boolean isFinal) {
		
		super(name, parent, visibility, isAbstract, isStatic, isFinal);
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
