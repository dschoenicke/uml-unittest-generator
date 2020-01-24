package inputmdxml.converter.element;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import inputmdxml.converter.element.ParameterDirectionConverter;
import uml.UmlParameterDirection;

public class ParameterDirectionConverterTest {

	@Test
	public void testParameterDirectionConverter() {
		assertEquals(UmlParameterDirection.IN, ParameterDirectionConverter.convertDirection(null));
		assertEquals(UmlParameterDirection.IN, ParameterDirectionConverter.convertDirection("in"));
		assertEquals(UmlParameterDirection.INOUT, ParameterDirectionConverter.convertDirection("inout"));
		assertEquals(UmlParameterDirection.OUT, ParameterDirectionConverter.convertDirection("out"));
		assertEquals(UmlParameterDirection.RETURN, ParameterDirectionConverter.convertDirection("return"));
	}
}
