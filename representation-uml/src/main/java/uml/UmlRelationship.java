package uml;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an relationship with the involved {@link UmlElement}s, the {@link UmlMultiplicityValue}s and determined by an {@link UmlRelationshipType}
 * 
 * @author dschoenicke
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
