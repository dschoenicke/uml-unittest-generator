package test.testobjects;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import test.TestRepresentationTests;

public class ClassUnderTestTest extends TestRepresentationTests {

	@Test
	public void testClassUnderTestType() {
		assertTrue(subClassUnderTest.isClass());
		assertFalse(subClassUnderTest.isEnum());
		assertFalse(subClassUnderTest.isInterface());
		
		assertFalse(enumerationUnderTest.isClass());
		assertTrue(enumerationUnderTest.isEnum());
		assertFalse(enumerationUnderTest.isInterface());
		
		assertFalse(subInterfaceUnderTest.isClass());
		assertFalse(subInterfaceUnderTest.isEnum());
		assertTrue(subInterfaceUnderTest.isInterface());
	}
}
