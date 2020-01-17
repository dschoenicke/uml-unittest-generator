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
		assertEquals(UmlVisibility.PUBLIC, ModifierConverter.convertAccessModifier(null));
		assertEquals(UmlVisibility.PUBLIC, ModifierConverter.convertAccessModifier("---"));
		assertEquals(UmlVisibility.PACKAGE, ModifierConverter.convertAccessModifier("package"));
		assertEquals(UmlVisibility.PRIVATE, ModifierConverter.convertAccessModifier("private"));
		assertEquals(UmlVisibility.PROTECTED, ModifierConverter.convertAccessModifier("protected"));
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
