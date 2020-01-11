package mdxmlconverter.element;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import mdxml.DefaultValue;
import mdxml.OwnedAttribute;
import mdxml.PackagedElement;
import mdxmlconverter.temporary.TemporaryModel;
import uml.UmlAttribute;
import uml.UmlClass;
import uml.UmlMultiplicityValue;
import uml.UmlVisibility;

/**
 * Tests the {@link AttributeConverter}.
 * 
 * @author dschoenicke
 *
 */
public class AttributeConverterTest {

	/**
	 * Mocks a {@link mdxml.PackagedElement} which contains the {@link mdxml.OwnedAttribute} to be tested.
	 */
	PackagedElement mockPackagedElement;
	
	/**
	 * Mocks an {@link mdxml.OwnedAttribute} to be tested.
	 */
	OwnedAttribute mockOwnedAttribute;
	
	/**
	 * Mocks the {@link mdxmlconverter.temporary.TemporaryModel} to which the converted {@link uml.UmlAttribute} should be added.
	 */
	TemporaryModel mockTmpModel;
	
	/**
	 * Initializes the mock elements.
	 */
	@Before
	public void init() {
		mockPackagedElement = new PackagedElement();
		mockOwnedAttribute = new OwnedAttribute();
		mockOwnedAttribute.setId("123");
		mockOwnedAttribute.setName("TestAttribute");
		mockOwnedAttribute.setAssociationType("associationtype");
		ArrayList<OwnedAttribute> mockOwnedAttributes = new ArrayList<>();
		mockOwnedAttributes.add(mockOwnedAttribute);
		mockPackagedElement.setOwnedAttributes(mockOwnedAttributes);
		mockTmpModel = new TemporaryModel();
	}
	
	/**
	 * Tests {@link AttributeConverter#convertAttributes}.
	 */
	@Test
	public void testAttributeConverter() {
		UmlClass mockClass = new UmlClass("Test", UmlVisibility.PUBLIC);
		AttributeConverter.convertAttributes(mockPackagedElement, mockClass, mockTmpModel);
		UmlAttribute umlAttribute = mockClass.getAttributes().get(0);
		assertEquals(umlAttribute, mockTmpModel.getAttributeIDs().get(mockOwnedAttribute.getId()));
		assertEquals(umlAttribute.getName(), mockOwnedAttribute.getName());
		assertEquals(umlAttribute.getType(), mockOwnedAttribute.getAssociationType());
		assertEquals(umlAttribute.getVisibility(), UmlVisibility.PUBLIC);
		assertEquals(umlAttribute.getLowerValue(), UmlMultiplicityValue.ONE);
		assertEquals(umlAttribute.getUpperValue(), UmlMultiplicityValue.ONE);
		assertEquals(umlAttribute.getDefaultValue(), "");
		mockOwnedAttribute.setDefaultValue(new DefaultValue());
		mockOwnedAttribute.getDefaultValue().setValue("test");
		AttributeConverter.convertAttributes(mockPackagedElement, mockClass, mockTmpModel);
		umlAttribute = mockClass.getAttributes().get(1);
		assertEquals(umlAttribute.getDefaultValue(), "test");
	}
}
