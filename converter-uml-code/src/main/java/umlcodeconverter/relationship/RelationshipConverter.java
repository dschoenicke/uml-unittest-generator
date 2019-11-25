package umlcodeconverter.relationship;

import java.util.ArrayList;

import uml.UmlRelationship;
import uml.UmlRelationshipType;
import umlcodeconverter.temporary.TemporaryModel;

/**
 * Provides a static method delegating the conversion of {@link uml.UmlRelationship}s of type {@link uml.UmlRelationshipType#GENERALIZATION} 
 * to the {@link umlcodeconverter.relationship.GeneralizationConverter} and those of type {@link uml.UmlRelationshipType#INTERFACEREALIZATION}
 * to the {@link umlcodeconverter.relationship.InterfaceRealizationConverter}
 * 
 * @author dschoenicke
 *
 */
public class RelationshipConverter {

	/**
	 * Static method delegating the conversion of {@link uml.UmlRelationship}s of type {@link uml.UmlRelationshipType#GENERALIZATION} 
	 * to the {@link umlcodeconverter.relationship.GeneralizationConverter} and those of type {@link uml.UmlRelationshipType#INTERFACEREALIZATION}
	 * to the {@link umlcodeconverter.relationship.InterfaceRealizationConverter}
	 * 
	 * @param relationships the list of {@link uml.UmlRelationship}s to be converted
	 * @param tmpModel the {@link umlcodeconverter.temporary.TemporaryModel} containing the map of {@link uml.UmlElement}s and {@link code.CodeElement}s used to convert the {@link uml.UmlRelationship}s
	 */
	public static void convertRelationships(ArrayList<UmlRelationship> relationships, TemporaryModel tmpModel) {
		for (UmlRelationship relationship : relationships) {
			if (relationship.getType() == UmlRelationshipType.GENERALIZATION) {
				GeneralizationConverter.convertGeneralization(relationship, tmpModel);
			}
			else if (relationship.getType() == UmlRelationshipType.INTERFACEREALIZATION) {
				InterfaceRealizationConverter.convertInterfaceRealization(relationship, tmpModel);
			}
		}
	}
}
