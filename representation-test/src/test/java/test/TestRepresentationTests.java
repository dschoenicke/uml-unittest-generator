package test;

import java.util.List;
import java.util.Optional;

import org.junit.Before;

import lombok.Getter;
import lombok.NoArgsConstructor;
import test.testobjects.ClassUnderTest;
import test.testobjects.ClassUnderTest.ClassUnderTestType;
import test.testobjects.ConstructorUnderTest;
import test.testobjects.EnumConstantUnderTest;
import test.testobjects.FieldUnderTest;
import test.testobjects.MethodUnderTest;
import test.testobjects.ParameterUnderTest;
import test.testobjects.TemplateParameterUnderTest;

@Getter
@NoArgsConstructor
public class TestRepresentationTests {

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
	
	public void initializeTestRepresentation() {
		testRepresentation = new TestRepresentation("Model");
		testModelPackage = new TestPackage("Model", testRepresentation);
		testRepresentation.addPackage(testModelPackage);
		topLevelInterfaceUnderTest = new ClassUnderTest("Model.TopLevelInterface", ClassUnderTestType.INTERFACE, 1, Optional.empty());
		testTopLevelInterface = new TestClass("TopLevelInterfaceTest", testModelPackage, topLevelInterfaceUnderTest);
		topLevelClassUnderTest = new ClassUnderTest("Model.TopLevelClass", ClassUnderTestType.CLASS, 1, Optional.empty());
		testTopLevelClass = new TestClass("TopLevelClassTest", testModelPackage, topLevelClassUnderTest);
		testModelPackage.addTestClass(testTopLevelInterface);
		testModelPackage.addTestClass(testTopLevelClass);
		testTopLevelPackage = new TestPackage("TopLevelPackage", testRepresentation);
		testRepresentation.addPackage(testTopLevelPackage);
		
		subInterfaceUnderTest = new ClassUnderTest("TopLevelPackage.SubInterface", ClassUnderTestType.INTERFACE, 1, Optional.empty());
		subInterfaceUnderTest.getInterfaces().add(topLevelInterfaceUnderTest.getQualifiedName());
		testSubInterface = new TestClass("SubInterfaceTest", testTopLevelPackage, subInterfaceUnderTest);
		subClassUnderTest = new ClassUnderTest("TopLevelPackage.SubClass", ClassUnderTestType.CLASS, 1, Optional.of(topLevelClassUnderTest.getQualifiedName()));
		new FieldUnderTest("testString", "String", 2, subClassUnderTest, true, false);
		testSubClass = new TestClass("SubClassTest", testTopLevelPackage, subClassUnderTest);
		genericClassUnderTest = new ClassUnderTest("TopLevelPackage.GenericClass", ClassUnderTestType.CLASS, 1, Optional.empty());
		new FieldUnderTest("subPackageClass", "TopLevelPackage.SubPackage.SubPackageClass", 2, genericClassUnderTest, false, true);
		new FieldUnderTest("bigEnum", "TopLevelPackage.SubPackage.BigEnum", 2, genericClassUnderTest, false, false);
		new ConstructorUnderTest(1, genericClassUnderTest);
		genericClassUnderTest.getConstructors().get(0).addParameter(new ParameterUnderTest("name", "String", 0, false, false));
		new MethodUnderTest("getSubPackageClasses", 1, genericClassUnderTest, new ParameterUnderTest("", "TopLevelPackage.SubPackage.SubPackageClass", 0, false, true));
		new MethodUnderTest("addSubPackageClass", 1, genericClassUnderTest, new ParameterUnderTest("", "void", 0, false, false));
		genericClassUnderTest.getMethods().get(1).getParameters().add(new ParameterUnderTest("subPackageClass", "TopLevelPackage.SubPackage.SubPackageClass", 0, false, false));
		new TemplateParameterUnderTest("T", "Model.TopLevelClass", genericClassUnderTest);
		new TemplateParameterUnderTest("O", "java.lang.Object", genericClassUnderTest);
		testGenericClass = new TestClass("GenericClassTest", testTopLevelPackage, genericClassUnderTest);
		bindingClassUnderTest = new ClassUnderTest("TopLevelPackage.BindingClass", ClassUnderTestType.CLASS, 1, Optional.empty());
		new ConstructorUnderTest(1, bindingClassUnderTest);
		testBindingClass = new TestClass("BindingClassTest", testTopLevelPackage, bindingClassUnderTest);
		testTopLevelPackage.getTestClasses().addAll(List.of(testSubInterface, testSubClass, testGenericClass, testBindingClass));
		
		testSubPackage = new TestPackage("SubPackage", testTopLevelPackage);
		testTopLevelPackage.addPackage(testSubPackage);
		subPackageClassUnderTest = new ClassUnderTest("TopLevelPackage.SubPackage.SubPackageClass", ClassUnderTestType.CLASS, 1, Optional.empty());
		testSubPackageClass = new TestClass("SubPackageClassTest", testSubPackage, subPackageClassUnderTest);
		enumerationUnderTest = new ClassUnderTest("TopLevelPackage.SubPackage.SubPackageClass$Enumeration", ClassUnderTestType.ENUM, 1, Optional.empty());
		new EnumConstantUnderTest("FIRST", enumerationUnderTest);
		new EnumConstantUnderTest("SECOND", enumerationUnderTest);
		testEnumeration = new TestClass("EnumerationTest", testSubPackage, enumerationUnderTest);
		bigEnumUnderTest = new ClassUnderTest("TopLevelPackage.SubPackage.BigEnum", ClassUnderTestType.ENUM, 1, Optional.empty());
		new EnumConstantUnderTest("BIGFIRST", bigEnumUnderTest);
		new FieldUnderTest("value", "int", 18, bigEnumUnderTest, false, false);
		new ConstructorUnderTest(1, bigEnumUnderTest);
		bigEnumUnderTest.getConstructors().get(0).getParameters().add(new ParameterUnderTest("value", "int", 0, false, false));
		new MethodUnderTest("someOperation", 1, bigEnumUnderTest, new ParameterUnderTest("", "void", 0, false, false));
		testBigEnum = new TestClass("BigEnumTest", testSubPackage, bigEnumUnderTest);
		testSubPackage.getTestClasses().addAll(List.of(testSubPackageClass, testEnumeration, testBigEnum));
	}
	
	@Before
	public void init() {
		initializeTestRepresentation();
	}
}
