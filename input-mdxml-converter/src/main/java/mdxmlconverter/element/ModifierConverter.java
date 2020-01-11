package mdxmlconverter.element;

import uml.UmlVisibility;

/**
 * Class providing static methods to convert modifier information
 * 
 * @author dschoenicke
 *
 */
public class ModifierConverter {

	/**
	 * Static method converting the a given access modifier to an {@link uml.UmlVisibility}
	 * 
	 * @param visibility the String representing the modifier
	 * @return the converted {@link uml.UmlVisibility}
	 */
	public static UmlVisibility convertAccessModifier(String visibility) {
		UmlVisibility umlVisibility;
		
		if (visibility == null) {
			return UmlVisibility.PUBLIC;
		}
		
		switch(visibility) {
			case "private": {
				umlVisibility = UmlVisibility.PRIVATE;
				break;
			}
			case "protected": {
				umlVisibility = UmlVisibility.PROTECTED;
				break;
			}
			case "package": {
				umlVisibility = UmlVisibility.PACKAGE;
				break;
			}
			default: {
				umlVisibility = UmlVisibility.PUBLIC;
				break;
			}
		}
		
		return umlVisibility;
	}
	
	/**
	 * Static method converting information about the presence of a non-access modifier to a boolean
	 * 
	 * @param modifier the information about the presence of the modifier, can be 'true' or {@literal null}
	 * @return true, if the modifier is present
	 */
	public static boolean convertNonAccessModifier(String modifier) {
		return (modifier != null && modifier.equals("true"));
	}
}
