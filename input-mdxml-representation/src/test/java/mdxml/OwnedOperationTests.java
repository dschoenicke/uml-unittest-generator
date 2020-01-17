package mdxml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import javax.xml.bind.JAXBException;

import org.junit.Before;
import org.junit.Test;

import mdxml.OwnedOperation;
import mdxml.OwnedParameter;
import mdxml.PackagedElement;

/**
 * Unit tests validating the correct parsing of {@link mdxml.OwnedOperation}s
 * 
 * @author dschoenicke
 *
 */
public class OwnedOperationTests extends MdxmlRepresentationTests {
	
	/**
	 * A sample {@link mdxml.PackagedElement} which should be checked
	 */
	private PackagedElement element;
	
	/**
	 * A sample {@link mdxml.OwnedOperation} of the {@link mdxml.PackagedElement} which should be checked
	 */
	private OwnedOperation operation;
	
	/**
	 * Initializes the {@link PackagedElement} containing the {@link mdxml.OwnedOperation} which should be tested
	 * 
	 * @throws JAXBException {@link JAXBException} could be thrown if the xml file is invalid
	 */
	@Before
	public void getOperation() throws JAXBException {
		element = initializePackagedElement();
		
		//PackageElement.setOwnedAttributes
		operation = element.getOwnedOperations().get(14);
	}
	
	/**
	 * Checks if the operation is there
	 */
	@Test
	public void ownedOperationFoundTest() {
		assertNotNull(operation);
	}
	
	/**
	 * Checks the attributes of an {@link mdxml.OwnedOperation}
	 */
	@Test
	public void ownedOperationAttributesTest() {
		assertEquals("setOwnedAttributes", operation.getName());
		assertEquals("public", operation.getVisibility());
	}
	
	/**
	 * Checks the parameters of an {@link mdxml.OwnedOperation}
	 */
	@Test
	public void ownedOperationParameterTest() {
		OwnedParameter returnType = operation.getOwnedParameters().get(0);
		OwnedParameter methodParameter = operation.getOwnedParameters().get(1);
		
		assertEquals(2, operation.getOwnedParameters().size());
		assertEquals("return", returnType.getDirection());
		assertTrue(returnType.getDataType().getExtension().getReferenceExtension().getReferentPath().contains("void"));
	
		assertEquals("ownedAttributes", methodParameter.getName());
		assertEquals("_19_0_1_62d0212_1572550603923_570944_4931", methodParameter.getAssociationType());
		assertNull(methodParameter.getLowerValue().getValue());
		assertEquals("*", methodParameter.getUpperValue().getValue());
	}
}
