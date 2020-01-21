package mdxml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class OwnedParameterTest extends MdxmlRepresentationTests {

	@Test
	public void testOwnedParameter() {
		OwnedParameter ownedParameter = mdxmlGenericClass.getOwnedOperations().get(0).getOwnedParameters().get(0);
		assertNotNull(ownedParameter);
		assertEquals("_19_0_1_62d0212_1574772605664_583760_4854", ownedParameter.getId());
		assertEquals("name", ownedParameter.getName());
		assertEquals("uml:Parameter", ownedParameter.getParameterType());
		assertNotNull(ownedParameter.getDataType());
		
		ownedParameter = mdxmlGenericClass.getOwnedOperations().get(1).getOwnedParameters().get(0);
		assertNotNull(ownedParameter);
		assertEquals("return", ownedParameter.getDirection());
		assertEquals("_19_0_1_62d0212_1574772632018_583047_4856", ownedParameter.getAssociationType());
		
		ownedParameter = mdxmlGenericClass.getOwnedTemplateSignature().getOwnedParameters().get(0);
		assertNotNull(ownedParameter);
		assertEquals("uml:ClassifierTemplateParameter", ownedParameter.getParameterType());
		assertNotNull(ownedParameter.getConstrainingClassifier());
		assertNotNull(ownedParameter.getOwnedParameteredElement());
	}
}
