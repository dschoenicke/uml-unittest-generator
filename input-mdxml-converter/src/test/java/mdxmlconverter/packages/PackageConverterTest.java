package mdxmlconverter.packages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import mdxmlconverter.MdxmlUmlConverterTests;
import mdxmlconverter.temporary.TemporaryModel;
import uml.UmlPackage;

public class PackageConverterTest extends MdxmlUmlConverterTests {

	@Test
	public void testTopLevelPackageConverter() {
		umlModel.getPackages().clear();
		UmlPackage umlPackage = PackageConverter.convertPackage(mdxmlTopLevelPackage, umlModel, new TemporaryModel());
		assertEquals(umlTopLevelPackage.getName(), umlPackage.getName());
		assertTrue(umlModel.getPackages().contains(umlPackage));
	}
	
	@Test
	public void testSubPackageConverter() {
		umlTopLevelPackage.getPackages().clear();
		UmlPackage umlPackage = PackageConverter.convertPackage(mdxmlSubPackage, umlTopLevelPackage, new TemporaryModel());
		assertEquals(umlSubPackage.getName(), umlPackage.getName());
		assertTrue(umlTopLevelPackage.getPackages().contains(umlPackage));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidPackageConverter() {
		PackageConverter.convertPackage(mdxmlSubPackage, umlBigEnum, mockTmpModel);
	}
}
