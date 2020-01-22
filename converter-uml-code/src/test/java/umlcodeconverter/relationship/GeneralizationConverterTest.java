package umlcodeconverter.relationship;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import umlcodeconverter.UmlCodeConverterTests;

public class GeneralizationConverterTest extends UmlCodeConverterTests {

	@Before
	public void initializeMockTmpModel() {
		mockTmpModel.addConvertedElement(umlTopLevelClass, codeTopLevelClass);
		mockTmpModel.addConvertedElement(umlTopLevelInterface, codeTopLevelInterface);
		mockTmpModel.addConvertedElement(umlBigEnum, codeBigEnum);
		mockTmpModel.addConvertedElement(umlSubClass, codeSubClass);
		mockTmpModel.addConvertedElement(umlSubInterface, codeSubInterface);
	}
	
	@Test
	public void testGeneralizationConverterClassClient() {
		codeTopLevelClass.setSuperClass(null);
		GeneralizationConverter.convertGeneralization(umlClassGeneralization, mockTmpModel);
		assertEquals(codeSubClass.getSuperClass(), codeTopLevelClass);
	}
	
	@Test
	public void testGeneralizationConverterInterfaceClient() {
		codeSubInterface.getInterfaces().clear();
		GeneralizationConverter.convertGeneralization(umlInterfaceGeneralization, mockTmpModel);
		assertTrue(codeSubInterface.getInterfaces().contains(codeTopLevelInterface));
	}
	
	@Test(expected = IllegalStateException.class)
	public void testInvalidGeneralization() {
		umlInterfaceGeneralization.setClient(umlBigEnum);
		GeneralizationConverter.convertGeneralization(umlInterfaceGeneralization, mockTmpModel);
	}
}
