package uml;

import core.representation.Node;

/**
 * Determines the type of an {@link UmlRelationship}
 * 
 * @author dschoenicke
 *
 */
public enum UmlRelationshipType implements Node {
	ASSOCIATION,
	AGGREGATION,
	COMPOSITION,
	DEPENDENCY,
	GENERALIZATION,
	INTERFACEREALIZATION;
}
