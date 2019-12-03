package umlcodeconverter.element;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests the {@link LiteralConverter}
 *
 * @author dschoenicke
 *
 */
public class LiteralConverterTest extends TestInitializer {

	/**
	 * Tests {@link LiteralConverter#convertLiterals}.
	 */
	@Test
	public void testLiteralConverter() {
		LiteralConverter.convertLiterals(mockUmlEnumeration, mockCodeEnumeration);
		assertEquals(mockCodeEnumeration.getCodeLiterals().get(0).getName(), mockUmlLiteral.getName());
	}
}
