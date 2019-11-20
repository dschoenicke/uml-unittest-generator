package converter.element;

import model.UmlParameterDirection;

public class ParameterDirectionConverter {

	public static UmlParameterDirection convertDirection(String direction) {
		UmlParameterDirection parameterDirection;
		
		switch(direction) {
			case "return": parameterDirection = UmlParameterDirection.RETURN;
			case "out": parameterDirection = UmlParameterDirection.OUT;
			case "inout": parameterDirection = UmlParameterDirection.INOUT;
			default: parameterDirection = UmlParameterDirection.IN;
		}
		
		return parameterDirection;
	}
}
