package inputmdxml.converter.relationship;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import inputmdxml.MdxmlUmlConverterTests;
import inputmdxml.converter.relationship.RelationshipConverter;
import inputmdxml.temporary.TemporaryAttribute;
import inputmdxml.temporary.TemporaryRelationship;
import mdxml.MemberEnd;
import mdxml.OwnedAttribute;
import uml.UmlRelationshipType;

public class RelationshipConverterTest extends MdxmlUmlConverterTests {

	private TemporaryRelationship mockTmpRelationship;
	
	@Before
	public void initTemporaryRelationshipElements() {
		OwnedAttribute mockOwnedAttribute = new OwnedAttribute();
		mockOwnedAttribute.setName("");
		mockOwnedAttribute.setVisibility("package");
		mockOwnedAttribute.setAssociationType(mdxmlGenericClass.getId());
		mockTmpModel.addAttribute("123", new TemporaryAttribute(mockOwnedAttribute));
		
		mockTmpModel.addElement(mdxmlGenericClass.getId(), umlGenericClass);
		mockTmpModel.addElement(mdxmlSubPackageClass.getId(), umlSubPackageClass);
		mockTmpModel.addElement(mdxmlSubClass.getId(), umlSubClass);
		mockTmpModel.addElement(mdxmlTopLevelInterface.getId(), umlTopLevelInterface);
		mockTmpModel.addAttribute(mdxmlGenericClass.getOwnedAttributes().get(0).getId(), new TemporaryAttribute(mdxmlGenericClass.getOwnedAttributes().get(0)));
		
		mockTmpRelationship = new TemporaryRelationship();
		mockTmpRelationship.setFirstMember(mdxmlSubPackageClassAssociation.getMemberEnds().get(0));
		mockTmpRelationship.setSecondMember((mdxmlSubPackageClassAssociation.getMemberEnds().get(1)));
	}
	
	@Test
	public void testConvertAssociation() {
		TemporaryRelationship relationship = RelationshipConverter.convertRelationship(mdxmlBigEnumAssociation, umlModel, mockTmpModel);
		assertTrue(umlModel.getRelationships().contains(relationship));
		assertNull(relationship.getType());
	}
	
	@Test
	public void testConvertDependency() {
		TemporaryRelationship relationship = RelationshipConverter.convertRelationship(mdxmlDependency, umlTopLevelPackage, mockTmpModel);
		assertTrue(umlTopLevelPackage.getRelationships().contains(relationship));
		assertEquals(UmlRelationshipType.DEPENDENCY, relationship.getType());
		
		mdxmlDependency.setType("uml:Dependency");
		relationship = RelationshipConverter.convertRelationship(mdxmlDependency, umlTopLevelPackage, mockTmpModel);
		assertTrue(umlTopLevelPackage.getRelationships().contains(relationship));
		assertEquals(UmlRelationshipType.DEPENDENCY, relationship.getType());
	}
	
	@Test
	public void testInvalidRelationshipType() {
		mdxmlDependency.setType("-");
		assertNull(RelationshipConverter.convertRelationship(mdxmlDependency, umlModel, mockTmpModel));
	}
	
	@Test
	public void testConvertTemporaryDependency() {
		mockTmpRelationship.setClientId(mdxmlSubClass.getId());
		mockTmpRelationship.setSupplierId(mdxmlTopLevelInterface.getId());
		mockTmpRelationship.setType(UmlRelationshipType.DEPENDENCY);
		RelationshipConverter.convertTemporaryRelationship(mockTmpRelationship, mockTmpModel);
		assertEquals(umlSubClass, mockTmpRelationship.getClient());
		assertEquals(umlTopLevelInterface, mockTmpRelationship.getSupplier());
		assertEquals(UmlRelationshipType.DEPENDENCY, mockTmpRelationship.getType());
	}
	
	@Test
	public void testConvertTemporaryDirectedAssociation() {
		mockTmpRelationship.setOwnedEnd(mdxmlSubPackageClassAssociation.getOwnedEnd());
		RelationshipConverter.convertTemporaryRelationship(mockTmpRelationship, mockTmpModel);
		assertEquals(umlGenericClass, mockTmpRelationship.getClient());
		assertEquals(umlSubPackageClass, mockTmpRelationship.getSupplier());
		assertEquals(UmlRelationshipType.AGGREGATION, mockTmpRelationship.getType());
	}
	
	@Test
	public void testConvertTemporaryUndirectedComposition() {
		((TemporaryAttribute) mockTmpModel.getAttributeIDs().get(mdxmlGenericClass.getOwnedAttributes().get(0).getId())).setAggregation("composite");
		mockTmpRelationship.getSecondMember().setIdref("123");
		RelationshipConverter.convertTemporaryRelationship(mockTmpRelationship, mockTmpModel);
		assertEquals(umlGenericClass, mockTmpRelationship.getClient());
		assertEquals(umlSubPackageClass, mockTmpRelationship.getSupplier());
		assertEquals(UmlRelationshipType.COMPOSITION, mockTmpRelationship.getType());
	}
	
	@Test(expected = IllegalStateException.class)
	public void testConvertEmptyTemporaryRelationship() {
		RelationshipConverter.convertTemporaryRelationship(new TemporaryRelationship(), mockTmpModel);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testConvertInvalidMemberTemporaryRelatioship() {
		TemporaryRelationship invalid = new TemporaryRelationship();
		invalid.setFirstMember(new MemberEnd());
		RelationshipConverter.convertTemporaryRelationship(invalid, mockTmpModel);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testConvertInvalidSupplierTemporaryRelationship() {
		TemporaryRelationship invalid = new TemporaryRelationship();
		invalid.setClientId("-");
		RelationshipConverter.convertTemporaryRelationship(invalid, mockTmpModel);
	}
}
