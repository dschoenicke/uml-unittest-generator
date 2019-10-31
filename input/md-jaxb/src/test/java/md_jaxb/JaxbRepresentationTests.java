package md_jaxb;

import static org.junit.Assert.assertEquals;

import java.io.File;

import javax.xml.bind.JAXBException;

import org.junit.Before;
import org.junit.Test;

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
		assertEquals(representation.getXmi().getModel().getPackagedElements().size(), 7);
	}
}
