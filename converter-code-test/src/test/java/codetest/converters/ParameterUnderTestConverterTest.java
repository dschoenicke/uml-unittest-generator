package codetest.converters;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import code.CodeParameter;
import codetest.CodeTestConverterTests;
import codetest.converters.ParameterUnderTestConverter;
import test.testobjects.ParameterUnderTest;

public class ParameterUnderTestConverterTest extends CodeTestConverterTests {

	@Test
	public void testConvertParameters() {
		CodeParameter param1 = codeGenericClass.getConstructors().get(0).getParameters().get(0);
		CodeParameter param2 = codeGenericClass.getMethods().get(1).getParameters().get(0);
		codeGenericClass.getConstructors().get(0).getParameters().add(param2);
		List<ParameterUnderTest> convertedParameters = ParameterUnderTestConverter.convertParametersUnderTest(codeGenericClass.getConstructors().get(0).getParameters());
		assertEquals(2, convertedParameters.size());
		assertEquals(param1.getName(), convertedParameters.get(0).getName());
		assertEquals(param1.getType(), convertedParameters.get(0).getType());
		assertEquals(param1.getModifiers(), convertedParameters.get(0).getModifiers());
		assertEquals(param1.getCanBeNull(), convertedParameters.get(0).getCanBeNull());
		assertEquals(param1.getHasMultiplicity(), convertedParameters.get(0).getHasMultiplicity());
	}
}
