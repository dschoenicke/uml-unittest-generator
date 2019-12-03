package umlcodeconverter.element;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import code.CodeParameter;

/**
 * Tests the {@link ParameterConverter}.
 * 
 * @author dschoenicke
 * 
 */
public class ParameterConverterTest extends TestInitializer {

	/**
	 * Tests {@link ParameterConverter#createParameter}.
	 */
	@Test
	public void testCreateParameter() { 
		CodeParameter convertedParameter = ParameterConverter.createParameter(mockUmlParameter, mockCodeMethod);
		assertEquals(convertedParameter.getName(), mockUmlParameter.getName());
		assertEquals(convertedParameter.getParent(), mockCodeMethod);
		assertEquals(convertedParameter.getType(), mockUmlParameter.getType());
		assertEquals(convertedParameter.getModifiers(), 0);
	}
	
	/**
	 * Tests {@link ParameterConverter#convertParameters} with an {@link uml.UmlOperation}.
	 */
	@Test
	public void testConvertParametersWithOperation() {
		ParameterConverter.convertParameters(mockUmlOperation, mockCodeMethod);
		assertEquals(mockCodeMethod.getParameters().size(), 1);
		assertEquals(mockCodeMethod.getParameters().get(0).getName(), mockUmlParameter.getName());
	}
	
	/**
	 * Tests {@link ParameterConverter#convertParameters} with a constructor
	 */
	@Test
	public void testConvertParametersWithConstructor() {
		ParameterConverter.convertParameters(mockUmlConstructor, mockCodeConstructor);
		assertEquals(mockCodeConstructor.getParameters().size(), 1);
		assertEquals(mockCodeConstructor.getParameters().get(0).getName(), mockUmlParameter.getName());
	}
}
