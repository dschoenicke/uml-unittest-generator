package mdxmlconverter.relationship;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
		assertEquals(tmpRelationship.getType(), UmlRelationshipType.GENERALIZATION);
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
		assertEquals(tmpRelationship.getType(), UmlRelationshipType.GENERALIZATION);
	}
}
