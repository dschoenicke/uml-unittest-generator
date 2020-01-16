package outputjunit.files;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

import outputjunit.OutputJunitConverterTests;

/**
 * Tests the {@link FileDirectoryCreator}.
 * 
 * @author dschoenicke
 *
 */
public class FileDirectoryCreatorTest extends OutputJunitConverterTests {
	
	/**
	 * Tests {@link FileDirectoryCreator#createFileDirectories}
	 */
	@Test
	public void testCreateDirectories() {
		FileDirectoryCreator.createFileDirectories(mockJunitRepresentation, outputPath);
		File directory = new File(testDirectory);
		assertTrue(directory.exists());
		assertTrue(directory.isDirectory());
		directory = new File(testDirectory + File.separator + "app");
		assertTrue(directory.exists());
		assertTrue(directory.isDirectory());
		directory = new File(testDirectory + File.separator + "app" + File.separator + "firstpackage");
		assertTrue(directory.exists());
		assertTrue(directory.isDirectory());
		directory = new File(testDirectory + File.separator + "app" + File.separator + "secondpackage");
		assertTrue(directory.exists());
		assertTrue(directory.isDirectory());
		directory = new File(testDirectory + File.separator + "app" + File.separator + "firstpackage" + File.separator + "subpackage");
		assertTrue(directory.exists());
		assertTrue(directory.isDirectory());
		directory = new File(testDirectory + File.separator + "extern");
		assertFalse(directory.exists());
		
	}
}
