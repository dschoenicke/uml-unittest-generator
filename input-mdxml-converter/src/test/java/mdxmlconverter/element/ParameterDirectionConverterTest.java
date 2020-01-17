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
		assertEquals(UmlParameterDirection.IN, ParameterDirectionConverter.convertDirection(null));
		assertEquals(UmlParameterDirection.IN, ParameterDirectionConverter.convertDirection("in"));
		assertEquals(UmlParameterDirection.INOUT, ParameterDirectionConverter.convertDirection("inout"));
		assertEquals(UmlParameterDirection.OUT, ParameterDirectionConverter.convertDirection("out"));
		assertEquals(UmlParameterDirection.RETURN, ParameterDirectionConverter.convertDirection("return"));
	}
}
