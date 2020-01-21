package mdxml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ReferenceExtensionTest extends MdxmlRepresentationTests {

	@Test
	public void testReferenceExtension() {
		ReferenceExtension referenceExtension = mdxmlSubClass.getOwnedAttributes().get(0).getDataType().getExtension().getReferenceExtension();
		assertNotNull(referenceExtension);
		assertEquals("UML Standard Profile::UML2 Metamodel::PrimitiveTypes::String", referenceExtension.getReferentPath());
	}
}
