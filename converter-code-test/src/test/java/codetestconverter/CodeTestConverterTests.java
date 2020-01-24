package codetestconverter;

import org.junit.Before;

import code.CodeClass;
import code.CodeEnumeration;
import code.CodeInterface;
import code.CodePackage;
import code.CodeRepresentation;
import code.CodeRepresentationTests;
import codetestconverter.temporary.TemporaryModel;
import test.TestClass;
import test.TestPackage;
import test.TestRepresentation;
import test.TestRepresentationTests;
import test.testobjects.ClassUnderTest;

public class CodeTestConverterTests {
	
	protected CodeRepresentation codeRepresentation;
	protected CodePackage codeModelPackage;
	protected CodePackage codeTopLevelPackage;
	protected CodeInterface codeTopLevelInterface;
	protected CodeClass codeTopLevelClass;
	protected CodeClass codeSubClass;
	protected CodeInterface codeSubInterface;
	protected CodeClass codeGenericClass;
	protected CodeClass codeBindingClass;
	protected CodePackage codeSubPackage;
	protected CodeClass codeSubPackageClass;
	protected CodeEnumeration codeEnumeration;
	protected CodeEnumeration codeBigEnum;
	
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
	
	protected CodeRepresentationTests codeRepresentationTests;
	protected TestRepresentationTests testRepresentationTests;
	protected TemporaryModel mockTmpModel;
	protected CodeTestConverter converter;
	
	@Before
	public void initTestData() {
		codeRepresentationTests = new CodeRepresentationTests();
		codeRepresentationTests.initializeCodeRepresentation();
		testRepresentationTests = new TestRepresentationTests();
		testRepresentationTests.initializeTestRepresentation();
		codeRepresentation = codeRepresentationTests.getCodeRepresentation();
		codeModelPackage = codeRepresentationTests.getCodeModelPackage();
		codeTopLevelPackage = codeRepresentationTests.getCodeTopLevelPackage();
		codeTopLevelInterface = codeRepresentationTests.getCodeTopLevelInterface();
		codeTopLevelClass = codeRepresentationTests.getCodeTopLevelClass();
		codeSubClass = codeRepresentationTests.getCodeSubClass();
		codeSubInterface = codeRepresentationTests.getCodeSubInterface();
		codeGenericClass = codeRepresentationTests.getCodeGenericClass();
		codeBindingClass = codeRepresentationTests.getCodeBindingClass();
		codeSubPackage = codeRepresentationTests.getCodeSubPackage();
		codeSubPackageClass = codeRepresentationTests.getCodeSubPackageClass();
		codeEnumeration = codeRepresentationTests.getCodeEnumeration();
		codeBigEnum = codeRepresentationTests.getCodeBigEnum();
		
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
		
		mockTmpModel = new TemporaryModel();
		converter = new CodeTestConverter();
	}
}
