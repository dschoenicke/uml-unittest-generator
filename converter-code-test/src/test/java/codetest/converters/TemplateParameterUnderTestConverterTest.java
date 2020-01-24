package codetest.converters;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import codetest.CodeTestConverterTests;
import codetest.converters.TemplateParameterUnderTestConverter;

public class TemplateParameterUnderTestConverterTest extends CodeTestConverterTests {

	@Test
	public void testConvertTemplateParameters() {
		genericClassUnderTest.getTemplateParameters().clear();
		TemplateParameterUnderTestConverter.convertTemplateParameters(codeGenericClass, genericClassUnderTest);
		assertEquals(2, genericClassUnderTest.getTemplateParameters().size());
		assertEquals("T", genericClassUnderTest.getTemplateParameters().get(0).getParameterName());
		assertEquals("Model.TopLevelClass", genericClassUnderTest.getTemplateParameters().get(0).getBoundedType());
		assertEquals(genericClassUnderTest, genericClassUnderTest.getTemplateParameters().get(0).getParent());
	}
}
