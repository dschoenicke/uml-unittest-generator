package mdxmlconverter.packages;

import mdxml.PackagedElement;
import uml.UmlPackage;

/**
 * Class providing static methods to convert {@link mdxml.PackagedElement}s of a given {@link mdxml.Model} to {@link uml.UmlPackage}s
 * 
 * @author dschoenicke
 *
 */
public class PackageConverter {

	/** 
	 * Static method converting a given {@link mdxml.PackagedElement} with type 'uml:Package' to an {@link uml.UmlPackage}
	 * 
	 * @param packagedElement the {@link mdxml.PackagedElement} to convert
	 * @return the converted {@link uml.UmlPackage}
	 */
	public static UmlPackage convertPackage(PackagedElement packagedElement) {
		UmlPackage umlPackage = new UmlPackage(packagedElement.getName());
		return umlPackage;
	}
}
