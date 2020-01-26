package umlcode.converter.element;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.CodeMethod;
import uml.UmlOperation;
import umlcode.UmlCodeConverterTests;

public class MethodConverterTest extends UmlCodeConverterTests {

	@Test
	public void testGetOperationReturnParameter() {
		assertEquals(MethodConverter.getOperationReturnParameter(umlGenericClass.getOperations().get(1)), umlGenericClass.getOperations().get(1).getParameters().get(0));
	}
	
	@Test
	public void testMethodConverter() {
		codeGenericClass.getMethods().clear();
		MethodConverter.convertMethods(umlGenericClass, codeGenericClass, mockTmpModel);
		assertEquals(2, codeGenericClass.getMethods().size());
		UmlOperation mockUmlOperation = umlGenericClass.getOperations().get(1);
		CodeMethod convertedMethod = codeGenericClass.getMethods().get(0);
		assertEquals(mockUmlOperation.getName(), convertedMethod.getName());
		assertEquals(1, convertedMethod.getModifiers());
		assertEquals(umlSubPackageClass.getName(), convertedMethod.getReturnType().getType());
		assertTrue(convertedMethod.isHasMultiplicity());
	}
}
