package uml;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

/**
 * Represents an enumeration in a class diagramm
 * 
 * @author dschoenicke
 *
 */
@Getter
public class UmlEnumeration extends UmlElement {

	/**
	 * List of the enumeration's {@link UmlLiteral}s
	 */
	private List<UmlLiteral> literals;
	
	/**
	 * Default constructor, initializes the list of literals
	 * 
	 * @param name the name of the enumeration
	 * @param visibility the {@link UmlVisibility} of the enumeration
	 */
	public UmlEnumeration(String name, UmlVisibility visibility) {
		super(name, visibility, false);
		literals = new ArrayList<>();
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
