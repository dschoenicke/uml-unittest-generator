package inputmdxml.converter.element;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import inputmdxml.MdxmlUmlConverterTests;
import inputmdxml.converter.element.ParameterConverter;
import uml.UmlMultiplicityValue;
import uml.UmlOperation;
import uml.UmlParameter;
import uml.UmlParameterDirection;

public class ParameterConverterTest extends MdxmlUmlConverterTests {

	@Test
	public void testParameterConverter() {
		UmlOperation umlOperation = umlGenericClass.getOperations().get(2);
		umlOperation.getParameters().clear();
		ParameterConverter.convertParameters(mdxmlGenericClass.getOwnedOperations().get(2), umlOperation, mockTmpModel);
		assertEquals(2, umlOperation.getParameters().size());
		
		UmlParameter umlParameter = umlOperation.getParameters().get(0);
		assertEquals("", umlParameter.getName());
		assertEquals(UmlParameterDirection.RETURN, umlParameter.getDirection());
		assertEquals("void", umlParameter.getType());
		assertEquals(UmlMultiplicityValue.ONE, umlParameter.getLowerValue());
		assertEquals(UmlMultiplicityValue.ONE, umlParameter.getUpperValue());
		
		umlParameter = umlOperation.getParameters().get(1);
		assertEquals("subPackageClass", umlParameter.getName());
		assertEquals(UmlParameterDirection.IN, umlParameter.getDirection());
		assertEquals(mdxmlSubPackageClass.getId(), umlParameter.getType());
		assertEquals(UmlMultiplicityValue.ONE, umlParameter.getLowerValue());
		assertEquals(UmlMultiplicityValue.ONE, umlParameter.getUpperValue());
	}
}
