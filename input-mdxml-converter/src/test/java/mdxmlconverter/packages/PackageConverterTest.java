package mdxmlconverter.packages;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import mdxml.PackagedElement;
import mdxmlconverter.temporary.TemporaryModel;
import uml.UmlModel;

/**
 * Tests the {@link PackageConverter#convertPackage} method.
 * 
 * @author dschoenicke
 *
 */
public class PackageConverterTest {

	/**
	 * Mocks a {@link mdxml PackagedElement} which will be converted to an {@link uml.UmlPackage}
	 */
	private PackagedElement mockPackagedElement;
	
	/**
	 * Initializes the mock {@link mdxml.PackagedElement}.
	 */
	@Before
	public void init() {
		mockPackagedElement = new PackagedElement();
		mockPackagedElement.setName("test");
	}
	
	/**
	 * Tests the {@link PackageConverter#convertPackage} method.
	 */
	@Test
	public void testPackageConverter() {
		assertEquals(PackageConverter.convertPackage(mockPackagedElement, new UmlModel(""), new TemporaryModel()).getName(), mockPackagedElement.getName());
	}
}
