package uml;

import core.representation.Node;

/**
 * Enumeration to determine the visibility of {@link UmlElement}s, {@link UmlOperation}s and {@link UmlAttribute}s
 * 
 * @author dschoenicke
 *
 */
public enum UmlVisibility implements Node {
	PUBLIC,
	PRIVATE,
	PROTECTED,
	PACKAGE,
	NONE;
}
