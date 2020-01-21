package mdxml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class OwnedParameteredElementTest extends MdxmlRepresentationTests {

	@Test
	public void testOwnedParameteredElement() {
		OwnedParameteredElement ownedParameteredElement = mdxmlGenericClass.getOwnedTemplateSignature().getOwnedParameters().get(0).getOwnedParameteredElement();
		assertNotNull(ownedParameteredElement);
		assertEquals("T", ownedParameteredElement.getName());
		assertEquals("_19_0_1_62d0212_1574772300317_692055_4821", ownedParameteredElement.getId());
		assertEquals(mdxmlGenericClass.getOwnedTemplateSignature().getOwnedParameters().get(0).getId(), ownedParameteredElement.getTemplateParameter());
	}
}
