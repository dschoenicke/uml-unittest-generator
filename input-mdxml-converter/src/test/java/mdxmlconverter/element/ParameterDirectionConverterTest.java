package mdxmlconverter.element;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uml.UmlParameterDirection;

/**
 * Tests the method of {@link ParameterDirectionConverter}.
 * 
 * @author dschoenicke
 *
 */
public class ParameterDirectionConverterTest {

	/**
	 * Tests {@link ParameterDirectionConverter#convertDirection}.
	 */
	@Test
	public void testParameterDirectionConverter() {
		assertEquals(ParameterDirectionConverter.convertDirection(null), UmlParameterDirection.IN);
		assertEquals(ParameterDirectionConverter.convertDirection("in"), UmlParameterDirection.IN);
		assertEquals(ParameterDirectionConverter.convertDirection("inout"), UmlParameterDirection.INOUT);
		assertEquals(ParameterDirectionConverter.convertDirection("out"), UmlParameterDirection.OUT);
		assertEquals(ParameterDirectionConverter.convertDirection("return"), UmlParameterDirection.RETURN);
	}
}
