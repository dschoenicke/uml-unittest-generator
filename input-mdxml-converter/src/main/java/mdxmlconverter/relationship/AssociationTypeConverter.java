package mdxmlconverter.relationship;

import uml.UmlRelationshipType;

/**
 * Class providing a static method which converts the aggregation attribute of a {@link mdxmlconverter.temporary.TemporaryAttribute} to an {@link uml.UmlRelationshipType}
 * 
 * @author dschoenicke
 *
 */
public class AssociationTypeConverter {

	/**
	 * Converts a given string representing the aggregation attribute of a {@link mdxmlconverter.temporary.TemporaryAttribute} to an {@link uml.UmlRelationshipType}
	 * 
	 * @param associationType the string representing the aggregation attribute
	 * @return the converted {@link uml.UmlRelationshipType}
	 */
	public static UmlRelationshipType convertAssociationType(String associationType) {
		UmlRelationshipType relationshipType = UmlRelationshipType.ASSOCIATION;
		
		switch (associationType) {
			case "shared": {
				relationshipType = UmlRelationshipType.AGGREGATION;
				break;
			}
			case "composite": {
				relationshipType = UmlRelationshipType.COMPOSITION;
				break;
			}
			default: break;
		}
		
		return relationshipType;
	}
}
