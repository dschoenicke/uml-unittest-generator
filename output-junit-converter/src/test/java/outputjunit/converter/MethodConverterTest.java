package outputjunit.converter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import junit.JunitMethodUnderTest;
import outputjunit.OutputJunitConverterTests;

/**
 * Tests {@link MethodConverter}
 * 
 * @author dschoenicke
 *
 */
public class MethodConverterTest extends OutputJunitConverterTests {

	/**
	 * Tests {@link MethodConverter#convertMethods}
	 */
	@Test
	public void testConvertMethods() {
		MethodConverter.convertMethods(mockClass1, mockJunitTestClass1);
		JunitMethodUnderTest method = mockJunitTestClass1.getMethods().get(0);
		assertEquals(2, mockJunitTestClass1.getMethods().size());
		assertEquals("method1", method.getMethodName());
		assertEquals("void", method.getReturnType());
		assertEquals("int.class, app.firstpackage.firstclass.class", method.getParameterTypeClasses());
		assertEquals(2, method.getParameters().size());
		assertEquals(7, method.getAssertions().size());
		method = mockJunitTestClass1.getMethods().get(1);
		assertEquals("method2", method.getMethodName());
		assertEquals("secondclass", method.getReturnType());
		assertEquals("", method.getParameterTypeClasses());
		assertEquals(0, method.getParameters().size());
	}
}
