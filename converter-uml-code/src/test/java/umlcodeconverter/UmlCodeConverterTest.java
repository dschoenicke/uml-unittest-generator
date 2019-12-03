package umlcodeconverter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import code.CodeRepresentation;
import uml.UmlClass;
import uml.UmlModel;
import uml.UmlPackage;

/**
 * Tests the {@link UmlCodeConverter}.
 * 
 * @author dschoenicke
 *
 */
public class UmlCodeConverterTest {
	
	/**
	 * Checks if {@link UmlCodeConverter#convertUmlToCodeRepresentation} assigns the name of the {@link uml.UmlModel} to the {@link code.CodeRepresentation}.
	 */
	@Test
	public void testUmlCodeConverter() {
		UmlModel mockUmlModel = new UmlModel("testmodel");
		UmlPackage mockUmlPackage = new UmlPackage("testpackage");
		UmlClass mockUmlClass = new UmlClass("testclass", null);
		mockUmlModel.addElement(mockUmlClass);
		mockUmlModel.addPackage(mockUmlPackage);
		UmlCodeConverter converter = new UmlCodeConverter();
		CodeRepresentation codeRepresentation = converter.convertUmlToCodeRepresentation(mockUmlModel);
		assertEquals(codeRepresentation.getName(), mockUmlModel.getName());
	}
}
