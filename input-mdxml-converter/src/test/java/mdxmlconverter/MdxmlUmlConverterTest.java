package mdxmlconverter;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import org.junit.Before;
import org.junit.Test;

import mdxml.Client;
import mdxml.MdxmlRepresentation;
import mdxml.OwnedAttribute;
import mdxml.PackagedElement;
import mdxml.Supplier;
import mdxmlconverter.temporary.TemporaryAttribute;
import mdxmlconverter.temporary.TemporaryModel;
import mdxmlconverter.temporary.TemporaryRelationship;
import uml.UmlClass;
import uml.UmlModel;
import uml.UmlMultiplicityValue;
import uml.UmlPackage;
import uml.UmlParameter;
import uml.UmlParameterDirection;
import uml.UmlRelationshipType;
import uml.UmlTemplateParameter;

/**
 * Tests the {@link MdxmlUmlConverter}
 * 
 * @author dschoenicke
 *
 */
public class MdxmlUmlConverterTest {
	
	/**
	 * Mocks the {@link mdxmlconverter.temporary.TemporaryModel} to test {@link MdxmlUmlConverter#resolveDataTypeReferences}.
	 */
	private TemporaryModel mockTmpModel;
	
	/**
	 * The {@link MdxmlUmlConverter} to be used.
	 */
	private MdxmlUmlConverter converter;
	
	/**
	 * Mocks a {@link mdxml.PackagedElement} representing a package to be used to test {@link MdxmlUmlConverter#convertPackagedElement}.
	 */
	private PackagedElement mockPackagedPackage;
	
	/**
	 * Mocks a {@link mdxml.PackagedElement} representing a sub package to be used to test {@link MdxmlUmlConverter#convertPackagedElement}.
	 */
	private PackagedElement mockPackagedSubPackage;
	
	/**
	 * Mocks a {@link mdxml.PackagedElement} representing a class to be used to test {@link MdxmlUmlConverter#convertPackagedElement}.
	 */
	private PackagedElement mockPackagedElement;
	
	/**
	 * Mocks a {@link mdxml.PackagedElement} representing a dependency to be used to test {@link MdxmlUmlConverter#convertPackagedElement}.
	 */
	private PackagedElement mockPackagedDependency;
	
	/**
	 * Mocks an {@link uml.UmlModel} to be used to test {@link MdxmlUmlConverter#convertPackagedElement}.
	 */
	private UmlModel mockUmlModel;
	
	/**
	 * Mocks an {@link mdxml.OwnedAttribute} to be used in the tests
	 */
	private OwnedAttribute mockOwnedAttribute;
	
	/**
	 * Initializes the mock elements.
	 */
	@Before
	public void init() {
		converter = new MdxmlUmlConverter();
		mockTmpModel = new TemporaryModel();
		mockUmlModel = new UmlModel("");
		
		mockTmpModel.addElement("123", new UmlClass("TestElement", null, false, false, false));
		mockTmpModel.addRelationship(new TemporaryRelationship());
		mockOwnedAttribute = new OwnedAttribute();
		mockOwnedAttribute.setName("");
		mockOwnedAttribute.setVisibility("package");
		mockOwnedAttribute.setAssociationType("123");
		mockTmpModel.addAttribute("789", new TemporaryAttribute(mockOwnedAttribute));
		mockTmpModel.addParameter(new UmlParameter("", "123", UmlParameterDirection.IN, false, UmlMultiplicityValue.ONE, UmlMultiplicityValue.ONE));
		mockTmpModel.addTemplateParameter("456", new UmlTemplateParameter("321", "123"));
		
		ArrayList<PackagedElement> packagedElements = new ArrayList<>();
	
		mockPackagedPackage = new PackagedElement();
		mockPackagedPackage.setName("package");
		mockPackagedPackage.setId("1");
		mockPackagedPackage.setType("uml:Package");
		
		mockPackagedSubPackage = new PackagedElement();
		mockPackagedSubPackage.setName("subPackage");
		mockPackagedSubPackage.setId("1.1");
		mockPackagedSubPackage.setType("uml:Package");
		packagedElements.add(mockPackagedSubPackage);
		
		mockPackagedElement = new PackagedElement();
		mockPackagedElement.setName("element");
		mockPackagedElement.setId("2");
		mockPackagedElement.setType("uml:Class");
		packagedElements.add(mockPackagedElement);
		
		mockPackagedDependency = new PackagedElement();
		mockPackagedDependency.setId("3");
		mockPackagedDependency.setType("uml:Usage");
		mockPackagedDependency.setClient(new Client());
		mockPackagedDependency.setSupplier(new Supplier());
		mockPackagedDependency.getClient().setIdref("2");
		mockPackagedDependency.getSupplier().setIdref("2");
		packagedElements.add(mockPackagedDependency);
		
		mockPackagedPackage.setPackagedElements(packagedElements);
	}
	
