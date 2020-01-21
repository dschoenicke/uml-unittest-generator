package mdxml;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ExtensionTest extends MdxmlRepresentationTests {

	@Test
	public void testExtensions() {
		Extension extension = mdxmlSubClass.getOwnedAttributes().get(0).getDataType().getExtension();
		assertNotNull(extension);
		assertNotNull(extension.getReferenceExtension());
		
		extension = mdxmlSubClass.getOwnedAttributes().get(0).getExtensions().get(0);
		assertNotNull(extension);
		assertNotNull(extension.getModelExtension());
	}
}
