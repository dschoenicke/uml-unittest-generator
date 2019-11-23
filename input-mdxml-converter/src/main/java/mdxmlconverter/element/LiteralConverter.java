package mdxmlconverter.element;

import mdxml.OwnedLiteral;
import mdxml.PackagedElement;
import uml.UmlElement;
import uml.UmlEnumeration;
import uml.UmlLiteral;

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
