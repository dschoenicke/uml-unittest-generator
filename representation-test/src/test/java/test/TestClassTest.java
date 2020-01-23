package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestClassTest extends TestRepresentationTests {

	@Test
	public void testClassQualifiedName() {
		assertEquals("TopLevelPackage.SubPackage.SubPackageClassTest", testSubPackageClass.getQualifiedName());
	}
}
