package converter.relationship;

import converter.temporary.TemporaryModel;
import model.PackagedElement;
import model.UmlRelationship;
import model.UmlRelationshipType;

public class DependencyConverter {

	public static void convertDependency(PackagedElement packagedElement, TemporaryModel tmpModel) {
		UmlRelationship dependency = new UmlRelationship(
				tmpModel.getElementIDs().get(packagedElement.getClient().getIdref()),
				tmpModel.getElementIDs().get(packagedElement.getSupplier().getIdref()),
				UmlRelationshipType.DEPENDENCY
			);
		tmpModel.addRelationship(packagedElement.getId(), dependency);
	}
}
