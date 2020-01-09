package codetestconverter.testclass;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import code.CodeClass;
import code.CodePackage;
import code.CodeRepresentation;
import code.CodeVisibility;
import codetestconverter.temporary.TemporaryModel;
import test.TestPackage;
import test.TestRepresentation;

public class TestClassConverterTest {

	/**
	 * Mocks a {@link test.TestRepresentation} to be used in the test.
	 */
	TestRepresentation mockTestRepresentation;
	
	/**
	 * Mocks a {@link test.TestPackage} to be used in the test.
	 */
	TestPackage mockTestPackage;
	
	/**
	 * Mocks a {@link codetestconverter.temporary.TemporaryModel}
	 */
	TemporaryModel mockTmpModel;
	
	/**
	 * Mocks a {@link code.CodeRepresentation} to be used in the test.
	 */
	CodeRepresentation mockCodeRepresentation;
	
	/**
	 * Mocks a {@link code.CodePackage} to be used in the test.
	 */
	CodePackage mockCodePackage;
	
	/**
	 * Mocks a {@link code.CodeClass} to be used in the test.
	 */
	CodeClass mockCodeClass;
	
	/**
	 * Mocks a nested {@link code.CodeClass} to be used in the test.
	 */
	CodeClass mockNestedClass;
	
	/**
	 * Initializes the mock elements.
	 */
	@Before
	public void init() {
		mockTestRepresentation = new TestRepresentation("");
		mockCodeRepresentation = new CodeRepresentation("");
		mockTestPackage = new TestPackage("package", mockTestRepresentation);
		mockCodePackage = new CodePackage("package", mockCodeRepresentation);
		mockCodeClass = new CodeClass("class", mockCodePackage, CodeVisibility.PUBLIC, false, false, false);
		mockNestedClass = new CodeClass("nestedclass", mockCodeClass, CodeVisibility.DEFAULT, false, false, false);
		mockCodeClass.addNestedElement(mockNestedClass);
		mockCodePackage.addElement(mockCodeClass);
		mockTmpModel = new TemporaryModel();
		mockTmpModel.addConvertedPackage(mockCodePackage, mockTestPackage);
	}
	
	/**
	 * Tests {@link TestClassConverter#convertTestClasses}.
	 */
	@Test
	public void testTestClassConverter() {
		TestClassConverter.convertTestClasses(mockTmpModel);
		assertEquals(2, mockTestPackage.getTestClasses().size());
		assertEquals("classTest", mockTestPackage.getTestClasses().get(0).getName());
		assertEquals("nestedclassTest", mockTestPackage.getTestClasses().get(1).getName());
	}
}
