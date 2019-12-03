package mdxmlconverter.element;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import mdxml.Client;
import mdxml.Generalization;
import mdxml.InterfaceRealization;
import mdxml.PackagedElement;
import mdxmlconverter.temporary.TemporaryModel;
import uml.UmlClass;
import uml.UmlElement;
import uml.UmlEnumeration;
import uml.UmlInterface;
import uml.UmlPackage;
import uml.UmlRelationshipType;

public class ElementConverterTest {

	/**
	 * Mocks a {@link mdxml.PackagedElement} of type class.
	 */
	private PackagedElement mockPackagedClass;
	
	/**
	 * Mocks a {@link mdxml.PackagedElement} of type enumeration.
	 */
	private PackagedElement mockPackagedEnumeration;
	
	/**
	 * Mocks a {@link mdxml.PackagedElement} of type interface.
	 */
	private PackagedElement mockPackagedInterface;
	
	/**
	 * Mocks the {@link mdxmlconverter.temporary.TemporaryModel} to which the converted {@link uml.UmlElement}s should be added.
	 */
	private TemporaryModel mockTmpModel;
	
	/**
	 * Mocks the parent {@link uml.UmlPackage} to which the converted {@link uml.UmlElement}s should be added.
	 */
	private UmlPackage mockPackage;
	
	/**
	 * Initializes the mock elements
	 */
	@Before
	public void init() {
		mockPackagedClass = new PackagedElement();
		mockPackagedClass.setName("class");
		mockPackagedClass.setType("uml:Class");
		mockPackagedClass.setGeneralization(new Generalization());
		mockPackagedClass.getGeneralization().setGeneral("123");
		ArrayList<InterfaceRealization> realizations = new ArrayList<>();
		InterfaceRealization mockInterfaceRealization = new InterfaceRealization();
		mockInterfaceRealization.setContract("");
		mockInterfaceRealization.setClient(new Client());
		mockInterfaceRealization.getClient().setIdref("");
		realizations.add(mockInterfaceRealization);
		mockPackagedClass.setInterfaceRealizations(realizations);
		
		mockPackagedEnumeration = new PackagedElement();
		mockPackagedEnumeration.setName("enumeration");
		mockPackagedEnumeration.setType("uml:Enumeration");
		
		mockPackagedInterface = new PackagedElement();
		mockPackagedInterface.setName("interface");
		mockPackagedInterface.setType("uml:Interface");
		
		mockTmpModel = new TemporaryModel();
		mockPackage = new UmlPackage(null);
	}
	
	/**
	 * Tests {@link ElementConverter#convertElement} with a class.
	 */
	@Test
	public void testElementConverterWithClass() {
		UmlElement umlClass = ElementConverter.convertElement(mockPackagedClass, mockTmpModel, mockPackage);
		assertTrue(umlClass instanceof UmlClass);
		assertEquals(umlClass.getName(), mockPackagedClass.getName());
		assertEquals(mockTmpModel.getRelationships().get(0).getType(), UmlRelationshipType.GENERALIZATION);
		assertEquals(mockTmpModel.getRelationships().get(1).getType(), UmlRelationshipType.INTERFACEREALIZATION);
	}
	
	/**
	 * Tests {@link ElementConverter#convertElement} with an enumeration
	 */
	@Test
	public void testElementConverterWithEnumeration() {
		UmlElement umlEnumeration = ElementConverter.convertElement(mockPackagedEnumeration, mockTmpModel, mockPackage);
		assertTrue(umlEnumeration instanceof UmlEnumeration);
		assertEquals(umlEnumeration.getName(), mockPackagedEnumeration.getName());
	}
	
	/**
	 * Tests {@link ElementConverter#convertElement} with an interface.
	 */
	@Test
	public void testElementConverterWithInterface() {
		UmlElement umlInterface = ElementConverter.convertElement(mockPackagedInterface, mockTmpModel, mockPackage);
		assertTrue(umlInterface instanceof UmlInterface);
		assertEquals(umlInterface.getName(), mockPackagedInterface.getName());
	}
}
