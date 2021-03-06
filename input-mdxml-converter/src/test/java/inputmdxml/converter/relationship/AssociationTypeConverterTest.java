package inputmdxml.converter.relationship;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import inputmdxml.converter.relationship.AssociationTypeConverter;
import uml.UmlRelationshipType;

public class AssociationTypeConverterTest {

	@Test 
	public void testSharedRelationship() {
		assertEquals(UmlRelationshipType.AGGREGATION, AssociationTypeConverter.convertAssociationType("shared"));
		assertEquals(UmlRelationshipType.COMPOSITION, AssociationTypeConverter.convertAssociationType("composite"));
		assertEquals(UmlRelationshipType.ASSOCIATION, AssociationTypeConverter.convertAssociationType("-"));
		assertEquals(UmlRelationshipType.ASSOCIATION, AssociationTypeConverter.convertAssociationType(null));;
	}
}
