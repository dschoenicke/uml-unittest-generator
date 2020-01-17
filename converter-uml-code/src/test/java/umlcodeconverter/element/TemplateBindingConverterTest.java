package umlcodeconverter.element;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Tests the {@link TemplateBindingConverter}.
 * 
 * @author dschoenicke
 *
 */
public class TemplateBindingConverterTest extends TestInitializer {

	/**
	 * Tests {@link TemplateBindingConverter#convertTemplateBindings}.
	 */
	@Test
	public void testTemplateBindingConverter() {
		mockTmpModel.getTemporaryTemplateBindings().clear();
		
		assertEquals(0, mockCodeClass.getTemplateBindings().size());
		assertEquals(0, mockCodeMethod.getTemplateBindings().size());
		assertEquals(0, mockCodeConstructor.getTemplateBindings().size());
		
		TemplateBindingConverter.convertTemplateBindings(mockUmlClass.getTemplateBindings(), mockCodeClass, mockTmpModel);
		TemplateBindingConverter.convertTemplateBindings(mockUmlOperation.getTemplateBindings(), mockCodeMethod, mockTmpModel);
		TemplateBindingConverter.convertTemplateBindings(mockUmlConstructor.getTemplateBindings(), mockCodeConstructor, mockTmpModel);
		
		assertEquals(1, mockCodeClass.getTemplateBindings().size());
		assertEquals(1, mockCodeMethod.getTemplateBindings().size());
		assertEquals(1, mockCodeConstructor.getTemplateBindings().size());
		
		assertTrue(mockTmpModel.getTemporaryTemplateBindings().containsKey(mockCodeClass.getTemplateBindings().get(0)));
		assertTrue(mockTmpModel.getTemporaryTemplateBindings().containsKey(mockCodeMethod.getTemplateBindings().get(0)));
		assertTrue(mockTmpModel.getTemporaryTemplateBindings().containsKey(mockCodeConstructor.getTemplateBindings().get(0)));
	}
	
	/**
	 * Tests {@link TemplateBindingConverter#finishTemplateBindingConversions}.
	 */
	@Test
	public void testFinishTemplateBindingConversion() {
		TemplateBindingConverter.finishTemplateBindingConversions(mockTmpModel);
		assertEquals(mockCodeTemplateBinding.getParameterSubstitutions().get(mockCodeTemplateParameter), mockUmlParameterSubstitution.getSubstitutionType());
	}
}
