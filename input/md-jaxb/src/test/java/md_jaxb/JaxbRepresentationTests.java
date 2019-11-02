package md_jaxb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import javax.xml.bind.JAXBException;

import org.junit.Before;
import org.junit.Test;

import model.OwnedOperation;
import model.OwnedParameter;
import model.PackagedElement;

/**
 * Unit tests validating the parsing of the xml file into the {@link JaxbRepresentation}
 * 
 * @author dschoenicke
 *
 */
public class JaxbRepresentationTests
{
	/**
	 * The resulting {@link JaxbRepresentation} which should be checked
	 */
	private JaxbRepresentation representation;
	
	/**
	 * A sample {@link model.PackagedElement} which should be checked
	 */
	private PackagedElement element;
	
	/**
	 * A sample {@link model.OwnedOperation} of the {@link model.PackagedElement} which should be checked
	 */
	private OwnedOperation operation;
	
	/**
	 * Auxiliary method to find a {@link model.PackagedElement} by its name
	 * 
	 * @param elementToCheck the {@link model.PackagedElement} to check the name of
	 * @param name the name of the searched {@link PackagedElement}
	 * @return the {@link model.PackagedElement} if the names match, null otherwise
	 */
	public PackagedElement checkForPackagedElement(PackagedElement elementToCheck, String name) {
		if (elementToCheck.getName() != null && elementToCheck.getName().equals(name)) {
			return elementToCheck;
		}
		
		if (elementToCheck.getPackagedElements().isEmpty()) {
			return null;
		}
		
		PackagedElement returnElement = null;
		
		for (PackagedElement childElement : elementToCheck.getPackagedElements()) {
			returnElement = checkForPackagedElement(childElement, name);
			
			if (returnElement != null) {
				break;
			}
		}
		
		return returnElement;
	}
	
	/**
	 * Initialization method, initializing a {@link JaxbRepresentation} out of an sample xml file and
	 * the {@link PackagedElement} with the name "PackagedElement"
	 * 
	 * @throws JAXBException {@link JAXBException} could be thrown if the xml file is invalid
	 */
	@Before
	public void init() throws JAXBException {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("md_jaxb.xml").getFile());
		representation = new JaxbRepresentation(file.getAbsolutePath());
		
		for (PackagedElement packagedElement : representation.getXmi().getModel().getPackagedElements()) {
			element = checkForPackagedElement(packagedElement, "PackagedElement");
			
			if (element != null) {
				break;
			}
		}
		
		//PackageElement.setOwnedAttributes
		operation = element.getOwnedOperations().get(14);
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
	public void attributeTest() {
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
	public void ownedAttributeTest() {
		assertEquals(element.getOwnedAttributes().size(), 23);
	}
	
	/**
	 * Checks whether the correct number of {@link model.OwnedOperation}s of the {@link model.PackagedElement} have been found
	 */
	@Test
	public void ownedOperationsTest() {
		assertEquals(element.getOwnedOperations().size(), 41);
	}
	
	/**
	 * Checks if the operation is there
	 */
	@Test
	public void ownedOperationFoundTest() {
		assertNotNull(operation);
	}
	
	/**
	 * Checks the attributes of an {@link model.OwnedOperation}
	 */
	@Test
	public void ownedOperationAttributesTest() {
		assertEquals(operation.getName(), "setOwnedAttributes");
		assertEquals(operation.getVisibility(), "public");
	}
	
	/**
	 * Checks the parameters of an {@link model.OwnedOperation}
	 */
	@Test
	public void ownedOperationParameterTest() {
		OwnedParameter returnType = operation.getOwnedParameters().get(0);
		OwnedParameter methodParameter = operation.getOwnedParameters().get(1);
		
		assertEquals(operation.getOwnedParameters().size(), 2);
		assertEquals(returnType.getDirection(), "return");
		assertTrue(returnType.getDataType().getExtension().getReferenceExtension().getReferentPath().contains("void"));
	
		assertEquals(methodParameter.getName(), "ownedAttributes");
		assertEquals(methodParameter.getAssociationType(), "_19_0_1_62d0212_1572550603923_570944_4931");
		assertEquals(methodParameter.getLowerValue().getValue(), null);
		assertEquals(methodParameter.getUpperValue().getValue(), "*");
	}
}
