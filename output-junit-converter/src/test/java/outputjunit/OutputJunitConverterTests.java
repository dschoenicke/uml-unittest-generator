package outputjunit;

import java.util.List;
import java.util.Optional;

import org.junit.Before;

import junit.JunitPackage;
import junit.JunitRepresentation;
import junit.JunitTestClass;
import test.TestClass;
import test.TestPackage;
import test.TestRepresentation;
import test.testobjects.ClassUnderTest;
import test.testobjects.ClassUnderTest.ClassUnderTestType;
import test.testobjects.ConstructorUnderTest;
import test.testobjects.EnumConstantUnderTest;
import test.testobjects.FieldUnderTest;
import test.testobjects.MethodUnderTest;
import test.testobjects.ParameterUnderTest;
import test.testobjects.TemplateParameterUnderTest;

/**
 * Tests the {@link OutputJUnitConverter}.
 * 
 * @author dschoenicke
 *
 */
public class OutputJunitConverterTests {

	/**
	 * Mocks a {@link test.TestRepresentation} to be used in the tests.
	 */
	protected TestRepresentation mockTestRepresentation;
	
	/**
	 * Mocks a {@link test.TestPackage} to be used in the tests.
	 */
	protected TestPackage mockTestPackage1;
	
	/**
	 * Mocks a second {@link test.TestPackage} to be used in the tests.
	 */
	protected TestPackage mockTestPackage2;
	
	/**
	 * Mocks a sub {@link test.TestPackage} to be used in the tests.
	 */
	protected TestPackage mockSubTestPackage;
	
	/**
	 * Mocks a {@link test.TestClass} to be used in the tests.
	 */
	protected TestClass mockTestFile1;
	
	/**
	 * Mocks a second {@link test.TestClass} to be used in the tests.
	 */
	protected TestClass mockTestFile2;
	
	/**
	 * Mocks a sub {@link test.TestClass} to be used in the tests.
	 */
	protected TestClass mockSubTestFile;
	
	/**
	 * Mocks an inner {@link test.TestClass} to be used in the tests.
	 */
	protected TestClass mockInnerTestFile;
	
	/**
	 * Mocks a {@link test.testobjects.ClassUnderTest} to be used in the tests.
	 */
	protected ClassUnderTest mockClass1;
	
	/**
	 * Mocks a second {@link test.testobjects.ClassUnderTest} to be used in the tests.
	 */
	protected ClassUnderTest mockClass2;
	
	/**
	 * Mocks a sub {@link test.testobjects.ClassUnderTest} to be used in the tests.
	 */
	protected ClassUnderTest mockSubClass;
	
	/**
	 * Mocks an inner {@link test.testobjects.ClassUnderTest} to be used in the tests.
	 */
	protected ClassUnderTest mockInnerClass;
	
	/**
	 * Mocks a {@link junit.JunitRepresentation} to be used in the tests.
	 */
	protected JunitRepresentation mockJunitRepresentation;
	
	/**
	 * Mocks a {@link junit.JunitPackage} to be used in the tests.
	 */
	protected JunitPackage mockJunitPackage1;
	
	/**
	 * Mocks a second {@link junit.JunitPackage} to be used in the tests.
	 */
	protected JunitPackage mockJunitPackage2;
	
	/**
	 * Mocks a sub {@link junit.JunitPackage} to be used in the tests.
	 */
	protected JunitPackage mockJunitSubPackage;
	
	/**
	 * Mocks a {@link junit.JunitTestClass} to be used in the tests.
	 */
	protected JunitTestClass mockJunitTestClass1;
	
	/**
	 * Mocks a second {@link junit.JunitTestClass} to be used in the tests.
	 */
	protected JunitTestClass mockJunitTestClass2;
	
	/**
	 * Mocks a sub {@link junit.JunitTestClass} to be used in the tests.
	 */
	protected JunitTestClass mockJunitSubTestClass;
	
	/**
	 * Mocks an inner {@link junit.JunitTestClass} to be used in the tests.
	 */
	protected JunitTestClass mockJunitInnerTestClass;
	
