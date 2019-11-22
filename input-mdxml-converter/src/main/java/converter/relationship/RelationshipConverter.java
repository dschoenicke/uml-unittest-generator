package converter.relationship;

import java.util.ArrayList;

import converter.temporary.TemporaryModel;
import model.PackagedElement;

public class RelationshipConverter {
	
	public static void convertRelationships(ArrayList<PackagedElement> packagedElements, TemporaryModel tmpModel) {
		for (PackagedElement packagedElement : packagedElements) {
			switch (packagedElement.getType()) {
				case "uml:Association": {
					AssociationConverter.convertAssociation(packagedElement, tmpModel);
					break;
				}
				case "uml:Usage": {
					DependencyConverter.convertDependency(packagedElement, tmpModel);
					break;
				}
				case "uml:Interface": {
					if (packagedElement.getGeneralization() != null) {
						GeneralizationConverter.convertGeneralization(packagedElement, tmpModel);
					}
					
					GeneralizationConverter.convertInnerGeneralizations(packagedElement, tmpModel);
					InterfaceRealizationConverter.convertInnerInterfaceRealizations(packagedElement, tmpModel);
					
					break;
				}
				case "uml:Class": {
					if (packagedElement.getGeneralization() != null) {
						GeneralizationConverter.convertGeneralization(packagedElement, tmpModel);
					}
					else if (!packagedElement.getInterfaceRealizations().isEmpty()) {
						InterfaceRealizationConverter.convertInterfaceRealizations(packagedElement.getInterfaceRealizations(), tmpModel);
					}
					
					GeneralizationConverter.convertInnerGeneralizations(packagedElement, tmpModel);
					InterfaceRealizationConverter.convertInnerInterfaceRealizations(packagedElement, tmpModel);
					
					break;
				}
				case "uml:Enumeration": {
					GeneralizationConverter.convertInnerGeneralizations(packagedElement, tmpModel);
					InterfaceRealizationConverter.convertInnerInterfaceRealizations(packagedElement, tmpModel);
					break;
				}
				case "uml:Package": {
					convertRelationships(packagedElement.getPackagedElements(), tmpModel);
					break;
				}
				default: break;
			}
		}
	}
}
