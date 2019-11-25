package umlcodeconverter.relationship;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import code.CodeClass;
import code.CodeElement;
import code.CodeInterface;
import uml.UmlRelationship;
import umlcodeconverter.temporary.TemporaryModel;

/**
 * Provides a static method adding a {@link code.CodeElement} converted out of the supplier {@link uml.UmlElement} of an {@link uml.UmlRelationship}
 * of type {@link uml.UmlRelationshipType#GENERALIZATION} to the {@link code.CodeElement} converted out of the client {@link uml.UmlElement} of this {@link uml.UmlRelationship}.
 * 
 * @author dschoenicke
 *
 */
public class GeneralizationConverter {

	/**
	 * Static method adding a {@link code.CodeElement} converted out of the supplier {@link uml.UmlElement} of an {@link uml.UmlRelationship}
	 * of type {@link uml.UmlRelationshipType#GENERALIZATION} to the {@link code.CodeElement} converted out of the client {@link uml.UmlElement} of this {@link uml.UmlRelationship}.
	 * 
	 * @param relationship the {@link uml.UmlRelationship} of type {@link uml.UmlRelationshipType#GENERALIZATION} to be converted
	 * @param tmpModel the {@link umlcodeconverter.temporary.TemporaryModel} containing the map of {@link uml.UmlElement}s and {@link code.CodeElement}s used to convert the {@link uml.UmlRelationship}
	 */
	public static void convertGeneralization(UmlRelationship relationship, TemporaryModel tmpModel) {
		CodeElement clientElement = tmpModel.getConvertedElements().get(relationship.getClient());
		CodeElement supplierElement = tmpModel.getConvertedElements().get(relationship.getSupplier());
		assertNotNull("The UmlElement " + relationship.getClient().getName() + " has not been converted properly!");
		assertNotNull("The UmlElement " + relationship.getSupplier().getName() + " has not been converted properly!");
	
		if (clientElement instanceof CodeClass) {
			assertTrue("UmlClass " + relationship.getClient().getName() + " cannot extend an UmlElement of another type than UmlClass!", 
					supplierElement instanceof CodeClass);
			
			((CodeClass) clientElement).setSuperClass((CodeClass) supplierElement);
		}
		else if (clientElement instanceof CodeInterface) {
			assertTrue("UmlInterface " + relationship.getClient().getName() + " cannot extend an UmlElement of another type than UmlInterface!", 
					supplierElement instanceof CodeInterface);
			
			((CodeInterface) clientElement).addInterface((CodeInterface) supplierElement);
		}
	}
}