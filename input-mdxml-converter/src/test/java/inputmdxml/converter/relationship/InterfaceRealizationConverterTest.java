package inputmdxml.converter.relationship;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import inputmdxml.MdxmlUmlConverterTests;
import inputmdxml.temporary.TemporaryRelationship;
import uml.UmlRelationshipType;

public class InterfaceRealizationConverterTest extends MdxmlUmlConverterTests {

	@Test
	public void testTopLevelInterfaceRealization() {
		InterfaceRealizationConverter.convertInterfaceRealizations(mdxmlTopLevelClass.getInterfaceRealizations(), mockTmpModel, umlModel);
		assertEquals(1, mockTmpModel.getRelationships().size());
		TemporaryRelationship relationship = (TemporaryRelationship) mockTmpModel.getRelationships().get(0);
		assertTrue(umlModel.getRelationships().contains(relationship));
		assertEquals(mdxmlTopLevelClass.getId(), relationship.getClientId());
		assertEquals(mdxmlTopLevelInterface.getId(), relationship.getSupplierId());
		assertEquals(UmlRelationshipType.INTERFACEREALIZATION, relationship.getType());
	}
	
	@Test
	public void testPackageInterfaceRealization() {
		InterfaceRealizationConverter.convertInterfaceRealizations(mdxmlTopLevelClass.getInterfaceRealizations(), mockTmpModel, umlTopLevelPackage);
		TemporaryRelationship relationship = (TemporaryRelationship) mockTmpModel.getRelationships().get(0);
		assertTrue(mockTmpModel.getRelationships().contains(relationship));
		assertTrue(umlTopLevelPackage.getRelationships().contains(relationship));
	}
}
