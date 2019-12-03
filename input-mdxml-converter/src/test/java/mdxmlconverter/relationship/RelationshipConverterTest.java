package mdxmlconverter.relationship;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import mdxml.Client;
import mdxml.MemberEnd;
import mdxml.OwnedEnd;
import mdxml.PackagedElement;
import mdxml.Supplier;
import mdxmlconverter.temporary.TemporaryAttribute;
import mdxmlconverter.temporary.TemporaryModel;
import mdxmlconverter.temporary.TemporaryRelationship;
import uml.UmlClass;
import uml.UmlRelationshipType;

/**
 * Tests {@link RelationshipConverter#convertRelationship} and {@link RelationshipConverter#convertTemporaryRelationship}.
 * 
 * @author dschoenicke
 *
 */
public class RelationshipConverterTest {

	/**
	 * The {@link mdxml.PackagedElement} representing the relationship to be tested
	 */
	private PackagedElement mockPackagedElement;
	
	/**
	 * The {@link mdxml.PackagedElement} representing the client {@link uml.UmlElement} of the relationship
	 */
	private PackagedElement mockPackagedClient;
	
	/**
	 * The {@link mdxml.PackagedElement} representing the supplier {@link uml.UmlElement} of the relationship
	 */
	private PackagedElement mockPackagedSupplier;
	
	/**
	 * The {@link mdxmlconverter.temporary.TemporaryModel} to be used in the tests
	 */
	private TemporaryModel mockTmpModel;
	
	/**
	 * The client {@link uml.UmlElement} of the {@link mdxmlconverter.temporary.TemporaryRelationship}
	 */
	private UmlClass mockClientClass;
	
	/**
	 * The supplier {@link uml.UmlElement} of the {@link mdxmlconverter.temporary.TemporaryRelationship}
	 */
	private UmlClass mockSupplierClass;
	
	/**
	 * The client {@link mdxmlconverter.temporary.TemporaryAttribute} for the association
	 */
	private TemporaryAttribute mockTmpAttribute;
	
	/**
	 * The {@link mdxmlconverter.temporary.TemporaryRelationship} to be used in the tests
	 */
	private TemporaryRelationship mockTmpRelationship;
	
	/**
	 * Initializes the mock elements
	 */
	@Before
	public void init() {
		ArrayList<MemberEnd> mockMemberEnds = new ArrayList<>();
		mockMemberEnds.add(new MemberEnd());
		mockMemberEnds.add(new MemberEnd());
		mockPackagedElement = new PackagedElement();
		mockPackagedClient = new PackagedElement();
		mockPackagedSupplier = new PackagedElement();
		mockPackagedElement.setMemberEnds(mockMemberEnds);
		mockPackagedElement.setClient(new Client());
		mockPackagedElement.setSupplier(new Supplier());
		mockClientClass = new UmlClass("mockClient", null);
		mockSupplierClass = new UmlClass("mockSupplier", null);
		
		mockTmpModel = new TemporaryModel();
		mockTmpAttribute = new TemporaryAttribute(null, null, "1234", false, false, null, null, null, null, null);
		
		mockPackagedClient.setId("123");
		mockPackagedClient.setName("mockClient");
		mockPackagedSupplier.setId("1234");
		mockPackagedSupplier.setName("mockSupplier");
		
		mockPackagedElement.getClient().setIdref(mockPackagedClient.getId());
		mockPackagedElement.getSupplier().setIdref(mockPackagedSupplier.getId());
		
		mockTmpModel = new TemporaryModel();
		mockTmpModel.addElement(mockPackagedClient.getId(), mockClientClass);
		mockTmpModel.addElement(mockPackagedSupplier.getId(), mockSupplierClass);
		mockTmpModel.addAttribute("789", mockTmpAttribute);
		
		mockTmpRelationship = new TemporaryRelationship();
		mockTmpRelationship.setFirstMember(new MemberEnd());
		mockTmpRelationship.getFirstMember().setIdref("789");
		mockTmpRelationship.setSecondMember(new MemberEnd());
	}
	
	/**
	 * Tests {@link mdxmlconverter.relationship.RelationshipConverter#convertRelationship} with an association.
	 */
	@Test
	public void testConvertRelationshipAssociation() {
		mockPackagedElement.setType("uml:Association");
		TemporaryRelationship tmpRelationship = RelationshipConverter.convertRelationship(mockPackagedElement, mockTmpModel);
		assertNotNull(tmpRelationship);
		assertNull(tmpRelationship.getType());
	}
	
	/**
	 * Tests {@link mdxmlconverter.relationship.RelationshipConverter#convertRelationship} with a relationship.
	 */
	@Test
	public void testConvertRelationshipDependency() {
		mockPackagedElement.setType("uml:Usage");
		assertEquals(RelationshipConverter.convertRelationship(mockPackagedElement, mockTmpModel).getType(), UmlRelationshipType.DEPENDENCY);
	}
	
	/**
	 * Tests {@link mdxmlconverter.relationship.RelationshipConverter#convertRelationship} with an invalid type.
	 */
	@Test
	public void testConvertRelationshipOther() {
		mockPackagedElement.setType("INVALID");
		assertNull(RelationshipConverter.convertRelationship(mockPackagedElement, mockTmpModel));
	}
	
	/**
	 * Tests {@link mdxmlconverter.relationship.RelationshipConverter#convertTemporaryRelationship} with a dependency.
	 */
	@Test
	public void testConvertTemporaryDependency() {
		mockTmpRelationship.setClientId(mockPackagedClient.getId());
		mockTmpRelationship.setSupplierId(mockPackagedSupplier.getId());
		mockTmpRelationship.setType(UmlRelationshipType.DEPENDENCY);
		RelationshipConverter.convertTemporaryRelationship(mockTmpRelationship, mockTmpModel);
		assertEquals(mockTmpRelationship.getClient(), mockClientClass);
		assertEquals(mockTmpRelationship.getSupplier(), mockSupplierClass);
		assertEquals(mockTmpRelationship.getType(), UmlRelationshipType.DEPENDENCY);
	}
	
	/**
	 * Tests {@link mdxmlconverter.relationship.RelationshipConverter#convertTemporaryRelationship} with a directed association.
	 */
	@Test
	public void testConvertTemporaryDirectedAssociation() {
		mockTmpRelationship.setOwnedEnd(new OwnedEnd());
		mockTmpRelationship.getOwnedEnd().setAssociationType("123");
		RelationshipConverter.convertTemporaryRelationship(mockTmpRelationship, mockTmpModel);
		assertEquals(mockTmpRelationship.getClient(), mockClientClass);
		assertEquals(mockTmpRelationship.getSupplier(), mockSupplierClass);
		assertEquals(mockTmpRelationship.getType(), UmlRelationshipType.ASSOCIATION);
	}
	
	/**
	 * Tests {@link mdxmlconverter.relationship.RelationshipConverter#convertTemporaryRelationship} with a undirected composition.
	 */
	@Test
	public void testConvertTemporaryUndirectedComposition() {
		mockTmpAttribute.setAggregation("composite");
		mockTmpModel.addAttribute("456", new TemporaryAttribute(null, null, "123", false, false, null, null, null, null, null));
		mockTmpRelationship.getSecondMember().setIdref("456");
		RelationshipConverter.convertTemporaryRelationship(mockTmpRelationship, mockTmpModel);
		assertEquals(mockTmpRelationship.getClient(), mockClientClass);
		assertEquals(mockTmpRelationship.getSupplier(), mockSupplierClass);
		assertEquals(mockTmpRelationship.getType(), UmlRelationshipType.COMPOSITION);
	}
}
