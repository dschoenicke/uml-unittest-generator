package mdxml;

import java.io.File;

import javax.xml.bind.JAXBException;

import mdxml.MdxmlRepresentation;
import mdxml.PackagedElement;

/**
 * Class extended by other test classes providing setup functions for the tests
 * 
 * @author dschoenicke
 *
 */
public class MdxmlRepresentationTests
{	
	/**
	 * Initialization method, initializing a {@link MdxmlRepresentation} out of an sample xml file and
	 * the {@link PackagedElement} with the name "PackagedElement"
	 * 
	 * @throws JAXBException {@link JAXBException} could be thrown if the xml file is invalid
	 * @return the sample {@link PackagedElement} used by the test classes
	 */
	public PackagedElement initializePackagedElement() throws JAXBException {
		MdxmlRepresentation representation;
		PackagedElement element = null;
		
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("md_jaxb.xml").getFile());
		representation = new MdxmlRepresentation(file.getAbsolutePath());
		
		for (PackagedElement packagedElement : representation.getXmi().getModel().getPackagedElements()) {
			element = checkForPackagedElement(packagedElement, "PackagedElement");
			
			if (element != null) {
				break;
			}
		}
		
		return element;
	}
	
	/**
	 * Auxiliary method to find a {@link mdxml.PackagedElement} by its name
	 * 
	 * @param elementToCheck the {@link mdxml.PackagedElement} to check the name of
	 * @param name the name of the searched {@link PackagedElement}
	 * @return the {@link mdxml.PackagedElement} if the names match, null otherwise
	 */
	private PackagedElement checkForPackagedElement(PackagedElement elementToCheck, String name) {
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
}
