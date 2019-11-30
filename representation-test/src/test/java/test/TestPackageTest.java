package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the {@link TestPackage#getQualifiedName} method
 */
public class TestPackageTest {
	
	/**
	 * Mocks a parent {@link TestPackage}
	 */
	private TestPackage mockParentPackage;
	
	/**
	 * Mocks a sub {@link TestPackage}
	 */
	private TestPackage mockSubPackage;
	
	/**
	 * Initializes the mock {@link TestPackage}s
	 */
	@Before
	public void init() {
		mockParentPackage = new TestPackage("parent", new TestRepresentation("model"));
		mockSubPackage = new TestPackage("subpackage", mockParentPackage);
	}
	
	/**
	 * Tests the {@link TestPackage#getQualifiedName} method
	 */
	@Test
	public void testQualifiedName() {
		assertEquals(mockSubPackage.getQualifiedName(), mockParentPackage.getParent().getName() + "." + 
				mockParentPackage.getName() + "." + mockSubPackage.getName());
	}
}
