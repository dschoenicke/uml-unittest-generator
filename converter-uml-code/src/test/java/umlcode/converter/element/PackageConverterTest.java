package umlcode.converter.element;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.CodePackage;
import code.CodeRepresentation;
import umlcode.UmlCodeConverterTests;
import umlcode.converter.element.PackageConverter;

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
	
	@Test
	public void testCreateTopLevelPackage() {
		codeRepresentation.getPackages().clear();
		PackageConverter.convertPackages(umlModel.getPackages(), codeRepresentation, mockTmpModel);
		CodePackage subPackage = new CodePackage("Model.SubPackage", codeRepresentation);
		codeRepresentation.addPackage(subPackage);
		assertEquals(2, codeRepresentation.getPackages().size());
		CodePackage topLevelPackage = PackageConverter.createTopLevelPackage(codeRepresentation);
		assertEquals(2, codeRepresentation.getPackages().size());
		assertTrue(codeRepresentation.getPackages().contains(topLevelPackage));
		assertTrue(topLevelPackage.getPackages().contains(subPackage));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidPackageConverter() {
		PackageConverter.convertPackage(umlTopLevelPackage, codeBigEnum, mockTmpModel);
	}
}
