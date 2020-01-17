package mdxmlconverter.element;

import uml.UmlParameterDirection;

/**
 * Class providing a static method to convert a string with information about the direction of a {@link mdxml.OwnedParameter} to an {@link uml.UmlParameterDirection}
 * 
 * @author dschoenicke
 *
 */
public class ParameterDirectionConverter {

	private ParameterDirectionConverter() {
		throw new IllegalStateException("utility class");
	}
	
	/**
	 * Static method converting a given string describing the direction of an {@link mdxml.OwnedParameter} to an {@link uml.UmlParameterDirection}
	 * 
	 * @param direction the string containing the information about the direction
	 * @return the converted {@link uml.UmlParameterDirection}
	 */
	public static UmlParameterDirection convertDirection(String direction) {
		if (direction == null) {
			return UmlParameterDirection.IN;
		}
		
		switch(direction) {
			case "return": return UmlParameterDirection.RETURN;
			case "out": return UmlParameterDirection.OUT;
			case "inout": return UmlParameterDirection.INOUT;
			default: return UmlParameterDirection.IN;
		}
	}
}
