package codetestconverter.testclass;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;

import codetestconverter.CodeTestConverterTests;
import test.TestClass;

public class TestClassConverterTest extends CodeTestConverterTests {

	@Test
	public void testConvertTestClass() {
		testSubPackage.getTestClasses().clear();
		TestClassConverter.convertTestClass(codeSubPackageClass, testSubPackage);
		assertEquals(2, testSubPackage.getTestClasses().size());
		TestClass convertedClass = testSubPackage.getTestClasses().get(0);
		TestClass convertedInnerClass = testSubPackage.getTestClasses().get(1);
		assertEquals(codeSubPackageClass.getName() + "Test", convertedClass.getName());
		assertEquals("TopLevelPackage.SubPackage.SubPackageClassTest", convertedClass.getQualifiedName());
		assertEquals(testSubPackage, convertedClass.getParent());
		assertEquals(Optional.empty(), convertedClass.getClassUnderTest().getNestHost());
		assertEquals(codeEnumeration.getName() + "Test", convertedInnerClass.getName());
		assertEquals(testSubPackage, convertedInnerClass.getParent());
		assertEquals("TopLevelPackage.SubPackage.EnumerationTest", convertedInnerClass.getQualifiedName());
		assertEquals(Optional.of(convertedClass.getClassUnderTest()), convertedInnerClass.getClassUnderTest().getNestHost());
	}
	
	@Test
	public void testConvertNestedClass() {
		testSubPackage.getTestClasses().clear();
		codeEnumeration.addNestedElement(codeBigEnum);
		TestClassConverter.convertTestClass(codeSubPackageClass, testSubPackage);
		assertEquals(Optional.of(testSubPackage.getTestClasses().get(0).getClassUnderTest()), testSubPackage.getTestClasses().get(1).getClassUnderTest().getNestHost());
		assertEquals(Optional.of(testSubPackage.getTestClasses().get(1).getClassUnderTest()), testSubPackage.getTestClasses().get(2).getClassUnderTest().getNestHost());
	}
	
	@Test
	public void testConvertTestClasses() {
		testTopLevelPackage.getTestClasses().clear();
		mockTmpModel.addConvertedPackage(codeTopLevelPackage, testTopLevelPackage);
		TestClassConverter.convertTestClasses(mockTmpModel);
		assertEquals(codeTopLevelPackage.getElements().size(), testTopLevelPackage.getTestClasses().size());
	}
}
