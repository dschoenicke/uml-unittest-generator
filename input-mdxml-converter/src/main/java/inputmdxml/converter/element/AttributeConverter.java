package inputmdxml.converter.element;

import static org.junit.Assert.assertNotNull;

import inputmdxml.temporary.TemporaryAttribute;
import inputmdxml.temporary.TemporaryModel;
import lombok.experimental.UtilityClass;
import mdxml.OwnedAttribute;
import mdxml.PackagedElement;
import uml.UmlAttribute;
import uml.UmlElement;

/**
 * Class providing a static method to convert {@link mdxml.OwnedAttribute}s of a {@link mdxml.PackagedElement} to an {@link uml.UmlAttribute} and adds it to the corresponding {@link uml.UmlElement}
 * 
 * @author dschoenicke
 *
 */
@UtilityClass
public class AttributeConverter {
	
	/**
	 * Converts the {@link mdxml.OwnedAttribute}s of a {@link mdxml.PackagedElement} to {@link inputmdxml.temporary.TemporaryAttribute}s
	 * 
	 * @param packagedElement the {@link mdxml.PackagedElement} which {@link mdxml.OwnedAttribute}s should be converted
	 * @param element the {@link uml.UmlElement} to which the converted {@link UmlAttribute}s will be added
	 * @param tmpModel the {@link inputmdxml.temporary.TemporaryModel} to which the converted {@link inputmdxml.temporary.TemporaryAttribute} will be added
	 */
	public static void convertAttributes(PackagedElement packagedElement, UmlElement element, TemporaryModel tmpModel) {
		for (OwnedAttribute ownedAttribute : packagedElement.getOwnedAttributes()) {		
			assertNotNull("The id of OwnedAttribute must not be null!\nOccurance in " + element.getName(), ownedAttribute.getId());
			assertNotNull("The name of OwnedAttribute with id " + ownedAttribute.getId() + " must not be null!\nOccurance in " + element.getName(), ownedAttribute.getName());
			UmlAttribute attribute = new TemporaryAttribute(ownedAttribute);
			element.addAttribute(attribute);
			tmpModel.addAttribute(ownedAttribute.getId(), attribute);
		}
	}
}
