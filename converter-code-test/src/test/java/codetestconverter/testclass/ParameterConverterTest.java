package codetestconverter.testclass;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import code.CodeMethod;
import code.CodeParameter;
import code.CodeVisibility;

/**
 * Tests the {@link ParameterConverter}.
 * 
 * @author dschoenicke
 *
 */
public class ParameterConverterTest {

	/**
	 * Mocks a {@link code.CodeMethod} to be used in the tests.
	 */
	CodeMethod mockCodeMethod;
	
	/**
	 * Initializes the mock elements.
	 */
	@Before
	public void init() {
		mockCodeMethod = new CodeMethod("testMethod", null, null, false, CodeVisibility.PRIVATE, false, false, false);
		mockCodeMethod.addParameter(new CodeParameter("param1", null, "String", false, false, false));
		mockCodeMethod.addParameter(new CodeParameter("param2", null, "Float", false, true, false));
		mockCodeMethod.addParameter(new CodeParameter("param3", null, "Integer", false, false, false));
	}
	
	/**
	 * Tests {@link ParameterConverter#createParameterList}.
	 */
	@Test
	public void testParameterListConverter() {
		assertEquals(ParameterConverter.createParameterList(mockCodeMethod.getParameters()), "String, Float[], Integer");
	}
	
	/**
	 * Tests {@link ParameterConverter#createParameterTypeList}.
	 */
	@Test
	public void testParameterTypeListConverter() {
		assertEquals(ParameterConverter.createParameterTypeList(mockCodeMethod.getParameters()), "String.class, Float.class[], Integer.class");
	}
	
	/**
	 * Tests {@link ParameterConverter#createParameterTypeList} with a {@link code.CodeMethod}.
	 */
	@Test
	public void testMethodParameterTypeListConverter() {
		assertEquals(ParameterConverter.createParameterTypeList(mockCodeMethod), "testMethod, String.class, Float.class[], Integer.class");
	}
}
