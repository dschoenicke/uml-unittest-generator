package outputjunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

public class OutputJunitConverterTest extends OutputJunitConverterTests {

	@Test
	public void testConvertTestToJunitRepresentation() {
		assertEquals("app", OutputJunitConverter.convertTestToJunitRepresentation(mockTestRepresentation).getName());
	}
	
	@Test
	public void testConvertTestFiles() {
		new OutputJunitConverter().convertTestFiles(mockTestRepresentation, outputPath);
		assertTrue(new File(testDirectory).exists());
	}
}
