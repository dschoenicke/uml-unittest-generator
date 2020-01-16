package outputjunit.files;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

import junit.JunitTestClass;
import outputjunit.OutputJunitConverterTests;

/**
 * Tests {@link TestFileCreator}
 * 
 * @author dschoenicke
 *
 */
public class TestFileCreatorTest extends OutputJunitConverterTests {
	
	/**
	 * Test {@link TestFileCreator#createTestFiles}
	 */
	@Test
	public void testCreateTestFiles() {
		FileDirectoryCreator.createFileDirectories(mockJunitRepresentation, outputPath);
		mockJunitExternPackage.addTestClass(new JunitTestClass("externclassTest", "extern.externclass", "extern", mockJunitExternPackage));
		TestFileCreator.createTestFiles(mockJunitRepresentation, outputPath);
		File testfile = new File(testDirectory + File.separator + "app" + File.separator + "firstpackage" + File.separator + "firstclassTest.java");
		assertTrue(testfile.exists());
		testfile.delete();
		testfile = new File(testDirectory + File.separator + "app" + File.separator + "secondpackage" + File.separator + "secondclassTest.java");
		assertTrue(testfile.exists());
		testfile.delete();
		testfile = new File(testDirectory + File.separator + "app" + File.separator + "firstpackage" + File.separator + "subpackage" + File.separator + "subclassTest.java");
		assertTrue(testfile.exists());
		testfile.delete();
		testfile = new File(testDirectory + File.separator + "app" + File.separator + "secondpackage" + File.separator + "innerclassTest.java");
		assertTrue(testfile.exists());
		testfile.delete();
		testfile = new File(testDirectory + File.separator + "extern" + File.separator + "externclassTest");
		assertFalse(testfile.exists());
	}
}
