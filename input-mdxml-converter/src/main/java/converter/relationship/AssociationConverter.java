package converter.relationship;

import converter.temporary.TemporaryAttribute;
import converter.temporary.TemporaryModel;
import model.MemberEnd;
import model.OwnedEnd;
import model.PackagedElement;
import model.UmlAttribute;
import model.UmlElement;
import model.UmlRelationship;
import model.UmlRelationshipType;

public class AssociationConverter {

	public static void convertAssociation(PackagedElement packagedElement, TemporaryModel tmpModel) {
		tmpModel.addRelationship(packagedElement.getId(), createAssociation(packagedElement, tmpModel));
	}
	
	private static UmlRelationship createAssociation(PackagedElement packagedElement, TemporaryModel tmpModel) {
		MemberEnd firstMember = packagedElement.getMemberEnds().get(0);
		MemberEnd secondMember = packagedElement.getMemberEnds().get(1);
		UmlRelationship association = null;
		UmlElement client = null;
		UmlElement supplier = null;
		TemporaryAttribute attribute = null;
		UmlRelationshipType associationType;
		
		if (firstMember == null || secondMember == null) {
			return association;
		}
		
		OwnedEnd ownedEnd = packagedElement.getOwnedEnd();
		
		if (ownedEnd == null) {
			attribute = (TemporaryAttribute) tmpModel.getAttributeIDs().get(secondMember.getIdref());
			supplier = tmpModel.getElementIDs().get(attribute.getType());
			attribute = (TemporaryAttribute) tmpModel.getAttributeIDs().get(firstMember.getIdref());
			client = tmpModel.getElementIDs().get(attribute.getType());
		}
		else {
			client = tmpModel.getElementIDs().get(ownedEnd.getAssociationType());
			attribute = findTemporaryAttributeByAssociation(client, packagedElement.getId());
			
			if (attribute == null) {
				return null;
			}
		
			supplier = tmpModel.getElementIDs().get(attribute.getType());
		}
		
		associationType = AssociationTypeConverter.convertAssociationType(attribute.getAssociation());
		
		return new UmlRelationship(client, supplier, associationType);
	}
	
	private static TemporaryAttribute findTemporaryAttributeByAssociation(UmlElement element, String association) {
		for (UmlAttribute attribute : element.getAttributes()) {
			if (attribute instanceof TemporaryAttribute) {
				TemporaryAttribute checkAttribute = (TemporaryAttribute) attribute;
				
				if (checkAttribute.getAssociation() != null && checkAttribute.getAssociation().equals(association)) {
					return checkAttribute;
				}
			}
		}
		
		return null;
	}
}
