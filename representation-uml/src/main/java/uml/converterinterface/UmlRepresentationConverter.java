package uml.converterinterface;

import uml.UmlModel;

/**
 * An interface providing the method which converts an {@link UmlInputRepresentation} into an {@link UmlModel}
 * 
 * @author dschoenicke
 *
 */
public interface UmlRepresentationConverter {

	/**
	 * Takes a representation object of another representation implementing the {@link UmlInputRepresentation} interface
	 * and converts it to an {@link UmlModel}
	 * 
	 * @param inputRepresentation the representation object of the representation to be converted
	 * @return the generated {@link UmlModel}
	 */
	public UmlModel convertToUmlRepresentation(UmlInputRepresentation inputRepresentation);
}
