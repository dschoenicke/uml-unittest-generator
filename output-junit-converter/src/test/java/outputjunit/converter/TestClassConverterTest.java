package outputjunit.converter;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import junit.JunitTestClass;
import outputjunit.OutputJunitConverterTests;
import outputjunit.TemporaryModel;

/**
 * Tests {@link TestClassConverter}
 * 
 * @author dschoenicke
 *
 */
public class TestClassConverterTest extends OutputJunitConverterTests {

	/**
	 * Mocks a {@link outputjunit.TemporaryModel} to be used in the tests.
	 */
	TemporaryModel tmpModel;
	
	/**
	 * Initializes the {@link outputjunit.TemporaryModel} and clears the package's class lists.
	 */
	@Before
	public void initTmpModel() {
		tmpModel = new TemporaryModel();
		tmpModel.addConvertedPackage(mockTestPackage1, mockJunitPackage1);
		tmpModel.addConvertedPackage(mockTestPackage2, mockJunitPackage2);
		tmpModel.addConvertedPackage(mockSubTestPackage, mockJunitSubPackage);
		mockJunitPackage1.getTestClasses().clear();
		mockJunitPackage2.getTestClasses().clear();
		mockJunitSubPackage.getTestClasses().clear();
	}
	
	/**
	 * Tests {@link TestClassConverter#convertTestClasses}
	 */
	@Test
	public void testConvertClasses() {
		TestClassConverter.convertTestClasses(mockJunitRepresentation, tmpModel);
		assertEquals(1, mockJunitPackage1.getTestClasses().size());
		assertEquals(2, mockJunitPackage2.getTestClasses().size());
		assertEquals(1, mockJunitSubPackage.getTestClasses().size());
	}
	
	/**
	 * Tests {@link TestClassConverter#convertTestClass}
	 */
	@Test
	public void testConvertClass() {
		JunitTestClass convertedClass = TestClassConverter.convertTestClass(mockTestFile1, mockJunitPackage1, mockJunitRepresentation);
		assertEquals("firstclassTest", convertedClass.getName());
		assertEquals("app.firstpackage.firstclass", convertedClass.getClassName());
		assertEquals("appStructure.app.firstpackage", convertedClass.getPackageDeclaration());
		assertEquals(7, convertedClass.getPropertyAssertions().size());
		assertEquals(2, convertedClass.getRelationshipAssertions().size());
		assertEquals(0, convertedClass.getTemplateParameters().size());
		assertEquals(0, convertedClass.getEnumConstantAssertions().size());
		assertEquals(0, convertedClass.getFields().size());
		assertEquals(0, convertedClass.getConstructors().size());
		assertEquals(2, convertedClass.getMethods().size());
	}
}
