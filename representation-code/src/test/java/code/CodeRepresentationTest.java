package code;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class CodeRepresentationTest extends CodeRepresentationTests {
	
	@Test
	public void testGetPackagesAsList() {
		List<CodePackage> packages = codeRepresentation.getPackagesAsList();
		assertTrue(packages.contains(codeModelPackage));
		assertTrue(packages.contains(codeTopLevelPackage));
		assertTrue(packages.contains(codeSubPackage));
	}
	
	@Test
	public void testGetElementsAsList() {
		List<CodeElement> elements = codeRepresentation.getElementsAsList();
		assertTrue(elements.contains(codeTopLevelInterface));
		assertTrue(elements.contains(codeTopLevelClass));
		assertTrue(elements.contains(codeSubInterface));
		assertTrue(elements.contains(codeSubClass));
		assertTrue(elements.contains(codeGenericClass));
		assertTrue(elements.contains(codeBindingClass));
		assertTrue(elements.contains(codeSubPackageClass));
		assertTrue(elements.contains(codeEnumeration));
		assertTrue(elements.contains(codeBigEnum));
	}
}
