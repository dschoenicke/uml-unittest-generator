package umlcodeconverter.element;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import code.CodeClass;
import code.CodeEnumeration;
import code.CodeInterface;
import code.CodePackage;

/**
 * Tests the {@link ElementConverter}.
 * 
 * @author dschoenicke
 *
 */
public class ElementConverterTest extends TestInitializer {
	
	/**
	 * Tests {@link ElementConverter#convertElement}.
	 */
	@Test
	public void testElementConverter() {
		mockCodePackage.getElements().clear();
		mockCodeClass = (CodeClass) ElementConverter.convertElement(mockUmlClass, umlPackage, mockCodePackage, mockTmpModel);
		mockCodeInterface = (CodeInterface) ElementConverter.convertElement(mockUmlInterface, umlPackage, mockCodePackage, mockTmpModel);
		mockCodeEnumeration = (CodeEnumeration) ElementConverter.convertElement(mockUmlEnumeration, umlPackage, mockCodePackage, mockTmpModel);
		
		assertEquals(mockCodePackage.getElements().size(), 3);
		assertEquals(mockCodeClass, mockTmpModel.getConvertedElements().get(mockUmlClass));
		assertEquals(mockCodeInterface, mockTmpModel.getConvertedElements().get(mockUmlInterface));
		assertEquals(mockCodeEnumeration, mockTmpModel.getConvertedElements().get(mockUmlEnumeration));
		assertEquals(mockCodeClass.getNestedElements().size(), 1);
		
		assertEquals(mockCodeClass.getName(), mockUmlClass.getName());
		assertEquals(mockCodeClass.getParent(), mockCodePackage);
		assertEquals(mockCodeInterface.getName(), mockUmlInterface.getName());
		assertEquals(mockCodeInterface.getParent(), mockCodePackage);
		assertEquals(mockCodeEnumeration.getName(), mockUmlEnumeration.getName());
		assertEquals(mockCodeEnumeration.getParent(), mockCodePackage);
		assertEquals(mockCodeClass.getNestedElements().get(0).getName(), mockInnerUmlClass.getName());
		assertEquals(mockCodeClass.getNestedElements().get(0).getParent(), mockCodeClass);
	}
	
	/**
	 * Test {@link ElementConverter#convertElements}.
	 */
	@Test
	public void testConvertElements() {
		mockTmpModel.addConvertedPackage(umlPackage, mockCodePackage);
		mockTmpModel.addConvertedPackage(umlSubPackage, new CodePackage("subPackage", mockCodePackage));
		ElementConverter.convertElements(mockUmlModel, mockCodeRepresentation, mockTmpModel);
		assertEquals(mockCodeRepresentation.getPackages().size(), 2);
		assertEquals(mockCodeRepresentation.getPackages().get(1).getName(), mockUmlModel.getName());
		assertEquals(mockCodeRepresentation.getPackages().get(1).getElements().get(0), mockTmpModel.getConvertedElements().get(mockUmlEnumeration));
	}
}
