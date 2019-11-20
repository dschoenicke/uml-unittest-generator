package model;

/**
 * Represents an relationship with the involved {@link UmlElement}s, the {@link UmlMultiplicityValue}s and determined by an {@link UmlRelationshipType}
 * 
 * @author dschoenicke
 *
 */
public class UmlRelationship {

	/**
	 * The owning end of the relationship
	 * <b>Note:</b> If the relationship is not directed, the assignments of client and supplier are arbitrary
	 */
	private UmlElement client;
	
	/**
	 * The owned end of the relationship
	 * <b>Note:</b> If the relationship is not directed, the assignments of client and supplier are arbitrary
	 */
	private UmlElement supplier;
	
	/**
	 * The type of the relationship
	 */
	private UmlRelationshipType type;
	
	/**
	 * Constructor with client, supplier and type
	 * lowerValue and upperValue are set to {@literal UmlMultiplicityValue.ONE}
	 * 
	 * @param client the owning {@link UmlElement} of the relationship
	 * @param supplier the owned {@link UmlElement} of the relationship
	 * @param type the {@link UmlRelationshipType} of the relationship
	 */
	public UmlRelationship(UmlElement client, UmlElement supplier, UmlRelationshipType type) {
		this.client = client;
		this.supplier = supplier;
		this.type = type;
	}
	
	/**
	 * Gets the owning {@link UmlElement} of the relationship
	 * 
	 * @return the owning {@link UmlElement} of the relationship
	 */
	public UmlElement getClient() {
		return client;
	}

	/**
	 * Sets the owning {@link UmlElement} of the relationship
	 * 
	 * @param client the owning {@link UmlElement} of the relationship
	 */
	public void setClient(UmlElement client) {
		this.client = client;
	}

	/**
	 * Gets the owned {@link UmlElement} of the relationship
	 * 
	 * @return the owned {@link UmlElement} of the relationship
	 */
	public UmlElement getSupplier() {
		return supplier;
	}

	/**
	 * Sets the owned {@link UmlElement} of the relationship
	 * 
	 * @param supplier the owned {@link UmlElement} of the relationship
	 */
	public void setSupplier(UmlElement supplier) {
		this.supplier = supplier;
	}

	/**
	 * Gets the {@link UmlRelationshipType} of the relationship
	 * 
	 * @return the {@link UmlRelationshipType} of the relationship
	 */
	public UmlRelationshipType getType() {
		return type;
	}

	/**
	 * Sets the {@link UmlRelationshipType} of the relationship
	 * 
	 * @param type the {@link UmlRelationshipType} of the relationship
	 */
	public void setType(UmlRelationshipType type) {
		this.type = type;
	}
}
