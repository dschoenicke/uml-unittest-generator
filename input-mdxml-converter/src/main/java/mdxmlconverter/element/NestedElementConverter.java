package mdxmlconverter.element;

import core.representation.Node;
import mdxml.PackagedElement;
import mdxmlconverter.temporary.TemporaryModel;
import uml.UmlElement;

/**
 * Class providing a method to convert an nested element of a {@link mdxml.PackagedElement} and adds it to the owning {@link uml.UmlElement}
 * 
 * @author dschoenicke
 *
 */
public class NestedElementConverter {

	/**
	 * Static method converting nested {@link mdxml.PackagedElement}s of a given {@link mdxml.PackagedElement} to an {@link uml.UmlElement} and adds it to its owning {@link uml.UmlElement}
	 * 
	 * @param packagedElement the {@link mdxml.PackagedElement} which nested elements should be converted
	 * @param element the {@link uml.UmlElement} to which the converted elements should be added
	 * @param tmpModel the {@link mdxmlconverter.temporary.TemporaryModel} to which the converted {@link uml.UmlElement}s should be added
	 * @param parent the parent {@link core.representation.Node} representing the owning {@link uml.UmlModel} or {@link uml.UmlPackage}
	 */
	public static void convertNestedElements(PackagedElement packagedElement, UmlElement element, TemporaryModel tmpModel, Node parent) {
		for (PackagedElement innerElement : packagedElement.getNestedClassifiers()) {
			element.addInnerElement(ElementConverter.convertElement(innerElement, tmpModel, parent));
		}
	}
	
}
