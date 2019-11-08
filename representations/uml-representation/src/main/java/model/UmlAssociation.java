package model;

/**
 * Represents an association with the involved {@link UmlElement}s, the {@link UmlMultiplicityValue}s and determined by an {@link UmlAssociationType}
 * 
 * @author dschoenicke
 *
 */
public class UmlAssociation {

	/**
	 * The owning end of the association
	 * <b>Note:</b> If the association is not directed, the assignments of client and supplier are arbitrary
	 */
	private UmlElement client;
	
	/**
	 * The owned end of the association
	 * <b>Note:</b> If the association is not directed, the assignments of client and supplier are arbitrary
	 */
	private UmlElement supplier;
	
	/**
	 * The type of the association
	 */
	private UmlAssociationType type;
	
	/**
	 * The lower {@link UmlMultiplicityValue} of the association
	 */
	private UmlMultiplicityValue lowerValue;
	
	/**
	 * The upper {@link UmlMultiplicityValue} of the association
	 */
	private UmlMultiplicityValue upperValue;
	
	/**
	 * Constructor with client, supplier and type
	 * lowerValue and upperValue are set to {@literal UmlMultiplicityValue.ONE}
	 * 
	 * @param client the owning {@link UmlElement} of the association
	 * @param supplier the owned {@link UmlElement} of the association
	 * @param type the {@link UmlAssociationType} of the association
	 */
	public UmlAssociation(UmlElement client, UmlElement supplier, UmlAssociationType type) {
		this.client = client;
		this.supplier = supplier;
		this.type = type;
		this.lowerValue = this.upperValue = UmlMultiplicityValue.ONE;
	}
	
	/**
	 * Constructor with client, supplier, type, lower and upper multiplicity value
	 * 
	 * @param client the owning {@link UmlElement} of the association
	 * @param supplier the owned {@link UmlElement} of the association
	 * @param type the {@link UmlAssociationType} of the association
	 * @param lowerValue the lower {@link UmlMultiplicityValue} of the association
	 * @param upperValue the upper {@link UmlMultiplicityValue} of the association
	 */
	public UmlAssociation(UmlElement client, 
			UmlElement supplier, 
			UmlAssociationType type, 
			UmlMultiplicityValue lowerValue, 
			UmlMultiplicityValue upperValue) {
		this.client = client;
		this.supplier = supplier;
		this.type = type;
		this.lowerValue = lowerValue;
		this.upperValue = upperValue;
	}

	/**
	 * Gets the owning {@link UmlElement} of the association
	 * 
	 * @return the owning {@link UmlElement} of the association
	 */
	public UmlElement getClient() {
		return client;
	}

	/**
	 * Sets the owning {@link UmlElement} of the association
	 * 
	 * @param client the owning {@link UmlElement} of the association
	 */
	public void setClient(UmlElement client) {
		this.client = client;
	}

	/**
	 * Gets the owned {@link UmlElement} of the association
	 * 
	 * @return the owned {@link UmlElement} of the association
	 */
	public UmlElement getSupplier() {
		return supplier;
	}

	/**
	 * Sets the owned {@link UmlElement} of the association
	 * 
	 * @param supplier the owned {@link UmlElement} of the association
	 */
	public void setSupplier(UmlElement supplier) {
		this.supplier = supplier;
	}

	/**
	 * Gets the {@link UmlAssociationType} of the association
	 * 
	 * @return the {@link UmlAssociationType} of the association
	 */
	public UmlAssociationType getType() {
		return type;
	}

	/**
	 * Sets the {@link UmlAssociationType} of the association
	 * 
	 * @param type the {@link UmlAssociationType} of the association
	 */
	public void setType(UmlAssociationType type) {
		this.type = type;
	}

	/**
	 * Gets the lower {@link UmlMultiplicityValue} of the association
	 * 
	 * @return the lower {@link UmlMultiplicityValue} of the association
	 */
	public UmlMultiplicityValue getLowerValue() {
		return lowerValue;
	}

	/**
	 * Sets the lower {@link UmlMultiplicityValue} of the association
	 * 
	 * @param lowerValue the lower {@link UmlMultiplicityValue} of the association
	 */
	public void setLowerValue(UmlMultiplicityValue lowerValue) {
		this.lowerValue = lowerValue;
	}

	/**
	 * Gets the upper {@link UmlMultiplicityValue} of the association
	 * 
	 * @return the upper {@link UmlMultiplicityValue} of the association
	 */
	public UmlMultiplicityValue getUpperValue() {
		return upperValue;
	}

	/**
	 * Sets the upper {@link UmlMultiplicityValue} of the association
	 * 
	 * @param upperValue the upper {@link UmlMultiplicityValue} of the association
	 */
	public void setUpperValue(UmlMultiplicityValue upperValue) {
		this.upperValue = upperValue;
	}
}
