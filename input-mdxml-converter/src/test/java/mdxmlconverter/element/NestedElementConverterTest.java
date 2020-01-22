package mdxmlconverter.element;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import mdxmlconverter.MdxmlUmlConverterTests;
import uml.UmlEnumeration;

/**
 * Tests the {@link NestedElementConverter}
 * 
 * @author dschoenicke
 *
 */
public class NestedElementConverterTest extends MdxmlUmlConverterTests {

	@Test
	public void testNestedElementConverter() {
		NestedElementConverter.convertNestedElements(mdxmlSubPackageClass, umlSubClass, mockTmpModel);
		assertEquals(1, umlSubClass.getInnerElements().size());
		assertEquals("Enumeration", umlSubClass.getInnerElements().get(0).getName());
		assertTrue(umlSubClass.getInnerElements().get(0) instanceof UmlEnumeration);
	}
}
