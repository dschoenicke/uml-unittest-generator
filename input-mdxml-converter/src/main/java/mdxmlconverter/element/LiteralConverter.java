package mdxmlconverter.element;

import mdxml.OwnedLiteral;
import mdxml.PackagedElement;
import uml.UmlElement;
import uml.UmlEnumeration;
import uml.UmlLiteral;

/**
 * Class providing a static method to convert the {@link mdxml.OwnedLiteral}s of an {@link mdxml.PackagedElement} of type 'uml:Enumeration' to {@link uml.UmlLiteral}s
 * 
 * @author dschoenicke
 *
 */
public class LiteralConverter {

	/**
	 * Converts the {@link mdxml.OwnedLiteral}s of the given {@link mdxml.PackagedElement} to {@link uml.UmlLiteral}s and adds them to the owning {@link uml.UmlElement}
	 * 
	 * @param packagedElement the {@link mdxml.PackagedElement} containing the {@link mdxml.OwnedLiteral}s
	 * @param element the {@link uml.UmlElement} representing the enumeration to which the converted {@link uml.UmlLiteral}s should be added
	 */
	public static void convertLiterals(PackagedElement packagedElement, UmlElement element) {
		if (element instanceof UmlEnumeration) {
			UmlEnumeration enumeration = (UmlEnumeration) element;
			
			for (OwnedLiteral ownedLiteral : packagedElement.getOwnedLiterals()) {
				enumeration.addUmlLiteral(new UmlLiteral(ownedLiteral.getName()));
			}
		}
	}
	
}