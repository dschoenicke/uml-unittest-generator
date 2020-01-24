package inputmdxml.converter.relationship;

import inputmdxml.temporary.TemporaryModel;
import inputmdxml.temporary.TemporaryRelationship;
import lombok.experimental.UtilityClass;
import mdxml.MemberEnd;
import mdxml.OwnedEnd;
import mdxml.PackagedElement;

/**
 * Class providing a static method to convert a {@link mdxml.PackagedElement} to an {@link uml.UmlRelationship}
 * 
 * @author dschoenicke
 *
 */
@UtilityClass
public class AssociationConverter {
	
	/**
	 * Static method converting a given {@link mdxml.PackagedElement} with the type 'uml:Association to an {@link inputmdxml.temporary.TemporaryRelationship}<br>
	 * If the given association is directed, a {@link inputmdxml.temporary.TemporaryRelationship} with the two {@link mdxml.MemberEnd}s is created<br>
	 * If the given association is directed, a {@link inputmdxml.temporary.TemporaryRelationship} with the two {@link mdxml.MemberEnd}s and the {@link mdxml.OwnedEnd} is created
	 * 
	 * @param packagedElement the {@link mdxml.PackagedElement} which should be converted
	 * @param tmpModel the {@link inputmdxml.temporary.TemporaryModel} to which the converted {@link inputmdxml.temporary.TemporaryRelationship} should be added
	 * @return the converted {@link inputmdxml.temporary.TemporaryRelationship}
	 */
	public static TemporaryRelationship convertAssociation(PackagedElement packagedElement, TemporaryModel tmpModel) {
		if (packagedElement.getMemberEnds().size() != 2) {
			throw new IllegalArgumentException("The PackagedElement with id " + packagedElement.getId() + " must have 2 MemberEnds!");
		}
		
		MemberEnd firstMember = packagedElement.getMemberEnds().get(0);
		MemberEnd secondMember = packagedElement.getMemberEnds().get(1);
		OwnedEnd ownedEnd = packagedElement.getOwnedEnd();
		TemporaryRelationship relationship;
		
		if (ownedEnd == null) {
			relationship = new TemporaryRelationship(firstMember, secondMember);
		}
		else {
			relationship = new TemporaryRelationship(firstMember, secondMember, ownedEnd);
		}
		
		tmpModel.addRelationship(relationship);
		return relationship;
	}
}
