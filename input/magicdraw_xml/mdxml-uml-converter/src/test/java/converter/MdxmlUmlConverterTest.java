package converter;

import java.io.File;

import javax.xml.bind.JAXBException;

import org.junit.Before;

import mdxml.MdxmlRepresentation;
import model.UmlModel;

public class MdxmlUmlConverterTest {
	
	private UmlModel umlModel;
	private MdxmlRepresentation mdxmlRepresentation;
	
	@Before
	public void init() throws JAXBException {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("mdxml.xml").getFile());
		mdxmlRepresentation = new MdxmlRepresentation(file.getAbsolutePath());
		MdxmlUmlConverter converter = new MdxmlUmlConverter(mdxmlRepresentation);
		umlModel = converter.convertToUmlRepresentation(mdxmlRepresentation);
	}
	
	public UmlModel getUmlModel() {
		return umlModel;
	}
	
	public MdxmlRepresentation getMdxmlRepresentation() {
		return mdxmlRepresentation;
	}
}
