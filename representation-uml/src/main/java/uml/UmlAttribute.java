package uml;

/**
 * Represents an attribute of an {@link UmlClass}
 * 
 * @author dschoenicke
 *
 */
public class UmlAttribute {

	/**
	 * The name of the attribute
	 */
	private String name;
	
	/**
	 * The {@link UmlVisibility} of the attribute
	 */
	private UmlVisibility visibility;
	
	/**
	 * The data type of the attribute
	 */
	private String type;
	
	/**
	 * Determines whether the attribute is static
	 */
	private boolean isStatic;
	
	/**
	 * Determines whether the attribute is final
	 */
	private boolean isFinal;
	
	/**
	 * The default value of the attribute
	 */
	private String defaultValue;
	
	/**
	 * The lower {@link UmlMultiplicityValue} of the attribute
	 */
	private UmlMultiplicityValue lowerValue;
	
	/**
	 * The upper {@link UmlMultiplicityValue} of the attribute, cannot be {@literal UmlMultiplicityValue.ZERO}
	 */
	private UmlMultiplicityValue upperValue;
	
	/**
	 * Constructor with name, visibility and type
	 * lowerValue and upperValue are set to {@literal UmlMultiplicityValue.ONE}
	 * 
	 * @param name the name of the attribute
	 * @param visibility the {@link UmlVisibility} of the attribute
	 * @param type the data type of the attribute
	 */
	public UmlAttribute(String name, UmlVisibility visibility, String type) {
		this.name = name;
		this.visibility = visibility;
		this.type = type;
		this.lowerValue = this.upperValue = UmlMultiplicityValue.ONE;
	}
	
	/**
	 * Constructor with name, visibility, type, static- and final classifiers, default value and multiplicity values
	 * 
	 * @param name the name of the attribute
	 * @param visibility the {@link UmlVisibility} of the attribute
	 * @param type the data type of the attribute
	 * @param isStatic true if the attribute is static
	 * @param isFinal true if the attribute is final
	 * @param defaultValue the default value of the attribute
	 * @param lowerValue the lower multiplicity value
	 * @param upperValue the upper multiplicity value
	 */
	public UmlAttribute(String name, 
			UmlVisibility visibility, 
			String type, 
			boolean isStatic, 
			boolean isFinal, 
			String defaultValue,
			UmlMultiplicityValue lowerValue, 
			UmlMultiplicityValue upperValue) {
		
		this.name = name;
		this.visibility = visibility;
		this.type = type;
		this.isStatic = isStatic;
		this.isFinal = isFinal;
		this.defaultValue = defaultValue;
		this.lowerValue = lowerValue;
		this.upperValue = upperValue;
	}

	/**
	 * Gets the name of the attribute
	 * 
	 * @return the name of the attribute
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the attribute
	 * 
	 * @param name the name of the attribute
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the {@link UmlVisibility} of the attribute
	 * 
	 * @return the {@link UmlVisibility} of the attribute
	 */
	public UmlVisibility getVisibility() {
		return visibility;
	}

	/**
	 * Sets the {@link UmlVisibility} of the attribute
	 * 
	 * @param visibility the {@link UmlVisibility} of the attribute
	 */
	public void setVisibility(UmlVisibility visibility) {
		this.visibility = visibility;
	}

	/**
	 * Gets the data type of the attribute
	 * 
	 * @return the data type of the attribute
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the data type of the attribute
	 * 
	 * @param type the data type of the attribute
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Returns true if the attribute is static
	 * 
	 * @return true if the attribute is static
	 */
	public boolean isStatic() {
		return isStatic;
	}

	/**
	 * Sets the static value
	 * 
	 * @param isStatic the static value
	 */
	public void setStatic(boolean isStatic) {
		this.isStatic = isStatic;
	}

	/**
	 * Returns true if the attribute is final
	 * 
	 * @return true if the attribute is final
	 */
	public boolean isFinal() {
		return isFinal;
	}

	/**
	 * Sets the final value
	 * 
	 * @param isFinal the final value
	 */
	public void setFinal(boolean isFinal) {
		this.isFinal = isFinal;
	}

	/**
	 * Gets the default value of the attribute
	 * 
	 * @return the default value of the attribute
	 */
	public String getDefaultValue() {
		return defaultValue;
	}

	/**
	 * Sets the default value of the attribute
	 * 
	 * @param defaultValue the default value of the attribute
	 */
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	/**
	 * Gets the lower {@link UmlMultiplicityValue} of the attribute
	 * 
	 * @return the lower {@link UmlMultiplicityValue} of the attribute
	 */
	public UmlMultiplicityValue getLowerValue() {
		return lowerValue;
	}

	/**
	 * Sets the lower {@link UmlMultiplicityValue} of the attribute
	 * 
	 * @param lowerValue the lower {@link UmlMultiplicityValue} of the attribute
	 */
	public void setLowerValue(UmlMultiplicityValue lowerValue) {
		this.lowerValue = lowerValue;
	}

	/**
	 * Gets the upper {@link UmlMultiplicityValue} of the attribute
	 * 
	 * @return the upper {@link UmlMultiplicityValue} of the attribute
	 */
	public UmlMultiplicityValue getUpperValue() {
		return upperValue;
	}

	/**
	 * Sets the upper {@link UmlMultiplicityValue} of the attribute
	 * 
	 * @param upperValue the upper {@link UmlMultiplicityValue} of the attribute
	 */
	public void setUpperValue(UmlMultiplicityValue upperValue) {
		this.upperValue = upperValue;
	}
}
