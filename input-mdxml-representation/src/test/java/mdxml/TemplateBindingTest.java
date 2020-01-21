package mdxml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TemplateBindingTest extends MdxmlRepresentationTests {

	@Test
	public void testTemplateBinding() {
		TemplateBinding templateBinding = mdxmlBindingClass.getTemplateBindings().get(0);
		assertNotNull(templateBinding);
		assertEquals("_19_0_1_62d0212_1574772322815_363015_4825", templateBinding.getId());
		assertNotNull(templateBinding.getParameterSubstitutions());
		assertEquals(mdxmlGenericClass.getOwnedTemplateSignature().getId(), templateBinding.getSignature());
	}
}
