package code;

/**
 * Represents a field of a {@link CodeElement}
 * 
 * @author dschoenicke
 *
 */
public class CodeField {
	
	/**
	 * The name of the field
	 */
	private String name;
	
	/**
	 * The data type of the field
	 */
	private String type;
	
	/**
	 * An integer representing the {@link CodeModifier} determining the fields modifiers
	 */
	private int modifiers;
	
	/**
	 * The default value of the field
	 */
	private String defaultValue;
	
	/**
	 * Determines whether the field is allowed to be {@literal null}
	 */
	private boolean canBeNull;
	
	/**
	 * Determines whether the field has a multiplicity
	 */
	private boolean hasMultiplicity;
	
	/**
	 * The {@link CodeParent} of the field
	 */
	private CodeParent parent;
	
	/**
	 * Constructor with name, {@link CodeParent}, data type, default value, values whether the field can be null or has a multiplicity and modifiers<br>
	 * The modifiers are converted to an int value usable for the {@link CodeModifier} methods.<br>
	 * 
	 * @param name the name of the field
	 * @param parent the {@link CodeParent} of the field
	 * @param type the data type of the field
	 * @param defaultValue the default value of the field
	 * @param canBeNull true if the field can be {@literal null}
	 * @param hasMultiplicity true if the field has a multiplicity
	 * @param visibility the {@link CodeVisibility} value representing the access modifier of the field
	 * @param isStatic determines whether the field is static
	 * @param isFinal determines whether the field is final
	 */
	public CodeField(String name, 
			CodeParent parent,
			String type,
			String defaultValue,
			boolean canBeNull,
			boolean hasMultiplicity,
			CodeVisibility visibility,
			boolean isStatic,
			boolean isFinal) {
		
		this.name = name;
		this.type = type;
		this.parent = parent;
		this.defaultValue = defaultValue;
		this.canBeNull = canBeNull;
		this.hasMultiplicity = hasMultiplicity;
		this.modifiers = CodeModifier.convertModifierValue(visibility, isStatic, isFinal, false);
	}

	/**
	 * Gets the name of the field
	 * 
	 * @return the name of the field
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the field
	 * 
	 * @param name the name of the field
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the type of the field
	 * 
	 * @return the type of the field
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the data type of the field
	 * 
	 * @param type the data type of the field
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the int value representing the {@link CodeModifier}s of the field
	 * 
	 * @return the int value representing the {@link CodeModifier}s of the field
	 */
	public int getModifiers() {
		return modifiers;
	}

	/**
	 * Sets the modifiers value of the field
	 * 
	 * @param modifiers the modifiers field
	 */
	public void setModifiers(int modifiers) {
		this.modifiers = modifiers;
	}

	/**
	 * Gets the default value of the field
	 * 
	 * @return the default value of the field
	 */
	public String getDefaultValue() {
		return defaultValue;
	}

	/**
	 * Sets the default value of the field
	 * 
	 * @param defaultValue the default value of the field
	 */
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	/**
	 * Returns true, if the field can be {@literal null}
	 * 
	 * @return true, if the field can be {@literal null}
	 */
	public boolean canBeNull() {
		return canBeNull;
	}

	/**
	 * Sets the value determining whether the field can be null
	 * 
	 * @param canBeNull the value determining whether the field can be {@literal null}
	 */
	public void setCanBeNull(boolean canBeNull) {
		this.canBeNull = canBeNull;
	}

	/**
	 * Returns true, if the field has a multiplicity
	 * 
	 * @return true, if the field has a multiplicity
	 */
	public boolean hasMultiplicity() {
		return hasMultiplicity;
	}

	/**
	 * Sets the value determining whether the field can have a multiplicity
	 * 
	 * @param hasMultiplicity the value determining whether the field can have a multiplicity
	 */
	public void setHasMultiplicity(boolean hasMultiplicity) {
		this.hasMultiplicity = hasMultiplicity;
	}

	/**
	 * Gets the {@link CodeParent} of the field
	 * 
	 * @return the {@link CodeParent} of the field
	 */
	public CodeParent getParent() {
		return parent;
	}

	/**
	 * The {@link CodeParent} element of the field
	 * 
	 * @param parent the {@link CodeParent} of the field
	 */
	public void setParent(CodeParent parent) {
		this.parent = parent;
	}
}
