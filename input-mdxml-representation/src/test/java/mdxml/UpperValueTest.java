package mdxml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class UpperValueTest extends MdxmlRepresentationTests {

	@Test
	public void testUpperValues() {
		UpperValue upperValue = mdxmlGenericClass.getOwnedAttributes().get(0).getUpperValue();
		assertNotNull(upperValue);
		assertEquals("_19_0_1_62d0212_1574772725171_72179_4925", upperValue.getId());
		assertEquals("uml:LiteralUnlimitedNatural", upperValue.getType());
		assertEquals("*", upperValue.getValue());
		
		upperValue = mdxmlSubClass.getOwnedAttributes().get(0).getExtensions().get(0).getModelExtension().getUpperValue();
		assertNotNull(upperValue);
		assertEquals("1", upperValue.getValue());
	}
}
