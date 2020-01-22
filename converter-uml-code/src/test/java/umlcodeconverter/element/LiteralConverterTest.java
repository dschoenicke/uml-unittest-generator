package umlcodeconverter.element;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import umlcodeconverter.UmlCodeConverterTests;

public class LiteralConverterTest extends UmlCodeConverterTests {

	@Test
	public void testLiteralConverter() {
		codeEnumeration.getLiterals().clear();
		LiteralConverter.convertLiterals(umlEnumeration, codeEnumeration);
		assertEquals(2, codeEnumeration.getLiterals().size());
		assertEquals("FIRST", codeEnumeration.getLiterals().get(0).getName());
		assertEquals("SECOND", codeEnumeration.getLiterals().get(1).getName());
	}
}
