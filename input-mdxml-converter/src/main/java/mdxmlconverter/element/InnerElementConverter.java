package mdxmlconverter.element;

import core.representation.Node;
import mdxml.PackagedElement;
import mdxmlconverter.temporary.TemporaryModel;
import uml.UmlElement;

public class InnerElementConverter {

	public static void convertInnerElements(PackagedElement packagedElement, UmlElement element, TemporaryModel tmpModel, Node parent) {
		for (PackagedElement innerElement : packagedElement.getNestedClassifiers()) {
			element.addInnerElement(ElementConverter.convertElement(innerElement, tmpModel, parent));
		}
	}
	
}
