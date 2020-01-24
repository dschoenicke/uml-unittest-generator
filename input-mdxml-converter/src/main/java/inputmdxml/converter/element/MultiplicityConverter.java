package inputmdxml.converter.element;

import static org.junit.Assert.assertNotNull;

import mdxml.LowerValue;
import mdxml.UpperValue;
import uml.UmlMultiplicityValue;

/**
 * Class providing static methods to convert {@link mdxml.LowerValue}s and {@link mdxml.UpperValue} to an {@link uml.UmlMultiplicityValue}
 * 
 * @author dschoenicke
 *
 */
public class MultiplicityConverter {

	private MultiplicityConverter() {}
	
	/**
	 * Converts a {@link mdxml.LowerValue} to the corresponding {@link uml.UmlMultiplicityValue}, returns {@link uml.UmlMultiplicityValue#ONE} if the {@link mdxml.LowerValue} is {@literal null}
	 * 
	 * @param lowerValue the {@link mdxml.LowerValue} to be converted, can be {@literal null}
	 * @return the converted {@link uml.UmlMultiplicityValue}
	 */
	public static UmlMultiplicityValue convertLowerValue(LowerValue lowerValue) {
		if (lowerValue != null) {
			assertNotNull("The xmi:type of a mdxml.LowerValue must not be null!");
			return convertMultiplicityValue(lowerValue.getValue(), lowerValue.getType());
		}
		
		return UmlMultiplicityValue.ONE;
	}
	
	/**
	 * Converts a {@link mdxml.UpperValue} to the corresponding {@link uml.UmlMultiplicityValue}, returns {@link uml.UmlMultiplicityValue#ONE} if the {@link mdxml.UpperValue} is {@literal null}
	 * 
	 * @param upperValue the {@link mdxml.UpperValue} to be converted, can be {@literal null}
	 * @return the converted {@link uml.UmlMultiplicityValue}
	 */
	public static UmlMultiplicityValue convertUpperValue(UpperValue upperValue) {
		if (upperValue != null) {
			assertNotNull("The xmi:type of a mdxml.UpperValue must not be null!");
			return convertMultiplicityValue(upperValue.getValue(), upperValue.getType());
		}
		
		return UmlMultiplicityValue.ONE;
	}
	
	/**
	 * Converts an {@link uml.UmlMultiplicityValue} out of a given value<br>
	 * <b>Note:</b> If the given value is a {@link mdxml.LowerValue} and is equal to the {@link mdxml.UpperValue}, the value is determined by the type of the value
	 * 
	 * @param value the value as a String, can be '0', '1', '*' or {@literal null}
	 * @param type the type of the value, can be 'uml:LiteralInteger' or 'uml:LiteralUnlimitedNatural'
	 * @return the converted {@link uml.UmlMultiplicityValue}
	 */
	private static UmlMultiplicityValue convertMultiplicityValue(String value, String type) {
		if (value != null) {
			switch(value) {
				case "0": return UmlMultiplicityValue.ZERO;
				case "*": return UmlMultiplicityValue.INFINITE;
				default: break;
			}
		}
		else {
			if (type != null) {
				if (type.equals("uml:LiteralInteger")) {
					return UmlMultiplicityValue.ZERO;
				}
				else {
					return UmlMultiplicityValue.INFINITE;
				}
			}
		}
		
		return UmlMultiplicityValue.ONE;
	}
}