	/**
	 * Tests whether {@link MdxmlUmlConverter#convertToUmlRepresentation} assigns the correct name to the converted {@link uml.UmlModel}.
	 * @throws JAXBException thrown if the given test Magic Draw Project is invalid.
	 */
	@Test
	public void testConvertToUmlRepresentation() throws JAXBException {
		MdxmlRepresentation mdxml = new MdxmlRepresentation(getClass().getClassLoader().getResource("test_model.xml").getFile());
		mockUmlModel = converter.convertToUmlRepresentation(getClass().getClassLoader().getResource("test_model.xml").getFile());
		assertEquals(mdxml.getXmi().getModel().getName(), mockUmlModel.getName());
	}
	
	/**
	 * Tests {@link MdxmlUmlConverter#convertPackagedElement} with an {@link uml.UmlPackage} as parent.
	 */
	@Test
	public void testConvertPackagedElement() {
		MdxmlUmlConverter.convertPackagedElement(mockPackagedPackage, mockTmpModel, mockUmlModel);
		UmlPackage umlPackage = mockUmlModel.getPackages().get(0);
		assertEquals(umlPackage.getPackages().get(0).getName(), mockPackagedSubPackage.getName());
		assertEquals(umlPackage.getName(), mockPackagedPackage.getName());
		assertEquals(umlPackage.getElements().get(0).getName(), mockPackagedElement.getName());
		assertEquals(UmlRelationshipType.DEPENDENCY, umlPackage.getRelationships().get(0).getType());
	}
	
	/**
	 * Tests {@link MdxmlUmlConverter#convertPackagedElement} with an {@link uml.UmlModel} as parent and a {@link mdxml.PackagedElement} representing a class.
	 */
	@Test
	public void testConvertTopLevelPackagedClass() {
		MdxmlUmlConverter.convertPackagedElement(mockPackagedElement, mockTmpModel, mockUmlModel);
		assertEquals(mockUmlModel.getElements().get(0).getName(), mockPackagedElement.getName());
	}
	
	/**
	 * Tests {@link MdxmlUmlConverter#convertPackagedElement} with an {@link uml.UmlModel} as parent and a {@link mdxml.PackagedElement} representing a dependency.
	 */
	@Test
	public void testConvertTopLevelPackagedDependency() {
		MdxmlUmlConverter.convertPackagedElement(mockPackagedDependency, mockTmpModel, mockUmlModel);
		assertEquals(UmlRelationshipType.DEPENDENCY, mockUmlModel.getRelationships().get(0).getType());
	}
	
	/**
	 * Tests {@link MdxmlUmlConverter#resolveDataTypeReferences}.
	 */
	@Test
	public void testResolveDataTypeReferences() {
		converter.resolveDataTypeReferences(mockTmpModel);
		assertEquals("TestElement", mockTmpModel.getAttributeIDs().get("789").getType());
		assertEquals("TestElement", mockTmpModel.getParameters().get(0).getType());
		assertEquals("TestElement", mockTmpModel.getTemplateParameterIDs().get("456").getType());
	}
}
