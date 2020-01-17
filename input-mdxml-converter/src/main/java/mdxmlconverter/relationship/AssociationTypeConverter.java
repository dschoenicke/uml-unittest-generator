package mdxmlconverter.relationship;

import uml.UmlRelationshipType;

/**
 * Class providing a static method which converts the aggregation attribute of a {@link mdxmlconverter.temporary.TemporaryAttribute} to an {@link uml.UmlRelationshipType}
 * 
 * @author dschoenicke
 *
 */
public class AssociationTypeConverter {

	private AssociationTypeConverter() {
		throw new IllegalStateException("utility class");
	}
	
	/**
	 * Converts a given string representing the aggregation attribute of a {@link mdxmlconverter.temporary.TemporaryAttribute} to an {@link uml.UmlRelationshipType}
	 * 
	 * @param associationType the string representing the aggregation attribute
	 * @return the converted {@link uml.UmlRelationshipType}
	 */
	public static UmlRelationshipType convertAssociationType(String associationType) {
		switch (associationType) {
			case "shared": return UmlRelationshipType.AGGREGATION;
			case "composite": return UmlRelationshipType.COMPOSITION;
			default: return UmlRelationshipType.ASSOCIATION;
		}
	}
}
