package junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Tests the functionalities of {@link junit.JunitPackage}
 * 
 * @author dschoenicke
 *
 */
public class JunitPackageTest extends TestInitializer {

	/**
	 * Tests {@link junit.JunitPackage#getQualifiedName()}
	 */
	@Test
	public void testGetQualifiedName() {
		assertEquals("parent", mockPackage.getQualifiedName());
		assertEquals("parent.sub", subPackage.getQualifiedName());
	}
	
	/**
	 * Tests {@link junit.JunitPackage#getTestClassesAsList()}
	 */
	@Test
	public void testGetTestClassesAsList() {
		assertEquals(2, mockPackage.getTestClassesAsList().size());
		assertTrue(mockPackage.getTestClassesAsList().contains(mockTestClass1));
		assertTrue(mockPackage.getTestClassesAsList().contains(mockTestClass2));
	}
}
