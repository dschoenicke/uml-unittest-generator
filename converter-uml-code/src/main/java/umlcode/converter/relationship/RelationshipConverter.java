package umlcode.converter.relationship;

import java.util.List;

import lombok.experimental.UtilityClass;
import uml.UmlRelationship;
import uml.UmlRelationshipType;
import umlcode.TemporaryModel;

/**
 * Provides a static method delegating the conversion of {@link uml.UmlRelationship}s of type {@link uml.UmlRelationshipType#GENERALIZATION} 
 * to the {@link umlcode.converter.relationship.GeneralizationConverter} and those of type {@link uml.UmlRelationshipType#INTERFACEREALIZATION}
 * to the {@link umlcode.converter.relationship.InterfaceRealizationConverter}
 * 
 * @author dschoenicke
 *
 */
@UtilityClass
public class RelationshipConverter {

	/**
	 * Static method delegating the conversion of {@link uml.UmlRelationship}s of type {@link uml.UmlRelationshipType#GENERALIZATION} 
	 * to the {@link umlcode.converter.relationship.GeneralizationConverter} and those of type {@link uml.UmlRelationshipType#INTERFACEREALIZATION}
	 * to the {@link umlcode.converter.relationship.InterfaceRealizationConverter}
	 * 
	 * @param relationships the list of {@link uml.UmlRelationship}s to be converted
	 * @param tmpModel the {@link umlcode.TemporaryModel} containing the map of {@link uml.UmlElement}s and {@link code.CodeElement}s used to convert the {@link uml.UmlRelationship}s
	 */
	public static void convertRelationships(List<UmlRelationship> relationships, TemporaryModel tmpModel) {
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
