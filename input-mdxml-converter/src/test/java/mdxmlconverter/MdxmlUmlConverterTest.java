package mdxmlconverter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import mdxml.OwnedAttribute;
import mdxml.PackagedElement;
import mdxmlconverter.temporary.TemporaryAttribute;
import mdxmlconverter.temporary.TemporaryRelationship;
import uml.UmlClass;
import uml.UmlMultiplicityValue;
import uml.UmlParameter;
import uml.UmlParameterDirection;
import uml.UmlRelationship;
import uml.UmlTemplateParameter;

public class MdxmlUmlConverterTest extends MdxmlUmlConverterTests {
	
	@Test
	public void testConvertPackagedElement() {
		MdxmlUmlConverter.convertPackagedElement(mdxmlDependency, mockTmpModel, umlTopLevelPackage);
		TemporaryRelationship convertedRelationship = (TemporaryRelationship) mockTmpModel.getRelationships().get(0);
		assertEquals(mdxmlDependency.getClient().getIdref(), convertedRelationship.getClientId());
		assertEquals(mdxmlDependency.getSupplier().getIdref(), convertedRelationship.getSupplierId());
		assertEquals(umlDependency.getType(), convertedRelationship.getType());
		PackagedElement invalid = new PackagedElement();
		invalid.setId("id");
		invalid.setType("invalid");
		thrown.expect(IllegalStateException.class);
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
