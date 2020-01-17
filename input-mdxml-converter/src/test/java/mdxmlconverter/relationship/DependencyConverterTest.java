package mdxmlconverter.relationship;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import mdxml.Client;
import mdxml.PackagedElement;
import mdxml.Supplier;
import mdxmlconverter.temporary.TemporaryModel;
import mdxmlconverter.temporary.TemporaryRelationship;
import uml.UmlRelationshipType;

/**
 * Tests for the {@link DependencyConverter#convertDependency}
 * 
 * @author dschoenicke
 *
 */
public class DependencyConverterTest {

	/**
	 * The {@link mdxml.PackagedElement} containing the {@link mdxml.Client} and {@link mdxml.Supplier} to be used.
	 */
	private PackagedElement mockPackagedElement;
	
	/**
	 * The {@link mdxml.Client} to be used.
	 */
	private Client mockClient;
	
	/**
	 * The {@link mdxml.Supplier} to be used.
	 */
	private Supplier mockSupplier;
	
	/**
	 * The {@link mdxmlconverter.temporary.TemporaryModel} to be used.
	 */
	private TemporaryModel mockTmpModel;
	
	/**
	 * Initializes the needed mock elements.
	 */
	@Before
	public void init() {
		mockPackagedElement = new PackagedElement();
		mockClient = new Client();
		mockClient.setIdref("refclient");
		mockSupplier = new Supplier();
		mockSupplier.setIdref("refsupplier");
		mockTmpModel = new TemporaryModel();
		mockPackagedElement.setClient(mockClient);
		mockPackagedElement.setSupplier(mockSupplier);
	}
	
	/**
	 * Tests {@link DependencyConverter#convertDependency} with the given mock elements.
	 */
	@Test
	public void testDependencyConversion() {
		TemporaryRelationship tmpRelationship = DependencyConverter.convertDependency(mockPackagedElement, mockTmpModel);
		assertTrue(mockTmpModel.getRelationships().contains(tmpRelationship));
		assertEquals(mockPackagedElement.getClient().getIdref(), tmpRelationship.getClientId());
		assertEquals(mockPackagedElement.getSupplier().getIdref(), tmpRelationship.getSupplierId());
		assertEquals(UmlRelationshipType.DEPENDENCY, tmpRelationship.getType());
	}
}
