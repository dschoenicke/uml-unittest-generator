package mdxml;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ModelExtensionTest extends MdxmlRepresentationTests {

	@Test
	public void testModelExtensions() {
		ModelExtension modelExtension = mdxmlSubClass.getOwnedAttributes().get(0).getExtensions().get(0).getModelExtension();
		assertNotNull(modelExtension);
		assertNotNull(modelExtension.getUpperValue());
		
		modelExtension = mdxmlGenericClass.getOwnedAttributes().get(0).getExtensions().get(0).getModelExtension();
		assertNotNull(modelExtension);
		assertNotNull(modelExtension.getLowerValue());
	}
}
