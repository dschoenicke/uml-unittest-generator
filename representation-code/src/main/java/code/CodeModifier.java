package code;

import java.lang.reflect.Modifier;

/**
 * Class providing a static method to convert the modifiers of a {@link CodeElement}, {@link CodeField}, {@link CodeMethod}
 * or a {@link CodeParameter} to an integer value to use the methods inherited by {@link java.lang.reflect.Modifier}. 
 * 
 * @author dschoenicke
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/constant-values.html#java.lang.reflect.Modifier.ABSTRACT">List of Modifier enumeration constants</a>
 *
 */
public class CodeModifier extends Modifier {
	
	/**
	 * Static method to convert a given {@link CodeVisibility} and boolean values for the non access modifiers of 
	 * a {@link CodeElement}, {@link CodeField}, {@link CodeMethod} or {@link CodeParameter} to an int value.
	 * 
	 * @param visibility determines the {@link CodeVisibility}
	 * @param isStatic determines the static modifier
	 * @param isFinal determines the final modifier
	 * @param isAbstract determines the abstract modifier is set
	 * @return the int value of the modifiers to be used by the methods of the superclass {@link java.lang.reflect.Modifier}
	 */
	public static int convertModifierValue(
			CodeVisibility visibility,
			boolean isStatic,
			boolean isFinal,
			boolean isAbstract) {
		
		return visibility.value +
				boolToInt(isStatic) * STATIC + 
				boolToInt(isFinal) * FINAL + 
				boolToInt(isAbstract) * ABSTRACT;
	}
	
	/**
	 * Returns true if the given set of modifiers contains the default access modifier by
	 * substracting the values of the non access modifiers from the modifier set.
	 * If the modifier set contains the default access modifier, the result of the substractions has to be '0'.
	 * 
	 * @param mod a set of modifiers
	 * @return true if mod includes the default access modifier
	 */
	public static boolean hasDefaultAccess(int mod) {
		return mod - boolToInt(isAbstract(mod)) * ABSTRACT
				- boolToInt(isStatic(mod)) * STATIC
				- boolToInt(isFinal(mod)) * FINAL == 0;
	}
	
	/**
	 * Returns a string containing the modifier names of the given set of modifiers
	 * 
	 * @param mod a set of modifiers
	 * @return the string containing the modifier names
	 */
	public static String toString(int mod) {
		String modifiers = "";
		modifiers = (hasDefaultAccess(mod)) ? "default" : "";
		modifiers += (isPublic(mod)) ? "public" : "";
		modifiers += (isPrivate(mod)) ? "private" : "";
		modifiers += (isProtected(mod)) ? "protected" : "";
		modifiers += (isStatic(mod)) ? " static" : "";
		modifiers += (isFinal(mod)) ? " final" : "";
		modifiers += (isAbstract(mod)) ? " abstract" : "";
		return modifiers;
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