	/**
	 * Initializes the mock {@test.TestRepresentation} elements.
	 */
	@Before
	public void initTestRepresentation() {
		mockTestRepresentation = new TestRepresentation("app");
		mockTestPackage1 = new TestPackage("firstpackage", mockTestRepresentation);
		mockTestPackage2 = new TestPackage("secondpackage", mockTestRepresentation);
		mockSubTestPackage = new TestPackage("subpackage", mockTestPackage1);
		mockTestRepresentation.getPackages().addAll(List.of(mockTestPackage1, mockTestPackage2));
		mockTestPackage1.addPackage(mockSubTestPackage);
		mockClass1 = new ClassUnderTest("app.firstpackage.firstclass", ClassUnderTestType.INTERFACE, 0, Optional.empty());
		mockClass1.setNestHost(Optional.empty());
		mockClass2 = new ClassUnderTest("app.secondpackage.secondclass", ClassUnderTestType.CLASS, 1055, Optional.empty());
		mockClass2.setNestHost(Optional.empty());
		mockSubClass = new ClassUnderTest("app.firstpackage.subpackage.subclass", ClassUnderTestType.CLASS, 0, Optional.of("firstclass"));
		mockSubClass.setNestHost(Optional.empty());
		mockInnerClass = new ClassUnderTest("app.secondpackage.secondclass$innerclass", ClassUnderTestType.ENUM, 2, Optional.empty());
		mockTestFile1 = new TestClass("firstclassTest", mockTestPackage1, mockClass1);
		mockTestFile2 = new TestClass("secondclassTest", mockTestPackage2, mockClass2);
		mockSubTestFile = new TestClass("subclassTest", mockSubTestPackage, mockSubClass);
		mockInnerTestFile = new TestClass("innerclassTest", mockTestPackage2, mockInnerClass);
		mockTestPackage1.addTestClass(mockTestFile1);
		mockTestPackage2.addTestClass(mockTestFile2);
		mockSubTestPackage.addTestClass(mockSubTestFile);
		mockTestPackage2.addTestClass(mockInnerTestFile);
		
		ParameterUnderTest returnType = new ParameterUnderTest("", "void", 0, false, false);
		ParameterUnderTest param1 = new ParameterUnderTest("param1", "int", 16, true, false);
		ParameterUnderTest param2 = new ParameterUnderTest("param2", "app.firstpackage.firstclass", 0, true, true);
		new MethodUnderTest("method1", 1055, mockClass1, returnType);
		new MethodUnderTest("method2", 0, mockClass1, new ParameterUnderTest("", "app.secondpackage.secondclass", 0, false, false));
		mockClass1.getMethods().get(0).getParameters().addAll(List.of(param1, param2));
		
		new TemplateParameterUnderTest("T", "app.firstpackage.firstclass", mockClass2);
		new FieldUnderTest("field1", "int", 0, mockClass2, false, false);
		new FieldUnderTest("field2", "String", 31, mockClass2, true, false);
		new FieldUnderTest("field3", "app.firstpackage.firstclass", 2, mockClass2, true, true);
		new ConstructorUnderTest(7, mockClass2);
		new ConstructorUnderTest(0, mockClass2);
		mockClass2.getConstructors().get(1).addParameter(param1);
		mockClass2.getConstructors().get(1).addParameter(param2);
		
		new EnumConstantUnderTest("TEST1", mockInnerClass);
		new EnumConstantUnderTest("TEST2", mockInnerClass);
		mockInnerClass.setNestHost(Optional.of(mockClass2));
		mockInnerClass.getInterfaces().add(mockClass1.getQualifiedName());
	}
	
