package inputmdxml.converter.element;

import static org.junit.Assert.assertNotNull;

import inputmdxml.temporary.TemporaryModel;
import mdxml.PackagedElement;
import uml.UmlElement;
import uml.UmlParent;

/**
 * Class providing a method to convert an nested element of a {@link mdxml.PackagedElement} and adds it to the owning {@link uml.UmlElement}
 * 
 * @author dschoenicke
 *
 */
public class NestedElementConverter {

	private NestedElementConverter() {}
	
	/**
	 * Static method converting nested {@link mdxml.PackagedElement}s of a given {@link mdxml.PackagedElement} to an {@link uml.UmlElement} and adds it to its owning {@link uml.UmlElement}
	 * 
	 * @param packagedElement the {@link mdxml.PackagedElement} which nested elements should be converted
	 * @param element the {@link uml.UmlElement} to which the converted elements should be added
	 * @param parent the parent {@link uml.UmlModel} or {@link uml.UmlPackage} of the parent {@link uml.UmlElement}
	 * @param tmpModel the {@link inputmdxml.temporary.TemporaryModel} to which the converted {@link uml.UmlElement}s should be addede converted inner element should be added.
	 */
	public static void convertNestedElements(PackagedElement packagedElement, UmlElement element, UmlParent parent, TemporaryModel tmpModel) {
		for (PackagedElement innerElement : packagedElement.getNestedClassifiers()) {
			assertNotNull("The id of a nestedClassifier must not be null!\nOccurance in " + element.getName(), innerElement.getId());
			assertNotNull("The xmi:type of a nestedClassifier must not be null!\nOccurance in PackagedElement with id " + packagedElement.getId(), innerElement.getType());
			assertNotNull("The name of a nestedClassifier must not be null!\nOccurance in nestedClassifier with id " + packagedElement.getId(), innerElement.getName());
			
			element.addInnerElement(ElementConverter.convertElement(innerElement, tmpModel, parent));
		}
	}
	
}
