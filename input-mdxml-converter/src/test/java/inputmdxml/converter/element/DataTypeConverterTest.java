package inputmdxml.converter.element;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import inputmdxml.MdxmlUmlConverterTests;
import inputmdxml.converter.element.DataTypeConverter;
import mdxml.Actual;
import mdxml.DataType;

public class DataTypeConverterTest extends MdxmlUmlConverterTests {

	private DataType mockDataType;
	private Actual mockActual;
	
	@Before
	public void init() {
		mockDataType = mdxmlSubClass.getOwnedAttributes().get(0).getDataType();
		mockActual = new Actual();
		mockActual.setExtension(mockDataType.getExtension());
		mockTmpModel.addElement(mdxmlBindingClass.getId(), umlBindingClass);
	}
	
	@Test
	public void testConvertDataTypeWithActual() {
		assertEquals("String", DataTypeConverter.convertDataType(null, mockActual));
	}
	
	@Test
	public void testConvertDataTypeWithDataType() {
		assertEquals("String", DataTypeConverter.convertDataType(null, mockDataType));
	}
	
	@Test
	public void testConvertDataTypeWithElementReference() {
		assertEquals(mdxmlBindingClass.getId(), DataTypeConverter.convertDataType(mdxmlBindingClass.getId(), mockActual));
		assertEquals("5678", DataTypeConverter.convertDataType("5678", mockDataType));
	}
	
	@Test
	public void testConvertElementID() {
		assertEquals(umlBindingClass.getName(), DataTypeConverter.convertElementID(mdxmlBindingClass.getId(), mockTmpModel));
		assertEquals("5678", DataTypeConverter.convertElementID("5678", mockTmpModel));
	}
}
