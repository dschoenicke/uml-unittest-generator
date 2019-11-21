package mdxml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.xml.bind.JAXBException;

import org.junit.Before;
import org.junit.Test;

import model.OwnedAttribute;
import model.PackagedElement;

/**
 * Unit tests validating the correct parsing of {@link model.OwnedAttribute}s
 * 
 * @author dschoenicke
 *
 */
public class OwnedAttributeTests extends MdxmlRepresentationTests {

	/**
	 * A sample {@link model.PackagedElement} which should be checked
	 */
	private PackagedElement element;
	
	/**
	 * A sample {@link model.OwnedAttribute} of the {@link model.PackagedElement} which should be checked
	 */
	private OwnedAttribute attribute;
	
	/**
	 * A sample {@link model.OwnedAttribute} of an association of the {@link model.PackagedElement} which should be checked
	 */
	private OwnedAttribute associationAttribute;
	
	/**
	 * Initializes the {@link PackagedElement} containing the {@link model.OwnedAttribute}s which should be tested
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
		assertEquals(attribute.getName(), "name");
		assertEquals(associationAttribute.getName(), "nestedClassifier");
		assertEquals(attribute.getVisibility(), associationAttribute.getVisibility(), "private");
		assertTrue(attribute.getDataType().getExtension().getReferenceExtension().getReferentPath().contains("String"));
		assertEquals(associationAttribute.getAssociationType(), element.getId());
	}
	
	@Test
	public void aggregationTest() {
		assertEquals(associationAttribute.getAggregation(), "composite");
		assertEquals(associationAttribute.getAssociation(), "_19_0_1_62d0212_1572693748404_881663_4632");
		assertEquals(associationAttribute.getLowerValue().getValue(), null);
		assertEquals(associationAttribute.getUpperValue().getValue(), "*");
	}
}
