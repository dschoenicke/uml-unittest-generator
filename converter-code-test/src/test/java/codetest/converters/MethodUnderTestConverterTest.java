package codetest.converters;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import code.CodeMethod;
import codetest.CodeTestConverterTests;
import codetest.converters.MethodUnderTestConverter;
import test.testobjects.MethodUnderTest;

public class MethodUnderTestConverterTest extends CodeTestConverterTests {

	@Test
	public void testConstructorConverter() {
		genericClassUnderTest.getMethods().clear();
		MethodUnderTestConverter.convertMethodsUnderTest(codeGenericClass, genericClassUnderTest);
		assertEquals(2, genericClassUnderTest.getMethods().size());
		CodeMethod method = codeGenericClass.getMethods().get(0);
		MethodUnderTest convertedMethod = genericClassUnderTest.getMethods().get(0);
		assertEquals(method.getName(), convertedMethod.getName());
		assertEquals(method.getModifiers(), convertedMethod.getModifiers());
		assertEquals(genericClassUnderTest, convertedMethod.getParent());
		assertEquals(method.getReturnType().getType(), convertedMethod.getReturnType().getType());
		assertEquals(method.getParameters().size(), convertedMethod.getParameters().size());
	}
}
