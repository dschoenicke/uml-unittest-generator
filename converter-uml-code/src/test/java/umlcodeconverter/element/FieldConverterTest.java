package umlcodeconverter.element;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.CodeField;

/**
 * Tests the {@link FieldConverter}.
 * 
 * @author dschoenicke
 *
 */
public class FieldConverterTest extends TestInitializer {

	/**
	 * Tests {@link FieldConverter#convertFields}.
	 */
	@Test
	public void testFieldConverter() {
		FieldConverter.convertFields(mockUmlClass, mockCodeClass);
		assertEquals(mockCodeClass.getFields().size(), mockUmlClass.getAttributes().size());
		
		CodeField firstAttribute = mockCodeClass.getFields().get(0);
		CodeField secondAttribute = mockCodeClass.getFields().get(1);
		
		assertEquals(firstAttribute.getName(), mockUmlAttribute.getName());
		assertEquals(firstAttribute.getType(), mockUmlAttribute.getType());
		assertEquals(firstAttribute.getModifiers(), 2);
		assertNull(firstAttribute.getDefaultValue());
		assertFalse(firstAttribute.canBeNull());
		assertFalse(firstAttribute.hasMultiplicity());
		assertEquals(firstAttribute.getParent(), mockCodeClass);
		
		assertEquals(secondAttribute.getName(), mockMultiplicityUmlAttribute.getName());
		assertEquals(secondAttribute.getType(), mockMultiplicityUmlAttribute.getType());
		assertEquals(secondAttribute.getModifiers(), 2);
		assertEquals(secondAttribute.getDefaultValue(), "1.0");
		assertTrue(secondAttribute.canBeNull());
		assertTrue(secondAttribute.hasMultiplicity());
		assertEquals(secondAttribute.getParent(), mockCodeClass);
	}
}
