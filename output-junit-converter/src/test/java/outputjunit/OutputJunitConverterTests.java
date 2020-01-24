package outputjunit;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.FileUtils;
import org.junit.After;
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

public class OutputJunitConverterTests {
	
	protected TemporaryModel mockTmpModel;
	protected String outputPath;
	protected String testDirectory;
	protected TestRepresentation mockTestRepresentation;
	protected TestPackage mockTestParentPackage;
	protected TestPackage mockTestPackage1;
	protected TestPackage mockTestPackage2;
	protected TestPackage mockSubTestPackage;
	protected TestClass mockTestFile1;
	protected TestClass mockTestFile2;
	protected TestClass mockSubTestFile;
	protected TestClass mockInnerTestFile;
	protected ClassUnderTest mockClass1;
	protected ClassUnderTest mockClass2;
	protected ClassUnderTest mockSubClass;
	protected ClassUnderTest mockInnerClass;
	protected JunitRepresentation mockJunitRepresentation;
	protected JunitPackage mockJunitParentPackage;
	protected JunitPackage mockJunitExternPackage;
	protected JunitPackage mockJunitPackage1;
	protected JunitPackage mockJunitPackage2;
	protected JunitPackage mockJunitSubPackage;
	protected JunitTestClass mockJunitTestClass1;
	protected JunitTestClass mockJunitTestClass2;
	protected JunitTestClass mockJunitSubTestClass;
	protected JunitTestClass mockJunitInnerTestClass;
	
	@Before
	public void initTestRepresentation() {
		outputPath = System.getProperty("user.dir");
		testDirectory = outputPath + File.separator + "appStructure";
		mockTestRepresentation = new TestRepresentation("app");
		mockTestParentPackage = new TestPackage("app", mockTestRepresentation);
		mockTestPackage1 = new TestPackage("firstpackage", mockTestParentPackage);
		mockTestPackage2 = new TestPackage("secondpackage", mockTestParentPackage);
		mockSubTestPackage = new TestPackage("subpackage", mockTestPackage1);
		mockTestRepresentation.addPackage(mockTestParentPackage);
		mockTestParentPackage.getPackages().addAll(List.of(mockTestPackage1, mockTestPackage2));
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
		
		ParameterUnderTest returnType = new ParameterUnderTest("", "void", 0, true, true);
		ParameterUnderTest param1 = new ParameterUnderTest("param1", "List<int>", 16, true, false);
		ParameterUnderTest param2 = new ParameterUnderTest("param2", "app.firstpackage.firstclass", 0, true, true);
		new MethodUnderTest("method1", 1055, mockClass1, returnType);
		new MethodUnderTest("method2", 0, mockClass1, new ParameterUnderTest("", "app.secondpackage.secondclass", 0, true, false));
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
		new ConstructorUnderTest(0, mockInnerClass);
	}
	
	@Before
	public void initJunitRepresentation() {
		mockJunitRepresentation = new JunitRepresentation("app");
		mockJunitExternPackage = new JunitPackage("extern", mockJunitRepresentation);
		mockJunitParentPackage = new JunitPackage("app", mockJunitRepresentation);
		mockJunitPackage1 = new JunitPackage("firstpackage", mockJunitParentPackage);
		mockJunitPackage2 = new JunitPackage("secondpackage", mockJunitParentPackage);
		mockJunitSubPackage = new JunitPackage("subpackage", mockJunitPackage1);
		mockJunitRepresentation.getPackages().addAll(List.of(mockJunitExternPackage, mockJunitPackage1, mockJunitPackage2));
		mockJunitPackage1.addPackage(mockJunitSubPackage);
		mockJunitTestClass1 = new JunitTestClass("firstclassTest", "app.firstpackage.firstclass", "appStructure.app.firstpackage", mockJunitPackage1, false);
		mockJunitTestClass2 = new JunitTestClass("secondclassTest", "app.secondpackage.secondclass", "appStructure.app.secondpackage", mockJunitPackage2, false);
		mockJunitSubTestClass = new JunitTestClass("subclassTest", "app.firstpackage.subpackage.subclass", "appStructure.app.firstpackage.subpackage", mockJunitPackage1, false);
		mockJunitInnerTestClass = new JunitTestClass("innerclassTest", "app.secondpackage.secondclass$innerclass", "appStructure.app.secondpackage", mockJunitPackage2, true);
		
		mockJunitPackage1.addTestClass(mockJunitTestClass1);
		mockJunitPackage2.addTestClass(mockJunitTestClass2);
		mockJunitSubPackage.addTestClass(mockJunitSubTestClass);
		mockJunitPackage2.addTestClass(mockJunitInnerTestClass);
	}
	
	@After
	public void cleanUp() throws IOException {
		if (new File(testDirectory).exists()) {
			FileUtils.deleteDirectory(new File(testDirectory));
		}
	}
}
