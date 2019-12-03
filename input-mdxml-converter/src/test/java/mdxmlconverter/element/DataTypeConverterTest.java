package mdxmlconverter.element;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import mdxml.Actual;
import mdxml.DataType;
import mdxml.Extension;
import mdxml.ReferenceExtension;
import mdxmlconverter.temporary.TemporaryModel;
import uml.UmlClass;
import uml.UmlVisibility;

/**
 * Tests the {@link DataTypeConverter}.
 * 
 * @author dschoenicke
 *
 */
public class DataTypeConverterTest {

	/**
	 * Mocks a {@link mdxml.DataType} to be used in the tests.
	 */
	private DataType mockDataType;

	/**
	 * Mocks a {@link mdxml.Actual} to be used in the tests.
	 */
	private Actual mockActual;
	
	/**
	 * Mocks a {@link mdxmlconverter.temporary.TemporaryModel} to be used in the tests.
	 */
	private TemporaryModel mockTmpModel;
	
	/**
	 * Initializes the mock elements and a {@link mdxml.Extension} which will be added to the mock {@link mdxml.Actual} and mock {@link mdxml.DataType}.
	 */
	@Before
	public void init() {
		Extension extension = new Extension();
		extension.setReferenceExtension(new ReferenceExtension());
		extension.getReferenceExtension().setReferentPath("UML Standard Profile::UML2 Metamodel::PrimitiveTypes::String");
		mockActual = new Actual();
		mockDataType = new DataType();
		mockActual.setExtension(extension);
		mockDataType.setExtension(extension);
		mockTmpModel = new TemporaryModel();
		mockTmpModel.addElement("1234", new UmlClass("TestClass", UmlVisibility.PUBLIC));
	}
	
	/**
	 * Tests {@link DataTypeConverter#convertDataType(String, Actual)}.
	 */
	@Test
	public void testConvertDataTypeWithActual() {
		assertEquals(DataTypeConverter.convertDataType(null, mockActual), "String");
	}
	
	/**
	 * Tests {@link DataTypeConverter#convertDataType(String, DataType)}.
	 */
	@Test
	public void testConvertDataTypeWithDataType() {
		assertEquals(DataTypeConverter.convertDataType(null, mockDataType), "String");
	}
	
	/**
	 * Tests {@link DataTypeConverter#convertDataType} with an element reference string.
	 */
	@Test
	public void testConvertDataTypeWithElementReference() {
		assertEquals(DataTypeConverter.convertDataType("1234", mockActual), "1234");
		assertEquals(DataTypeConverter.convertDataType("5678", mockDataType), "5678");
	}
	
	/**
	 * Tests {@link DataTypeConverter#convertElementID}
	 */
	@Test
	public void testConvertElementID() {
		assertEquals(DataTypeConverter.convertElementID("1234", mockTmpModel), "TestClass");
		assertEquals(DataTypeConverter.convertElementID("5678", mockTmpModel), "5678");
	}
}
