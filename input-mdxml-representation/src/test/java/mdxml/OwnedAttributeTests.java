package mdxml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import javax.xml.bind.JAXBException;

import org.junit.Before;
import org.junit.Test;

import mdxml.OwnedAttribute;
import mdxml.PackagedElement;

/**
 * Unit tests validating the correct parsing of {@link mdxml.OwnedAttribute}s
 * 
 * @author dschoenicke
 *
 */
public class OwnedAttributeTests extends MdxmlRepresentationTests {

	/**
	 * A sample {@link mdxml.PackagedElement} which should be checked
	 */
	private PackagedElement element;
	
	/**
	 * A sample {@link mdxml.OwnedAttribute} of the {@link mdxml.PackagedElement} which should be checked
	 */
	private OwnedAttribute attribute;
	
	/**
	 * A sample {@link mdxml.OwnedAttribute} of an association of the {@link mdxml.PackagedElement} which should be checked
	 */
	private OwnedAttribute associationAttribute;
	
	/**
	 * Initializes the {@link PackagedElement} containing the {@link mdxml.OwnedAttribute}s which should be tested
	 * 
	 * @throws JAXBException {@link JAXBException} could be thrown if the xml file is invalid
	 */
	@Before
	public void init() throws JAXBException {
		element = initializePackagedElement();
		
		//PackageElement.name
		attribute = element.getOwnedAttributes().get(7);
				
		//PackageElement.nestedClassifier
		associationAttribute = element.getOwnedAttributes().get(21);
	}
	
	/**
	 * Checks whether the attributes are there
	 */
	@Test
	public void ownedAttributeFoundTest() {
		assertNotNull(attribute);
		assertNotNull(associationAttribute);
	}
	
	@Test
	public void ownedAttributeAttributesTest() {
		assertEquals("name", attribute.getName());
		assertEquals("nestedClassifier", associationAttribute.getName());
		assertEquals("private", attribute.getVisibility(), associationAttribute.getVisibility());
		assertTrue(attribute.getDataType().getExtension().getReferenceExtension().getReferentPath().contains("String"));
		assertEquals(element.getId(), associationAttribute.getAssociationType(), element.getId());
	}
	
	@Test
	public void aggregationTest() {
		assertEquals("composite", associationAttribute.getAggregation());
		assertEquals("_19_0_1_62d0212_1572693748404_881663_4632", associationAttribute.getAssociation());
		assertNull(associationAttribute.getLowerValue().getValue());
		assertEquals("*", associationAttribute.getUpperValue().getValue());
	}
}
