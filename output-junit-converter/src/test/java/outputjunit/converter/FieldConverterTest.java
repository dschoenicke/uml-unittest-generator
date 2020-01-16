package outputjunit.converter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import junit.JunitFieldUnderTest;
import outputjunit.OutputJunitConverterTests;

/**
 * Tests {@link FieldConverter}
 * 
 * @author dschoenicke
 *
 */
public class FieldConverterTest extends OutputJunitConverterTests {

	/**
	 * Tests {@link FieldConverter#convertFields}
	 */
	@Test
	public void testConvertFields() {
		FieldConverter.convertFields(mockClass2, mockJunitTestClass2);
		assertEquals(3, mockJunitTestClass2.getFields().size());
		JunitFieldUnderTest field1 = mockJunitTestClass2.getFields().get(0);
		JunitFieldUnderTest field2 = mockJunitTestClass2.getFields().get(1);
		JunitFieldUnderTest field3 = mockJunitTestClass2.getFields().get(2);
		assertEquals("field1", field1.getName());
		assertEquals("int", field1.getType());
		assertEquals(5, field1.getAssertions().size());
		assertEquals(false, field1.isCheckForOptional());
		assertEquals(false, field1.isHasMultiplicity());
		assertEquals("field2", field2.getName());
		assertEquals("String", field2.getType());
		assertEquals(true, field2.isCheckForOptional());
		assertEquals(false, field2.isHasMultiplicity());
		assertEquals("field3", field3.getName());
		assertEquals("app.firstpackage.firstclass", field3.getType());
		assertEquals(false, field3.isCheckForOptional());
		assertEquals(true, field3.isHasMultiplicity());
	}
}
