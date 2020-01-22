package umlcodeconverter.relationship;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import uml.UmlRelationship;
import umlcodeconverter.UmlCodeConverterTests;

public class RelationshipConverterTest extends UmlCodeConverterTests {

	@Before 
	public void initRelationshipTests() {
		mockTmpModel.addConvertedElement(umlTopLevelClass, codeTopLevelClass);
		mockTmpModel.addConvertedElement(umlTopLevelInterface, codeTopLevelInterface);
		mockTmpModel.addConvertedElement(umlSubClass, codeSubClass);
		codeSubClass.setSuperClass(null);
		codeTopLevelClass.getInterfaces().clear();
	}
	
	@Test
	public void testRelationshipConverter() {
		List<UmlRelationship> relationships = List.of(umlClassGeneralization, umlInterfaceRealization);
		RelationshipConverter.convertRelationships(relationships, mockTmpModel);
		assertEquals(codeSubClass.getSuperClass(), codeTopLevelClass);
		assertTrue(codeTopLevelClass.getInterfaces().contains(codeTopLevelInterface));
	}
	
	@Test
	public void testInvalidRelationship() {
		RelationshipConverter.convertRelationships(List.of(umlDependency), mockTmpModel);
		assertNull(codeSubClass.getSuperClass());
	}
}
