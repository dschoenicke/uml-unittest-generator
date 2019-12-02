package codetestconverter.packages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import code.CodePackage;
import code.CodeRepresentation;
import codetestconverter.temporary.TemporaryModel;
import test.TestPackage;
import test.TestRepresentation;

/**
 * Tests the {@link PackageConverter#convertPackages} method
 * 
 * @author dschoenicke
 *
 */
public class CodePackageTest {

	/**
	 * Mocks a {@link code.CodeRepresentation} containing the {@link code.CodePackage}s to be used.
	 */
	private CodeRepresentation mockCodeRepresentation;
	
	/**
	 * Mocks a {@link test.TestRepresentation} to which the converted {@link test.TestPackage}s will be added.
	 */
	private TestRepresentation mockTestRepresentation;
	
	/**
	 * Mocks a {@link code.CodePackage} of the {@link code.CodeRepresentation}.
	 */
	private CodePackage mockPackage;
	
	/**
	 * Mocks a {@link code.CodePackage} of another {@link code.CodePackage}.
	 */
	private CodePackage mockSubPackage;

	/**
	 * Initializes the mock elements
	 */
	@Before
	public void init() {
		mockCodeRepresentation = new CodeRepresentation("codeRepresentation");
		mockTestRepresentation = new TestRepresentation("testRepresentation");
		mockPackage = new CodePackage("package", mockCodeRepresentation);
		mockSubPackage = new CodePackage("subpackage", mockPackage);
		mockPackage.addPackage(mockSubPackage);
		mockCodeRepresentation.addPackage(mockPackage);
	}
	
	/**
	 * Tests the {@link PackageConverter#convertPackages} method
	 */
	@Test
	public void testPackageConversion() {
		PackageConverter.convertPackages(mockCodeRepresentation, mockTestRepresentation, new TemporaryModel());
		TestPackage testPackage = mockTestRepresentation.getPackages().get(0);
		assertNotNull(testPackage);
		assertEquals(testPackage.getName(), mockPackage.getName());
		testPackage = testPackage.getPackages().get(0);
		assertNotNull(testPackage);
		assertEquals(testPackage.getName(), mockSubPackage.getName());
	}
}
