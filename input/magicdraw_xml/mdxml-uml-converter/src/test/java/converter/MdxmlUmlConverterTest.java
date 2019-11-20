package converter;

import java.io.File;

import javax.xml.bind.JAXBException;

import org.junit.Before;

import mdxml.MdxmlRepresentation;
import model.UmlModel;

public class MdxmlUmlConverterTest {
	
	private UmlModel umlModel;
	
	@Before
	public void init() throws JAXBException {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("mdxml.xml").getFile());
		MdxmlRepresentation mdXmlRepresentation = new MdxmlRepresentation(file.getAbsolutePath());
		MdxmlUmlConverter converter = new MdxmlUmlConverter(mdXmlRepresentation);
		umlModel = converter.convertToUmlRepresentation(mdXmlRepresentation);
	}
	
	public UmlModel getUmlModel() {
		return umlModel;
	}
}
