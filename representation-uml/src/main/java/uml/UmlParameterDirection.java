package uml;

import core.representation.Node;

/**
 * Defines possible directions for {@link UmlParameter}s
 * 
 * @author dschoenicke
 *
 */
public enum UmlParameterDirection implements Node {
	IN,
	INOUT,
	OUT,
	RETURN;
}
