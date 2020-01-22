package mdxmlconverter.relationship;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import mdxmlconverter.MdxmlUmlConverterTests;
import mdxmlconverter.temporary.TemporaryRelationship;
import uml.UmlRelationship;
import uml.UmlRelationshipType;

public class GeneralizationConverterTest extends MdxmlUmlConverterTests {
	
	@Test
	public void testTopLevelGeneralization() {
		TemporaryRelationship relationship = GeneralizationConverter.convertGeneralization(mdxmlSubClass, mockTmpModel, umlModel);
		assertTrue(mockTmpModel.getRelationships().contains(relationship));
		assertTrue(umlModel.getRelationships().contains(relationship));
		assertEquals(mdxmlSubClass.getId(), relationship.getClientId());
		assertEquals(mdxmlTopLevelClass.getId(), relationship.getSupplierId());
		assertEquals(UmlRelationshipType.GENERALIZATION, relationship.getType());
	}
	
	@Test
	public void testPackageGeneralization() {
		TemporaryRelationship relationship = GeneralizationConverter.convertGeneralization(mdxmlSubInterface, mockTmpModel, umlTopLevelPackage);
		assertTrue(mockTmpModel.getRelationships().contains(relationship));
		assertTrue(umlTopLevelPackage.getRelationships().contains(relationship));
		assertEquals(mdxmlSubInterface.getId(), relationship.getClientId());
		assertEquals(mdxmlTopLevelInterface.getId(), relationship.getSupplierId());
		assertEquals(UmlRelationshipType.GENERALIZATION, relationship.getType());
	}
	
	@Test
	public void testNestedGeneralizations() {
		mdxmlSubPackageClass.getNestedClassifiers().add(mdxmlSubClass);
		GeneralizationConverter.convertNestedGeneralizations(mdxmlSubPackageClass, mockTmpModel, umlTopLevelPackage);
		UmlRelationship relationship = mockTmpModel.getRelationships().get(0);
		assertTrue(relationship instanceof TemporaryRelationship);
		assertEquals(mdxmlSubClass.getId(), ((TemporaryRelationship) relationship).getClientId());
		assertEquals(mdxmlTopLevelClass.getId(), ((TemporaryRelationship) relationship).getSupplierId());
		assertEquals(UmlRelationshipType.GENERALIZATION, relationship.getType());
	}
	
	@Test
	public void testInvalidGeneralization() {
		thrown.expect(IllegalArgumentException.class);
		GeneralizationConverter.convertGeneralization(mdxmlSubClass, mockTmpModel, umlBigEnum);
	}
}
