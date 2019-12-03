package umlcodeconverter.relationship;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Tests the {@link GeneralizationConverter}.
 * 
 * @author dschoenicke
 *
 */
public class GeneralizationConverterTest extends RelationshipTests {

	/**
	 * Tests {@link GeneralizationConverter#convertGeneralization} with {@link uml.UmlClass}es.
	 */
	@Test
	public void testGeneralizationConverterWithClasses() {
		GeneralizationConverter.convertGeneralization(mockClassGeneralization, mockTmpModel);
		assertEquals(mockClass.getSuperClass(), mockClass);
	}
	
	/**
	 * Tests {@link GeneralizationConverter#convertGeneralization} with {@link uml.UmlInterface}s.
	 */
	@Test
	public void testGeneralizationConverterWithInterfaces() {
		GeneralizationConverter.convertGeneralization(mockInterfaceGeneralization, mockTmpModel);
		assertTrue(mockInterface.getInterfaces().contains(mockInterface));
	}
}
