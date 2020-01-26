package umlcode.converter.element;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import code.CodeTemplateParameter;

public class TemplateParameterConverterTest extends TestInitializer {

	@Test
	public void testConvertTemplateParameter() {
		mockTmpModel.getConvertedTemplateParameters().clear();
		CodeTemplateParameter convertedTemplateParameter = TemplateParameterConverter.convertTemplateParameter(mockUmlTemplateParameter, mockTmpModel);
		assertEquals(convertedTemplateParameter, mockTmpModel.getConvertedTemplateParameters().get(mockUmlTemplateParameter));
		assertEquals(convertedTemplateParameter.getName(), mockUmlTemplateParameter.getName());
		assertEquals(convertedTemplateParameter.getType(), mockUmlTemplateParameter.getType());
	}
	
	@Test
	public void testConvertTemplateParameters() {
		mockTmpModel.getConvertedTemplateParameters().clear();
		assertEquals(0, mockCodeClass.getTemplateParameters().size());
		assertEquals(0, mockCodeMethod.getTemplateParameters().size());
		assertEquals(0, mockCodeConstructor.getTemplateParameters().size());
		
		mockCodeClass.getTemplateParameters().addAll(TemplateParameterConverter.convertTemplateParameters(mockUmlClass.getTemplateParameters(), mockTmpModel));
		mockCodeMethod.getTemplateParameters().addAll(TemplateParameterConverter.convertTemplateParameters(mockUmlOperation.getTemplateParameters(), mockTmpModel));
		mockCodeConstructor.getTemplateParameters().addAll(TemplateParameterConverter.convertTemplateParameters(mockUmlConstructor.getTemplateParameters(), mockTmpModel));
		
		assertEquals(1, mockCodeClass.getTemplateParameters().size());
		assertEquals(1, mockCodeMethod.getTemplateParameters().size());
		assertEquals(1, mockCodeConstructor.getTemplateParameters().size());
	}
}
