package umlcodeconverter;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

import code.CodeClass;

public class UmlCodeConverterIntegrationTest extends UmlCodeConverterTests {

	@Test
	public void verifyRepresentationStructure() {
		codeRepresentation = converter.convertUmlToCodeRepresentation(umlModel, new HashMap<>(), new HashMap<>());
		assertEquals(umlModel.getName(), codeRepresentation.getName());
		assertEquals(umlModel.getPackages().size() + 1, codeRepresentation.getPackages().size());
		assertEquals(umlModel.getName(), codeRepresentation.getPackages().get(1).getName());
		codeGenericClass = (CodeClass) codeRepresentation.getPackages().get(0).getElements().get(2);
		assertEquals(umlGenericClass.getOperations().size() - 1, codeGenericClass.getMethods().size());
		assertEquals(1, codeGenericClass.getConstructors().size());
	}
}
