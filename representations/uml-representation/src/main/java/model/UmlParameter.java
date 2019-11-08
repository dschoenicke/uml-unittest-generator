package model;

/**
 * Represents a parameter of an {@link UmlOperation}
 * 
 * @author dschoenicke
 *
 */
public class UmlParameter {

	/**
	 * The name of the parameter
	 */
	private String name;
	
	/**
	 * The {@link UmlVisibility} of the parameter
	 */
	private UmlVisibility visibility;
	
	/**
	 * The data type of the parameter
	 */
	private String type;
	
	/**
	 * The {@link UmlParameterDirection} of the parameter
	 */
	private UmlParameterDirection direction;
	
	/**
	 * Determines whether the parameter is final
	 */
	private boolean isFinal;
	
	/**
	 * The lower {@link UmlMultiplicityValue} of the attribute
	 */
	private UmlMultiplicityValue lowerValue;
	
	/**
	 * The upper {@link UmlMultiplicityValue} of the attribute, cannot be {@literal UmlMultiplicityValue.ZERO}
	 */
	private UmlMultiplicityValue upperValue;
	
	/**
	 * Constructor with name, visibility, type, direction and final classifier
	 * lowerValue and upperValue are set to {@literal UmlMultiplicityValue.ONE}
	 * 
	 * @param name the name of the parameter
	 * @param visibility the {@link UmlVisibility} of the parameter
	 * @param type the data type of the parameter
	 * @param direction the {@link UmlParameterDirection} of the parameter
	 * @param isFinal true if the parameter is final
	 */
	public UmlParameter(String name, 
			UmlVisibility visibility,
			String type,
			UmlParameterDirection direction,
			boolean isFinal) {
		
		this.name = name;
		this.visibility = visibility;
		this.type = type;
		this.direction = direction;
		this.isFinal = isFinal;
		this.lowerValue = this.upperValue = UmlMultiplicityValue.ONE;
	}
	
	/**
	 * Constructor with name, visibility, type, direction, final classifier and mulitplicity values
	 * 
	 * @param name the name of the parameter
	 * @param visibility the {@link UmlVisibility} of the parameter
	 * @param type the data type of the parameter
	 * @param direction the {@link UmlParameterDirection} of the parameter
	 * @param isFinal true if the parameter is final
	 * @param lowerValue the lower {@link UmlMultiplicityValue}
	 * @param uppperValue the upper {@link UmlMultiplicityValue}
	 */
	public UmlParameter(String name, 
			UmlVisibility visibility,
			String type,
			UmlParameterDirection direction,
			boolean isFinal,
			UmlMultiplicityValue lowerValue,
			UmlMultiplicityValue upperValue) {
		
		this.name = name;
		this.visibility = visibility;
		this.type = type;
		this.direction = direction;
		this.isFinal = isFinal;
		this.lowerValue = lowerValue;
		this.upperValue = upperValue;
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
	 * Gets the {@link UmlVisibility} of the parameter
	 * 
	 * @return the {@link UmlVisibility} of the parameter
	 */
	public UmlVisibility getVisibility() {
		return visibility;
	}

	/**
	 * Sets the {@link UmlVisibility} of the parameter
	 * 
	 * @param the {@link UmlVisibility} of the parameter
	 */
	public void setVisibility(UmlVisibility visibility) {
		this.visibility = visibility;
	}

	/**
	 * Gets the data type of the parameter
	 * 
	 * @return the data type of the parameter
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
	 * Gets the {@link UmlParameterDirection} of the parameter
	 * 
	 * @return the {@link UmlParameterDirection} of the parameter
	 */
	public UmlParameterDirection getDirection() {
		return direction;
	}

	/**
	 * Sets the {@link UmlParameterDirection} of the parameter
	 * 
	 * @param direction the {@link UmlParameterDirection} of the parameter
	 */
	public void setDirection(UmlParameterDirection direction) {
		this.direction = direction;
	}

	/**
	 * Returns true if the parameter is final
	 * 
	 * @return true if the parameter is final
	 */
	public boolean isFinal() {
		return isFinal;
	}

	/**
	 * Determines whether the parameter is final
	 * 
	 * @param isFinal true if the parameter is final
	 */
	public void setFinal(boolean isFinal) {
		this.isFinal = isFinal;
	}

	/**
	 * Gets the lower {@link UmlMultiplicityValue} of the parameter
	 * 
	 * @return the lower {@link MultiplicityValue} of the parameter
	 */
	public UmlMultiplicityValue getLowerValue() {
		return lowerValue;
	}

	/**
	 * Sets the lower {@link UmlMultiplicityValue} of the parameter
	 * 
	 * @param lowerValue the lower {@link MultiplicityValue} of the parameter
	 */
	public void setLowerValue(UmlMultiplicityValue lowerValue) {
		this.lowerValue = lowerValue;
	}

	/**
	 * Gets the upper {@link UmlMultiplicityValue} of the parameter
	 * 
	 * @return the upper {@link MultiplicityValue} of the parameter
	 */
	public UmlMultiplicityValue getUpperValue() {
		return upperValue;
	}

	/**
	 * Sets the upper {@link UmlMultiplicityValue} of the parameter
	 * 
	 * @param upperValue the upper {@link MultiplicityValue} of the parameter
	 */
	public void setUpperValue(UmlMultiplicityValue upperValue) {
		this.upperValue = upperValue;
	}
}