	/**
	 * Initializes the mock {@junit.JunitRepresentation}.<br>
	 * Creates only unique {@link junit.JunitAssertion}s.
	 */
	@Before
	public void initJunitRepresentation() {
		mockJunitRepresentation = new JunitRepresentation("app");
		mockJunitPackage1 = new JunitPackage("firstpackage", mockJunitRepresentation);
		mockJunitPackage2 = new JunitPackage("secondpackage", mockJunitRepresentation);
		mockJunitSubPackage = new JunitPackage("subpackage", mockJunitPackage1);
		mockJunitRepresentation.getPackages().addAll(List.of(mockJunitPackage1, mockJunitPackage2));
		mockJunitPackage1.addPackage(mockJunitSubPackage);
		mockJunitTestClass1 = new JunitTestClass("firstclassTest", "app.firstpackage.firstclass", "app.firstpackage", mockJunitPackage1);
		mockJunitTestClass2 = new JunitTestClass("secondclassTest", "app.secondpackage.secondclass", "app.secondpackage", mockJunitPackage2);
		mockJunitSubTestClass = new JunitTestClass("subclassTest", "app.firstpackage.subpackage.subclass", "app.firstpackage.subpackage", mockJunitPackage1);
		mockJunitInnerTestClass = new JunitTestClass("innerclassTest", "app.secondpackage.secondclass$innerclass", "app.secondpackage", mockJunitPackage2);
		
		mockJunitPackage1.addTestClass(mockJunitTestClass1);
		mockJunitPackage2.addTestClass(mockJunitTestClass2);
		mockJunitSubPackage.addTestClass(mockJunitSubTestClass);
		mockJunitPackage2.addTestClass(mockJunitInnerTestClass);
		/*
		mockJunitTestClass1.getPropertyAssertions().addAll(List.of(
				new JunitAssertion("true", "classUnderTest.isInterface()", mockJunitTestClass1.getClassName() + " must be an interface!"),
				new JunitAssertion("\"" + mockJunitTestClass1.getClassName() + "\"", "classUnderTest.getNestHost()", mockJunitTestClass1.getClassName() + " must not be an inner class!"),
				new JunitAssertion("false", "Modifier.isPublic(classUnderTest.getModifiers())", mockJunitTestClass1.getClassName() + " must not be public!"),
				new JunitAssertion("false", "Modifier.isPrivate(classUnderTest.getModifiers())", mockJunitTestClass1.getClassName() + " must not be private!"),
				new JunitAssertion("false", "Modifier.isProtected(classUnderTest.getModifiers())", mockJunitTestClass1.getClassName() + " must not be protected!"),
				new JunitAssertion("false", "Modifier.isStatic(classUnderTest.getModifiers())", mockJunitTestClass1.getClassName() + " must not be static!"),
				new JunitAssertion("false", "Modifier.isFinal(classUnderTest.getModifiers())", mockJunitTestClass1.getClassName() + " must not be final!"),
				new JunitAssertion("false", "Modifier.isAbstract(classUnderTest.getModifiers())", mockJunitTestClass1.getClassName() + " must not be abstract!")));
		mockJunitTestClass1.getRelationshipAssertions().addAll(List.of(
					new JunitAssertion("\"firstclass\"", "classUnderTest.getSuperclass().getSimpleName()", mockJunitTestClass1.getClassName() + " must not extend any super class!"),
					new JunitAssertion("0", "classUnderTest.getInterfaces().length", mockJunitTestClass1.getClassName() + " must implement exactly 0 interfaces!")
				));
		mockJunitTestClass1.getMethods().add*/
	}
	
	/*/**
	 * Tests {@link OutputJUnitConverter#convertTestFiles}, executes the function and assumes that the root directory has been created.
	 */
	/*@Test
	public void testOutputJUnitConverter() {
		OutputJUnitConverter converter = new OutputJUnitConverter();
		//converter.convertToJUnitTestFiles(mockTestRepresentation, "test");
		//assertTrue(new File("test" + File.separator + mockTestRepresentation.getName() + "Structure" + 
			//	File.separator + mockTestPackage1.getName() + File.separator + 
				//mockTestFile1.getName() + ".java").exists());
	}*/
	
	/*/**
	 * Deletes the created files.
	 */
	/*@After
	public void cleanup() {
		new File("test" + File.separator + mockTestRepresentation.getName() + "Structure" + File.separator + mockTestPackage1.getName() + File.separator + mockTestFile1.getName() + ".java").delete();
		new File("test" + File.separator + mockTestRepresentation.getName() + "Structure" + File.separator + mockTestPackage2.getName() + File.separator + mockTestFile2.getName() + ".java").delete();
		new File("test" + File.separator + mockTestRepresentation.getName() + "Structure" + File.separator + mockTestPackage1.getName() + File.separator + mockSubTestPackage.getName() + File.separator + mockSubTestFile.getName() + ".java").delete();
		new File("test" + File.separator + mockTestRepresentation.getName() + "Structure" + File.separator + mockTestPackage1.getName() + File.separator + mockSubTestPackage.getName()).delete();
		new File("test" + File.separator + mockTestRepresentation.getName() + "Structure" + File.separator + mockTestPackage1.getName()).delete();
		new File("test" + File.separator + mockTestRepresentation.getName() + "Structure" + File.separator + mockTestPackage2.getName()).delete();
		new File("test" + File.separator + mockTestRepresentation.getName() + "Structure").delete();
	}*/
}
