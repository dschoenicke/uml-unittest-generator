package junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Tests the functionalitites of {@link junit.JunitRepresentation}
 * 
 * @author dschoenicke
 *
 */
public class JunitRepresentationTest extends TestInitializer {

	/**
	 * Tests {@link junit.JunitRepresentation#getTestClassesAsList()}
	 */
	@Test
	public void testGetTestClassesAsList() {
		assertEquals(2, mockRepresentation.getTestClassesAsList().size());
		assertTrue(mockRepresentation.getTestClassesAsList().contains(mockTestClass1));
		assertTrue(mockRepresentation.getTestClassesAsList().contains(mockTestClass2));
	}
}
