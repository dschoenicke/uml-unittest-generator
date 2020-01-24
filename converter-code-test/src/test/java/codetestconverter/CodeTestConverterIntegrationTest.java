package codetestconverter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CodeTestConverterIntegrationTest extends CodeTestConverterTests {

	@Before
	public void convertRepresentation() {
		testRepresentation = converter.convertCodeToTestRepresentation(codeRepresentation);
		testModelPackage = testRepresentation.getPackages().get(0);
		testTopLevelInterface = testModelPackage.getTestClassesAsList().get(0);
		topLevelInterfaceUnderTest = testTopLevelInterface.getClassUnderTest();
		testTopLevelClass = testModelPackage.getTestClassesAsList().get(1);
		topLevelClassUnderTest = testTopLevelClass.getClassUnderTest();
		testTopLevelPackage = testModelPackage.getPackages().get(0);
		testSubInterface = testTopLevelPackage.getTestClasses().get(0);
		subInterfaceUnderTest = testSubInterface.getClassUnderTest();
		testSubClass = testTopLevelPackage.getTestClasses().get(1);
		subClassUnderTest = testSubClass.getClassUnderTest();
		testGenericClass = testTopLevelPackage.getTestClasses().get(2);
		genericClassUnderTest = testGenericClass.getClassUnderTest();
		testBindingClass = testTopLevelPackage.getTestClasses().get(3);
		bindingClassUnderTest = testBindingClass.getClassUnderTest();
		testSubPackage = testTopLevelPackage.getPackages().get(0);
		testSubPackageClass = testSubPackage.getTestClasses().get(0);
		subPackageClassUnderTest = testSubPackageClass.getClassUnderTest();
		testEnumeration = testSubPackage.getTestClasses().get(1);
		enumerationUnderTest = testEnumeration.getClassUnderTest();
		testBigEnum = testSubPackage.getTestClasses().get(2);
		bigEnumUnderTest = testBigEnum.getClassUnderTest();
	}
	
	@Test
	public void verifyRepresentationStructure() {
		assertEquals("Model", testRepresentation.getName());
		assertEquals(1, testRepresentation.getPackages().size());
		assertTrue(testRepresentation.getPackages().contains(testModelPackage));
		assertEquals("Model", testModelPackage.getName());
		assertEquals(2, testModelPackage.getTestClasses().size());
		assertTrue(testModelPackage.getTestClasses().contains(testTopLevelInterface));
		assertTrue(testModelPackage.getTestClasses().contains(testTopLevelClass));
		assertEquals("TopLevelInterfaceTest", testTopLevelInterface.getName());
		assertEquals("Model.TopLevelInterface", topLevelInterfaceUnderTest.getQualifiedName());
		assertEquals("TopLevelClassTest", testTopLevelClass.getName());
		assertEquals("Model.TopLevelClass", topLevelClassUnderTest.getQualifiedName());
		assertTrue(topLevelClassUnderTest.getInterfaces().contains(testTopLevelInterface.getName().substring(0, testTopLevelInterface.getName().length() - 4)));
		assertEquals(1, testModelPackage.getPackages().size());
		assertTrue(testModelPackage.getPackages().contains(testTopLevelPackage));
		assertEquals(4, testTopLevelPackage.getTestClasses().size());
		assertTrue(testTopLevelPackage.getTestClasses().contains(testSubInterface));
		assertTrue(testTopLevelPackage.getTestClasses().contains(testSubClass));
		assertTrue(testTopLevelPackage.getTestClasses().contains(testGenericClass));
		assertTrue(testTopLevelPackage.getTestClasses().contains(testBindingClass));
		assertEquals("SubInterfaceTest", testSubInterface.getName());
		assertEquals("Model.TopLevelPackage.SubInterface", subInterfaceUnderTest.getQualifiedName());
		assertTrue(subInterfaceUnderTest.getInterfaces().contains(testTopLevelInterface.getName().substring(0, testTopLevelInterface.getName().length() - 4)));
		assertEquals("SubClassTest", testSubClass.getName());
		assertEquals("TopLevelClass", subClassUnderTest.getSuperClass().get());
		assertEquals(1, subClassUnderTest.getFields().size());
		assertEquals("Model.TopLevelPackage.SubClass", subClassUnderTest.getQualifiedName());
		assertEquals("GenericClassTest", testGenericClass.getName());
		assertEquals(2, genericClassUnderTest.getTemplateParameters().size());
		assertEquals(2, genericClassUnderTest.getFields().size());
		assertEquals(1, genericClassUnderTest.getConstructors().size());
		assertEquals(2, genericClassUnderTest.getMethods().size());
		assertEquals("Model.TopLevelPackage.GenericClass", genericClassUnderTest.getQualifiedName());
		assertEquals("BindingClassTest", testBindingClass.getName());
		assertEquals(1, bindingClassUnderTest.getConstructors().size());
		assertEquals("Model.TopLevelPackage.BindingClass", bindingClassUnderTest.getQualifiedName());
		assertEquals(1, testTopLevelPackage.getPackages().size());
		assertTrue(testTopLevelPackage.getPackages().contains(testSubPackage));
		assertEquals(3, testSubPackage.getTestClasses().size());
		assertTrue(testSubPackage.getTestClasses().contains(testSubPackageClass));
		assertTrue(testSubPackage.getTestClasses().contains(testEnumeration));
		assertTrue(testSubPackage.getTestClasses().contains(testBigEnum));
		assertEquals("SubPackageClassTest", testSubPackageClass.getName());
		assertEquals("Model.TopLevelPackage.SubPackage.SubPackageClass", subPackageClassUnderTest.getQualifiedName());
		assertEquals("EnumerationTest", testEnumeration.getName());
		assertEquals("Model.TopLevelPackage.SubPackage.SubPackageClass", enumerationUnderTest.getNestHost().get().getQualifiedName());
		assertEquals(2, enumerationUnderTest.getEnumConstants().size());
		assertEquals("Model.TopLevelPackage.SubPackage.SubPackageClass$Enumeration", enumerationUnderTest.getQualifiedName());
		assertEquals("BigEnumTest", testBigEnum.getName());
		assertEquals(1, bigEnumUnderTest.getFields().size());
		assertEquals(1, bigEnumUnderTest.getConstructors().size());
		assertEquals(1, bigEnumUnderTest.getMethods().size());
		assertEquals("Model.TopLevelPackage.SubPackage.BigEnum", bigEnumUnderTest.getQualifiedName());
	}
}
