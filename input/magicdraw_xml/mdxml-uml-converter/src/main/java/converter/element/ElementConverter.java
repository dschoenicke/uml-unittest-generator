package converter.element;

import java.util.ArrayList;

import converter.temporary.TemporaryModel;
import model.PackagedElement;
import model.UmlClass;
import model.UmlElement;
import model.UmlEnumeration;
import model.UmlInterface;

public class ElementConverter {

	public static void convertElements(ArrayList<PackagedElement> packagedElements, TemporaryModel tmpModel) {
		for (PackagedElement packagedElement : packagedElements) {	
			convertElement(packagedElement, tmpModel);
		}
	}
	
	public static UmlElement convertElement(PackagedElement packagedElement, TemporaryModel tmpModel) {
		UmlElement element = null;
		
		switch (packagedElement.getType()) {
			case "uml:Class": {
				element = new UmlClass(packagedElement.getName(), 
						VisibilityConverter.convertVisibility(packagedElement.getVisibility()), 
						ClassifierConverter.convertClassifier(packagedElement.getIsStatic()),
						ClassifierConverter.convertClassifier(packagedElement.getIsFinal()),
						ClassifierConverter.convertClassifier(packagedElement.getIsAbstract())
					);
				break;
			}
			case "uml:Interface": {
				element = new UmlInterface(packagedElement.getName(), 
						VisibilityConverter.convertVisibility(packagedElement.getVisibility()), 
						ClassifierConverter.convertClassifier(packagedElement.getIsAbstract())
					);
				break;
			}
			case "uml:Enumeration": {
				element = new UmlEnumeration(packagedElement.getName(), 
						VisibilityConverter.convertVisibility(packagedElement.getVisibility())
					);
				LiteralConverter.convertLiterals(packagedElement, element);
				break;
			}
			default: break;
		}
		
		if (element != null) {
			AttributeConverter.convertAttributes(packagedElement, element, tmpModel);
			OperationConverter.convertOperations(packagedElement, element, tmpModel);
			TemplateParameterConverter.convertTemplateParameters(packagedElement.getOwnedTemplateSignature(), element, tmpModel);
			TemplateBindingConverter.convertTemplateBindings(packagedElement.getTemplateBindings(), element);
			InnerElementConverter.convertInnerElements(packagedElement, element, tmpModel);
			tmpModel.addElement(packagedElement.getId(), element);
		}
		
		return element;
	}
}
