package mdxmlconverter.relationship;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import mdxml.Generalization;
import mdxml.PackagedElement;
import mdxmlconverter.temporary.TemporaryModel;
import mdxmlconverter.temporary.TemporaryRelationship;
import uml.UmlModel;
import uml.UmlPackage;
import uml.UmlRelationshipType;

/**
 * Tests {@link GeneralizationConverter#convertGeneralization} with an {@link uml.UmlModel} and an {@link uml.UmlPackage} as parent.
 * 
 * @author dschoenicke
 *
 */
public class GeneralizationConverterTest {
	
	/**
	 * The {@link mdxml.PackagedElement} containing the {@link mdxml.Generalization}.
	 */
	private PackagedElement mockPackagedElement;
	
	/**
	 * The {@link mdxml.Generalization} to be converted.
	 */
	private Generalization mockGeneralization;
	
	/**
	 * The {@link mdxmlconverter.temporary.TemporaryModel} to be used.
	 */
	private TemporaryModel mockTmpModel;
	
	/**
	 * A {@link mdxml.PackagedElement} acting as a nest host to test {@link mdxmlconverter.relationship.GeneralizationConverter#convertNestedGeneralizations}.
	 */
	private PackagedElement parentElement;
	
	/**
	 * Initializes the needed mock elements
	 */
	@Before
	public void init() {
		mockPackagedElement = new PackagedElement();
		mockPackagedElement.setId("elementID");
		mockGeneralization = new Generalization();
		mockGeneralization.setGeneral("generalID");
		mockPackagedElement.setGeneralization(mockGeneralization);
		mockTmpModel = new TemporaryModel();
		parentElement = new PackagedElement();
		ArrayList<PackagedElement> elementList = new ArrayList<>();
		elementList.add(mockPackagedElement);
		parentElement.setNestedClassifiers(elementList);
	}
	
	/**
	 * Tests {@link GeneralizationConverter#convertGeneralization} with an {@link uml.UmlModel} as parent.
	 */
	@Test
	public void testGeneralizationConverterWithModel() {
		UmlModel mockModel = new UmlModel("mockModel");
		TemporaryRelationship tmpRelationship = GeneralizationConverter.convertGeneralization(mockPackagedElement, mockTmpModel, mockModel);
		assertTrue(mockTmpModel.getRelationships().contains(tmpRelationship));
		assertTrue(mockModel.getRelationships().contains(tmpRelationship));
		assertEquals(tmpRelationship.getClientId(), mockPackagedElement.getId());
		assertEquals(tmpRelationship.getSupplierId(), mockGeneralization.getGeneral());
		assertEquals(UmlRelationshipType.GENERALIZATION, tmpRelationship.getType());
	}
	
	/**
	 * Tests {@link GeneralizationConverter#convertGeneralization} with an {@link uml.UmlPackage} as parent.
	 */
	@Test
	public void testGeneralizationConverterWithPackage() {
		UmlPackage mockPackage = new UmlPackage("mockPackage");
		TemporaryRelationship tmpRelationship = GeneralizationConverter.convertGeneralization(mockPackagedElement, mockTmpModel, mockPackage);
		assertTrue(mockTmpModel.getRelationships().contains(tmpRelationship));
		assertTrue(mockPackage.getRelationships().contains(tmpRelationship));
		assertEquals(tmpRelationship.getClientId(), mockPackagedElement.getId());
		assertEquals(tmpRelationship.getSupplierId(), mockGeneralization.getGeneral());
		assertEquals(UmlRelationshipType.GENERALIZATION, tmpRelationship.getType());
	}
	
	/**
	 * Tests {@link GeneralizationConverter#convertNestedGeneralizations}
	 */
	@Test
	public void testNestedGeneralizationConverter() {
		UmlPackage mockPackage = new UmlPackage("mockPackage");
		GeneralizationConverter.convertNestedGeneralizations(parentElement, mockTmpModel, mockPackage);
		TemporaryRelationship tmpRelationship = (TemporaryRelationship) mockTmpModel.getRelationships().get(0);
		assertTrue(mockPackage.getRelationships().contains(tmpRelationship));
		assertEquals(tmpRelationship.getClientId(), mockPackagedElement.getId());
		assertEquals(tmpRelationship.getSupplierId(), mockGeneralization.getGeneral());
		assertEquals(UmlRelationshipType.GENERALIZATION, tmpRelationship.getType());
	}
}
