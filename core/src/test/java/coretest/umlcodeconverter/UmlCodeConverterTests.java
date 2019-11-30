package coretest.umlcodeconverter;

import java.util.HashMap;

import code.CodeElement;
import code.CodePackage;
import code.CodeRepresentation;
import uml.UmlElement;
import uml.UmlModel;
import uml.UmlPackage;

/**
 * Class testing the {@link umlcodeconverter.UmlCodeConverter} by comparing a given {@link uml.UmlModel} with a given {@link code.CodeRepresentation} generated out of it.
 * 
 * @author dschoenicke
 *
 */
public class UmlCodeConverterTests {

	public static void test(HashMap<String, UmlPackage> umlPackages,
			HashMap<String, UmlElement> umlElements,
			HashMap<String, CodePackage> codePackages,
			HashMap<String, CodeElement> codeElements,
			UmlModel umlModel, 
			CodeRepresentation codeRepresentation) {
		
		UmlCodePackageTests.testPackages(umlPackages, codePackages, umlModel, codeRepresentation);
		UmlCodeElementTests.testElements(umlPackages, umlElements, codePackages, codeElements, umlModel, codeRepresentation);
	}
}
