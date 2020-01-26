package umlcode.converter.element;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import code.CodeClass;
import code.CodeEnumeration;
import code.CodeInterface;
import umlcode.UmlCodeConverterTests;

public class ElementConverterTest extends UmlCodeConverterTests {
	
	@Test
	public void testElementConverter() {
		codeTopLevelPackage.getElements().clear();
		codeSubPackage.getElements().clear();
		CodeClass mockCodeClass = (CodeClass) ElementConverter.convertElement(umlSubPackageClass, umlSubPackage, codeSubPackage, mockTmpModel);
		CodeInterface mockCodeInterface = (CodeInterface) ElementConverter.convertElement(umlSubInterface, umlTopLevelPackage, codeTopLevelPackage, mockTmpModel);
		CodeEnumeration mockCodeEnumeration = (CodeEnumeration) ElementConverter.convertElement(umlBigEnum, umlSubPackage, codeSubPackage, mockTmpModel);
		
		assertEquals(1, codeTopLevelPackage.getElements().size());
		assertEquals(3, codeSubPackage.getElements().size());
		assertEquals(mockCodeClass, mockTmpModel.getConvertedElements().get(umlSubPackageClass));
		assertEquals(mockCodeInterface, mockTmpModel.getConvertedElements().get(umlSubInterface));
		assertEquals(mockCodeEnumeration, mockTmpModel.getConvertedElements().get(umlBigEnum));
		assertEquals(1, mockCodeClass.getNestedElements().size());
		
		assertEquals(umlSubPackageClass.getName(), mockCodeClass.getName());
		assertEquals(codeSubPackage, mockCodeClass.getParent());
		assertEquals(mockCodeInterface.getName(), umlSubInterface.getName());
		assertEquals(mockCodeInterface.getParent(), codeTopLevelPackage);
		assertEquals(mockCodeEnumeration.getName(), umlBigEnum.getName());
		assertEquals(mockCodeEnumeration.getParent(), codeSubPackage);
		assertEquals(mockCodeClass.getNestedElements().get(0).getName(), codeEnumeration.getName());
		assertEquals(mockCodeClass.getNestedElements().get(0).getNestHost().get(), mockCodeClass);
	}
	
	@Test
	public void testConvertElements() {
		codeTopLevelPackage.getElements().clear();
		codeSubPackage.getElements().clear();
		mockTmpModel.addConvertedPackage(umlTopLevelPackage, codeTopLevelPackage);
		mockTmpModel.addConvertedPackage(umlSubPackage, codeSubPackage);
		ElementConverter.convertElements(umlModel, codeRepresentation, mockTmpModel);
		assertEquals(2, codeRepresentation.getPackages().size());
		assertEquals(codeRepresentation.getPackages().get(0).getName(), umlModel.getName());
		assertEquals(codeRepresentation.getPackages().get(0).getElements().get(0).getName(), mockTmpModel.getConvertedElements().get(umlTopLevelInterface).getName());
	}
	
	@Test
	public void testUmlModelWithoutElements() {
		umlModel.getElements().clear();
		mockTmpModel.addConvertedPackage(umlTopLevelPackage, codeTopLevelPackage);
		mockTmpModel.addConvertedPackage(umlSubPackage, codeSubPackage);
		ElementConverter.convertElements(umlModel, codeRepresentation, mockTmpModel);
		assertEquals(1, codeRepresentation.getPackages().size());
	}
}
