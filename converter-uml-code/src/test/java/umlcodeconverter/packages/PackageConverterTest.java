package umlcodeconverter.packages;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import code.CodeRepresentation;
import uml.UmlModel;
import uml.UmlPackage;
import umlcodeconverter.temporary.TemporaryModel;

/**
 * Tests the {@link PackageConverter}.
 * 
 * @author dschoenicke
 *
 */
public class PackageConverterTest {

	/**
	 * Mocks an {@link uml.UmlModel} to be used.
	 */
	private UmlModel mockUmlModel;
	
	/**
	 * Mocks a {@link umlcodeconverter.temporary.TemporaryModel} to be used.
	 */
	private TemporaryModel mockTmpModel;
	
	/**
	 * Mocks a {@link code.CodeRepresentation} to be used.
	 */
	private CodeRepresentation mockCodeRepresentation;
	
	/**
	 * Mocks an {@link uml.UmlPackage} to be converted.
	 */
	private UmlPackage umlPackage;
	
	/**
	 * Mocks a sub {@link uml.UmlPackage} to be converted.
	 */
	private UmlPackage umlSubPackage;
	
	/**
	 * Initializes the mock elements.
	 */
	@Before
	public void init() {
		mockUmlModel = new UmlModel("");
		mockTmpModel = new TemporaryModel();
		mockCodeRepresentation = new CodeRepresentation("");
		umlPackage = new UmlPackage("package");
		umlSubPackage = new UmlPackage("subPackage");
		umlPackage.addPackage(umlSubPackage);
		mockUmlModel.addPackage(umlPackage);
	}
	
	/**
	 * Tests {@link PackageConverter#convertPackages} and {@link PackageConverter#convertPackage}.
	 */
	@Test
	public void testPackageConverter() {
		PackageConverter.convertPackages(mockUmlModel.getPackages(), mockCodeRepresentation, mockTmpModel);
		assertEquals(mockCodeRepresentation.getPackages().get(0), mockTmpModel.getConvertedPackages().get(umlPackage));
		assertEquals(mockCodeRepresentation.getPackages().get(0).getPackages().get(0), mockTmpModel.getConvertedPackages().get(umlSubPackage));
	}
}
