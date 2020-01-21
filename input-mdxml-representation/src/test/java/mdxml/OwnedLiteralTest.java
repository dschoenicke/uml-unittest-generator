package mdxml;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OwnedLiteralTest extends MdxmlRepresentationTests {

	@Test
	public void testOwnedLiteral() {
		OwnedLiteral ownedLiteral = mdxmlEnumeration.getOwnedLiterals().get(0);
		assertEquals("_19_0_1_62d0212_1579603509782_587807_4651", ownedLiteral.getId());
		assertEquals("FIRST", ownedLiteral.getName());
	}
}
