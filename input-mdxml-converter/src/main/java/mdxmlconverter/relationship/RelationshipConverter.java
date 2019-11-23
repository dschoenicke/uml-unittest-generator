package mdxmlconverter.relationship;

import mdxml.PackagedElement;
import mdxmlconverter.temporary.TemporaryAttribute;
import mdxmlconverter.temporary.TemporaryModel;
import mdxmlconverter.temporary.TemporaryRelationship;
import uml.UmlElement;
import uml.UmlRelationship;
import uml.UmlRelationshipType;

public class RelationshipConverter {
	
	public static UmlRelationship convertRelationship(PackagedElement packagedElement, TemporaryModel tmpModel) {
		UmlRelationship relationship = null;
		
		switch (packagedElement.getType()) {
			case "uml:Association": {
				relationship = AssociationConverter.convertAssociation(packagedElement, tmpModel);
				break;
			}
			case "uml:Usage": {
				relationship = DependencyConverter.convertDependency(packagedElement, tmpModel);
				break;
			}
			default: break;
		}
		
		return relationship;
	}
	
	public static void convertTemporaryRelationship(TemporaryRelationship tmpRelationship, TemporaryModel tmpModel) {
		UmlElement client = null;
		UmlElement supplier = null;
		UmlRelationshipType type = null;
		
		if (tmpRelationship.getClient() != null && tmpRelationship.getClient() != null) {
			client = tmpModel.getElementIDs().get(tmpRelationship.getClientId());
			supplier = tmpModel.getElementIDs().get(tmpRelationship.getSupplierId());
			type = tmpRelationship.getType();
		}
		else if (tmpRelationship.getFirstMember() != null && tmpRelationship.getSecondMember() != null) {
			TemporaryAttribute clientAttribute = (TemporaryAttribute)tmpModel.getAttributeIDs().get(tmpRelationship.getFirstMember().getIdref());
			supplier = tmpModel.getElementIDs().get(clientAttribute.getType());
			
			if (tmpRelationship.getOwnedEnd() != null) {
				client = tmpModel.getElementIDs().get(tmpRelationship.getOwnedEnd().getAssociationType());
			}
			else {
				client = tmpModel.getElementIDs().get(
					 	tmpModel.getAttributeIDs().get(
					 		tmpRelationship.getSecondMember().getIdref()
					 	).getType());
			}
			
			if (clientAttribute.getAggregation() == null) {
				type = UmlRelationshipType.ASSOCIATION;
			}
			else {
				type = clientAttribute.getAggregation().equals("shared") ? UmlRelationshipType.AGGREGATION : UmlRelationshipType.COMPOSITION;
			}
		}
		
		tmpRelationship.setClient(client);
		tmpRelationship.setSupplier(supplier);
		tmpRelationship.setType(type);
	}
}
