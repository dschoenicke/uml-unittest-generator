package mdxmlconverter.element;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import mdxml.OwnedLiteral;
import mdxml.PackagedElement;
import uml.UmlEnumeration;
import uml.UmlVisibility;

/**
 * Tests {@link LiteralConverter}
 * 
 * @author dschoenicke
 *
 */
public class LiteralConverterTest {

	/**
	 * Mocks a {@link mdxml.PackagedElement} which contains the {@link mdxml.OwnedLiteral}s to be tested.
	 */
	private PackagedElement mockPackagedElement;
	
	/**
	 * A list containing {@link mdxml.OwnedLiteral}s to be tested.
	 */
	private ArrayList<OwnedLiteral> mockOwnedLiterals;
	
	/**
	 * The {@link uml.UmlEnumeration} to which the converted {@link uml.UmlLiteral}s should be added.
	 */
	private UmlEnumeration mockEnumeration;
	
	/**
	 * Initializes the mock elements.
	 */
	@Before
	public void init() {
		mockPackagedElement = new PackagedElement();
		mockOwnedLiterals = new ArrayList<>();
		OwnedLiteral firstLiteral = new OwnedLiteral();
		firstLiteral.setName("FIRSTLITERAL");
		OwnedLiteral secondLiteral = new OwnedLiteral();
		secondLiteral.setName("SECONDLITERAL");
		mockOwnedLiterals.add(firstLiteral);
		mockOwnedLiterals.add(secondLiteral);
		mockPackagedElement.setOwnedLiterals(mockOwnedLiterals);
		mockEnumeration = new UmlEnumeration("TestEnumeration", UmlVisibility.PUBLIC);
	}
	
	/**
	 * Tests {@link mdxmlconverter.element.LiteralConverter}.
	 */
	@Test
	public void testConvertLiterals() {
		LiteralConverter.convertLiterals(mockPackagedElement, mockEnumeration);
		assertEquals(mockEnumeration.getLiterals().get(0).getName(), "FIRSTLITERAL");
		assertEquals(mockEnumeration.getLiterals().get(1).getName(), "SECONDLITERAL");
	}
}
