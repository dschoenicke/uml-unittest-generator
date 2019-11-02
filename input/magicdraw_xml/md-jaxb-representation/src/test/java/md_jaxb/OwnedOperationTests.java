package md_jaxb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.xml.bind.JAXBException;

import org.junit.Before;
import org.junit.Test;

import model.OwnedOperation;
import model.OwnedParameter;
import model.PackagedElement;

/**
 * Unit tests validating the correct parsing of {@link model.OwnedOperation}s
 * 
 * @author dschoenicke
 *
 */
public class OwnedOperationTests extends JaxbRepresentationTests {
	
	/**
	 * A sample {@link model.PackagedElement} which should be checked
	 */
	private PackagedElement element;
	
	/**
	 * A sample {@link model.OwnedOperation} of the {@link model.PackagedElement} which should be checked
	 */
	private OwnedOperation operation;
	
	/**
	 * Initializes the {@link PackagedElement} containing the {@link model.OwnedOperation} which should be tested
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
	 * Checks the attributes of an {@link model.OwnedOperation}
	 */
	@Test
	public void ownedOperationAttributesTest() {
		assertEquals(operation.getName(), "setOwnedAttributes");
		assertEquals(operation.getVisibility(), "public");
	}
	
	/**
	 * Checks the parameters of an {@link model.OwnedOperation}
	 */
	@Test
	public void ownedOperationParameterTest() {
		OwnedParameter returnType = operation.getOwnedParameters().get(0);
		OwnedParameter methodParameter = operation.getOwnedParameters().get(1);
		
		assertEquals(operation.getOwnedParameters().size(), 2);
		assertEquals(returnType.getDirection(), "return");
		assertTrue(returnType.getDataType().getExtension().getReferenceExtension().getReferentPath().contains("void"));
	
		assertEquals(methodParameter.getName(), "ownedAttributes");
		assertEquals(methodParameter.getAssociationType(), "_19_0_1_62d0212_1572550603923_570944_4931");
		assertEquals(methodParameter.getLowerValue().getValue(), null);
		assertEquals(methodParameter.getUpperValue().getValue(), "*");
	}
}
