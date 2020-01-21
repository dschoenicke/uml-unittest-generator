package mdxml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class LowerValueTest extends MdxmlRepresentationTests {

	@Test
	public void testLowerValues() {
		LowerValue lowerValue = mdxmlSubClass.getOwnedAttributes().get(0).getLowerValue();
		assertNotNull(lowerValue);
		assertEquals("_19_0_1_62d0212_1574772184481_928063_4740", lowerValue.getId());
		assertEquals("uml:LiteralInteger", lowerValue.getType());
		
		lowerValue = mdxmlGenericClass.getOwnedAttributes().get(0).getExtensions().get(0).getModelExtension().getLowerValue();
		assertNotNull(lowerValue);
		assertEquals("_19_0_1_62d0212_1574772725171_520974_4924", lowerValue.getId());
		assertEquals("uml:LiteralInteger", lowerValue.getType());
		assertEquals("1", lowerValue.getValue());
	}
}
