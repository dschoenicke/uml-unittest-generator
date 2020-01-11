package umlcodeconverter.relationship;

import org.junit.Before;

import code.CodeClass;
import code.CodeEnumeration;
import code.CodeInterface;
import code.CodeVisibility;
import uml.UmlClass;
import uml.UmlEnumeration;
import uml.UmlInterface;
import uml.UmlRelationship;
import uml.UmlRelationshipType;
import umlcodeconverter.temporary.TemporaryModel;

/**
 * Provides mock elements and an initialization method to be used by {@link GeneralizationConverterTest} and {@link InterfaceRealizationTest}.
 * 
 * @author dschoenicke
 *
 */
public class RelationshipTests {

	/**
	 * Mocks the {@link umlcodeconverter.temporary.TemporaryModel} containing the map of {@link uml.UmlElement}s and {@link code.CodeElement}s.
	 */
	TemporaryModel mockTmpModel;
	
	/**
	 * Mocks a {@link code.CodeClass} to be used.
	 */
	CodeClass mockClass;
	
	/**
	 * Mocks a {@link code.CodeInterface} to be used.
	 */
	CodeInterface mockInterface;
	
	/**
	 * Mocks a {@link code.CodeEnumeration} to be used.
	 */
	CodeEnumeration mockEnumeration;
	
	/**
	 * Mocks an {@link uml.UmlClass} to be used.
	 */
	UmlClass mockUmlClass;
	
	/**
	 * Mocks an {@link uml.UmlInterface} to be used.
	 */
	UmlInterface mockUmlInterface;
	
	/**
	 * Mocks an {@link uml.UmlEnumeration} to be used.
	 */
	UmlEnumeration mockUmlEnumeration;
	
	/**
	 * Mocks an {@link uml.UmlRelationship} of type {@link uml.UmlRelationshipType#GENERALIZATION} with {@link uml.UmlClass}es to be converted.
	 */
	UmlRelationship mockClassGeneralization;
	
	/**
	 * Mocks an {@link uml.UmlRelationship} of type {@link uml.UmlRelationshipType#GENERALIZATION} with {@link uml.UmlInterface}s to be converted.
	 */
	UmlRelationship mockInterfaceGeneralization;
	
	/**
	 * Mocks an {@link uml.UmlRelationship} of type {@link uml.UmlRelationshipType#INTERFACEREALIZATION} to be converted.
	 */
	UmlRelationship mockInterfaceRealization;
	
	/**
	 * Mocks an {@link uml.UmlRelationship} of type {@link uml.UmlRelationshipType#INTERFACEREALIZATION} with an enumeration as client to be converted.
	 */
	UmlRelationship mockEnumInterfaceRealization;
	
	/**
	 * Initializes the mock elements.
	 */
	@Before
	public void init() {
		mockTmpModel = new TemporaryModel();
		mockClass = new CodeClass("mockClass", null, CodeVisibility.PACKAGE, false, false, false);
		mockInterface = new CodeInterface("mockInterface", null, CodeVisibility.PACKAGE, false, false, false);
		mockEnumeration = new CodeEnumeration("mockEnumeration", null, CodeVisibility.PACKAGE, false, false, false);
		mockUmlClass = new UmlClass("mockClass", null, false, false, false);
		mockUmlInterface = new UmlInterface("mockInterface", null);
		mockUmlEnumeration = new UmlEnumeration("mockEnumeration", null);
		mockTmpModel.addConvertedElement(mockUmlClass, mockClass);
		mockTmpModel.addConvertedElement(mockUmlInterface, mockInterface);
		mockTmpModel.addConvertedElement(mockUmlEnumeration, mockEnumeration);
		mockClassGeneralization = new UmlRelationship(mockUmlClass, mockUmlClass, UmlRelationshipType.GENERALIZATION);
		mockInterfaceGeneralization = new UmlRelationship(mockUmlInterface, mockUmlInterface, UmlRelationshipType.GENERALIZATION);
		mockInterfaceRealization = new UmlRelationship(mockUmlClass, mockUmlInterface, UmlRelationshipType.INTERFACEREALIZATION);
		mockEnumInterfaceRealization = new UmlRelationship(mockUmlEnumeration, mockUmlInterface, UmlRelationshipType.INTERFACEREALIZATION);
	}
}
