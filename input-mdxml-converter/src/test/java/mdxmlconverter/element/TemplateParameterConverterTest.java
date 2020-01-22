package mdxmlconverter.element;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import mdxml.ConstrainingClassifier;
import mdxml.Extension;
import mdxml.OwnedParameter;
import mdxml.OwnedParameteredElement;
import mdxml.OwnedTemplateSignature;
import mdxml.ReferenceExtension;
import mdxmlconverter.MdxmlUmlConverterTests;
import uml.UmlClass;
import uml.UmlOperation;
import uml.UmlTemplateParameter;
import uml.UmlVisibility;

public class TemplateParameterConverterTest extends MdxmlUmlConverterTests {

	private OwnedTemplateSignature mockSignature;
	private OwnedParameter mockConstrainedPrimitiveParameter;
	
	@Before
	public void init() {
		ConstrainingClassifier primitiveConstrainingClassifier = new ConstrainingClassifier();
		primitiveConstrainingClassifier.setExtension(new Extension());
		primitiveConstrainingClassifier.getExtension().setReferenceExtension(new ReferenceExtension());
		primitiveConstrainingClassifier.getExtension().getReferenceExtension().setReferentPath("UML Standard Profile::UML2 Metamodel::PrimitiveTypes::String");
		mockConstrainedPrimitiveParameter = new OwnedParameter();
		OwnedParameteredElement thirdOwnedParameteredElement = new OwnedParameteredElement();
		thirdOwnedParameteredElement.setName("V");
		mockConstrainedPrimitiveParameter.setOwnedParameteredElement(thirdOwnedParameteredElement);
		mockConstrainedPrimitiveParameter.setConstrainingClassifier(primitiveConstrainingClassifier);
		mockConstrainedPrimitiveParameter.setId("constrainedPrimitive");
		
		OwnedParameter withoutConstraint = new OwnedParameter();
		withoutConstraint.setId("without");
		OwnedParameteredElement fourthParameteredElement = new OwnedParameteredElement();
		fourthParameteredElement.setName("W");
		withoutConstraint.setOwnedParameteredElement(fourthParameteredElement);
		
		mockSignature = mdxmlGenericClass.getOwnedTemplateSignature();
		mockSignature.getOwnedParameters().addAll(List.of(mockConstrainedPrimitiveParameter, withoutConstraint));
		mockTmpModel.addElement("123", new UmlClass("TestElement", UmlVisibility.PUBLIC, false, false, false));
	}
	
	@Test
	public void testConvertTemplateParametersModel() {
		List<UmlTemplateParameter> convertedTemplateParameters = TemplateParameterConverter.convertTemplateParameters(mockSignature, mockTmpModel);
		assertEquals("T", convertedTemplateParameters.get(0).getName());
		assertEquals(mdxmlTopLevelClass.getId(), convertedTemplateParameters.get(0).getType());
		assertEquals("O", convertedTemplateParameters.get(1).getName());
		assertEquals("java.lang.Object", convertedTemplateParameters.get(1).getType());
		assertEquals("V", convertedTemplateParameters.get(2).getName());
		assertEquals("String", convertedTemplateParameters.get(2).getType());
		assertEquals("W", convertedTemplateParameters.get(3).getName());
		assertEquals("java.lang.Object", convertedTemplateParameters.get(3).getType());
		assertEquals(convertedTemplateParameters.get(0), mockTmpModel.getTemplateParameterIDs().get(mockSignature.getOwnedParameters().get(0).getId()));
		assertEquals(convertedTemplateParameters.get(1), mockTmpModel.getTemplateParameterIDs().get(mockSignature.getOwnedParameters().get(1).getId()));
		assertEquals(convertedTemplateParameters.get(2), mockTmpModel.getTemplateParameterIDs().get("constrainedPrimitive"));
		assertEquals(convertedTemplateParameters.get(3), mockTmpModel.getTemplateParameterIDs().get("without"));
	}
	
	@Test
	public void testConvertTemplateParametersElement() {
		TemplateParameterConverter.convertTemplateParameters(null, umlBindingClass, mockTmpModel);
		assertEquals(0, umlBindingClass.getTemplateParameters().size());
		TemplateParameterConverter.convertTemplateParameters(mockSignature, umlBindingClass, mockTmpModel);
		assertEquals(umlBindingClass.getTemplateParameters().size(), mockSignature.getOwnedParameters().size());
	}
	
	@Test
	public void testConvertTemplateParametersOperation() {
		UmlOperation mockOperation = umlGenericClass.getOperations().get(0);
		TemplateParameterConverter.convertTemplateParameters(null, mockOperation, mockTmpModel);
		assertEquals(0, mockOperation.getTemplateParameters().size());
		TemplateParameterConverter.convertTemplateParameters(mockSignature, mockOperation, mockTmpModel);
		assertEquals(mockOperation.getTemplateParameters().size(), mockSignature.getOwnedParameters().size());
	}
}
