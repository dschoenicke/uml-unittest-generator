package converter;

import static org.junit.Assert.assertEquals;

import java.io.File;

import javax.xml.bind.JAXBException;

import org.junit.Before;
import org.junit.Test;

import mdxml.MdxmlRepresentation;
import mdxmlconverter.MdxmlUmlConverter;
import uml.UmlModel;

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
	
	@Test
	public void testModelName() {
		assertEquals(umlModel.getName(), mdxmlRepresentation.getXmi().getModel().getName());
	}
	
	public UmlModel getUmlModel() {
		return umlModel;
	}
	
	public MdxmlRepresentation getMdxmlRepresentation() {
		return mdxmlRepresentation;
	}
}
