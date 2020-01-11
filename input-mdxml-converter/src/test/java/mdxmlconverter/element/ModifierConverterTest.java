package mdxmlconverter.element;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import uml.UmlVisibility;

/**
 * Tests the methods of {@link ModifierConverter}.
 * 
 * @author dschoenicke
 *
 */
public class ModifierConverterTest {

	/**
	 * Tests {@link ModifierConverter#convertAccessModifier}.
	 */
	@Test
	public void testAccessModifier() {
		assertEquals(ModifierConverter.convertAccessModifier(null), UmlVisibility.PUBLIC);
		assertEquals(ModifierConverter.convertAccessModifier("---"), UmlVisibility.PUBLIC);
		assertEquals(ModifierConverter.convertAccessModifier("package"), UmlVisibility.PACKAGE);
		assertEquals(ModifierConverter.convertAccessModifier("private"), UmlVisibility.PRIVATE);
		assertEquals(ModifierConverter.convertAccessModifier("protected"), UmlVisibility.PROTECTED);
	}
	
	/**
	 * Tests {@link ModifierConverter#convertNonAccessModifier}.
	 */
	@Test
	public void testNonAccessModifier() {
		assertTrue(ModifierConverter.convertNonAccessModifier("true"));
		assertFalse(ModifierConverter.convertNonAccessModifier(null));
	}
}
