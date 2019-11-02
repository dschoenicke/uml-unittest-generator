package md_jaxb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.xml.bind.JAXBException;

import org.junit.Before;
import org.junit.Test;

import model.PackagedElement;

/**
 * Unit tests validating the correct parsing of {@link model.PackagedElement}s
 * 
 * @author dschoenicke
 *
 */
public class PackagedElementTests extends JaxbRepresentationTests {

	/**
	 * A sample {@link model.PackagedElement} which should be checked
	 */
	private PackagedElement element;
	
	/**
	 * Initializes the {@link PackagedElement} which should be tested
	 * 
	 * @throws JAXBException {@link JAXBException} could be thrown if the xml file is invalid
	 */
	@Before
	public void init() throws JAXBException {
		element = initializePackagedElement();
	}
	
	/**
	 * Checks if the element is there
	 */
	@Test
	public void packageElementFoundTest() {
		assertNotNull(element);
	}
	
	/**
	 * Checks the attributes of the {@link model.PackagedElement}
	 */
	@Test 
	public void packagedElementAttributeTest() {
		assertEquals(element.getId(), "_19_0_1_62d0212_1572527221607_338771_4722");
		assertEquals(element.getName(), "PackagedElement");
		assertEquals(element.getType(), "uml:Class");
		assertEquals(element.getIsAbstract(), null);
		assertEquals(element.getIsFinal(), null);
		assertEquals(element.getIsStatic(), null);
	}
	
	/**
	 * Checks whether the correct number of {@link model.OwnedAttribute}s of the {@link model.PackagedElement} have been found
	 */
	@Test
	public void packagedElementOwnedAttributeTest() {
		assertEquals(element.getOwnedAttributes().size(), 23);
	}
	
	/**
	 * Checks whether the correct number of {@link model.OwnedOperation}s of the {@link model.PackagedElement} have been found
	 */
	@Test
	public void packagedElementOwnedOperationsTest() {
		assertEquals(element.getOwnedOperations().size(), 41);
	}
}
