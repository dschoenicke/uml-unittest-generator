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
}
