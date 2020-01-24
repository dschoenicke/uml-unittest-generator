package inputmdxml.converter.element;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import inputmdxml.MdxmlUmlConverterTests;
import inputmdxml.converter.element.ElementConverter;
import mdxml.PackagedElement;
import uml.UmlClass;
import uml.UmlElement;
import uml.UmlEnumeration;
import uml.UmlInterface;
import uml.UmlRelationshipType;

public class ElementConverterTest extends MdxmlUmlConverterTests {
	
	@Test
	public void testElementConverterWithClass() {
		UmlElement umlClass = ElementConverter.convertElement(mdxmlSubClass, mockTmpModel, umlTopLevelPackage);
		assertTrue(umlClass instanceof UmlClass);
		assertEquals("SubClass", umlClass.getName());
		assertEquals(UmlRelationshipType.GENERALIZATION, mockTmpModel.getRelationships().get(0).getType());
	}
	
	@Test
	public void testElementConverterWithEnumeration() {
		UmlElement umlEnumeration = ElementConverter.convertElement(mdxmlBigEnum, mockTmpModel, umlSubPackage);
		assertTrue(umlEnumeration instanceof UmlEnumeration);
		assertEquals("BigEnum", umlEnumeration.getName());
	}
	
	@Test
	public void testElementConverterWithInterface() {
		UmlElement umlInterface = ElementConverter.convertElement(mdxmlTopLevelInterface, mockTmpModel, umlModel);
		assertTrue(umlInterface instanceof UmlInterface);
		assertEquals("TopLevelInterface", umlInterface.getName());
	}
	
	@Test
	public void testInvalidElement() {
		PackagedElement invalid = new PackagedElement();
		invalid.setType("-");
		assertNull(ElementConverter.convertElement(invalid, mockTmpModel, umlModel));
	}
}
