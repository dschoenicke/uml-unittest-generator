package codetestconverter.assertions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import test.TestAssertionType;

/**
 * Tests the {@link TemplateParameterAssertionConverter}
 * 
 * @author dschoenicke
 *
 */
public class TemplateParameterAssertionConverterTest extends AssertionTests {

	/**
	 * Tests {@link TemplateParameterAssertionConverter#createTemplateParameterAssertions}.
	 */
	@Test
	public void testTemplateParameterAssertionConverter() {
		TemplateParameterAssertionConverter.createTemplateParameterAssertions(mockCodeClass, mockTestMethod);
		assertEquals(mockTestMethod.getAssertions().size(), 2);
		assertEquals(mockTestMethod.getAssertions().get(0).getAssertionType(), TestAssertionType.COUNT);
		assertEquals(mockTestMethod.getAssertions().get(1).getAssertionType(), TestAssertionType.HASTEMPLATEPARAMETER);
	}
}
