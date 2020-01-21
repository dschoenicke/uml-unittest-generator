package mdxml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class OwnedTemplateSignatureTest extends MdxmlRepresentationTests {

	@Test
	public void testOwnedTemplateSignature() {
		OwnedTemplateSignature ownedTemplateSignature = mdxmlGenericClass.getOwnedTemplateSignature();
		assertNotNull(ownedTemplateSignature);
		assertEquals("_19_0_1_62d0212_1574772300317_735518_4820", ownedTemplateSignature.getId());
		assertEquals(2, ownedTemplateSignature.getOwnedParameters().size());
		assertEquals(2, ownedTemplateSignature.getParameters().size());
	}
}
