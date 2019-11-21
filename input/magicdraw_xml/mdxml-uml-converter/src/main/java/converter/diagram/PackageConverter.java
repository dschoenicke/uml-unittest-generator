package converter.diagram;

import converter.temporary.TemporaryModel;
import model.Model;
import model.PackagedElement;
import model.UmlPackage;

public class PackageConverter {

	public static void convertPackages(Model xmlModel, TemporaryModel tmpModel) {
		for (PackagedElement packagedElement : xmlModel.getPackagedElements()) {
			if (packagedElement.getType().equals("uml:Package")) {
				UmlPackage umlPackage = convertPackage(packagedElement, tmpModel);
				tmpModel.addPackage(packagedElement.getId(), umlPackage);
			}
		}
		
		tmpModel.getPackageIDs().forEach((packageID, umlPackage) -> {
			fillUmlPackage(packageID, umlPackage, xmlModel, tmpModel);
		}); 
	}
	
	private static UmlPackage convertPackage(PackagedElement packagedElement, TemporaryModel tmpModel) {
		UmlPackage umlPackage = new UmlPackage(packagedElement.getName());
		
		for (PackagedElement childElement : packagedElement.getPackagedElements()) {
			if (childElement.getType().equals("uml:Package")) {
				umlPackage.addPackage(convertPackage(childElement, tmpModel));
			}
		}
		
		return umlPackage;
	}
	
	private static void fillUmlPackage(String packageID, UmlPackage umlPackage, Model xmlModel, TemporaryModel tmpModel) {
		for (PackagedElement packagedElement : xmlModel.getPackagedElements()) {
			addConvertedPackagedElementToPackage(packagedElement, packageID, umlPackage, tmpModel);
		}
	}
	
	private static void addConvertedPackagedElementToPackage(PackagedElement packagedElement, String packageID, UmlPackage umlPackage, TemporaryModel tmpModel) {
		if (packagedElement.getId().equals(packageID)) {
			for (PackagedElement childElement : packagedElement.getPackagedElements()) {
				if (tmpModel.getElementIDs().containsKey(childElement.getId())) {
					umlPackage.addUmlElement(tmpModel.getElementIDs().get(childElement.getId()));
				}
				else if (tmpModel.getRelationshipIDs().containsKey(childElement.getId())) {
					umlPackage.addRelationship(tmpModel.getRelationshipIDs().get(childElement.getId()));
				}
				else if (tmpModel.getPackageIDs().containsKey(childElement.getId())) {
					umlPackage.addPackage(tmpModel.getPackageIDs().get(childElement.getId()));
				}
			}
		}
		else {
			for (PackagedElement childElement : packagedElement.getPackagedElements()) {
				addConvertedPackagedElementToPackage(childElement, packageID, umlPackage, tmpModel);
			}
		}
	}
}
