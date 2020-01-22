package mdxmlconverter.packages;

import static org.junit.Assert.assertNotNull;

import mdxml.PackagedElement;
import mdxmlconverter.MdxmlUmlConverter;
import mdxmlconverter.temporary.TemporaryModel;
import uml.UmlModel;
import uml.UmlPackage;
import uml.UmlParent;

/**
 * Class providing static methods to convert {@link mdxml.PackagedElement}s of a given {@link mdxml.Model} to {@link uml.UmlPackage}s
 * 
 * @author dschoenicke
 *
 */
public class PackageConverter {

	private PackageConverter() {}
	
	/** 
	 * Static method converting a given {@link mdxml.PackagedElement} with type 'uml:Package' to an {@link uml.UmlPackage}
	 * 
	 * @param packagedElement the {@link mdxml.PackagedElement} to convert
	 * @param parent {@link uml.UmlParent} element of the {@link mdxml.PackagedElement} to be converted
	 * @param tmpModel {@link mdxmlconverter.temporary.TemporaryModel} to be passed to {@link mdxmlconverter.MdxmlUmlConverter#convertPackagedElement}
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
		else if (parent instanceof UmlPackage) {
			((UmlPackage) parent).addPackage(umlPackage);
		}
		else {
			throw new IllegalArgumentException(parent.getName() + " is an invalid parent element for the package in PackagedElement with id: " + packagedElement.getId() + "!");
		}
		
		return umlPackage;
	}
}
