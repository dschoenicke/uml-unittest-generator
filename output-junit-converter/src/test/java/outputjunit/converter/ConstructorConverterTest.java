package outputjunit.converter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import junit.JunitConstructorUnderTest;
import outputjunit.OutputJunitConverterTests;

/**
 * Tests {@link ConstructorConverter}
 * 
 * @author dschoenicke
 *
 */
public class ConstructorConverterTest extends OutputJunitConverterTests {

	/**
	 * Tests {@link ConstructorConverter#convertConstructors}
	 */
	@Test
	public void testConvertConstructors() {
		ConstructorConverter.convertConstructors(mockClass2, mockJunitTestClass2);
		JunitConstructorUnderTest convertedConstructor = mockJunitTestClass2.getConstructors().get(0);
		assertEquals(2, mockJunitTestClass2.getConstructors().size());
		assertEquals("", convertedConstructor.getParameterTypeClasses());
		assertEquals(0, convertedConstructor.getParameters().size());
		assertEquals(3, convertedConstructor.getAssertions().size());
		convertedConstructor = mockJunitTestClass2.getConstructors().get(1);
		assertEquals("int.class, app.firstpackage.firstclass.class", convertedConstructor.getParameterTypeClasses());
		assertEquals(2, convertedConstructor.getParameters().size());
		assertEquals(3, convertedConstructor.getAssertions().size());
	}
}
