package outputjunit.converter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import junit.JunitTemplateParameterUnderTest;
import outputjunit.OutputJunitConverterTests;

/**
 * Tests {@link TemplateParameterConverter}
 * 
 * @author dschoenicke
 *
 */
public class TemplateParameterConverterTest extends OutputJunitConverterTests {

	/**
	 * Tests {@link TemplateParameterConverter#convertTemplateParameters}
	 */
	@Test
	public void testConvertTemplateParameters() {
		TemplateParameterConverter.convertTemplateParameters(mockClass2, mockJunitTestClass2);
		JunitTemplateParameterUnderTest templateParameter = mockJunitTestClass2.getTemplateParameters().get(0);
		assertEquals(1, mockJunitTestClass2.getTemplateParameters().size());
		assertEquals("T", templateParameter.getName());
		assertEquals("app.firstpackage.firstclass", templateParameter.getBoundedType());
		assertEquals(2, templateParameter.getAssertions().size());
	}
}
