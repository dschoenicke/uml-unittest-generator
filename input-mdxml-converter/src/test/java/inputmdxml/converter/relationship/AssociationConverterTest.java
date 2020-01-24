package inputmdxml.converter.relationship;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import inputmdxml.MdxmlUmlConverterTests;
import inputmdxml.converter.relationship.AssociationConverter;
import inputmdxml.temporary.TemporaryRelationship;

public class AssociationConverterTest extends MdxmlUmlConverterTests {

	@Test
	public void testDirectedAssociation() {
		TemporaryRelationship relationship = AssociationConverter.convertAssociation(mdxmlBigEnumAssociation, mockTmpModel);
		assertTrue(mockTmpModel.getRelationships().contains(relationship));
		assertEquals(mdxmlBigEnumAssociation.getMemberEnds().get(0), relationship.getFirstMember());
		assertEquals(mdxmlBigEnumAssociation.getMemberEnds().get(1), relationship.getSecondMember());
		assertEquals(mdxmlBigEnumAssociation.getOwnedEnd(), relationship.getOwnedEnd());
	}
	
	@Test
	public void testUndirectedAssociation() {
		mdxmlBigEnumAssociation.setOwnedEnd(null);
		TemporaryRelationship relationship = AssociationConverter.convertAssociation(mdxmlBigEnumAssociation, mockTmpModel);
		assertTrue(mockTmpModel.getRelationships().contains(relationship));
		assertEquals(mdxmlBigEnumAssociation.getMemberEnds().get(0), relationship.getFirstMember());
		assertEquals(mdxmlBigEnumAssociation.getMemberEnds().get(1), relationship.getSecondMember());
		assertNull(mdxmlBigEnumAssociation.getOwnedEnd());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidAssociation() {
		mdxmlBigEnumAssociation.getMemberEnds().clear();
		AssociationConverter.convertAssociation(mdxmlBigEnumAssociation, mockTmpModel);
	}
}
