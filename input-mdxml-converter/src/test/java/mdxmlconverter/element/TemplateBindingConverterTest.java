package mdxmlconverter.element;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import mdxml.ParameterSubstitution;
import mdxml.TemplateBinding;
import mdxmlconverter.temporary.TemporaryModel;
import mdxmlconverter.temporary.TemporaryTemplateBinding;
import uml.UmlClass;
import uml.UmlOperation;
import uml.UmlTemplateBinding;
import uml.UmlTemplateParameter;
import uml.UmlVisibility;

/**
 * Tests the {@link TemplateBindingConverter}
 * 
 * @author dschoenicke
 *
 */
public class TemplateBindingConverterTest {

	/**
	 * Mocks a list of {@link mdxml.TemplateBinding}s to be converted.
	 */
	private ArrayList<TemplateBinding> mockTemplateBindings;
	
	/**
	 * Mocks a list of {@link mdxml.ParameterSubstitution} to be added to the {@link mdxml.TemplateBinding}.
	 */
	private ArrayList<ParameterSubstitution> mockParameterSubstitutions;
	
	/**
	 * A {@link mdxml.TemplateBinding} to be converted.
	 */
	private TemplateBinding mockTemplateBinding;
	
	/**
	 * The {@link mdxmlconverter.temporary.TemporaryModel} to be used for the test of {@link TemplateBindingConverter#convertParameterSubstitutionID}.
	 */
	private TemporaryModel mockTmpModel;
	
	/**
	 * Mocks a {@link mdxml.ParameterSubstitution} to be used in the tests.
	 */
	private ParameterSubstitution mockSubstitution;
	
	/**
	 * Mocks an {@link uml.UmlTemplateParameter} to be used for the test of {@link TemplateBindingConverter#convertParameterSubstitutionID}.
	 */
	private UmlTemplateParameter mockTemplateParameter;
	
	/**
	 * Initializes the mock elements.
	 */
	@Before
	public void init() {
		mockTemplateBindings = new ArrayList<>();
		mockParameterSubstitutions = new ArrayList<>();
		mockTemplateBinding = new TemplateBinding();
		
		mockTmpModel = new TemporaryModel();
		mockTemplateParameter = new UmlTemplateParameter("T", "java.lang.Object");
		mockTmpModel.addTemplateParameter("456", mockTemplateParameter);
		
		mockSubstitution = new ParameterSubstitution();
		mockSubstitution.setFormal("456");
		mockSubstitution.setActual("123");
		mockParameterSubstitutions.add(mockSubstitution);
		mockTemplateBinding.setParameterSubstitutions(mockParameterSubstitutions);
		mockTemplateBindings.add(mockTemplateBinding);
	}
	
	/**
	 * Tests {@link TemplateBindingConverter#convertTemporaryTemplateBindings}.
	 */
	@Test
	public void testConvertTemporaryTemplateBindings() {
		ArrayList<TemporaryTemplateBinding> tmpTemplateBindings = TemplateBindingConverter.convertTemporaryTemplateBindings(mockTemplateBindings);
		assertNotNull(tmpTemplateBindings.get(0).getParameterSubstitutionMap().get("456"));
		assertEquals(tmpTemplateBindings.get(0).getParameterSubstitutionMap().get("456"), "123");
	}
	
	/**
	 * Tests {@link TemplateBindingConverter#convertTemplateBindings(ArrayList, uml.UmlElement)}.
	 */
	@Test
	public void testConvertTemplateBindingsWithElement() {
		ArrayList<TemporaryTemplateBinding> tmpTemplateBindings = TemplateBindingConverter.convertTemporaryTemplateBindings(mockTemplateBindings);
		UmlClass umlClass = new UmlClass("TestClass", UmlVisibility.PUBLIC);
		TemplateBindingConverter.convertTemplateBindings(mockTemplateBindings, umlClass);
		assertEquals(tmpTemplateBindings.get(0).getParameterSubstitutions(), umlClass.getUmlTemplateBindings().get(0).getParameterSubstitutions());
	}
	
	/**
	 * Tests {@link TemplateBindingConverter#convertTemplateBindings(ArrayList, uml.UmlOperation)}.
	 */
	@Test
	public void testConvertTemplateBindingsWithOperation() {
		ArrayList<TemporaryTemplateBinding> tmpTemplateBindings = TemplateBindingConverter.convertTemporaryTemplateBindings(mockTemplateBindings);
		UmlOperation umlOperation = new UmlOperation("TestOperation", UmlVisibility.PUBLIC);
		TemplateBindingConverter.convertTemplateBindings(mockTemplateBindings, umlOperation);
		assertEquals(tmpTemplateBindings.get(0).getParameterSubstitutions(), umlOperation.getUmlTemplateBindings().get(0).getParameterSubstitutions());
	}
	
	/**
	 * Tests {@link TemplateBindingConverter#convertParameterSubstitutionID}.
	 */
	@Test
	public void testConvertParameterSubstitutionID() {
		TemporaryTemplateBinding tmpBinding = new TemporaryTemplateBinding();
		tmpBinding.addTemporarySubstitution(mockSubstitution.getFormal(), mockSubstitution.getActual());
		UmlTemplateBinding templateBinding = TemplateBindingConverter.convertParameterSubstitutionID(tmpBinding, mockTmpModel);
		assertEquals(templateBinding.getParameterSubstitutions().get(0).getTemplateParameter(), mockTemplateParameter);
		assertEquals(templateBinding.getParameterSubstitutions().get(0).getSubstitutionType(), mockSubstitution.getActual());
	}
}
