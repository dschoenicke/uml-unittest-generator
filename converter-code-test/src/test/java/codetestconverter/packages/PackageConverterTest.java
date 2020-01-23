package codetestconverter.packages;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import codetestconverter.CodeTestConverterTests;

public class PackageConverterTest extends CodeTestConverterTests {
	
	@Test
	public void testConvertPackage() {
		testRepresentation.getPackages().clear();
		PackageConverter.convertPackages(codeRepresentation, testRepresentation, mockTmpModel);
		assertEquals(3, mockTmpModel.getConvertedPackages().size());
		assertEquals(1, testRepresentation.getPackages().size());
		assertEquals(1, testRepresentation.getPackages().get(0).getPackages().size());
		assertEquals(1, testRepresentation.getPackages().get(0).getPackages().get(0).getPackages().size());
		assertEquals(codeModelPackage.getName(), testRepresentation.getPackages().get(0).getName());
		assertEquals(codeTopLevelPackage.getName(), testRepresentation.getPackages().get(0).getPackages().get(0).getName());
		assertEquals(codeSubPackage.getName(), testRepresentation.getPackages().get(0).getPackages().get(0).getPackages().get(0).getName());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIllegalPackage() {
		PackageConverter.convertPackages(codeBigEnum, testRepresentation, mockTmpModel);
	}
}
