package umlcodeconverter.element;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
		assertEquals(firstAttribute.getModifiers(), Integer.valueOf(2));
		assertTrue(firstAttribute.getDefaultValue().isEmpty());
		assertFalse(firstAttribute.getCanBeNull());
		assertFalse(firstAttribute.getHasMultiplicity());
		assertEquals(firstAttribute.getParent(), mockCodeClass);
		
		assertEquals(secondAttribute.getName(), mockMultiplicityUmlAttribute.getName());
		assertEquals(secondAttribute.getType(), mockMultiplicityUmlAttribute.getType());
		assertEquals(secondAttribute.getModifiers(), Integer.valueOf(2));
		assertEquals(secondAttribute.getDefaultValue(), "1.0");
		assertTrue(secondAttribute.getCanBeNull());
		assertTrue(secondAttribute.getHasMultiplicity());
		assertEquals(secondAttribute.getParent(), mockCodeClass);
	}
}
