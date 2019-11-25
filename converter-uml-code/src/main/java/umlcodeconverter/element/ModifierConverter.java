package umlcodeconverter.element;

import code.CodeVisibility;
import uml.UmlVisibility;

/**
 * Class providing a static method to convert a {@link uml.UmlVisibility} to a {@link code.CodeVisibility}
 * 
 * @author dschoenicke
 *
 */
public class ModifierConverter {

	/**
	 * Converts a given {@link uml.UmlVisibility} to a {@link code.CodeVisibility}
	 * 
	 * @param visibility the {@link uml.UmlVisibility} to be converted
	 * @return the converted {@link code.CodeVisibility}
	 */
	public static CodeVisibility convertAccessModifier(UmlVisibility visibility) {
		CodeVisibility codeVisibility = CodeVisibility.DEFAULT;
		
		switch (visibility) {
			case PUBLIC: {
				codeVisibility = CodeVisibility.PUBLIC;
				break;
			}
			case PRIVATE: {
				codeVisibility = CodeVisibility.PRIVATE;
				break;
			}
			case PROTECTED: {
				codeVisibility = CodeVisibility.PROTECTED;
				break;
			}
			default: break;
		}
		
		return codeVisibility;
	}
}
