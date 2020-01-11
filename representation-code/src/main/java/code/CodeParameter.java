package code;

/**
 * Represents a parameter of a {@link CodeMethod}
 * 
 * @author dschoenicke
 *
 */
public class CodeParameter {

	/**
	 * The name of the parameter
	 */
	private String name;
	
	/**
	 * The data type of the parameter
	 */
	private String type;
	
	/**
	 * An integer representing the {@link CodeModifier} determining the parameter's modifiers
	 */
	private int modifiers;
	
	/**
	 * Determines whether the parameter can be {@literal null}
	 */
	private boolean canBeNull;
	
	/**
	 * Determines whether the parameter has a multiplicity
	 */
	private boolean hasMultiplicity;
	
	/**
	 * The {@link CodeParent} of the parameter
	 */
	private CodeParent parent;
	
	/**
	 * Constructor with name, {@link CodeParent}, data type, values determining whether the parameter can be {@literal null} or has a multiplicity and modifiers<br>
	 * The modifiers are converted to an int value usable for the {@link CodeModifier} methods.<br>
	 * 
	 * @param name the name of the parameter
	 * @param parent the {@link CodeParent} of the parameter
	 * @param type the data type of the parameter
	 * @param canBeNull true if the parameter can be {@literal null}
	 * @param hasMultiplicity true if the parameter has a multiplicity
	 * @param isFinal determines whether the parameter is final
	 */
	public CodeParameter(String name, 
			CodeParent parent,
			String type,
			boolean canBeNull,
			boolean hasMultiplicity,
			boolean isFinal) {
		
		this.name = name;
		this.type = type;
		this.parent = parent;
		this.canBeNull = canBeNull;
		this.hasMultiplicity = hasMultiplicity;
		this.modifiers = CodeModifier.convertModifierValue(CodeVisibility.PACKAGE, false, isFinal, false);
	}
	
	/**
	 * Gets the name of the parameter
	 * 
	 * @return the name of the parameter
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the parameter
	 * 
	 * @param name the name of the parameter
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the type of the parameter
	 * 
	 * @return the type of the parameter
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the data type of the parameter
	 * 
	 * @param type the data type of the parameter
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the int value representing the {@link CodeModifier}s of the parameter
	 * 
	 * @return the int value representing the {@link CodeModifier}s of the parameter
	 */
	public int getModifiers() {
		return modifiers;
	}

	/**
	 * Sets the modifiers value of the parameter
	 * 
	 * @param modifiers the modifiers parameter
	 */
	public void setModifiers(int modifiers) {
		this.modifiers = modifiers;
	}

	/**
	 * Returns true, if the parameter has a multiplicity
	 * 
	 * @return true, if the parameter has a multiplicity
	 */
	public boolean hasMultiplicity() {
		return hasMultiplicity;
	}

	/**
	 * Sets the value determining whether the parameter can have a multiplicity
	 * 
	 * @param hasMultiplicity the value determining whether the parameter can have a multiplicity
	 */
	public void setHasMultiplicity(boolean hasMultiplicity) {
		this.hasMultiplicity = hasMultiplicity;
	}
	
	/**
	 * Returns true, if the parameter can be {@literal null}
	 * 
	 * @return true, if the parameter can be {@literal null}
	 */
	public boolean canBeNull() {
		return canBeNull;
	}

	/**
	 * Sets the value determining whether the parameter can be {@literal null}
	 * 
	 * @param canBeNull the value determining whether the parameter can be {@literal null}
	 */
	public void setCanBeNull(boolean canBeNull) {
		this.canBeNull = canBeNull;
	}

	/**
	 * Gets the {@link CodeParent} of the parameter
	 * 
	 * @return the {@link CodeParent} of the parameter
	 */
	public CodeParent getParent() {
		return parent;
	}

	/**
	 * The {@link CodeParent} element of the parameter
	 * 
	 * @param parent the {@link CodeParent} of the parameter
	 */
	public void setParent(CodeParent parent) {
		this.parent = parent;
	}
}
