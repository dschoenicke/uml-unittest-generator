package codetest.converter;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;

import codetest.CodeTestConverterTests;
import codetest.converter.TestClassConverter;
import test.TestClass;

public class TestClassConverterTest extends CodeTestConverterTests {

	@Test
	public void testConvertTestClass() {
		testSubPackage.getTestClasses().clear();
		mockTmpModel.addConvertedPackage(codeSubPackage, testSubPackage);
		TestClassConverter.convertTestClasses(mockTmpModel);
		assertEquals(3, testSubPackage.getTestClasses().size());
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
	public void testConvertTestClasses() {
		testTopLevelPackage.getTestClasses().clear();
		mockTmpModel.addConvertedPackage(codeTopLevelPackage, testTopLevelPackage);
		TestClassConverter.convertTestClasses(mockTmpModel);
		assertEquals(codeTopLevelPackage.getElements().size(), testTopLevelPackage.getTestClasses().size());
	}
}
