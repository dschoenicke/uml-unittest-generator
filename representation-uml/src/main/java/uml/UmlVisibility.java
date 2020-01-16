package uml;

/**
 * Enumeration to determine the visibility of {@link UmlElement}s, {@link UmlOperation}s and {@link UmlAttribute}s
 * 
 * @author dschoenicke
 *
 */
public enum UmlVisibility {
	PACKAGE(0),
	PUBLIC(1),
	PRIVATE(2),
	PROTECTED(4);
	
	/**
	 * The int value representing the literals
	 */
	public final int value;
	
	/**
	 * Constructor setting the value of a literal
	 * 
	 * @param value the value of the literal
	 */
	private UmlVisibility(final int value) {
		this.value = value;
	}
}
