package codetestconverter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import code.CodeRepresentation;
import test.TestRepresentation;

/**
 * Tests the {@link CodeTestConverter}.
 * 
 * @author dschoenicke
 *
 */
public class CodeTestConverterTest {
	
	/**
	 * Checks if {@link CodeTestConverter#convertCodeToTestRepresentation} assigns the name of the {@link code.CodeRepresentation} to the {@link test.TestRepresentation}.
	 */
	@Test
	public void testCodeTestConverter() {
		CodeTestConverter converter = new CodeTestConverter();
		CodeRepresentation mockCodeRepresentation = new CodeRepresentation("representation");
		TestRepresentation mockTestRepresentation = converter.convertCodeToTestRepresentation(mockCodeRepresentation);
		assertEquals(mockCodeRepresentation.getName(), mockTestRepresentation.getName());
	}
}