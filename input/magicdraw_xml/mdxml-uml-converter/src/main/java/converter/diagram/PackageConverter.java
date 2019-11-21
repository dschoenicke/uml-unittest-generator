package converter.diagram;

import converter.temporary.TemporaryModel;
import model.Model;
import model.PackagedElement;
import model.UmlPackage;

/**
 * Class providing static methods to convert {@link model.PackagedElement}s of a given {@link model.Model} to {@link model.UmlPackage}s
 * 
 * @author dschoenicke
 *
 */
public class PackageConverter {

	/**
	 * Converts all {@link model.PackagedElement}s of the {@link model.Model} of the type 'uml:Package' to {@link UmlPackage}s and adds all the converted {@link model.PackagedElement} to the {@link model.UmlPackage}
	 * 
	 * @param xmlModel the {@link model.Model} containing the {@link PackagedElement}s
	 * @param tmpModel the {@link converter.temporary.TemporaryModel} to which the {@link model.UmlPackage}s are added
	 */
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
	
	/**
	 * Converts a single {@link model.PackagedElement} to an {@link model.UmlPackage} and recursively calls itself for possible packages inside the converted {@link model.UmlPackage}
	 * The id of the {@link model.PackagedElement} is added to a map of the {@link converter.temporary.TemporaryModel} with the resulting {@link model.UmlPackage}
	 * 
	 * @param packagedElement the {@link model.PackagedElement} to be converted
	 * @param tmpModel the {@link converter.temporary.TemporaryModel} where the id and package are added to
	 * @return the converted {@link model.UmlPackage}
	 */
	private static UmlPackage convertPackage(PackagedElement packagedElement, TemporaryModel tmpModel) {
		UmlPackage umlPackage = new UmlPackage(packagedElement.getName());
		
		for (PackagedElement childElement : packagedElement.getPackagedElements()) {
			if (childElement.getType().equals("uml:Package")) {
				umlPackage.addPackage(convertPackage(childElement, tmpModel));
			}
		}
		
		return umlPackage;
	}
	
	/**
	 * Adds all converted {@link model.PackagedElement}s to the {@link model.UmlPackage}, which are contained by the package
	 * 
	 * @param packageID the id of the {@link model.PackagedElement} representing the {@link model.UmlPackage}
	 * @param umlPackage the {@link model.UmlPackage}
	 * @param xmlModel the {@link model.Model} containing all the {@link model.PackagedElement}s to be added
	 * @param tmpModel the {@link converter.temporary.TemporaryModel} containing the references for all relevant elements
	 */
	private static void fillUmlPackage(String packageID, UmlPackage umlPackage, Model xmlModel, TemporaryModel tmpModel) {
		for (PackagedElement packagedElement : xmlModel.getPackagedElements()) {
			addConvertedPackagedElementToPackage(packagedElement, packageID, umlPackage, tmpModel);
		}
	}
	
	/**
	 * Adds a single {@link model.PackagedElement} to an given {@link model.UmlPackage}, calls itself recursively for all child elements
	 * 
	 * @param packagedElement the {@link model.PackagedElement} to be added
	 * @param packageID the id of the {@link model.PackagedElement} representing the {@link model.UmlPackage} to which the element should be added
	 * @param umlPackage the {@link model.UmlPackage} to which the element should be added
	 * @param tmpModel the {@link converter.temporary.TemporaryModel} containing the references for all relevant elements
	 */
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
