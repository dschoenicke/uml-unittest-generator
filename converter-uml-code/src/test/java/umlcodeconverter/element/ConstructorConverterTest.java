package umlcodeconverter.element;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests the {@link ConstructorConverter}.
 * 
 * @author dschoenicke
 *
 */
public class ConstructorConverterTest extends TestInitializer {

	/**
	 * Tests {@link ConstructorConverter#convertConstructors}.
	 */
	@Test
	public void testConstructorConverter() {
		mockCodeClass.getConstructors().clear();
		ConstructorConverter.convertConstructors(mockUmlClass, mockCodeClass, mockTmpModel);
		assertEquals(mockCodeClass.getConstructors().size(), 1);
		assertEquals(mockCodeClass.getConstructors().get(0).getName(), mockCodeClass.getName());
	}
}
