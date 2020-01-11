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
		
		assertEquals(mockCodeClass.getTemplateBindings().size(), 0);
		assertEquals(mockCodeMethod.getTemplateBindings().size(), 0);
		assertEquals(mockCodeConstructor.getTemplateBindings().size(), 0);
		
		TemplateBindingConverter.convertTemplateBindings(mockUmlClass.getTemplateBindings(), mockCodeClass, mockTmpModel);
		TemplateBindingConverter.convertTemplateBindings(mockUmlOperation.getTemplateBindings(), mockCodeMethod, mockTmpModel);
		TemplateBindingConverter.convertTemplateBindings(mockUmlConstructor.getTemplateBindings(), mockCodeConstructor, mockTmpModel);
		
		assertEquals(mockCodeClass.getTemplateBindings().size(), 1);
		assertEquals(mockCodeMethod.getTemplateBindings().size(), 1);
		assertEquals(mockCodeConstructor.getTemplateBindings().size(), 1);
		
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
