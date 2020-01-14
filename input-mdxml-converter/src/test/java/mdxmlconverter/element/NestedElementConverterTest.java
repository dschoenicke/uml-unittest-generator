package mdxmlconverter.element;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import mdxml.PackagedElement;
import mdxmlconverter.temporary.TemporaryModel;
import uml.UmlClass;

/**
 * Tests the {@link NestedElementConverter}
 * 
 * @author dschoenicke
 *
 */
public class NestedElementConverterTest {

	/**
	 * Mocks the {@link mdxml.PackagedElement} representing the outer element.
	 */
	private PackagedElement mockOuterPackagedElement;
	
	/**
	 * Mocks the {@link mdxml.PackagedElement} representing the nested element to be converted.
	 */
	private PackagedElement mockNestedPackagedElement;
	
	/**
	 * Initializes the mock elements.
	 */
	@Before
	public void init() {
		mockOuterPackagedElement = new PackagedElement();
		ArrayList<PackagedElement> nestedElements = new ArrayList<>();
		mockNestedPackagedElement = new PackagedElement();
		mockNestedPackagedElement.setName("Nested");
		mockNestedPackagedElement.setId("id");
		mockNestedPackagedElement.setType("uml:Class");
		nestedElements.add(mockNestedPackagedElement);
		mockOuterPackagedElement.setName("Host");
		mockOuterPackagedElement.setNestedClassifiers(nestedElements);
	}
	
	/**
	 * Tests {@link NestedElementConverter#convertNestedElements}
	 */
	@Test
	public void testNestedElementConverter() {
		UmlClass umlClass = new UmlClass(null, null, false, false, false);
		NestedElementConverter.convertNestedElements(mockOuterPackagedElement, umlClass, new TemporaryModel());
		assertEquals(umlClass.getInnerElements().get(0).getName(), mockNestedPackagedElement.getName());
		assertTrue(umlClass.getInnerElements().get(0) instanceof UmlClass);
	}
}
