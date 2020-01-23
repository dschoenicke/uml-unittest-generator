package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestPackageTest extends TestRepresentationTests {
	@Test
	public void testQualifiedName() {
		assertEquals("TopLevelPackage.SubPackage", testSubPackage.getQualifiedName());
	}
	
	@Test
	public void testGetClassesAsList() {
		assertEquals(7, testTopLevelPackage.getTestClassesAsList().size());
	}
}
