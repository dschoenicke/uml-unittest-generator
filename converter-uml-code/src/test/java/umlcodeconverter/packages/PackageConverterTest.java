package umlcodeconverter.packages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.CodePackage;
import code.CodeRepresentation;
import umlcodeconverter.UmlCodeConverterTests;

public class PackageConverterTest extends UmlCodeConverterTests {

	@Test
	public void testPackageConverter() {
		CodeRepresentation mockRepresentation = new CodeRepresentation("Test");
		PackageConverter.convertPackages(umlModel.getPackages(), mockRepresentation, mockTmpModel);
		CodePackage convertedTopPackage = mockTmpModel.getConvertedPackages().get(umlTopLevelPackage);
		CodePackage convertedSubPackage = mockTmpModel.getConvertedPackages().get(umlSubPackage);
		assertTrue(mockRepresentation.getPackages().contains(convertedTopPackage));
		assertTrue(convertedTopPackage.getPackages().contains(convertedSubPackage));
		assertEquals(1, mockRepresentation.getPackages().size());
		assertEquals(1, convertedTopPackage.getPackages().size());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidPackageConverter() {
		PackageConverter.convertPackage(umlTopLevelPackage, codeBigEnum, mockTmpModel);
	}
}
