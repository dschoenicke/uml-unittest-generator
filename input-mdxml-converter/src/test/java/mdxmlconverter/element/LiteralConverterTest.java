package mdxmlconverter.element;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import mdxmlconverter.MdxmlUmlConverterTests;

/**
 * Tests {@link LiteralConverter}
 * 
 * @author dschoenicke
 *
 */
public class LiteralConverterTest extends MdxmlUmlConverterTests {

	@Test
	public void testConvertLiterals() {
		umlEnumeration.getLiterals().clear();
		LiteralConverter.convertLiterals(mdxmlEnumeration, umlEnumeration);
		assertEquals(2, umlEnumeration.getLiterals().size());
		assertEquals("FIRST", umlEnumeration.getLiterals().get(0).getName());
		assertEquals("SECOND", umlEnumeration.getLiterals().get(1).getName());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidLiterals() {
		LiteralConverter.convertLiterals(mdxmlBigEnum, umlSubClass);
	}
}
