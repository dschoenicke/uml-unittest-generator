package converter.element;

import converter.temporary.TemporaryModel;
import model.PackagedElement;
import model.UmlElement;

public class InnerElementConverter {

	public static void convertInnerElements(PackagedElement packagedElement, UmlElement element, TemporaryModel tmpModel) {
		for (PackagedElement innerElement : packagedElement.getNestedClassifiers()) {
			element.addInnerElement(ElementConverter.convertElement(innerElement, tmpModel));
		}
	}
	
}
