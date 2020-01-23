package codetestconverter.testclass;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import code.CodeField;
import codetestconverter.CodeTestConverterTests;
import test.testobjects.FieldUnderTest;

public class FieldUnderTestConverterTest extends CodeTestConverterTests {

	@Test
	public void testFieldConverter() {
		genericClassUnderTest.getFields().clear();
		FieldUnderTestConverter.convertFieldsUnderTest(codeGenericClass, genericClassUnderTest);
		assertEquals(2, genericClassUnderTest.getFields().size());
		CodeField field = codeGenericClass.getFields().get(0);
		FieldUnderTest convertedField = genericClassUnderTest.getFields().get(0);
		assertEquals(field.getName(), convertedField.getName());
		assertEquals(field.getType(), convertedField.getType());
		assertEquals(field.getModifiers().intValue(), convertedField.getModifiers());
		assertEquals(field.getCanBeNull(), convertedField.isCanBeNull());
		assertEquals(field.getHasMultiplicity(), convertedField.isHasMultiplicity());
		assertEquals(genericClassUnderTest, convertedField.getParent());
	}
	
	@Test
	public void testEnumConstantConverter() {
		enumerationUnderTest.getEnumConstants().clear();
		FieldUnderTestConverter.convertEnumConstantsUnderTest(codeEnumeration, enumerationUnderTest);
		assertEquals(2, enumerationUnderTest.getEnumConstants().size());
		assertEquals(codeEnumeration.getLiterals().get(0).getName(), enumerationUnderTest.getEnumConstants().get(0).getName());
	}
}
