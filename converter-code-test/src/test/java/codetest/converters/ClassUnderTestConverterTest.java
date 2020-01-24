package codetest.converters;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;

import codetest.CodeTestConverterTests;
import codetest.converters.ClassUnderTestConverter;
import test.testobjects.ClassUnderTest;
import test.testobjects.ClassUnderTest.ClassUnderTestType;

public class ClassUnderTestConverterTest extends CodeTestConverterTests {

	@Test
	public void testNormalClass() {
		ClassUnderTest convertedClass = ClassUnderTestConverter.convertClassUnderTest(codeTopLevelClass);
		assertEquals(codeTopLevelClass.getQualifiedName(), convertedClass.getQualifiedName());
		assertEquals(codeTopLevelClass.getModifiers(), convertedClass.getModifiers());
		assertEquals(ClassUnderTestType.CLASS, convertedClass.getType());
		assertEquals(Optional.empty(), convertedClass.getSuperClass());
	}
	
	@Test
	public void testSubClass() {
		ClassUnderTest convertedClass = ClassUnderTestConverter.convertClassUnderTest(codeSubClass);
		assertEquals(Optional.of(codeTopLevelClass.getName()), convertedClass.getSuperClass());
	}
	
	@Test
	public void testInterface() {
		ClassUnderTest convertedClass = ClassUnderTestConverter.convertClassUnderTest(codeSubInterface);
		assertEquals(ClassUnderTestType.INTERFACE, convertedClass.getType());
	}
	
	@Test
	public void testEnumeration() {
		ClassUnderTest convertedClass = ClassUnderTestConverter.convertClassUnderTest(codeEnumeration);
		assertEquals(ClassUnderTestType.ENUM, convertedClass.getType());
	}
}
