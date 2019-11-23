package uml;

import java.util.ArrayList;

/**
 * Represents an enumeration in a class diagramm
 * 
 * @author dschoenicke
 *
 */
public class UmlEnumeration extends UmlElement {

	/**
	 * List of the enumeration's {@link UmlLiteral}s
	 */
	private ArrayList<UmlLiteral> literals;
	
	/**
	 * Default constructor, instanciates the list of literals
	 * 
	 * @param name the name of the enumeration
	 * @param visibility the {@link UmlVisibility} of the enumeration
	 */
	public UmlEnumeration(String name, UmlVisibility visibility) {
		super(name, visibility);
		literals = new ArrayList<UmlLiteral>();
	}
	
	/**
	 * Constructor with a list of {@link UmlLiteral}s as parameter
	 * 
	 * @param name the name of the enumeration
	 * @param visibility the {@link UmlVisibility} of the enumeration
	 * @param literals the {@link UmlLiteral}s to set for the enumeration
	 */
	public UmlEnumeration(String name, UmlVisibility visibility, ArrayList<UmlLiteral> literals) {
		super(name, visibility);
		this.literals = literals;
	}
	
	/**
	 * Get the list of the enumeration's {@link UmlLiteral}s
	 * 
	 * @return the list of the {@link UmlLiteral}s
	 */
	public ArrayList<UmlLiteral> getLiterals() {
		return literals;
	}
	
	/**
	 * Adds an {@link UmlLiteral} to the list
	 * 
	 * @param umlLiteral the {@link UmlLiteral} to add to the list
	 */
	public void addUmlLiteral(UmlLiteral umlLiteral) {
		literals.add(umlLiteral);
	}
}
