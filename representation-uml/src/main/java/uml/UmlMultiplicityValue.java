package uml;

import core.representation.Node;

/**
 * Defines possible values for multiplicity values in {@link UmlAttribute}s, {@link UmlRelationship}s and {@link UmlParameter}s
 * 
 * @author dschoenicke
 *
 */
public enum UmlMultiplicityValue implements Node {
	ZERO,
	ONE,
	INFINITE;
}
