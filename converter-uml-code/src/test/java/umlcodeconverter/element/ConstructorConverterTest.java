package umlcodeconverter.element;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uml.UmlOperation;
import uml.UmlVisibility;
import umlcodeconverter.UmlCodeConverterTests;

public class ConstructorConverterTest extends UmlCodeConverterTests {

	@Test
	public void testConstructorConverter() {
		umlGenericClass.addOperation(new UmlOperation("invalid", UmlVisibility.PUBLIC));
		codeGenericClass.getConstructors().clear();
		ConstructorConverter.convertConstructors(umlGenericClass, codeGenericClass, mockTmpModel);
		assertEquals(1, codeGenericClass.getConstructors().size());
		assertEquals(codeGenericClass.getName(), codeGenericClass.getConstructors().get(0).getName());
	}
}
