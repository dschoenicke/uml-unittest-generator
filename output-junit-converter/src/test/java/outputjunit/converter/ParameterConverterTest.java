package outputjunit.converter;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import junit.JunitParameterUnderTest;
import outputjunit.OutputJunitConverterTests;

/**
 * Tests {@link ParameterConverter}
 *
 * @author dschoenicke
 *
 */
public class ParameterConverterTest extends OutputJunitConverterTests {

	/**
	 * Test {@link ParameterConverter#createParameters(test.testobjects.MethodUnderTest, junit.JunitTestClass)}
	 */
	@Test
	public void testCreateMethodParameters() {
		ArrayList<JunitParameterUnderTest> parameters = ParameterConverter.createParameters(mockClass1.getMethods().get(0), mockJunitTestClass1);
		assertEquals(2, parameters.size());
		assertEquals("param1", parameters.get(0).getName());
		assertEquals(true, parameters.get(0).getIsFinal());
		assertEquals("true", parameters.get(0).getAssertion().getExpectedValue());
		assertEquals("Modifier.isFinal(parameterUnderTest.getModifiers())", parameters.get(0).getAssertion().getActualValue());
		assertEquals("The parameter param1 of the method method1 with parameters (List, app.firstpackage.firstclass) in app.firstpackage.firstclass must be final!", parameters.get(0).getAssertion().getMessage());
		assertEquals("false", parameters.get(1).getAssertion().getExpectedValue());
		assertEquals("The parameter param2 of the method method1 with parameters (List, app.firstpackage.firstclass) in app.firstpackage.firstclass must not be final!", parameters.get(1).getAssertion().getMessage());
	}
	
	/**
	 * Test {@link ParameterConverter#createParameters(test.testobjects.ConstructorUnderTest, junit.JunitTestClass)}
	 */
	@Test
	public void testCreateConstructorParameters() {
		ArrayList<JunitParameterUnderTest> parameters = ParameterConverter.createParameters(mockClass2.getConstructors().get(1), mockJunitTestClass2);
		assertEquals(2, parameters.size());
		assertEquals("param1", parameters.get(0).getName());
		assertEquals(true, parameters.get(0).getIsFinal());
		assertEquals("true", parameters.get(0).getAssertion().getExpectedValue());
		assertEquals("Modifier.isFinal(parameterUnderTest.getModifiers())", parameters.get(0).getAssertion().getActualValue());
		assertEquals("The parameter param1 of the constructor with parameters (List, app.firstpackage.firstclass) in app.secondpackage.secondclass must be final!", parameters.get(0).getAssertion().getMessage());
		assertEquals("false", parameters.get(1).getAssertion().getExpectedValue());
		assertEquals("The parameter param2 of the constructor with parameters (List, app.firstpackage.firstclass) in app.secondpackage.secondclass must not be final!", parameters.get(1).getAssertion().getMessage());
	
		parameters = ParameterConverter.createParameters(mockInnerClass.getConstructors().get(0), mockJunitInnerTestClass);
		assertEquals(2, parameters.size());
		assertEquals("$enum$name", parameters.get(0).getName());
		assertEquals("String", parameters.get(0).getType());
		assertEquals("$enum$ordinal", parameters.get(1).getName());
		assertEquals("int", parameters.get(1).getType());
	}
	
	/**
	 * Tests {@link ParameterConverter#createParameterTypeClasses}
	 */
	@Test
	public void testCreateParameterTypeClasses() {
		assertEquals("List.class, app.firstpackage.firstclass.class", ParameterConverter.createParameterTypeClasses(mockClass1.getMethods().get(0).getParameters()));
		assertEquals("", ParameterConverter.createParameterTypeClasses(mockClass1.getMethods().get(1).getParameters()));
	}
	
	/**
	 * Tests {@link ParameterConverter#createParameterTypes}
	 */
	@Test
	public void testCreateParameterTypes() {
		assertEquals("List, app.firstpackage.firstclass", ParameterConverter.createParameterTypes(mockClass1.getMethods().get(0).getParameters()));
		assertEquals("", ParameterConverter.createParameterTypes(mockClass1.getMethods().get(1).getParameters()));
	}
}
