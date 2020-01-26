package inputmdxml.converter.relationship;

import static org.junit.Assert.assertNotNull;

import inputmdxml.temporary.TemporaryAttribute;
import inputmdxml.temporary.TemporaryModel;
import inputmdxml.temporary.TemporaryRelationship;
import lombok.experimental.UtilityClass;
import mdxml.PackagedElement;
import uml.UmlElement;
import uml.UmlModel;
import uml.UmlPackage;
import uml.UmlParent;
import uml.UmlRelationshipType;

/**
 * Class providing static methods to convert {@link mdxml.PackagedElement}s with type 'uml:Association' or 'uml:Usage' to {@link inputmdxml.temporary.TemporaryRelationship}s<br>
 * These {@link inputmdxml.temporary.TemporaryRelationship}s contain references to their client- and supplier elements which are later resolved
 * 
 * @author dschoenicke
 *
 */
@UtilityClass
public class RelationshipConverter {
	
	/**
	 * Static method to convert {@link mdxml.PackagedElement}s of type 'uml:Association' and 'uml:Usage' to {@link inputmdxml.temporary.TemporaryRelationship}s
	 * Delegates the conversion of {@link mdxml.PackagedElement}s of type 'uml:Association' to the {@link inputmdxml.converter.relationship.AssociationConverter}
	 * Delegates the conversion of {@link mdxml.PackagedElement}s of type 'uml:Usage' to the {@link inputmdxml.converter.relationship.DependencyConverter}
	 * 
	 * @param packagedElement the {@link mdxml.PackagedElement} which should be converted
	 * @param parent the {@link uml.UmlParent} to add the {@link inputmdxml.temporary.TemporaryRelationship} to
	 * @param tmpModel the {@link inputmdxml.temporary.TemporaryModel} to which the converted {@link inputmdxml.temporary.TemporaryRelationship} should be added
	 * @return the converted {@link inputmdxml.temporary.TemporaryRelationship} 
	 */
	public static TemporaryRelationship convertRelationship(PackagedElement packagedElement, UmlParent parent, TemporaryModel tmpModel) {
		TemporaryRelationship relationship = null;
		
		switch (packagedElement.getType()) {
			case "uml:Association":
				relationship = AssociationConverter.convertAssociation(packagedElement, tmpModel);
				break;
				
			case "uml:Usage":
			case "uml:Dependency":
				relationship = DependencyConverter.convertDependency(packagedElement, tmpModel);
				break;
				
			default: return null;
		}
		
		if (parent instanceof UmlModel) {
			((UmlModel) parent).addRelationship(relationship);
		}
		else {
			((UmlPackage) parent).addRelationship(relationship);
		}
		
		return relationship;
	}
	
	/**
	 * Static method to resolve references of {@link inputmdxml.temporary.TemporaryRelationship}s and replace them by actual {@link uml.UmlElement}s so that the {@link inputmdxml.temporary.TemporaryRelationship} can be upcasted to an {@link uml.UmlRelationship}
	 * 
	 * @param tmpRelationship the {@link inputmdxml.temporary.TemporaryRelationship} of which the references should be resolved
	 * @param tmpModel the {@link inputmdxml.temporary.TemporaryModel} which contains mappings for the element ids to the actual {@link uml.UmlElement}s
	 */
	public static void convertTemporaryRelationship(TemporaryRelationship tmpRelationship, TemporaryModel tmpModel) {
		UmlElement client = null;
		UmlElement supplier = null;
		UmlRelationshipType type = null;
		
		if (tmpRelationship.getClientId() != null && tmpRelationship.getSupplierId() != null) {
			client = tmpModel.getElementIDs().get(tmpRelationship.getClientId());
			supplier = tmpModel.getElementIDs().get(tmpRelationship.getSupplierId());
			type = tmpRelationship.getType();
			
			assertNotNull("The packagedElement with id " + tmpRelationship.getClientId() + " has not been converted to an UmlElement!", client);
			assertNotNull("The packagedElement with id " + tmpRelationship.getSupplierId() + " has not been converted to an UmlElement!", supplier);
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
		else {
			throw new IllegalStateException("A TemporaryRelationship wasn't converted correctly!");
		}
		
		tmpRelationship.setClient(client);
		tmpRelationship.setSupplier(supplier);
		tmpRelationship.setType(type);
	}
}
