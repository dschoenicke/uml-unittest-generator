package converter.relationship;

import converter.temporary.TemporaryModel;
import model.Model;
import model.PackagedElement;
import model.UmlPackage;

public class RelationshipConverter {
	
	public static void convertRelationships(Model xmlModel, TemporaryModel tmpModel) {
		for (PackagedElement packagedElement : xmlModel.getPackagedElements()) {
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
					convertRelationships(packagedElement, tmpModel.getPackageIDs().get(packagedElement.getId()), tmpModel);
					break;
				}
				default: break;
			}
		}
	}
	
	private static void convertRelationships(PackagedElement packagedElement, UmlPackage umlPackage, TemporaryModel tmpModel) {
		for (PackagedElement childElement : packagedElement.getPackagedElements()) {
			switch (childElement.getType()) {
				case "uml:Association": {
					AssociationConverter.convertAssociation(childElement, umlPackage, tmpModel);
					break;
				}
				case "uml:Usage": {
					DependencyConverter.convertDependency(childElement, umlPackage, tmpModel);
					break;
				}
				case "uml:Interface": {
					if (childElement.getGeneralization() != null) {
						GeneralizationConverter.convertGeneralization(childElement, umlPackage, tmpModel);
					}
					
					GeneralizationConverter.convertInnerGeneralizations(childElement, umlPackage, tmpModel);
					InterfaceRealizationConverter.convertInnerInterfaceRealizations(childElement, umlPackage, tmpModel);
					
					break;
				}
				case "uml:Class": {
					if (childElement.getGeneralization() != null) {
						GeneralizationConverter.convertGeneralization(childElement, umlPackage, tmpModel);
					}
					else if (!childElement.getInterfaceRealizations().isEmpty()) {
						InterfaceRealizationConverter.convertInterfaceRealizations(childElement.getInterfaceRealizations(), umlPackage, tmpModel);
					}
					
					GeneralizationConverter.convertInnerGeneralizations(childElement, umlPackage, tmpModel);
					InterfaceRealizationConverter.convertInnerInterfaceRealizations(childElement, umlPackage, tmpModel);
					
					break;
				}
				case "uml:Enumeration": {
					GeneralizationConverter.convertInnerGeneralizations(childElement, umlPackage, tmpModel);
					InterfaceRealizationConverter.convertInnerInterfaceRealizations(childElement, umlPackage, tmpModel);
					break;
				}
				case "uml:Package": {
					convertRelationships(childElement, tmpModel.getPackageIDs().get(childElement.getId()), tmpModel);
					break;
				}
				default: break;
			}
		}
	}
}
