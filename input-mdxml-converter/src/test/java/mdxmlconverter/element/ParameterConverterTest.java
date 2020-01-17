package mdxmlconverter.element;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import mdxml.OwnedOperation;
import mdxml.OwnedParameter;
import mdxmlconverter.temporary.TemporaryModel;
import uml.UmlMultiplicityValue;
import uml.UmlOperation;
import uml.UmlParameter;
import uml.UmlParameterDirection;

/**
 * Tests the {@link ParameterConverter}.
 * 
 * @author dschoenicke
 *
 */
public class ParameterConverterTest {

	/**
	 * Mocks a {@link mdxml.OwnedOperation} containing the {@link mdxml.OwnedParameter} to be converted.
	 */
	private OwnedOperation mockOwnedOperation;
	
	/**
	 * Mocks a list of {@link mdxml.OwnedParameter} which should be converted.
	 */
	private ArrayList<OwnedParameter> mockOwnedParameters;

	/**
	 * Mocks an {@link mdxml.OwnedParameter} which should be converted.
	 */
	private OwnedParameter mockOwnedParameter;
	
	/**
	 * Initializes the mock elements.
	 */
	@Before
	public void init() {
		mockOwnedOperation = new OwnedOperation();
		mockOwnedParameters = new ArrayList<>();
		mockOwnedParameter = new OwnedParameter();
		mockOwnedParameter.setDirection("return");
		mockOwnedParameter.setAssociationType("type");
		mockOwnedParameters.add(mockOwnedParameter);
		mockOwnedOperation.setOwnedParameters(mockOwnedParameters);
	}
	
	/**
	 * Tests {@link ParameterConverter#convertParameters} with an input parameter.
	 */
	@Test
	public void testInputParameterConverter() {
		UmlOperation mockOperation = new UmlOperation(null, null);
		TemporaryModel mockTmpModel = new TemporaryModel();
		mockOwnedParameter.setName("param");
		mockOwnedParameter.setDirection(null);
		ParameterConverter.convertParameters(mockOwnedOperation, mockOperation, mockTmpModel);
		UmlParameter umlParameter = mockOperation.getParameters().get(0);
		assertEquals("param", umlParameter.getName());
		assertEquals(UmlParameterDirection.IN, umlParameter.getDirection());
		assertEquals(umlParameter.getType(), mockOwnedParameter.getAssociationType());
		assertEquals(UmlMultiplicityValue.ONE, umlParameter.getLowerValue());
		assertEquals(UmlMultiplicityValue.ONE, umlParameter.getUpperValue());
	}
	
	/**
	 * Tests {@link ParameterConverter#convertParameters} with a return parameter.
	 */
	@Test
	public void testReturnParameterConverter() {
		UmlOperation mockOperation = new UmlOperation(null, null);
		TemporaryModel mockTmpModel = new TemporaryModel();
		ParameterConverter.convertParameters(mockOwnedOperation, mockOperation, mockTmpModel);
		UmlParameter umlParameter = mockOperation.getParameters().get(0);
		assertEquals("", umlParameter.getName());
		assertEquals(UmlParameterDirection.RETURN, umlParameter.getDirection());
		assertEquals(umlParameter.getType(), mockOwnedParameter.getAssociationType());
		assertEquals(UmlMultiplicityValue.ONE, umlParameter.getLowerValue());
		assertEquals(UmlMultiplicityValue.ONE, umlParameter.getUpperValue());
	}
}
