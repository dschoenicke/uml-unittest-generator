package mdxml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ParameterTest extends MdxmlRepresentationTests {

	@Test
	public void testParameter() {
		Parameter parameter = mdxmlGenericClass.getOwnedTemplateSignature().getParameters().get(0);
		assertNotNull(parameter);
		assertEquals(mdxmlGenericClass.getOwnedTemplateSignature().getOwnedParameters().get(0).getId(), parameter.getIdref());
	}
}
