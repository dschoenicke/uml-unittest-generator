package umlcode.converter.element;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import code.CodeRepresentation;
import code.CodeTemplateParameter;
import umlcode.converter.element.TemplateParameterConverter;

public class TemplateParameterConverterTest extends TestInitializer {

	@Test
	public void testConvertTemplateParameter() {
		mockTmpModel.getConvertedTemplateParameters().clear();
		CodeTemplateParameter convertedTemplateParameter = TemplateParameterConverter.convertTemplateParameter(mockUmlTemplateParameter, mockCodeClass, mockTmpModel);
		assertEquals(convertedTemplateParameter, mockTmpModel.getConvertedTemplateParameters().get(mockUmlTemplateParameter));
		assertEquals(convertedTemplateParameter.getParent(), mockCodeClass);
		assertEquals(convertedTemplateParameter.getName(), mockUmlTemplateParameter.getName());
		assertEquals(convertedTemplateParameter.getType(), mockUmlTemplateParameter.getType());
	}
	
	@Test
	public void testConvertTemplateParameters() {
		mockTmpModel.getConvertedTemplateParameters().clear();
		assertEquals(0, mockCodeClass.getTemplateParameters().size());
		assertEquals(0, mockCodeMethod.getTemplateParameters().size());
		assertEquals(0, mockCodeConstructor.getTemplateParameters().size());
		
		TemplateParameterConverter.convertTemplateParameters(mockUmlClass.getTemplateParameters(), mockCodeClass, mockTmpModel);
		TemplateParameterConverter.convertTemplateParameters(mockUmlOperation.getTemplateParameters(), mockCodeMethod, mockTmpModel);
		TemplateParameterConverter.convertTemplateParameters(mockUmlConstructor.getTemplateParameters(), mockCodeConstructor, mockTmpModel);
		
		assertEquals(1, mockCodeClass.getTemplateParameters().size());
		assertEquals(1, mockCodeMethod.getTemplateParameters().size());
		assertEquals(1, mockCodeConstructor.getTemplateParameters().size());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidTemplateParameter() {
		TemplateParameterConverter.convertTemplateParameters(mockUmlClass.getTemplateParameters(), new CodeRepresentation("Invalid"), mockTmpModel);
	}
}
