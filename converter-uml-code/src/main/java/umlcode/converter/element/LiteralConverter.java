package umlcode.converter.element;

import code.CodeEnumeration;
import code.CodeLiteral;
import lombok.experimental.UtilityClass;
import uml.UmlEnumeration;
import uml.UmlLiteral;

/**
 * Provides a static method to convert the {@link uml.UmlLiteral}s of an {@link uml.UmlEnumeration} to {@link code.CodeLiteral}s
 * 
 * @author dschoenicke
 *
 */
@UtilityClass
public class LiteralConverter {

	/**
	 * Static method to convert the {@link uml.UmlLiteral}s of a given {@link uml.UmlEnumeration} to {@link code.CodeLiteral}s
	 * 
	 * @param umlEnumeration the {@link uml.UmlEnumeration} which {@link uml.UmlLiteral}s should be converted
	 * @param codeEnumeration the {@link code.CodeEnumeration} to which the converted {@link code.CodeLiteral}s should be added
	 */
	public static void convertLiterals(UmlEnumeration umlEnumeration, CodeEnumeration codeEnumeration) {
		for (UmlLiteral literal : umlEnumeration.getLiterals()) {
			codeEnumeration.addCodeLiteral(new CodeLiteral(literal.getName()));
		}
	}
}
