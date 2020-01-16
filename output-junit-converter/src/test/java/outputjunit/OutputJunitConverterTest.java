package outputjunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

/**
 * Tests {@link OutputJunitConverter}
 * 
 * @author dschoenicke
 *
 */
public class OutputJunitConverterTest extends OutputJunitConverterTests {

	/**
	 * Tests {@link OutputJunitConverter#convertTestToJunitRepresentation}
	 */
	@Test
	public void testConvertTestToJunitRepresentation() {
		assertEquals("app", OutputJunitConverter.convertTestToJunitRepresentation(mockTestRepresentation).getName());
	}
	
	/**
	 * Tests {@link OutputJunitConverter#convertTestFiles}
	 */
	@Test
	public void testConvertTestFiles() {
		new OutputJunitConverter().convertTestFiles(mockTestRepresentation, outputPath);
		assertTrue(new File(testDirectory).exists());
	}
}
