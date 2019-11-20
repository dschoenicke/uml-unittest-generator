package converter.relationship;

import converter.temporary.TemporaryModel;
import model.PackagedElement;
import model.UmlPackage;
import model.UmlRelationship;
import model.UmlRelationshipType;

public class GeneralizationConverter {

	public static void convertGeneralization(PackagedElement packagedElement, TemporaryModel tmpModel) {
		tmpModel.addRelationship(packagedElement.getGeneralization().getId(), createGeneralization(packagedElement, tmpModel));
	}
	
	public static void convertGeneralization(PackagedElement packagedElement, UmlPackage umlPackage, TemporaryModel tmpModel) {
		umlPackage.addRelationship(createGeneralization(packagedElement, tmpModel));
	}
	
	public static void convertInnerGeneralizations(PackagedElement packagedElement, TemporaryModel tmpModel) {
		for (PackagedElement innerElement : packagedElement.getNestedClassifiers()) {
			if (innerElement.getGeneralization() != null) {
				convertGeneralization(innerElement, tmpModel);
			}
		}
	}
	
	public static void convertInnerGeneralizations(PackagedElement packagedElement, UmlPackage umlPackage, TemporaryModel tmpModel) {
		for (PackagedElement innerElement : packagedElement.getNestedClassifiers()) {
			if (innerElement.getGeneralization() != null) {
				convertGeneralization(innerElement, umlPackage, tmpModel);
			}
		}
	}
	
	private static UmlRelationship createGeneralization(PackagedElement packagedElement, TemporaryModel tmpModel) {
		return new UmlRelationship(tmpModel.getElementIDs().get(packagedElement.getId()),
				tmpModel.getElementIDs().get(packagedElement.getGeneralization().getGeneral()),
				UmlRelationshipType.GENERALIZATION
			);
	}
}
