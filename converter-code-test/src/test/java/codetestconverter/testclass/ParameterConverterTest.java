package codetestconverter.testclass;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import code.CodeParameter;

/**
 * Tests the {@link ParameterConverter}.
 * 
 * @author dschoenicke
 *
 */
public class ParameterConverterTest {

	/**
	 * Test {@link ParameterConverter#createParameterTypeList}.
	 */
	@Test
	public void testParameterConverter() {
		ArrayList<CodeParameter> parameters = new ArrayList<>();
		CodeParameter param1 = new CodeParameter("param1", null, "String", false, false);
		CodeParameter param2 = new CodeParameter("param2", null, "Float", true, false);
		CodeParameter param3 = new CodeParameter("param3", null, "Integer", false, false);
		parameters.addAll(List.of(param1, param2, param3));
		assertEquals(ParameterConverter.createParameterTypeList(parameters), "String, Float[], Integer");
	}
}
