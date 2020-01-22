package umlcodeconverter.element;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.CodeConstructor;
import code.CodeMethod;
import code.CodeParameter;
import uml.UmlMultiplicityValue;
import uml.UmlParameter;
import uml.UmlParameterDirection;
import umlcodeconverter.UmlCodeConverterTests;

public class ParameterConverterTest extends UmlCodeConverterTests {

	@Test
	public void testCreateParameter() { 
		UmlParameter mockUmlParameter = umlGenericClass.getOperations().get(1).getParameters().get(0);
		codeGenericClass.getMethods().get(0).getParameters().clear();
		CodeParameter convertedParameter = ParameterConverter.createParameter(mockUmlParameter, codeGenericClass.getMethods().get(0));
		assertEquals(mockUmlParameter.getName(), convertedParameter.getName());
		assertEquals(codeGenericClass.getMethods().get(0), convertedParameter.getParent());
		assertEquals(mockUmlParameter.getType(), convertedParameter.getType());
		assertEquals(Integer.valueOf(0), convertedParameter.getModifiers());
	}
	
	@Test
	public void testNullableParameter() {
		UmlParameter param = new UmlParameter("", "", UmlParameterDirection.IN, false, UmlMultiplicityValue.ZERO, UmlMultiplicityValue.ONE);
		assertTrue(ParameterConverter.createParameter(param, codeBigEnum.getConstructors().get(0)).getCanBeNull());
	}
	
	@Test
	public void testConvertParametersWithOperation() {
		CodeMethod mockCodeMethod = codeGenericClass.getMethods().get(1);
		mockCodeMethod.getParameters().clear();
		ParameterConverter.convertParameters(umlGenericClass.getOperations().get(2), mockCodeMethod);
		assertEquals(1, mockCodeMethod.getParameters().size());
		assertEquals(umlGenericClass.getOperations().get(2).getParameters().get(1).getName(), mockCodeMethod.getParameters().get(0).getName());
	}
	
	@Test
	public void testConvertParametersWithConstructor() {
		CodeConstructor mockCodeConstructor = codeGenericClass.getConstructors().get(0);
		mockCodeConstructor.getParameters().clear();
		ParameterConverter.convertParameters(umlGenericClass.getOperations().get(0), mockCodeConstructor);
		assertEquals(1, mockCodeConstructor.getParameters().size());
		assertEquals(umlGenericClass.getOperations().get(0).getParameters().get(0).getName(), mockCodeConstructor.getParameters().get(0).getName());
	}
}
