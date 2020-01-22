package mdxmlconverter.relationship;

import static org.junit.Assert.assertNotNull;

import mdxml.PackagedElement;
import mdxmlconverter.temporary.TemporaryAttribute;
import mdxmlconverter.temporary.TemporaryModel;
import mdxmlconverter.temporary.TemporaryRelationship;
import uml.UmlElement;
import uml.UmlModel;
import uml.UmlPackage;
import uml.UmlParent;
import uml.UmlRelationshipType;

/**
 * Class providing static methods to convert {@link mdxml.PackagedElement}s with type 'uml:Association' or 'uml:Usage' to {@link mdxmlconverter.temporary.TemporaryRelationship}s<br>
 * These {@link mdxmlconverter.temporary.TemporaryRelationship}s contain references to their client- and supplier elements which are later resolved
 * 
 * @author dschoenicke
 *
 */
public class RelationshipConverter {
	
	private RelationshipConverter() {}
	
	/**
	 * Static method to convert {@link mdxml.PackagedElement}s of type 'uml:Association' and 'uml:Usage' to {@link mdxmlconverter.temporary.TemporaryRelationship}s
	 * Delegates the conversion of {@link mdxml.PackagedElement}s of type 'uml:Association' to the {@link mdxmlconverter.relationship.AssociationConverter}
	 * Delegates the conversion of {@link mdxml.PackagedElement}s of type 'uml:Usage' to the {@link mdxmlconverter.relationship.DependencyConverter}
	 * 
	 * @param packagedElement the {@link mdxml.PackagedElement} which should be converted
	 * @param parent the {@link uml.UmlParent} to add the {@link mdxmlconverter.temporary.TemporaryRelationship} to
	 * @param tmpModel the {@link mdxmlconverter.temporary.TemporaryModel} to which the converted {@link mdxmlconverter.temporary.TemporaryRelationship} should be added
	 * @return the converted {@link mdxmlconverter.temporary.TemporaryRelationship} 
	 */
	public static TemporaryRelationship convertRelationship(PackagedElement packagedElement, UmlParent parent, TemporaryModel tmpModel) {
		TemporaryRelationship relationship = null;
		
		switch (packagedElement.getType()) {
			case "uml:Association":
				relationship = AssociationConverter.convertAssociation(packagedElement, tmpModel);
				break;
				
			case "uml:Usage": 
				relationship = DependencyConverter.convertDependency(packagedElement, tmpModel);
				break;
				
			default: return null;
		}
		
		if (parent instanceof UmlModel) {
			((UmlModel) parent).addRelationship(relationship);
		}
		else if (parent instanceof UmlPackage) {
			((UmlPackage) parent).addRelationship(relationship);
		}
		else {
			throw new IllegalArgumentException(parent.getName() + " is an invalid parent element for the relationship in PackagedElement with id: " + packagedElement.getId() + "!");
		}
		
		return relationship;
	}
	
	/**
	 * Static method to resolve references of {@link mdxmlconverter.temporary.TemporaryRelationship}s and replace them by actual {@link uml.UmlElement}s so that the {@link mdxmlconverter.temporary.TemporaryRelationship} can be upcasted to an {@link uml.UmlRelationship}
	 * 
	 * @param tmpRelationship the {@link mdxmlconverter.temporary.TemporaryRelationship} of which the references should be resolved
	 * @param tmpModel the {@link mdxmlconverter.temporary.TemporaryModel} which contains mappings for the element ids to the actual {@link uml.UmlElement}s
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
