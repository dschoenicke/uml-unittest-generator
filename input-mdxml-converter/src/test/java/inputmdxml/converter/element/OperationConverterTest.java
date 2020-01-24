package inputmdxml.converter.element;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import inputmdxml.MdxmlUmlConverterTests;
import inputmdxml.converter.element.OperationConverter;
import uml.UmlOperation;
import uml.UmlVisibility;

public class OperationConverterTest extends MdxmlUmlConverterTests {

	@Test
	public void testOperationConverter() {
		umlGenericClass.getOperations().clear();
		OperationConverter.convertOperations(mdxmlGenericClass, umlGenericClass, mockTmpModel);
		assertEquals(3, umlGenericClass.getOperations().size());
		UmlOperation umlOperation = umlGenericClass.getOperations().get(0);
		assertEquals(mdxmlGenericClass.getOwnedOperations().get(0).getName(), umlOperation.getName());
		assertEquals(UmlVisibility.PUBLIC, umlOperation.getVisibility());
		assertFalse(umlOperation.isAbstract());
		assertFalse(umlOperation.isStatic());
		assertFalse(umlOperation.isFinal());
	}
}
