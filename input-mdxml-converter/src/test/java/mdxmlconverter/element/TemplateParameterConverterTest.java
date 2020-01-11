package mdxmlconverter.element;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import mdxml.ConstrainingClassifier;
import mdxml.Extension;
import mdxml.OwnedParameter;
import mdxml.OwnedParameteredElement;
import mdxml.OwnedTemplateSignature;
import mdxml.ReferenceExtension;
import mdxmlconverter.temporary.TemporaryModel;
import uml.UmlClass;
import uml.UmlOperation;
import uml.UmlTemplateParameter;
import uml.UmlVisibility;

/**
 * Tests the {@link TemplateParameterConverter}.
 * 
 * @author dschoenicke
 *
 */
public class TemplateParameterConverterTest {

	/**
	 * Mocks a {@link mdxml.OwnedTemplateSignature} to be used in the tests.
	 */
	private OwnedTemplateSignature mockSignature;
	
	/**
	 * Mocks a {@link mdxml.OwnedParameter} without a {@link mdxml.ConstrainingClassifier}.
	 */
	private OwnedParameter mockUnconstrainedParameter;
	
	/**
	 * Mocks a {@link mdxml.OwnedParameter} with a {@link mdxml.ConstrainingClassifier}.
	 */
	private OwnedParameter mockConstrainedParameter;
	
	/**
	 * Mocks a {@link mdxml.OwnedParameter} with a {@link mdxml.ConstrainingClassifier} with primitive type.
	 */
	private OwnedParameter mockConstrainedPrimitiveParameter;
	
	/**
	 * Mocks a {@link mdxmlconverter.temporary.TemporaryModel} to be used.
	 */
	private TemporaryModel mockTmpModel;
	
	/**
	 * Initializes the mock elements.
	 */
	@Before
	public void init() {
		ConstrainingClassifier constrainingClassifier = new ConstrainingClassifier();
		constrainingClassifier.setIdref("123");
		ConstrainingClassifier primitiveConstrainingClassifier = new ConstrainingClassifier();
		primitiveConstrainingClassifier.setExtension(new Extension());
		primitiveConstrainingClassifier.getExtension().setReferenceExtension(new ReferenceExtension());
		primitiveConstrainingClassifier.getExtension().getReferenceExtension().setReferentPath("UML Standard Profile::UML2 Metamodel::PrimitiveTypes::String");
		
		ArrayList<OwnedParameter> ownedParameters = new ArrayList<>();
		
		mockUnconstrainedParameter = new OwnedParameter();
		mockConstrainedParameter = new OwnedParameter();
		mockConstrainedPrimitiveParameter = new OwnedParameter();
		OwnedParameteredElement firstOwnedParameteredElement = new OwnedParameteredElement();
		firstOwnedParameteredElement.setName("T");
		mockUnconstrainedParameter.setOwnedParameteredElement(firstOwnedParameteredElement);
		mockUnconstrainedParameter.setId("unconstrained");
		OwnedParameteredElement secondOwnedParameteredElement = new OwnedParameteredElement();
		secondOwnedParameteredElement.setName("U");
		mockConstrainedParameter.setOwnedParameteredElement(secondOwnedParameteredElement);
		mockConstrainedParameter.setConstrainingClassifier(constrainingClassifier);
		mockConstrainedParameter.setId("constrained");
		OwnedParameteredElement thirdOwnedParameteredElement = new OwnedParameteredElement();
		thirdOwnedParameteredElement.setName("V");
		mockConstrainedPrimitiveParameter.setOwnedParameteredElement(thirdOwnedParameteredElement);
		mockConstrainedPrimitiveParameter.setConstrainingClassifier(primitiveConstrainingClassifier);
		mockConstrainedPrimitiveParameter.setId("constrainedPrimitive");
		
		ownedParameters.add(mockUnconstrainedParameter);
		ownedParameters.add(mockConstrainedParameter);
		ownedParameters.add(mockConstrainedPrimitiveParameter);
		
		mockSignature = new OwnedTemplateSignature();
		mockSignature.setOwnedParameters(ownedParameters);
		
		mockTmpModel = new TemporaryModel();
		mockTmpModel.addElement("123", new UmlClass("TestElement", UmlVisibility.PUBLIC, false, false, false));
	}
	
	/**
	 * Test {@link mdxmlconverter.element.TemplateParameterConverter#convertTemplateParameters(OwnedTemplateSignature, TemporaryModel)}.
	 */
	@Test
	public void testConvertTemplateParametersModel() {
		ArrayList<UmlTemplateParameter> convertedTemplateParameters = TemplateParameterConverter.convertTemplateParameters(mockSignature, mockTmpModel);
		assertEquals(convertedTemplateParameters.get(0).getName(), "T");
		assertEquals(convertedTemplateParameters.get(0).getType(), "java.lang.Object");
		assertEquals(convertedTemplateParameters.get(1).getName(), "U");
		assertEquals(convertedTemplateParameters.get(1).getType(), "123");
		assertEquals(convertedTemplateParameters.get(2).getName(), "V");
		assertEquals(convertedTemplateParameters.get(2).getType(), "String");
		assertEquals(convertedTemplateParameters.get(0), mockTmpModel.getTemplateParameterIDs().get("unconstrained"));
		assertEquals(convertedTemplateParameters.get(1), mockTmpModel.getTemplateParameterIDs().get("constrained"));
		assertEquals(convertedTemplateParameters.get(2), mockTmpModel.getTemplateParameterIDs().get("constrainedPrimitive"));
	}
	
	/**
	 * Tests {@link mdxmlconverter.element.TemplateParameterConverter#convertTemplateParameters(OwnedTemplateSignature, uml.UmlElement, TemporaryModel)}.
	 */
	@Test
	public void testConvertTemplateParametersElement() {
		UmlClass mockElement = new UmlClass("Test", UmlVisibility.PUBLIC, false, false, false);
		TemplateParameterConverter.convertTemplateParameters(null, mockElement, mockTmpModel);
		assertEquals(mockElement.getTemplateParameters().size(), 0);
		TemplateParameterConverter.convertTemplateParameters(mockSignature, mockElement, mockTmpModel);
		assertEquals(mockElement.getTemplateParameters().size(), mockSignature.getOwnedParameters().size());
	}
	
	/**
	 * Test {@link mdxmlconverter.element.TemplateParameterConverter#convertTemplateParameters(OwnedTemplateSignature, uml.UmlOperation, TemporaryModel)}.
	 */
	@Test
	public void testConvertTemplateParametersOperation() {
		UmlOperation mockOperation = new UmlOperation("Test", UmlVisibility.PUBLIC);
		TemplateParameterConverter.convertTemplateParameters(null, mockOperation, mockTmpModel);
		assertEquals(mockOperation.getTemplateParameters().size(), 0);
		TemplateParameterConverter.convertTemplateParameters(mockSignature, mockOperation, mockTmpModel);
		assertEquals(mockOperation.getTemplateParameters().size(), mockSignature.getOwnedParameters().size());
	}
}
