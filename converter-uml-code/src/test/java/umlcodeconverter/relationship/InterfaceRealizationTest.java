package umlcodeconverter.relationship;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Tests the {@link GeneralizationConverter}.
 * 
 * @author dschoenicke
 *
 */
public class InterfaceRealizationTest extends RelationshipTests {

	/**
	 * Tests {@link InterfaceRealizationConverter#convertInterfaceRealization}.
	 */
	@Test
	public void testInterfaceRealizationConverter() {
		InterfaceRealizationConverter.convertInterfaceRealization(mockInterfaceRealization, mockTmpModel);
		assertTrue(mockClass.getInterfaces().contains(mockInterface));
	}
}
