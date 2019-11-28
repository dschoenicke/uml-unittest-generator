package mdxmlconverter.relationship;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import mdxml.MemberEnd;
import mdxml.OwnedEnd;
import mdxml.PackagedElement;
import mdxmlconverter.temporary.TemporaryModel;
import mdxmlconverter.temporary.TemporaryRelationship;

/**
 * Unit tests for {@link AssociationConverter} 
 * 
 * @author dschoenicke
 *
 */
public class AssociationConverterTest {

	/**
	 * Mock the two {@link mdxml.MemberEnd}s to be tested.
	 */
	private ArrayList<MemberEnd> mockMemberEnds;
	
	/**
	 * Mocks the {@link mdxml.OwnedEnd} to test the conversion of directed relationships.
	 */
	private OwnedEnd mockOwnedEnd;
	
	/**
	 * Mocks a {@link mdxml.PackagedElement} to test the conversion of relationships
	 */
	private PackagedElement mockPackagedElement;
	
	/**
	 * Mocks the {@link mdxmlconverter.temporary.TemporaryModel} which contains the converted {@link mdxmlconverter.temporary.TemporaryModel}.
	 */
	private TemporaryModel mockTmpModel;
	
	/**
	 * Initializes the mock objects
	 */
	@Before
	public void init() {
		mockMemberEnds = new ArrayList<>();
		mockMemberEnds.add(new MemberEnd());
		mockMemberEnds.add(new MemberEnd());
		mockOwnedEnd = new OwnedEnd();
		mockPackagedElement = new PackagedElement();
		mockPackagedElement.setMemberEnds(mockMemberEnds);
		mockTmpModel = new TemporaryModel();
	}
	
	/**
	 * Tests {@link AssociationConverter#convertAssociation} with an undirected relationship.
	 */
	@Test
	public void testUndirectedRelationshipConversion() {
		TemporaryRelationship tmpRelationship = AssociationConverter.convertAssociation(mockPackagedElement, mockTmpModel);
		
		assertTrue("The converted TemporaryRelationship was not added to the TemporaryModel!", mockTmpModel.getRelationships().contains(tmpRelationship));
		assertTrue("The converted TemporaryRelationship does not contain the MemberEnds!", 
				tmpRelationship.getFirstMember().equals(mockMemberEnds.get(0)) &&
				tmpRelationship.getSecondMember().equals(mockMemberEnds.get(1)));
		assertNull("The converted TemporaryRelationship must not contain an OwnedEnd!", tmpRelationship.getOwnedEnd());
	}
	
	/**
	 * Tests {@link AssociationConverter#convertAssociation} with an directed relationship.
	 */
	@Test
	public void testDirectedRelationshipConversion() {
		mockPackagedElement.setOwnedEnd(mockOwnedEnd);
		TemporaryRelationship tmpRelationship = AssociationConverter.convertAssociation(mockPackagedElement, mockTmpModel);
		assertTrue("The converted TemporaryRelationship was not added to the TemporaryModel!", mockTmpModel.getRelationships().contains(tmpRelationship));
		assertTrue("The converted TemporaryRelationship does not contain the MemberEnds!", 
				tmpRelationship.getFirstMember().equals(mockMemberEnds.get(0)) &&
				tmpRelationship.getSecondMember().equals(mockMemberEnds.get(1)));
		assertEquals("The converted TemporaryRelationship does not contain an OwnedEnd!", tmpRelationship.getOwnedEnd(), mockOwnedEnd);
	}
}
