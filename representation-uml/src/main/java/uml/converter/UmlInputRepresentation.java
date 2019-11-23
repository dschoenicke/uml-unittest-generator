package uml.converter;

import core.representation.Node;
import uml.UmlModel;

/**
 * Interface used as a wrapper for the representation objects of a representation which should be converted into 
 * an {@link UmlModel} by the {@link uml.converter.UmlRepresentationConverter#convertToUmlRepresentation(UmlInputRepresentation) convertToUmlRepresentation} method
 * 
 * @author dschoenicke
 *
 */
public interface UmlInputRepresentation extends Node {
	
}
