package md_jaxb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;

import javax.xml.bind.JAXBException;

import org.junit.Before;
import org.junit.Test;

import model.PackagedElement;

public class JaxbRepresentationTests
{
	private JaxbRepresentation representation;
	private PackagedElement element;
	
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
	}
	
	@Test
	public void packageElementFoundTest() {
		assertNotNull(element);
	}
	
	@Test 
	public void attributeTest() {
		assertEquals(element.getId(), "_19_0_1_62d0212_1572527221607_338771_4722");
		assertEquals(element.getName(), "PackagedElement");
		assertEquals(element.getType(), "uml:Class");
		assertEquals(element.getIsAbstract(), null);
		assertEquals(element.getIsFinal(), null);
		assertEquals(element.getIsStatic(), null);
	}
	
	@Test
	public void ownedAttributeTest() {
		assertEquals(element.getOwnedAttributes().size(), 23);
	}
	
	@Test
	public void ownedOperationsTest() {
		assertEquals(element.getOwnedOperations().size(), 41);
	}
}
