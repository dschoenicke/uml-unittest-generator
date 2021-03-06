package umlcode.converter.relationship;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import code.CodeClass;
import code.CodeElement;
import code.CodeEnumeration;
import code.CodeInterface;
import lombok.experimental.UtilityClass;
import uml.UmlRelationship;
import umlcode.TemporaryModel;

/**
 * Provides a static method adding a {@link code.CodeElement} converted out of the supplier {@link uml.UmlElement} of an {@link uml.UmlRelationship}
 * of type {@link uml.UmlRelationshipType#GENERALIZATION} to the {@link code.CodeElement} converted out of the client {@link uml.UmlElement} of this {@link uml.UmlRelationship}.
 * 
 * @author dschoenicke
 *
 */
@UtilityClass
public class InterfaceRealizationConverter {

	/**
	 * Static method adding a {@link code.CodeElement} converted out of the supplier {@link uml.UmlElement} of an {@link uml.UmlRelationship}
	 * of type {@link uml.UmlRelationshipType#INTERFACEREALIZATION} to the {@link code.CodeElement} converted out of the client {@link uml.UmlElement} of this {@link uml.UmlRelationship}.
	 * 
	 * @param relationship the {@link uml.UmlRelationship} of type {@link uml.UmlRelationshipType#INTERFACEREALIZATION} to be converted
	 * @param tmpModel the {@link umlcode.TemporaryModel} containing the map of {@link uml.UmlElement}s and {@link code.CodeElement}s used to convert the {@link uml.UmlRelationship}
	 */
	public static void convertInterfaceRealization(UmlRelationship relationship, TemporaryModel tmpModel) {
		CodeElement clientElement = tmpModel.getConvertedElements().get(relationship.getClient());
		CodeElement supplierElement = tmpModel.getConvertedElements().get(relationship.getSupplier());
		assertNotNull("The UmlElement " + relationship.getClient().getName() + " has not been converted properly!");
		assertNotNull("The UmlElement " + relationship.getSupplier().getName() + " has not been converted properly!");
	
		if (clientElement instanceof CodeClass) {
			assertTrue("UmlClass " + relationship.getClient().getName() + " cannot implement an UmlElement of another type than UmlInterface!", 
					supplierElement instanceof CodeInterface);
			
			((CodeClass) clientElement).addInterface((CodeInterface) supplierElement);
		}
		else if (clientElement instanceof CodeEnumeration) {
			assertTrue("UmlEnumeration " + relationship.getClient().getName() + " cannot implement an UmlElement of another type than UmlInterface!", 
					supplierElement instanceof CodeInterface);
			
			((CodeEnumeration) clientElement).addInterface((CodeInterface) supplierElement);
		}
		else {
			throw new IllegalStateException(clientElement.getName() + " is an invalid client element for a Generalization!");
		}
	}
}
