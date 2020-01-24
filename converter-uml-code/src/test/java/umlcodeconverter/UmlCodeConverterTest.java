package umlcodeconverter;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import uml.UmlClass;
import uml.UmlVisibility;

public class UmlCodeConverterTest extends UmlCodeConverterTests {
	
	@Test
	public void testUmlCodeConverter() {
		Map<String, String> map = new HashMap<>();
		assertEquals(umlModel.getPackages().size() + 1, converter.convertUmlToCodeRepresentation(umlModel, map, map).getPackages().size());
		umlModel.getElements().clear();
		umlModel.getRelationships().clear();
		assertEquals(umlModel.getPackages().size(), converter.convertUmlToCodeRepresentation(umlModel, map, map).getPackages().size());
		umlModel.addElement(new UmlClass("Test<>", UmlVisibility.PUBLIC, false, false, false));
		umlModel.addElement(new UmlClass("Test[]", UmlVisibility.PUBLIC, false, false, false));
		codeRepresentation = converter.convertUmlToCodeRepresentation(umlModel, map, map);
		assertEquals(umlModel.getPackages().size() + 1, codeRepresentation.getPackages().size());
	}
}
