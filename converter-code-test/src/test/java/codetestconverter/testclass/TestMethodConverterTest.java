package codetestconverter.testclass;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import code.CodeEnumeration;
import code.CodePackage;
import code.CodeRepresentation;
import code.CodeVisibility;
import test.TestClass;

/**
 * Tests the {@link TestMethodConverter}.
 * 
 * @author dschoenicke
 *
 */
public class TestMethodConverterTest {

	/**
	 * Tests {@link TestMethodConverter#createTestMethods}.
	 */
	@Test
	public void testTestMethodConverter() {
		TestClass mockTestClass = new TestClass(null, null);
		CodePackage mockCodePackage = new CodePackage("package", new CodeRepresentation(""));
		CodeEnumeration mockCodeEnumeration = new CodeEnumeration("enum", mockCodePackage, CodeVisibility.PUBLIC, false, false, false);
		TestMethodConverter.createTestMethods(mockCodeEnumeration, mockTestClass);
		assertEquals(mockTestClass.getMethods().size(), 7);
		assertEquals(mockTestClass.getMethods().get(0).getName(), "testClassProperties");
		assertEquals(mockTestClass.getMethods().get(1).getName(), "testClassRelationships");
		assertEquals(mockTestClass.getMethods().get(2).getName(), "testTemplateParameters");
		assertEquals(mockTestClass.getMethods().get(3).getName(), "testClassFields");
		assertEquals(mockTestClass.getMethods().get(4).getName(), "testEnumerationConstants");
		assertEquals(mockTestClass.getMethods().get(5).getName(), "testClassConstructors");
		assertEquals(mockTestClass.getMethods().get(6).getName(), "testClassMethods");
	}
}
