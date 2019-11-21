package converter;

import java.util.ArrayList;

import model.UmlDiagram;
import model.UmlModel;
import model.UmlPackage;

public class ClassFinder {

	public static UmlPackage findUmlPackageByName(String name, UmlModel model) {
		for (UmlDiagram diagram : model.getDiagrams()) {
			return searchUmlPackage(name, diagram.getPackages());
		}
		
		return null;
	}
	
	private static UmlPackage searchUmlPackage(String name, ArrayList<UmlPackage> packages) {
		UmlPackage foundPackage = null;
		
		for (UmlPackage umlPackage : packages) {
			if (umlPackage.getName().equals(name)) {
				return umlPackage;
			}
			
			foundPackage = searchUmlPackage(name, umlPackage.getPackages());
		}
		
		return foundPackage;
	}
}
