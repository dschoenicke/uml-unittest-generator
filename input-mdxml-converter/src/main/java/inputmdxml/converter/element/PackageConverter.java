package inputmdxml.converter.element;

import static org.junit.Assert.assertNotNull;

import inputmdxml.MdxmlUmlConverter;
import inputmdxml.temporary.TemporaryModel;
import lombok.experimental.UtilityClass;
import mdxml.PackagedElement;
import uml.UmlModel;
import uml.UmlPackage;
import uml.UmlParent;

/**
 * Class providing static methods to convert {@link mdxml.PackagedElement}s of a given {@link mdxml.Model} to {@link uml.UmlPackage}s
 * 
 * @author dschoenicke
 *
 */
@UtilityClass
public class PackageConverter {
	
	/** 
	 * Static method converting a given {@link mdxml.PackagedElement} with type 'uml:Package' to an {@link uml.UmlPackage}
	 * 
	 * @param packagedElement the {@link mdxml.PackagedElement} to convert
	 * @param parent {@link uml.UmlParent} element of the {@link mdxml.PackagedElement} to be converted
	 * @param tmpModel {@link inputmdxml.temporary.TemporaryModel} to be passed to {@link inputmdxml.MdxmlUmlConverter#convertPackagedElement}
	 * @return the converted {@link uml.UmlPackage}
	 * @throws IllegalArgumentException if the given {@link uml.UmlParent} is not of type {@link uml.UmlModel} or {@link uml.UmlPackage}
	 */
	public static UmlPackage convertPackage(PackagedElement packagedElement, UmlParent parent, TemporaryModel tmpModel) {
		assertNotNull(packagedElement.getName(), "The name of a PackagedElement must not be null!\nOccurance in PackagedElement with id " + packagedElement.getName());
		UmlPackage umlPackage = new UmlPackage(packagedElement.getName());
		
		for (PackagedElement childElement : packagedElement.getPackagedElements()) {
			MdxmlUmlConverter.convertPackagedElement(childElement, tmpModel, umlPackage);
		}
		
		if (parent instanceof UmlModel) {
			((UmlModel) parent).addPackage(umlPackage);
		}
		else {
			((UmlPackage) parent).addPackage(umlPackage);
		}
		
		return umlPackage;
	}
}
