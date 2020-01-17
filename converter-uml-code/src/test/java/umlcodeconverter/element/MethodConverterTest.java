package umlcodeconverter.element;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import code.CodeMethod;
import uml.UmlMultiplicityValue;

/**
 * Tests the {@link MethodConverter}.
 * 
 * @author dschoenicke
 *
 */
public class MethodConverterTest extends TestInitializer {

	/**
	 * Tests {@link MethodConverter#getOperationReturnParameter}.
	 */
	@Test
	public void testGetOperationReturnParameter() {
		assertEquals(MethodConverter.getOperationReturnParameter(mockUmlOperation), mockUmlReturnParameter);
	}
	
	/**
	 * Tests {@link MethodConverter#convertMethods}.
	 */
	@Test
	public void testMethodConverter() {
		mockCodeClass.getMethods().clear();
		MethodConverter.convertMethods(mockUmlClass, mockCodeClass, mockTmpModel);
		assertEquals(1, mockCodeClass.getMethods().size());
		CodeMethod convertedMethod = mockCodeClass.getMethods().get(0);
		assertEquals(convertedMethod.getName(), mockUmlOperation.getName());
		assertEquals(convertedMethod.getParent(), mockCodeClass);
		assertEquals(1, convertedMethod.getModifiers());
		assertEquals(convertedMethod.getReturnType().getType(), mockUmlReturnParameter.getType());
		assertEquals(mockUmlReturnParameter.getUpperValue() == UmlMultiplicityValue.INFINITE, convertedMethod.isHasMultiplicity());
	}
}
