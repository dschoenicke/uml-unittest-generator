package inputmdxml.converter.element;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import inputmdxml.MdxmlUmlConverterTests;
import inputmdxml.converter.element.AttributeConverter;
import mdxml.OwnedAttribute;
import uml.UmlAttribute;
import uml.UmlMultiplicityValue;
import uml.UmlVisibility;

public class AttributeConverterTest extends MdxmlUmlConverterTests {

	@Test
	public void testAttributeConverter() {
		umlGenericClass.getAttributes().clear();
		OwnedAttribute ownedAttribute = mdxmlGenericClass.getOwnedAttributes().get(0);
		AttributeConverter.convertAttributes(mdxmlGenericClass, umlGenericClass, mockTmpModel);
		assertEquals(2, umlGenericClass.getAttributes().size());
		UmlAttribute umlAttribute = umlGenericClass.getAttributes().get(0);
		assertEquals(umlAttribute, mockTmpModel.getAttributeIDs().get(mdxmlGenericClass.getOwnedAttributes().get(0).getId()));
		assertEquals(umlAttribute.getName(), ownedAttribute.getName());
		assertEquals(umlAttribute.getType(), ownedAttribute.getAssociationType());
		assertEquals(UmlVisibility.PRIVATE, umlAttribute.getVisibility());
		assertEquals(UmlMultiplicityValue.ONE, umlAttribute.getLowerValue());
		assertEquals(UmlMultiplicityValue.INFINITE, umlAttribute.getUpperValue());
		assertEquals("", umlAttribute.getDefaultValue());
	}
}
