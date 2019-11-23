package mdxmlconverter.relationship;

import mdxml.MemberEnd;
import mdxml.OwnedEnd;
import mdxml.PackagedElement;
import mdxmlconverter.temporary.TemporaryModel;
import mdxmlconverter.temporary.TemporaryRelationship;
import uml.UmlRelationship;

public class AssociationConverter {

	public static UmlRelationship convertAssociation(PackagedElement packagedElement, TemporaryModel tmpModel) {
		UmlRelationship relationship = createAssociation(packagedElement, tmpModel);
		tmpModel.addRelationship(relationship);
		return relationship;
	}
	
	private static UmlRelationship createAssociation(PackagedElement packagedElement, TemporaryModel tmpModel) {
		MemberEnd firstMember = packagedElement.getMemberEnds().get(0);
		MemberEnd secondMember = packagedElement.getMemberEnds().get(1);
		OwnedEnd ownedEnd = packagedElement.getOwnedEnd();
		
		if (firstMember == null || secondMember == null) {
			return null;
		}
		
		if (ownedEnd == null) {
			return new TemporaryRelationship(firstMember, secondMember);
		}
		
		return new TemporaryRelationship(firstMember, secondMember, ownedEnd);
	}
}
