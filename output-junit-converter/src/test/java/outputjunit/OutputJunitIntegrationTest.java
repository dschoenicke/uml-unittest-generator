package outputjunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import junit.JunitPackage;
import junit.JunitRepresentation;
import junit.JunitTestClass;
import test.TestClass;
import test.TestPackage;
import test.TestRepresentation;
import test.TestRepresentationTests;
import test.testobjects.ClassUnderTest;

public class OutputJunitIntegrationTest {

	protected TestRepresentation testRepresentation;
	protected TestPackage testModelPackage;
	protected TestPackage testTopLevelPackage;
	protected TestClass testTopLevelInterface;
	protected TestClass testTopLevelClass;
	protected ClassUnderTest topLevelInterfaceUnderTest;
	protected ClassUnderTest topLevelClassUnderTest;
	protected TestClass testSubClass;
	protected TestClass testSubInterface;
	protected TestClass testGenericClass;
	protected TestClass testBindingClass;
	protected ClassUnderTest subClassUnderTest;
	protected ClassUnderTest subInterfaceUnderTest;
	protected ClassUnderTest genericClassUnderTest;
	protected ClassUnderTest bindingClassUnderTest;
	protected TestPackage testSubPackage;
	protected TestClass testSubPackageClass;
	protected TestClass testEnumeration;
	protected TestClass testBigEnum;
	protected ClassUnderTest subPackageClassUnderTest;
	protected ClassUnderTest enumerationUnderTest;
	protected ClassUnderTest bigEnumUnderTest;
	protected TestRepresentationTests testRepresentationTests;
	
	protected JunitRepresentation junitRepresentation;
	protected JunitPackage junitModelPackage;
	protected JunitPackage junitTopLevelPackage;
	protected JunitTestClass junitTopLevelInterface;
	protected JunitTestClass junitTopLevelClass;
	protected JunitTestClass junitSubInterface;
	protected JunitTestClass junitSubClass;
	protected JunitTestClass junitGenericClass;
	protected JunitTestClass junitBindingClass;
	protected JunitPackage junitSubPackage;
	protected JunitTestClass junitSubPackageClass;
	protected JunitTestClass junitEnumeration;
	protected JunitTestClass junitBigEnum;
	
	@Before
	public void initTestData() {
		testRepresentationTests = new TestRepresentationTests();
		testRepresentationTests.initializeTestRepresentation();
		testRepresentation = testRepresentationTests.getTestRepresentation();
		testModelPackage = testRepresentationTests.getTestModelPackage();
		testTopLevelPackage = testRepresentationTests.getTestTopLevelPackage();
		testTopLevelInterface = testRepresentationTests.getTestTopLevelInterface();
		testTopLevelClass = testRepresentationTests.getTestTopLevelClass();
		topLevelInterfaceUnderTest = testRepresentationTests.getTopLevelInterfaceUnderTest();
		topLevelClassUnderTest = testRepresentationTests.getTopLevelClassUnderTest();
		testSubClass = testRepresentationTests.getTestSubClass();
		testSubInterface = testRepresentationTests.getTestSubInterface();
		testGenericClass = testRepresentationTests.getTestGenericClass();
		testBindingClass = testRepresentationTests.getTestBindingClass();
		subClassUnderTest = testRepresentationTests.getSubClassUnderTest();
		subInterfaceUnderTest = testRepresentationTests.getSubInterfaceUnderTest();
		genericClassUnderTest = testRepresentationTests.getGenericClassUnderTest();
		bindingClassUnderTest = testRepresentationTests.getBindingClassUnderTest();
		testSubPackage = testRepresentationTests.getTestSubPackage();
		testSubPackageClass = testRepresentationTests.getTestSubPackageClass();
		testEnumeration = testRepresentationTests.getTestEnumeration();
		testBigEnum = testRepresentationTests.getTestBigEnum();
		subPackageClassUnderTest = testRepresentationTests.getSubPackageClassUnderTest();
		enumerationUnderTest = testRepresentationTests.getEnumerationUnderTest();
		bigEnumUnderTest = testRepresentationTests.getBigEnumUnderTest();
		
		junitRepresentation = OutputJunitConverter.convertTestToJunitRepresentation(testRepresentation);
		junitModelPackage = junitRepresentation.getPackages().get(1);
		junitTopLevelInterface = junitModelPackage.getTestClasses().get(0);
		junitTopLevelClass = junitModelPackage.getTestClasses().get(1);
		junitTopLevelPackage = junitRepresentation.getPackages().get(0);
		junitSubInterface = junitTopLevelPackage.getTestClasses().get(0);
		junitSubClass = junitTopLevelPackage.getTestClasses().get(1);
		junitGenericClass = junitTopLevelPackage.getTestClasses().get(2);
		junitBindingClass = junitTopLevelPackage.getTestClasses().get(3);
		junitSubPackage = junitTopLevelPackage.getPackages().get(0);
		junitSubPackageClass = junitSubPackage.getTestClasses().get(0);
		junitEnumeration = junitSubPackage.getTestClasses().get(1);
		junitBigEnum = junitSubPackage.getTestClasses().get(2);
	}
	
	@Test
	public void verifyModelStructure() {
		assertEquals("Model", junitRepresentation.getName());
		assertEquals(2, junitRepresentation.getPackages().size());
		assertTrue(junitRepresentation.getPackages().contains(junitTopLevelPackage));
		assertTrue(junitRepresentation.getPackages().contains(junitModelPackage));
		assertEquals(junitRepresentation.getPackages().get(0), junitTopLevelPackage);
		assertEquals(junitRepresentation.getPackages().get(1), junitModelPackage);
		assertEquals(4, junitTopLevelPackage.getTestClasses().size());
		assertTrue(junitTopLevelPackage.getTestClasses().contains(junitSubInterface));
		assertTrue(junitTopLevelPackage.getTestClasses().contains(junitSubClass));
		assertTrue(junitTopLevelPackage.getTestClasses().contains(junitGenericClass));
		assertTrue(junitTopLevelPackage.getTestClasses().contains(junitBindingClass));
		assertEquals(1, junitSubClass.getFields().size());
		assertEquals(2, junitGenericClass.getFields().size());
		assertEquals(2, junitGenericClass.getTemplateParameters().size());
		assertEquals(1, junitGenericClass.getConstructors().size());
		assertEquals(1, junitGenericClass.getConstructors().get(0).getParameters().size());
		assertEquals(2, junitGenericClass.getMethods().size());
		assertEquals(0, junitGenericClass.getMethods().get(0).getParameters().size());
		assertEquals(1, junitGenericClass.getMethods().get(1).getParameters().size());
		assertEquals(1, junitBindingClass.getConstructors().size());
		assertEquals(0, junitBindingClass.getConstructors().get(0).getParameters().size());
		assertEquals(3, junitEnumeration.getEnumConstantAssertions().size());
		assertEquals(1, junitBigEnum.getFields().size());
		assertEquals(2, junitBigEnum.getEnumConstantAssertions().size());
		assertEquals(1, junitBigEnum.getConstructors().size());
		assertEquals(1, junitBigEnum.getMethods().size());
		assertEquals(0, junitBigEnum.getMethods().get(0).getParameters().size());
	}
}
