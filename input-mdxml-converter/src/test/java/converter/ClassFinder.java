package converter;

import java.util.ArrayList;

import model.UmlDiagram;
import model.UmlElement;
import model.UmlModel;
import model.UmlPackage;

public class ClassFinder {

	public static UmlElement findUmlElementByName(String name, UmlModel model) {
		for (UmlDiagram diagram : model.getDiagrams()) {
			for (UmlPackage umlPackage : diagram.getPackages()) {
				return searchUmlElement(name, umlPackage.getElements());
			}
		}
		
		return null;
	}
	
	private static UmlElement searchUmlElement(String name, ArrayList<UmlElement> elements) {
		UmlElement foundElement = null;
		
		for (UmlElement umlElement : elements) {
			if (umlElement.getName().equals(name)) {
				return umlElement;
			}
			
			foundElement = searchUmlElement(name, umlElement.getInnerElements());
		}
		
		return foundElement;
	}
}
