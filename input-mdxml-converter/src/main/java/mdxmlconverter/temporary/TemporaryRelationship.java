package mdxmlconverter.temporary;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mdxml.MemberEnd;
import mdxml.OwnedEnd;
import uml.UmlRelationship;
import uml.UmlRelationshipType;

/**
 * Auxiliary class extending the {@link uml.UmlRelationship} with references to the client element and supplier element since the resolving of all references is only possible after all {@link uml.UmlElement}s have been converted
 * 
 * @author dschoenicke
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TemporaryRelationship extends UmlRelationship {

	/**
	 * Reference to the {@link mdxml.PackagedElement} which represents the client of the relationship
	 */
	private String clientId;
	
	/**
	 * Reference to the {@link mdxml.PackagedElement} which represents the supplier of the relationship
	 */
	private String supplierId;
	
	/**
	 * The first {@link mdxml.MemberEnd} of the relationship if it is an association
	 */
	private MemberEnd firstMember;
	
	/**
	 * The second {@link mdxml.MemberEnd} of the relationship if it is an association
	 */
	private MemberEnd secondMember;
	
	/**
	 * The {@link mdxml.OwnedEnd} of the relationship if it is an directed association
	 */
	private OwnedEnd ownedEnd;
	
	/**
	 * Default constructor
	 */
	public TemporaryRelationship() {
		super();
	}

	/**
	 * Constructor with references to client and supplier elements and an {@link uml.UmlRelationshipType} if the relationship is a generalization, interface realization or dependency
	 * 
	 * @param clientId the id of the {@link mdxml.PackagedElement} which represents the client of the relationship
	 * @param supplierId the {@link mdxml.PackagedElement} which represents the supplier of the relationship
	 * @param relationshipType the {@link uml.UmlRelationshipType} 
	 */
	public TemporaryRelationship(String clientId, String supplierId, UmlRelationshipType relationshipType) {
		super();
		this.clientId = clientId;
		this.supplierId = supplierId;
		this.setType(relationshipType);
	}
	
	/**
	 * Constructor with two {@link mdxml.MemberEnd} if the relationship is an undirected association
	 * 
	 * @param firstMember the first {@link mdxml.MemberEnd} referencing the {@link mdxml.OwnedAttribute} of the client element
	 * @param secondMember the second {@link mdxml.MemberEnd} referencing the {@link mdxml.OwnedAttribute} of the supplier element
	 */
	public TemporaryRelationship(MemberEnd firstMember, MemberEnd secondMember) {
		super();
		this.firstMember = firstMember;
		this.secondMember = secondMember;
	}
	
	/**
	 * Constructor with two {@link mdxml.MemberEnd} and and {@link OwnedEnd} if the relationship is a directed association
	 * 
	 * @param firstMember the first {@link mdxml.MemberEnd} referencing the {@link mdxml.OwnedAttribute} of the client element
	 * @param secondMember the second {@link mdxml.MemberEnd} referencing the {@link mdxml.OwnedAttribute} of the supplier element
	 * @param ownedEnd the {@link mdxml.OwnedEnd} referencing the client element
	 */
	public TemporaryRelationship(MemberEnd firstMember, MemberEnd secondMember, OwnedEnd ownedEnd) {
		super();
		this.firstMember = firstMember;
		this.secondMember = secondMember;
		this.ownedEnd = ownedEnd;
	}
}
