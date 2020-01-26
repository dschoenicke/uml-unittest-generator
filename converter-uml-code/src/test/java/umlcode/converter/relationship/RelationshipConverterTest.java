package umlcode.converter.relationship;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import umlcode.UmlCodeConverterTests;

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
		RelationshipConverter.convertRelationships(umlModel, mockTmpModel);
		assertTrue(codeTopLevelClass.getInterfaces().contains(codeTopLevelInterface));
		RelationshipConverter.convertRelationships(umlTopLevelPackage, mockTmpModel);
		assertEquals(codeSubClass.getSuperClass(), codeTopLevelClass);
	}
}
