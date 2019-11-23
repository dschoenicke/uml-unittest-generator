package converter.element;

import uml.UmlParameterDirection;

public class ParameterDirectionConverter {

	public static UmlParameterDirection convertDirection(String direction) {
		UmlParameterDirection parameterDirection;
		
		if (direction == null) {
			return UmlParameterDirection.IN;
		}
		
		switch(direction) {
			case "return": {
				parameterDirection = UmlParameterDirection.RETURN;
				break;
			}
			case "out": {
				parameterDirection = UmlParameterDirection.OUT;
				break;
			}
			case "inout": {
				parameterDirection = UmlParameterDirection.INOUT;
				break;
			}
			default: {
				parameterDirection = UmlParameterDirection.IN;
				break;
			}
		}
		
		return parameterDirection;
	}
}
