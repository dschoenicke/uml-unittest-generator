package inputmdxml.converter.element;

import lombok.experimental.UtilityClass;
import uml.UmlVisibility;

/**
 * Class providing static methods to convert modifier information
 * 
 * @author dschoenicke
 *
 */
@UtilityClass
public class ModifierConverter {
	
	/**
	 * Static method converting the a given access modifier to an {@link uml.UmlVisibility}
	 * 
	 * @param visibility the String representing the modifier
	 * @return the converted {@link uml.UmlVisibility}
	 */
	public static UmlVisibility convertAccessModifier(String visibility) {
		if (visibility == null) {
			return UmlVisibility.PUBLIC;
		}
		
		switch(visibility) {
			case "private": return UmlVisibility.PRIVATE;
			case "protected": return UmlVisibility.PROTECTED;
			case "package": return UmlVisibility.PACKAGE;
			default: return UmlVisibility.PUBLIC;
		}
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
