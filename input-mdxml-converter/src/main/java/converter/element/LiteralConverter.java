package converter.element;

import model.OwnedLiteral;
import model.PackagedElement;
import model.UmlElement;
import model.UmlEnumeration;
import model.UmlLiteral;

public class LiteralConverter {

	public static void convertLiterals(PackagedElement packagedElement, UmlElement element) {
		if (element instanceof UmlEnumeration) {
			UmlEnumeration enumeration = (UmlEnumeration) element;
			
			for (OwnedLiteral ownedLiteral : packagedElement.getOwnedLiterals()) {
				enumeration.addUmlLiteral(new UmlLiteral(ownedLiteral.getName()));
			}
		}
	}
	
}
