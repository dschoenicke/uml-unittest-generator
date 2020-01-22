package umlcodeconverter.element;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uml.UmlVisibility;

public class ModifierConverterTest {

	@Test
	public void testModifierValueConversion() {
		assertEquals(0, ModifierConverter.convertModifierValue(null, false, false, false));
		assertEquals(1, ModifierConverter.convertModifierValue(UmlVisibility.PUBLIC, false, false, false));
		assertEquals(2, ModifierConverter.convertModifierValue(UmlVisibility.PRIVATE, false, false, false));
		assertEquals(4, ModifierConverter.convertModifierValue(UmlVisibility.PROTECTED, false, false, false));
		assertEquals(8, ModifierConverter.convertModifierValue(null, true, false, false));
		assertEquals(16, ModifierConverter.convertModifierValue(null, false, true, false));
		assertEquals(1024, ModifierConverter.convertModifierValue(null, false, false, true));
	}
}
