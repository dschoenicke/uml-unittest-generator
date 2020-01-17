package mdxmlconverter.relationship;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uml.UmlRelationshipType;

/**
 * Tests for {@link AssociationTypeConverter#convertAssociationType} with different inputs.
 * 
 * @author dschoenicke
 *
 */
public class AssociationTypeConverterTest {

	/**
	 * Tests whether {@link AssociationTypeConverter} returns {@link uml.UmlRelationshipType#AGGREGATION} for input string 'shared'.
	 */
	@Test 
	public void testSharedRelationship() {
		assertEquals(UmlRelationshipType.AGGREGATION, AssociationTypeConverter.convertAssociationType("shared"));
	}
	
	/**
	 * Tests whether {@link AssociationTypeConverter} returns {@link uml.UmlRelationshipType#COMPOSITION} for input string 'composite'.
	 */
	@Test 
	public void testCompositeRelationship() {
		assertEquals(UmlRelationshipType.COMPOSITION, AssociationTypeConverter.convertAssociationType("composite"));
	}
	
	/**
	 * Tests whether {@link AssociationTypeConverter} returns {@link uml.UmlRelationshipType#ASSOCIATION} for an arbitrary input string'.
	 */
	@Test 
	public void testArbitraryRelationship() {
		assertEquals(UmlRelationshipType.ASSOCIATION, AssociationTypeConverter.convertAssociationType("1234"));
	}
}
