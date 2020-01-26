package umlcode.converter.relationship;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import umlcode.UmlCodeConverterTests;

public class InterfaceRealizationTest extends UmlCodeConverterTests {

	@Before
	public void initializeMockTmpModel() {
		mockTmpModel.addConvertedElement(umlTopLevelClass, codeTopLevelClass);
		mockTmpModel.addConvertedElement(umlTopLevelInterface, codeTopLevelInterface);
		mockTmpModel.addConvertedElement(umlBigEnum, codeBigEnum);
		mockTmpModel.addConvertedElement(umlSubInterface, codeSubInterface);
	}
	
	@Test
	public void testInterfaceRealizationConverterClassClient() {
		codeTopLevelClass.getInterfaces().clear();
		InterfaceRealizationConverter.convertInterfaceRealization(umlInterfaceRealization, mockTmpModel);
		assertTrue(codeTopLevelClass.getInterfaces().contains(codeTopLevelInterface));
	}
	
	@Test
	public void testInterfaceRealizationConverterEnumerationClient() {
		codeSubInterface.getInterfaces().clear();
		umlInterfaceRealization.setClient(umlBigEnum);
		InterfaceRealizationConverter.convertInterfaceRealization(umlInterfaceRealization, mockTmpModel);
		assertTrue(codeBigEnum.getInterfaces().contains(codeTopLevelInterface));
	}
	
	@Test(expected = IllegalStateException.class)
	public void testInvalidInterfaceRealization() {
		umlInterfaceRealization.setClient(umlSubInterface);
		InterfaceRealizationConverter.convertInterfaceRealization(umlInterfaceRealization, mockTmpModel);
	}
}
