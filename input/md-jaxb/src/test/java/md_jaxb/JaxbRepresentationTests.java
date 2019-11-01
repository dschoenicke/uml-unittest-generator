package md_jaxb;

import static org.junit.Assert.assertEquals;

import java.io.File;

import javax.xml.bind.JAXBException;

import org.junit.Before;
import org.junit.Test;

import model.OwnedAttribute;
import model.PackagedElement;

public class JaxbRepresentationTests
{
	private JaxbRepresentation representation;
	
	@Before
	public void init() throws JAXBException {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("md_jaxb.xml").getFile());
		representation = new JaxbRepresentation(file.getAbsolutePath());
	}
	
	@Test
	public void modelSizeTest() {
		assertEquals(representation.getXmi().getModel().getPackagedElements().size(), 32);
		
		for (PackagedElement element : representation.getXmi().getModel().getPackagedElements()) {
			for (OwnedAttribute attribute : element.getOwnedAttributes()) {
				System.out.println(element.getName() + "." + attribute.getName());
				
				if (attribute.getDataType() != null) {
					System.out.println(attribute.getDataType().getHref());
				}
				else {
					System.out.println(attribute.getAssociationType());
				}
			}
 		}
	}
	
	
}
