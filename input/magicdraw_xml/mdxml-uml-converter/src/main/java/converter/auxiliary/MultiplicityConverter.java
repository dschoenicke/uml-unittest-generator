package converter.auxiliary;

import model.LowerValue;
import model.UmlMultiplicityValue;
import model.UpperValue;

public class MultiplicityConverter {

	public static UmlMultiplicityValue convertLowerValue(LowerValue lowerValue) {
		if (lowerValue != null) {
			return convertMultiplicityValue(lowerValue.getValue(), lowerValue.getType());
		}
		
		return UmlMultiplicityValue.ONE;
	}
	
	public static UmlMultiplicityValue convertUpperValue(UpperValue upperValue) {
		if (upperValue != null) {
			return convertMultiplicityValue(upperValue.getValue(), upperValue.getType());
		}
		
		return UmlMultiplicityValue.ONE;
	}
	
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
