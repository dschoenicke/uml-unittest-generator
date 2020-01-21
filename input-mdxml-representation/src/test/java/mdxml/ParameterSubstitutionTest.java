package mdxml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class ParameterSubstitutionTest extends MdxmlRepresentationTests {

	@Test
	public void testParameterSubstituton() {
		ParameterSubstitution parameterSubstitution = mdxmlBindingClass.getTemplateBindings().get(0).getParameterSubstitutions().get(0);
		assertNotNull(parameterSubstitution);
		assertEquals(mdxmlSubClass.getId(), parameterSubstitution.getActual());
		assertEquals(mdxmlGenericClass.getOwnedTemplateSignature().getOwnedParameters().get(0).getId(), parameterSubstitution.getFormal());
		assertEquals("_19_0_1_62d0212_1574772476902_805879_4845", parameterSubstitution.getId());
		assertNull(parameterSubstitution.getPrimitiveActual());
	}
}
