package umlcodeconverter.element;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import code.CodeVisibility;
import uml.UmlVisibility;

/**
 * Tests the {@link ModifierConverter}.
 * 
 * @author dschoenicke
 *
 */
public class ModifierConverterTest {

	/**
	 * Tests {@link ModifierConverter#convertAccessModifier}.
	 */
	@Test
	public void testModifierConverter() {
		assertEquals(ModifierConverter.convertAccessModifier(null), CodeVisibility.DEFAULT);
		assertEquals(ModifierConverter.convertAccessModifier(UmlVisibility.DEFAULT), CodeVisibility.DEFAULT);
		assertEquals(ModifierConverter.convertAccessModifier(UmlVisibility.PUBLIC), CodeVisibility.PUBLIC);
		assertEquals(ModifierConverter.convertAccessModifier(UmlVisibility.PRIVATE), CodeVisibility.PRIVATE);
		assertEquals(ModifierConverter.convertAccessModifier(UmlVisibility.PROTECTED), CodeVisibility.PROTECTED);
	}
}
