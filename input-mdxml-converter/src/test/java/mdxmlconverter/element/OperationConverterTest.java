package mdxmlconverter.element;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import mdxml.OwnedOperation;
import mdxml.PackagedElement;
import mdxmlconverter.temporary.TemporaryModel;
import uml.UmlClass;
import uml.UmlOperation;
import uml.UmlVisibility;

/**
 * Tests {@link OperationConverter}.
 * 
 * @author dschoenicke
 *
 */
public class OperationConverterTest {

	/**
	 * Mocks a {@link mdxml.PackagedElement} containing the {@link mdxml.OwnedOperation}.
	 */
	private PackagedElement mockPackagedElement;
	
	/**
	 * Mocks a list of {@link mdxml.OwnedOperation}s to be converted.
	 */
	private ArrayList<OwnedOperation> mockOwnedOperations;
	
	/**
	 * Mocks an {@link mdxml.OwnedOperation} to be converted.
	 */
	private OwnedOperation mockOwnedOperation;
	
	/**
	 * Initializes the mock elements.
	 */
	@Before
	public void init() {
		mockPackagedElement = new PackagedElement();
		mockOwnedOperations = new ArrayList<>();
		mockOwnedOperation = new OwnedOperation();
		mockOwnedOperation.setName("Operation");
		mockOwnedOperations.add(mockOwnedOperation);
		mockPackagedElement.setOwnedOperations(mockOwnedOperations);
	}
	
	/**
	 * Tests {@link OperationConverter#convertOperations}.
	 */
	@Test
	public void testOperationConverter() {
		UmlClass mockClass = new UmlClass(null, null);
		TemporaryModel mockTmpModel = new TemporaryModel();
		OperationConverter.convertOperations(mockPackagedElement, mockClass, mockTmpModel);
		UmlOperation umlOperation = mockClass.getOperations().get(0);
		assertEquals(umlOperation.getName(), mockOwnedOperation.getName());
		assertEquals(umlOperation.getVisibility(), UmlVisibility.PUBLIC);
		assertFalse(umlOperation.isAbstract());
		assertFalse(umlOperation.isStatic());
		assertFalse(umlOperation.isFinal());
	}
}
