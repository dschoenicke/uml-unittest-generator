package mdxmlconverter;

import static org.junit.Assert.assertEquals;

import java.io.File;

import javax.xml.bind.JAXBException;

import org.junit.Before;
import org.junit.Test;

import mdxml.MdxmlRepresentation;
import mdxml.Model;
import mdxml.PackagedElement;
import uml.UmlModel;

public class MdxmlUmlConverterTest {
	
	private UmlModel umlModel;
	private MdxmlRepresentation mdxmlRepresentation;
	
	@Before
	public void init() throws JAXBException {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("mdxml.xml").getFile());
		mdxmlRepresentation = new MdxmlRepresentation(file.getAbsolutePath());
		MdxmlUmlConverter converter = new MdxmlUmlConverter();
		umlModel = converter.convertToUmlRepresentation(mdxmlRepresentation);
	}
	
	@Test
	public void testModelName() {
		assertEquals(umlModel.getName(), mdxmlRepresentation.getXmi().getModel().getName());
	}
	
	@Test
	public void testUmlModel() {
		Model xmlModel = getMdxmlRepresentation().getXmi().getModel();
		UmlModel umlModel = getUmlModel();
		xmlModel.getPackagedElements().forEach((packagedElement) -> {
			evaluatePackagedElement(packagedElement, umlModel);
		});
	}
	
	public UmlModel getUmlModel() {
		return umlModel;
	}
	
	public MdxmlRepresentation getMdxmlRepresentation() {
		return mdxmlRepresentation;
	}
	
	private void evaluatePackagedElement(PackagedElement packagedElement, UmlModel umlModel) {
		switch (packagedElement.getType()) {
			case "uml:Package": {
				UmlPackageTest.evaluateUmlPackage(packagedElement, umlModel);
				packagedElement.getPackagedElements().forEach((childElement) -> {
					evaluatePackagedElement(childElement, umlModel);
				});
				break;
			}	
			case "uml:Class":
			case "uml:Interface":
			case "uml:Enumeration": {
				UmlElementTest.evaluateUmlElement(packagedElement, umlModel);
				packagedElement.getPackagedElements().forEach((childElement) -> {
					evaluatePackagedElement(childElement, umlModel);
				});
				break;
			}
			default: break;
		}
	}
}
