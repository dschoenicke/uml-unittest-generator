package codetest.converter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import code.CodeConstructor;
import codetest.CodeTestConverterTests;
import codetest.converter.ConstructorUnderTestConverter;
import test.testobjects.ConstructorUnderTest;

public class ConstructorUnderTestConverterTest extends CodeTestConverterTests {

	@Test
	public void testConstructorConverter() {
		genericClassUnderTest.getConstructors().clear();
		ConstructorUnderTestConverter.convertConstructorsUnderTest(codeGenericClass, genericClassUnderTest);
		assertEquals(1, genericClassUnderTest.getConstructors().size());
		CodeConstructor constructor = codeGenericClass.getConstructors().get(0);
		ConstructorUnderTest convertedConstructor = genericClassUnderTest.getConstructors().get(0);
		assertEquals(constructor.getModifiers(), convertedConstructor.getModifiers());
		assertEquals(genericClassUnderTest, convertedConstructor.getParent());
		assertEquals(constructor.getParameters().size(), convertedConstructor.getParameters().size());
	}
}
