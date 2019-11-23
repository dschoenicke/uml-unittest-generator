package converter.element;

import converter.temporary.TemporaryModel;
import core.representation.Node;
import mdxml.PackagedElement;
import uml.UmlElement;

public class InnerElementConverter {

	public static void convertInnerElements(PackagedElement packagedElement, UmlElement element, TemporaryModel tmpModel, Node parent) {
		for (PackagedElement innerElement : packagedElement.getNestedClassifiers()) {
			element.addInnerElement(ElementConverter.convertElement(innerElement, tmpModel, parent));
		}
	}
	
}
