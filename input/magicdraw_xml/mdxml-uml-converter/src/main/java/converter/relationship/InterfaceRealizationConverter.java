package converter.relationship;

import java.util.ArrayList;

import converter.temporary.TemporaryModel;
import model.InterfaceRealization;
import model.PackagedElement;
import model.UmlPackage;
import model.UmlRelationship;
import model.UmlRelationshipType;

public class InterfaceRealizationConverter {

	public static void convertInterfaceRealizations(ArrayList<InterfaceRealization> realizations, TemporaryModel tmpModel) {
		for (InterfaceRealization realization : realizations) {
			tmpModel.addRelationship(realization.getId(), createInterfaceRealization(realization, tmpModel));
		}
	}
	
	public static void convertInterfaceRealizations(ArrayList<InterfaceRealization> realizations, UmlPackage umlPackage, TemporaryModel tmpModel) {
		for (InterfaceRealization realization : realizations) {
			umlPackage.addRelationship(createInterfaceRealization(realization, tmpModel));
		}
	}
	
	public static void convertInnerInterfaceRealizations(PackagedElement packagedElement, TemporaryModel tmpModel) {
		for (PackagedElement innerElement : packagedElement.getNestedClassifiers()) {
			if (!innerElement.getInterfaceRealizations().isEmpty()) {
				convertInterfaceRealizations(innerElement.getInterfaceRealizations(), tmpModel);
			}
		}
	}
	
	public static void convertInnerInterfaceRealizations(PackagedElement packagedElement, UmlPackage umlPackage, TemporaryModel tmpModel) {
		for (PackagedElement innerElement : packagedElement.getNestedClassifiers()) {
			if (!innerElement.getInterfaceRealizations().isEmpty()) {
				convertInterfaceRealizations(innerElement.getInterfaceRealizations(), umlPackage, tmpModel);
			}
		}
	}
	
	private static UmlRelationship createInterfaceRealization(InterfaceRealization realization, TemporaryModel tmpModel) {
		return new UmlRelationship(tmpModel.getElementIDs().get(realization.getClient().getIdref()),
				tmpModel.getElementIDs().get(realization.getContract()),
				UmlRelationshipType.INTERFACEREALIZATION
			);
	}
	
}
