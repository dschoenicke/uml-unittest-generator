package umlcodeconverter.relationship;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import uml.UmlRelationship;

/**
 * Tests {@link RelationshipConverter}.
 * 
 * @author dschoenicke
 *
 */
public class RelationshipConverterTest extends RelationshipTests {

	/**
	 * Tests {@link RelationshipConverter#convertRelationships} with a class generalization and and interface realization with a {@link code.CodeEnumeration} as client.
	 */
	@Test
	public void testRelationshipConverter() {
		ArrayList<UmlRelationship> relationships = new ArrayList<>();
		relationships.add(mockEnumInterfaceRealization);
		relationships.add(mockClassGeneralization);
		RelationshipConverter.convertRelationships(relationships, mockTmpModel);
		assertEquals(mockClass.getSuperClass(), mockClass);
		assertTrue(mockEnumeration.getInterfaces().contains(mockInterface));
	}
}
