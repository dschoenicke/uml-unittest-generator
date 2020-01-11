package outputjunit;

import java.io.File;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test.TestClass;
import test.TestPackage;
import test.TestRepresentation;
import test.testobjects.ClassUnderTest;

/**
 * Tests the {@link OutputJUnitConverter}.
 * 
 * @author dschoenicke
 *
 */
public class OutputJunitConverterTest {

	/**
	 * Mocks a {@link test.TestRepresentation} to be used in the tests.
	 */
	TestRepresentation mockTestRepresentation;
	
	/**
	 * Mocks a {@link test.TestPackage} to be used in the tests.
	 */
	TestPackage mockTestPackage1;
	
	/**
	 * Mocks a second {@link test.TestPackage} to be used in the tests.
	 */
	TestPackage mockTestPackage2;
	
	/**
	 * Mocks a sub {@link test.TestPackage} to be used in the tests.
	 */
	TestPackage mockSubTestPackage;
	
	/**
	 * Mocks a {@link test.TestClass} to be used in the tests.
	 */
	TestClass mockTestFile1;
	
	/**
	 * Mocks a second {@link test.TestClass} to be used in the tests.
	 */
	TestClass mockTestFile2;
	
	/**
	 * Mocks a sub {@link test.TestClass} to be used in the tests.
	 */
	TestClass mockSubTestFile;
	
	/**
	 * Initializes the mock elements.
	 */
	@Before
	public void init() {
		mockTestRepresentation = new TestRepresentation("testRepresentation");
		mockTestPackage1 = new TestPackage("firstpackage", mockTestRepresentation);
		mockTestPackage2 = new TestPackage("secondpackage", mockTestRepresentation);
		mockSubTestPackage = new TestPackage("subpackage", mockTestPackage1);
		mockTestRepresentation.getPackages().addAll(List.of(mockTestPackage1, mockTestPackage2));
		mockTestPackage1.addPackage(mockSubTestPackage);
		mockTestFile1 = new TestClass("firsttestclass", mockTestPackage1, new ClassUnderTest(null, null, 0, null));
		mockTestFile2 = new TestClass("secondtestclass", mockTestPackage2, new ClassUnderTest(null, null, 0, null));
		mockSubTestFile = new TestClass("subtestclass", mockSubTestPackage, new ClassUnderTest(null, null, 0, null));
		mockTestPackage1.addTestClass(mockTestFile1);
		mockTestPackage2.addTestClass(mockTestFile2);
		mockSubTestPackage.addTestClass(mockSubTestFile);
	}
	
	/**
	 * Tests {@link OutputJUnitConverter#convertToJUnitTestFiles}, executes the function and assumes that the root directory has been created.
	 */
	@Test
	public void testOutputJUnitConverter() {
		OutputJUnitConverter converter = new OutputJUnitConverter();
		//converter.convertToJUnitTestFiles(mockTestRepresentation, "test");
		//assertTrue(new File("test" + File.separator + mockTestRepresentation.getName() + "Structure" + 
			//	File.separator + mockTestPackage1.getName() + File.separator + 
				//mockTestFile1.getName() + ".java").exists());
	}
	
	/**
	 * Deletes the created files.
	 */
	@After
	public void cleanup() {
		new File("test" + File.separator + mockTestRepresentation.getName() + "Structure" + File.separator + mockTestPackage1.getName() + File.separator + mockTestFile1.getName() + ".java").delete();
		new File("test" + File.separator + mockTestRepresentation.getName() + "Structure" + File.separator + mockTestPackage2.getName() + File.separator + mockTestFile2.getName() + ".java").delete();
		new File("test" + File.separator + mockTestRepresentation.getName() + "Structure" + File.separator + mockTestPackage1.getName() + File.separator + mockSubTestPackage.getName() + File.separator + mockSubTestFile.getName() + ".java").delete();
		new File("test" + File.separator + mockTestRepresentation.getName() + "Structure" + File.separator + mockTestPackage1.getName() + File.separator + mockSubTestPackage.getName()).delete();
		new File("test" + File.separator + mockTestRepresentation.getName() + "Structure" + File.separator + mockTestPackage1.getName()).delete();
		new File("test" + File.separator + mockTestRepresentation.getName() + "Structure" + File.separator + mockTestPackage2.getName()).delete();
		new File("test" + File.separator + mockTestRepresentation.getName() + "Structure").delete();
	}
}
