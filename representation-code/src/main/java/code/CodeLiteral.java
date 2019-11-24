package code;

/**
 * Represents a literal of a {@link CodeEnumeration}
 * 
 * @author dschoenicke
 *
 */
public class CodeLiteral {

	/**
	 * The name of the literal
	 */
	private String name;
	
	/**
	 * The {@link CodeParent} of the literal
	 */
	private CodeParent parent;

	/**
	 * Constructor with name and {@link CodeParent}
	 * 
	 * @param name the name of the literal
	 * @param parent the {@link CodeParent} of the literal
	 */
	public CodeLiteral(String name, CodeParent parent) {
		super();
		this.name = name;
		this.parent = parent;
	}

	/**
	 * Gets the name of the literal
	 * 
	 * @return the name of the literal
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the literal
	 * 
	 * @param name the name of the literal
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the {@link CodeParent} of the literal
	 * 
	 * @return the {@link CodeParent} of the literal
	 */
	public CodeParent getParent() {
		return parent;
	}

	/**
	 * Sets the {@link CodeParent} of the literal
	 * 
	 * @param parent the {@link CodeParent} of the literal
	 */
	public void setParent(CodeParent parent) {
		this.parent = parent;
	}
}
