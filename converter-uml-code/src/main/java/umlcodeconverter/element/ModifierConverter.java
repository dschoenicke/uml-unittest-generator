package umlcodeconverter.element;

import java.lang.reflect.Modifier;

import uml.UmlVisibility;

/**
 * Class providing a static method to convert a {@link uml.UmlVisibility} to a {@link code.CodeVisibility}
 * 
 * @author dschoenicke
 *
 */
public class ModifierConverter extends Modifier {

	/**
	 * Static method to convert a given {@link uml.UmlVisibility} and boolean values for the non access modifiers of 
	 * a {@link uml.UmlElement}, {@link uml.UmlAttribute}, {@link uml.UmlOperation} or {@link uml.UmlParameter} to an int value.
	 * 
	 * @param visibility determines the {@link uml.UmlVisibility}
	 * @param isStatic determines the static modifier
	 * @param isFinal determines the final modifier
	 * @param isAbstract determines the abstract modifier is set
	 * @return the int value of the modifiers to be used by the methods of the superclass {@link java.lang.reflect.Modifier}
	 */
	public static int convertModifierValue(
			UmlVisibility visibility,
			boolean isStatic,
			boolean isFinal,
			boolean isAbstract) {
		
		return (visibility == null ? 0 : visibility.value) +
				boolToInt(isStatic) * STATIC + 
				boolToInt(isFinal) * FINAL + 
				boolToInt(isAbstract) * ABSTRACT;
	}
	
	/**
	 * Auxiliary method converting a boolean to an int value
	 * 
	 * @param bool the boolean to be converted
	 * @return 1 if the boolean is true, 0 otherwise
	 */
	private static int boolToInt(boolean bool) {
		return bool ? 1 : 0;
	}
}
