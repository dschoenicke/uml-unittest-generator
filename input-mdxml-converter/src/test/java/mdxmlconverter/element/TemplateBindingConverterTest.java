package mdxmlconverter.element;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import mdxml.ParameterSubstitution;
import mdxml.TemplateBinding;
import mdxmlconverter.MdxmlUmlConverterTests;
import mdxmlconverter.temporary.TemporaryTemplateBinding;
import uml.UmlClass;
import uml.UmlOperation;
import uml.UmlTemplateBinding;
import uml.UmlTemplateParameter;
import uml.UmlVisibility;

public class TemplateBindingConverterTest extends MdxmlUmlConverterTests {

	private List<TemplateBinding> mockTemplateBindings;
	private List<ParameterSubstitution> mockParameterSubstitutions;
	private TemplateBinding mockTemplateBinding;
	private ParameterSubstitution mockSubstitution;
	private UmlTemplateParameter mockTemplateParameter;
	
	@Before
	public void init() {
		mockTemplateBindings = new ArrayList<>();
		mockParameterSubstitutions = new ArrayList<>();
		mockTemplateBinding = new TemplateBinding();
		mockTemplateParameter = new UmlTemplateParameter("T", "java.lang.Object");
		mockTmpModel.addTemplateParameter("456", mockTemplateParameter);
		mockTmpModel.addTemplateParameter("789", new UmlTemplateParameter("U", mdxmlSubClass.getId()));
		mockTmpModel.addElement(mdxmlSubClass.getId(), umlSubClass);
		
		mockSubstitution = new ParameterSubstitution();
		mockSubstitution.setFormal("456");
		mockSubstitution.setActual("123");
		mockParameterSubstitutions.add(mockSubstitution);
		mockTemplateBinding.setParameterSubstitutions(mockParameterSubstitutions);
		mockTemplateBindings.add(mockTemplateBinding);
	}
	
	@Test
	public void testConvertTemporaryTemplateBindings() {
		List<TemporaryTemplateBinding> tmpTemplateBindings = TemplateBindingConverter.convertTemporaryTemplateBindings(mockTemplateBindings);
		assertNotNull(tmpTemplateBindings.get(0).getParameterSubstitutionMap().get("456"));
		assertEquals("123", tmpTemplateBindings.get(0).getParameterSubstitutionMap().get("456"));
	}
	
	@Test
	public void testConvertTemplateBindingsWithElement() {
		List<TemporaryTemplateBinding> tmpTemplateBindings = TemplateBindingConverter.convertTemporaryTemplateBindings(mockTemplateBindings);
		UmlClass umlClass = new UmlClass("TestClass", UmlVisibility.PUBLIC, false, false, false);
		TemplateBindingConverter.convertTemplateBindings(mockTemplateBindings, umlClass);
		assertEquals(tmpTemplateBindings.get(0).getParameterSubstitutions(), umlClass.getTemplateBindings().get(0).getParameterSubstitutions());
	}
	
	@Test
	public void testConvertTemplateBindingsWithOperation() {
		List<TemporaryTemplateBinding> tmpTemplateBindings = TemplateBindingConverter.convertTemporaryTemplateBindings(mockTemplateBindings);
		UmlOperation umlOperation = new UmlOperation("TestOperation", UmlVisibility.PUBLIC);
		TemplateBindingConverter.convertTemplateBindings(mockTemplateBindings, umlOperation);
		assertEquals(tmpTemplateBindings.get(0).getParameterSubstitutions(), umlOperation.getTemplateBindings().get(0).getParameterSubstitutions());
	}
	
	@Test
	public void testConvertParameterSubstitutionID() {
		TemporaryTemplateBinding tmpBinding = new TemporaryTemplateBinding();
		tmpBinding.addTemporarySubstitution(mockSubstitution.getFormal(), mockSubstitution.getActual());
		tmpBinding.addTemporarySubstitution("789", mdxmlSubClass.getId());
		tmpBinding.addTemporarySubstitution("-", "-");
		UmlTemplateBinding templateBinding = TemplateBindingConverter.convertParameterSubstitutionID(tmpBinding, mockTmpModel);
		assertEquals(2, templateBinding.getParameterSubstitutions().size());
		assertEquals(mockTemplateParameter, templateBinding.getParameterSubstitutions().get(0).getTemplateParameter());
		assertEquals(mockSubstitution.getActual(), templateBinding.getParameterSubstitutions().get(0).getSubstitutionType());
		assertEquals(mockTmpModel.getTemplateParameterIDs().get("789"), templateBinding.getParameterSubstitutions().get(1).getTemplateParameter());
		assertEquals(umlSubClass.getName(), templateBinding.getParameterSubstitutions().get(1).getSubstitutionType());
	}
}
