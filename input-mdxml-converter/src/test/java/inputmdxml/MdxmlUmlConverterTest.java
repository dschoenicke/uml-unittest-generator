package inputmdxml;

import static org.junit.Assert.assertEquals;

import javax.xml.bind.JAXBException;

import org.junit.Test;

import inputmdxml.MdxmlUmlConverter;
import inputmdxml.temporary.TemporaryAttribute;
import inputmdxml.temporary.TemporaryRelationship;
import mdxml.OwnedAttribute;
import mdxml.PackagedElement;
import uml.UmlClass;
import uml.UmlMultiplicityValue;
import uml.UmlParameter;
import uml.UmlParameterDirection;
import uml.UmlRelationship;
import uml.UmlTemplateParameter;

public class MdxmlUmlConverterTest extends MdxmlUmlConverterTests {
	
	@Test
	public void testConverToUmlRepresentation() throws JAXBException {
		assertEquals(mdxmlRepresentation.getXmi().getModel().getName(), converter.convertToUmlRepresentation(getClass().getClassLoader().getResource("md_test.xml").getFile()).getName());
	}
	
	@Test
	public void testConvertPackagedElement() {
		MdxmlUmlConverter.convertPackagedElement(mdxmlDependency, mockTmpModel, umlTopLevelPackage);
		TemporaryRelationship convertedRelationship = (TemporaryRelationship) mockTmpModel.getRelationships().get(0);
		assertEquals(mdxmlDependency.getClient().getIdref(), convertedRelationship.getClientId());
		assertEquals(mdxmlDependency.getSupplier().getIdref(), convertedRelationship.getSupplierId());
		assertEquals(umlDependency.getType(), convertedRelationship.getType());
	}
	
	@Test(expected = IllegalStateException.class)
	public void testConvertInvalidPackagedElement() {
		PackagedElement invalid = new PackagedElement();
		invalid.setId("id");
		invalid.setType("invalid");
		MdxmlUmlConverter.convertPackagedElement(invalid, mockTmpModel, umlModel);
	}
	
	@Test
	public void testResolveDataTypeReferences() {
		OwnedAttribute mockOwnedAttribute = new OwnedAttribute();
		mockOwnedAttribute.setName("");
		mockOwnedAttribute.setVisibility("package");
		mockOwnedAttribute.setAssociationType("123");
		
		mockTmpModel.addElement("123", new UmlClass("TestElement", null, false, false, false));
		mockTmpModel.addAttribute("789", new TemporaryAttribute(mockOwnedAttribute));
		mockTmpModel.addParameter(new UmlParameter("", "123", UmlParameterDirection.IN, false, UmlMultiplicityValue.ONE, UmlMultiplicityValue.ONE));
		mockTmpModel.addTemplateParameter("456", new UmlTemplateParameter("321", "123"));
		mockTmpModel.addRelationship(new UmlRelationship());
		
		converter.resolveDataTypeReferences(mockTmpModel);
		assertEquals("TestElement", mockTmpModel.getAttributeIDs().get("789").getType());
		assertEquals("TestElement", mockTmpModel.getParameters().get(0).getType());
		assertEquals("TestElement", mockTmpModel.getTemplateParameterIDs().get("456").getType());
	}
}
