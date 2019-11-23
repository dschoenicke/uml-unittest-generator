package converter.relationship;

import converter.temporary.TemporaryModel;
import converter.temporary.TemporaryRelationship;
import mdxml.PackagedElement;
import uml.UmlRelationship;
import uml.UmlRelationshipType;

public class DependencyConverter {

	public static UmlRelationship convertDependency(PackagedElement packagedElement, TemporaryModel tmpModel) {
		TemporaryRelationship dependency = new TemporaryRelationship();
		dependency.setClientId(packagedElement.getClient().getIdref());
		dependency.setSupplierId(packagedElement.getSupplier().getIdref());
		dependency.setType(UmlRelationshipType.DEPENDENCY);
		tmpModel.addRelationship(dependency);
		return dependency;
	}
}
