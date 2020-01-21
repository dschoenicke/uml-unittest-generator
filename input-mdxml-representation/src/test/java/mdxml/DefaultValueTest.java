package mdxml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class DefaultValueTest extends MdxmlRepresentationTests {

	@Test
	public void testDefaultValue() {
		DefaultValue defaultValue = mdxmlBigEnum.getOwnedAttributes().get(0).getDefaultValue();
		assertNotNull(defaultValue);
		assertEquals("_19_0_1_62d0212_1579607983466_984418_4707", defaultValue.getId());
		assertEquals("uml:LiteralInteger", defaultValue.getType());
		assertEquals("10", defaultValue.getValue());
	}
}
