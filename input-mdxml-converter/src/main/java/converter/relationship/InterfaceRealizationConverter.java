package converter.relationship;

import java.util.ArrayList;

import converter.temporary.TemporaryModel;
import converter.temporary.TemporaryRelationship;
import core.representation.Node;
import mdxml.InterfaceRealization;
import mdxml.PackagedElement;
import uml.UmlModel;
import uml.UmlPackage;
import uml.UmlRelationshipType;

public class InterfaceRealizationConverter {

	public static void convertInterfaceRealizations(ArrayList<InterfaceRealization> realizations, TemporaryModel tmpModel, Node parentNode) {
		for (InterfaceRealization realization : realizations) {
			TemporaryRelationship tmpRelationship = createInterfaceRealization(realization);
			tmpModel.addRelationship(tmpRelationship);
			
			if (parentNode instanceof UmlModel) {
				((UmlModel) parentNode).addRelationship(tmpRelationship);
			}
			else if (parentNode instanceof UmlPackage) {
				((UmlPackage) parentNode).addRelationship(tmpRelationship);
			}
		}
	}
	
	public static void convertInnerInterfaceRealizations(PackagedElement packagedElement, TemporaryModel tmpModel, Node parentNode) {
		for (PackagedElement innerElement : packagedElement.getNestedClassifiers()) {
			if (!innerElement.getInterfaceRealizations().isEmpty()) {
				convertInterfaceRealizations(innerElement.getInterfaceRealizations(), tmpModel, parentNode);
			}
		}
	}
	
	private static TemporaryRelationship createInterfaceRealization(InterfaceRealization realization) {
		return new TemporaryRelationship(realization.getClient().getIdref(),
				realization.getContract(),
				UmlRelationshipType.INTERFACEREALIZATION
			);
	}
	
}
