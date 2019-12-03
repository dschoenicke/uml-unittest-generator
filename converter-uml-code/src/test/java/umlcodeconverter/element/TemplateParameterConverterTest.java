package umlcodeconverter.element;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import code.CodeTemplateParameter;

/**
 * Tests {@link TemplateParameterConverter}.
 * 
 * @author dschoenicke
 *
 */
public class TemplateParameterConverterTest extends TestInitializer {

	/**
	 * Tests {@link TemplateParameterConverter#convertTemplateParameters}.
	 */
	@Test
	public void testConvertTemplateParameter() {
		mockTmpModel.getConvertedTemplateParameters().clear();
		CodeTemplateParameter convertedTemplateParameter = TemplateParameterConverter.convertTemplateParameter(mockUmlTemplateParameter, mockCodeClass, mockTmpModel);
		assertEquals(convertedTemplateParameter, mockTmpModel.getConvertedTemplateParameters().get(mockUmlTemplateParameter));
		assertEquals(convertedTemplateParameter.getParent(), mockCodeClass);
		assertEquals(convertedTemplateParameter.getName(), mockUmlTemplateParameter.getName());
		assertEquals(convertedTemplateParameter.getType(), mockUmlTemplateParameter.getType());
	}
	
	/**
	 * Tests {@link TemplateParameterConverter#convertTemplateParameters} with a {@link code.CodeClass}, {@link code.CodeMethod} and {@link code.CodeConstructor} as parent.
	 */
	@Test
	public void testConvertTemplateParameters() {
		mockTmpModel.getConvertedTemplateParameters().clear();
		assertEquals(mockCodeClass.getTemplateParameters().size(), 0);
		assertEquals(mockCodeMethod.getTemplateParameters().size(), 0);
		assertEquals(mockCodeConstructor.getTemplateParameters().size(), 0);
		
		TemplateParameterConverter.convertTemplateParameters(mockUmlClass.getTemplateParameters(), mockCodeClass, mockTmpModel);
		TemplateParameterConverter.convertTemplateParameters(mockUmlOperation.getTemplateParameters(), mockCodeMethod, mockTmpModel);
		TemplateParameterConverter.convertTemplateParameters(mockUmlConstructor.getTemplateParameters(), mockCodeConstructor, mockTmpModel);
		
		assertEquals(mockCodeClass.getTemplateParameters().size(), 1);
		assertEquals(mockCodeMethod.getTemplateParameters().size(), 1);
		assertEquals(mockCodeConstructor.getTemplateParameters().size(), 1);
	}
}
