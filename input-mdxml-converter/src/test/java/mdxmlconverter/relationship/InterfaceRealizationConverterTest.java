package mdxmlconverter.relationship;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import mdxml.Client;
import mdxml.InterfaceRealization;
import mdxml.PackagedElement;
import mdxmlconverter.temporary.TemporaryModel;
import mdxmlconverter.temporary.TemporaryRelationship;
import uml.UmlModel;
import uml.UmlPackage;
import uml.UmlRelationshipType;

public class InterfaceRealizationConverterTest {

	/**
	 * The {@link mdxml.PackagedElement} containing the {@link mdxml.InterfaceRealization}.
	 */
	private PackagedElement mockPackagedElement;
	
	/**
	 * The {@link mdxml.InterfaceRealization} to be converted.
	 */
	private InterfaceRealization mockInterfaceRealization;
	
	/**
	 * The {@link mdxmlconverter.temporary.TemporaryModel} to be used.
	 */
	private TemporaryModel mockTmpModel;
	
	/**
	 * A {@link mdxml.PackagedElement} acting as a nest host to test {@link mdxmlconverter.relationship.InterfaceRealizationConverter#convertInterfaceRealizations}.
	 */
	private PackagedElement parentElement;
	
	/**
	 * Initializes the needed mock elements
	 */
	@Before
	public void init() {
		ArrayList<PackagedElement> elementList = new ArrayList<>();
		ArrayList<InterfaceRealization> realizations = new ArrayList<>();
		
		mockPackagedElement = new PackagedElement();
		mockPackagedElement.setId("elementID");
		mockInterfaceRealization = new InterfaceRealization();
		mockInterfaceRealization.setContract("contractID");
		mockInterfaceRealization.setClient(new Client());
		mockInterfaceRealization.getClient().setIdref(mockPackagedElement.getId());
		realizations.add(mockInterfaceRealization);
		mockPackagedElement.setInterfaceRealizations(realizations);
		mockTmpModel = new TemporaryModel();
		parentElement = new PackagedElement();
		elementList.add(mockPackagedElement);
		parentElement.setNestedClassifiers(elementList);
	}
	
	/**
	 * Tests {@link InterfaceRealizationConverter#convertInterfaceRealizations} with an {@link uml.UmlModel} as parent.
	 */
	@Test
	public void testInterfaceRealizationConverterWithModel() {
		UmlModel mockModel = new UmlModel("mockModel");
		InterfaceRealizationConverter.convertInterfaceRealizations(mockPackagedElement.getInterfaceRealizations(), mockTmpModel, mockModel);
		TemporaryRelationship tmpRelationship = (TemporaryRelationship) mockModel.getRelationships().get(0);
		assertTrue(mockTmpModel.getRelationships().contains(tmpRelationship));
		assertEquals(tmpRelationship.getClientId(), mockPackagedElement.getId());
		assertEquals(tmpRelationship.getSupplierId(), mockInterfaceRealization.getContract());
		assertEquals(UmlRelationshipType.INTERFACEREALIZATION, tmpRelationship.getType());
	}
	
	/**
	 * Tests {@link InterfaceRealizationConverter#convertInterfaceRealizations} with an {@link uml.UmlPackage} as parent.
	 */
	@Test
	public void testInterfaceRealizationConverterWithPackage() {
		UmlPackage mockPackage = new UmlPackage("mockPackage");
		InterfaceRealizationConverter.convertInterfaceRealizations(mockPackagedElement.getInterfaceRealizations(), mockTmpModel, mockPackage);
		TemporaryRelationship tmpRelationship = (TemporaryRelationship) mockPackage.getRelationships().get(0);
		assertTrue(mockTmpModel.getRelationships().contains(tmpRelationship));
		assertEquals(tmpRelationship.getClientId(), mockPackagedElement.getId());
		assertEquals(tmpRelationship.getSupplierId(), mockInterfaceRealization.getContract());
		assertEquals(UmlRelationshipType.INTERFACEREALIZATION, tmpRelationship.getType());
	}
	
	/**
	 * Tests {@link InterfaceRealizationConverter#convertNestedInterfaceRealizations}
	 */
	@Test
	public void testNestedInterfaceRealizationConverter() {
		UmlPackage mockPackage = new UmlPackage("mockPackage");
		InterfaceRealizationConverter.convertNestedInterfaceRealizations(parentElement, mockTmpModel, mockPackage);
		TemporaryRelationship tmpRelationship = (TemporaryRelationship) mockTmpModel.getRelationships().get(0);
		assertTrue(mockPackage.getRelationships().contains(tmpRelationship));
		assertEquals(tmpRelationship.getClientId(), mockPackagedElement.getId());
		assertEquals(tmpRelationship.getSupplierId(), mockInterfaceRealization.getContract());
		assertEquals(UmlRelationshipType.INTERFACEREALIZATION, tmpRelationship.getType());
	}
}
