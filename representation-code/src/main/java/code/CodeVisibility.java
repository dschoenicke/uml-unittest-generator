package code;

/**
 * Enumeration containing literals representing access modifiers. The int values of the literals are used
 * for the conversion to an int value usable for the {@link CodeModifier} methods.
 * 
 * @author dschoenicke
 *
 */
public enum CodeVisibility {

	DEFAULT(0),
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
	private CodeVisibility(final int value) {
		this.value = value;
	}
}
