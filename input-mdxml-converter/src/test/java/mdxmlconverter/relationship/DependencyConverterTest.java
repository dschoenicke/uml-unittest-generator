package mdxmlconverter.relationship;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import mdxmlconverter.MdxmlUmlConverterTests;
import mdxmlconverter.temporary.TemporaryRelationship;
import uml.UmlRelationshipType;

public class DependencyConverterTest extends MdxmlUmlConverterTests {

	@Test
	public void testDependencyConversion() {
		TemporaryRelationship tmpRelationship = DependencyConverter.convertDependency(mdxmlDependency, mockTmpModel);
		assertTrue(mockTmpModel.getRelationships().contains(tmpRelationship));
		assertEquals(mdxmlDependency.getClient().getIdref(), tmpRelationship.getClientId());
		assertEquals(mdxmlDependency.getSupplier().getIdref(), tmpRelationship.getSupplierId());
		assertEquals(UmlRelationshipType.DEPENDENCY, tmpRelationship.getType());
	}
}
