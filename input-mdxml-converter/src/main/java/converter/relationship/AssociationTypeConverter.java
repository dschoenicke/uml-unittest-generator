package converter.relationship;

import model.UmlRelationshipType;

public class AssociationTypeConverter {

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
