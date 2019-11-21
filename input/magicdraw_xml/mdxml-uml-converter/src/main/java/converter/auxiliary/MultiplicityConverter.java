package converter.auxiliary;

import model.LowerValue;
import model.UmlMultiplicityValue;
import model.UpperValue;

/**
 * Class providing static methods to convert {@link model.LowerValue}s and {@link model.UpperValue} to an {@link model.UmlMultiplicityValue}
 * 
 * @author dschoenicke
 *
 */
public class MultiplicityConverter {

	/**
	 * Converts a {@link model.LowerValue} to the corresponding {@link model.UmlMultiplicityValue}, returns {@link model.UmlMultiplicityValue#ONE} if the {@link model.LowerValue} is {@literal null}
	 * 
	 * @param lowerValue the {@link model.LowerValue} to be converted, can be {@literal null}
	 * @return the converted {@link model.UmlMultiplicityValue}
	 */
	public static UmlMultiplicityValue convertLowerValue(LowerValue lowerValue) {
		if (lowerValue != null) {
			return convertMultiplicityValue(lowerValue.getValue(), lowerValue.getType());
		}
		
		return UmlMultiplicityValue.ONE;
	}
	
	/**
	 * Converts a {@link model.UpperValue} to the corresponding {@link model.UmlMultiplicityValue}, returns {@link model.UmlMultiplicityValue#ONE} if the {@link model.UpperValue} is {@literal null}
	 * 
	 * @param upperValue the {@link model.UpperValue} to be converted, can be {@literal null}
	 * @return the converted {@link model.UmlMultiplicityValue}
	 */
	public static UmlMultiplicityValue convertUpperValue(UpperValue upperValue) {
		if (upperValue != null) {
			return convertMultiplicityValue(upperValue.getValue(), upperValue.getType());
		}
		
		return UmlMultiplicityValue.ONE;
	}
	
	/**
	 * Converts an {@link model.UmlMultiplicityValue} out of a given value<br>
	 * <b>Note:</b> If the given value is a {@link model.LowerValue} and is equal to the {@link model.UpperValue}, the value is determined by the type of the value
	 * 
	 * @param value the value as a String, can be '0', '1', '*' or {@literal null}
	 * @param type the type of the value, can be 'uml:LiteralInteger' or 'uml:LiteralUnlimitedNatural'
	 * @return the converted {@link model.UmlMultiplicityValue}
	 */
	private static UmlMultiplicityValue convertMultiplicityValue(String value, String type) {
		if (value != null) {
			switch(value) {
				case "0": return UmlMultiplicityValue.ZERO;
				case "*": return UmlMultiplicityValue.INFINITE;
			}
		}
		else {
			if (type.equals("uml:LiteralInteger")) {
				return UmlMultiplicityValue.ZERO;
			}
			else if (type.equals("uml:LiteralUnlimitedNatural")) {
				return UmlMultiplicityValue.INFINITE;
			}
		}
		
		return UmlMultiplicityValue.ONE;
	}
}
