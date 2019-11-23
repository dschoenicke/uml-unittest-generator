package converter.packages;

import converter.temporary.TemporaryModel;
import mdxml.Model;
import mdxml.PackagedElement;
import uml.UmlModel;
import uml.UmlPackage;

/**
 * Class providing static methods to convert {@link mdxml.PackagedElement}s of a given {@link mdxml.Model} to {@link uml.UmlPackage}s
 * 
 * @author dschoenicke
 *
 */
public class PackageConverter {

	/** 
	 * Static method converting a given {@link mdxml.PackagedElement} with type 'uml:Package' to an {@link uml.UmlPackage} and adds it to the {@link converter.temporary.TemporaryModel}
	 * 
	 * @param packagedElement the {@link mdxml.PackagedElement} to convert
	 * @param tmpModel the {@link converter.temporary.TemporaryModel} to add the converted package to
	 * @return the converted {@link uml.UmlPackage}
	 */
	public static UmlPackage convertPackage(PackagedElement packagedElement, TemporaryModel tmpModel) {
		UmlPackage umlPackage = new UmlPackage(packagedElement.getName());
		tmpModel.addPackage(packagedElement.getId(), umlPackage);
		return umlPackage;
	}
	
	public static void assignnPackagedElementToPackage(PackagedElement packagedElement, UmlModel umlModel, TemporaryModel tmpModel) {
		//TODO: Implement
	}
	
	/**
	 * Converts all {@link mdxml.PackagedElement}s of the {@link mdxml.Model} of the type 'uml:Package' to {@link UmlPackage}s and adds all the converted {@link mdxml.PackagedElement} to the {@link uml.UmlPackage}
	 * 
	 * @param xmlModel the {@link mdxml.Model} containing the {@link PackagedElement}s
	 * @param tmpModel the {@link converter.temporary.TemporaryModel} to which the {@link uml.UmlPackage}s are added
	 */
	public static void convertPackages(Model xmlModel, TemporaryModel tmpModel) {
		for (PackagedElement packagedElement : xmlModel.getPackagedElements()) {
			if (packagedElement.getType().equals("uml:Package")) {
				UmlPackage umlPackage = converttPackage(packagedElement, tmpModel);
				tmpModel.addPackage(packagedElement.getId(), umlPackage);
			}
		}
		
		tmpModel.getPackageIDs().forEach((packageID, umlPackage) -> {
			fillUmlPackage(packageID, umlPackage, xmlModel, tmpModel);
		}); 
	}
	
	/**
	 * Converts a single {@link mdxml.PackagedElement} to an {@link uml.UmlPackage} and recursively calls itself for possible packages inside the converted {@link uml.UmlPackage}
	 * The id of the {@link mdxml.PackagedElement} is added to a map of the {@link converter.temporary.TemporaryModel} with the resulting {@link uml.UmlPackage}
	 * 
	 * @param packagedElement the {@link mdxml.PackagedElement} to be converted
	 * @param tmpModel the {@link converter.temporary.TemporaryModel} where the id and package are added to
	 * @return the converted {@link uml.UmlPackage}
	 */
	private static UmlPackage converttPackage(PackagedElement packagedElement, TemporaryModel tmpModel) {
		UmlPackage umlPackage = new UmlPackage(packagedElement.getName());
		
		for (PackagedElement childElement : packagedElement.getPackagedElements()) {
			if (childElement.getType().equals("uml:Package")) {
				umlPackage.addPackage(converttPackage(childElement, tmpModel));
			}
		}
		
		return umlPackage;
	}
	
	/**
	 * Adds all converted {@link mdxml.PackagedElement}s to the {@link uml.UmlPackage}, which are contained by the package
	 * 
	 * @param packageID the id of the {@link mdxml.PackagedElement} representing the {@link uml.UmlPackage}
	 * @param umlPackage the {@link uml.UmlPackage}
	 * @param xmlModel the {@link mdxml.Model} containing all the {@link mdxml.PackagedElement}s to be added
	 * @param tmpModel the {@link converter.temporary.TemporaryModel} containing the references for all relevant elements
	 */
	private static void fillUmlPackage(String packageID, UmlPackage umlPackage, Model xmlModel, TemporaryModel tmpModel) {
		for (PackagedElement packagedElement : xmlModel.getPackagedElements()) {
			addConvertedPackagedElementToPackage(packagedElement, packageID, umlPackage, tmpModel);
		}
	}
	
	/**
	 * Adds a single {@link mdxml.PackagedElement} to an given {@link uml.UmlPackage}, calls itself recursively for all child elements
	 * 
	 * @param packagedElement the {@link mdxml.PackagedElement} to be added
	 * @param packageID the id of the {@link mdxml.PackagedElement} representing the {@link uml.UmlPackage} to which the element should be added
	 * @param umlPackage the {@link uml.UmlPackage} to which the element should be added
	 * @param tmpModel the {@link converter.temporary.TemporaryModel} containing the references for all relevant elements
	 */
	private static void addConvertedPackagedElementToPackage(PackagedElement packagedElement, String packageID, UmlPackage umlPackage, TemporaryModel tmpModel) {
		/*if (packagedElement.getId().equals(packageID)) {
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
		}*/
	}
}
