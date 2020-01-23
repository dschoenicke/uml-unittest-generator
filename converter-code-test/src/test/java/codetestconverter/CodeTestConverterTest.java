package codetestconverter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CodeTestConverterTest extends CodeTestConverterTests {
	
	@Test
	public void testCodeTestConverter() {
		assertEquals(codeRepresentation.getName(), converter.convertCodeToTestRepresentation(codeRepresentation).getName());
	}
}