package converter.relationship;

import converter.temporary.TemporaryModel;
import converter.temporary.TemporaryRelationship;
import core.representation.Node;
import mdxml.PackagedElement;
import uml.UmlModel;
import uml.UmlPackage;
import uml.UmlRelationshipType;

public class GeneralizationConverter {

	public static void convertGeneralization(PackagedElement packagedElement, TemporaryModel tmpModel, Node parent) {
		TemporaryRelationship tmpRelationship = createGeneralization(packagedElement);
		tmpModel.addRelationship(tmpRelationship);
	
		if (parent instanceof UmlModel) {
			((UmlModel) parent).addRelationship(tmpRelationship);
		}
		else if (parent instanceof UmlPackage) {
			((UmlPackage) parent).addRelationship(tmpRelationship);
		}
	}
	
	public static void convertInnerGeneralizations(PackagedElement packagedElement, TemporaryModel tmpModel, Node parent) {
		for (PackagedElement innerElement : packagedElement.getNestedClassifiers()) {
			if (innerElement.getGeneralization() != null) {
				convertGeneralization(innerElement, tmpModel, parent);
			}
		}
	}
	
	private static TemporaryRelationship createGeneralization(PackagedElement packagedElement) {
		return new TemporaryRelationship(packagedElement.getId(),
				packagedElement.getGeneralization().getGeneral(),
				UmlRelationshipType.GENERALIZATION
			);
	}
}
