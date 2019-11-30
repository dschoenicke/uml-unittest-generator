package coretest.umlcodeconverter;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import code.CodePackage;
import code.CodeRepresentation;
import uml.UmlModel;
import uml.UmlPackage;

/**
 * Class containing a method testing whether all {@link uml.UmlPackage}s have been converted to {@link code.CodePackage}s
 * and if the converted package structure is correct.
 * 
 * @author dschoenicke
 *
 */
public class UmlCodePackageTests {

	/**
	 * Method testing whether all {@link uml.UmlPackage}s have been converted to {@link code.CodePackage}s
	 * and if the converted package structure is correct.
	 * 
	 * @param umlPackages map of {@link uml.UmlPackage}s and their names as keys
	 * @param codePackages map of {@link code.CodePackage}s and their names as keys
	 * @param umlModel the {@link uml.UmlModel} containing the {@link uml.UmlPackage}s
	 * @param codeRepresentation the {@link code.CodeRepresentation} containing the {@link code.CodePackage}s
	 */
	public static void testPackages(HashMap<String, UmlPackage> umlPackages, 
			HashMap<String, CodePackage> codePackages, 
			UmlModel umlModel, 
			CodeRepresentation codeRepresentation) {
	
		if (!umlModel.getElements().isEmpty()) {
			assertTrue("UmlModel " + umlModel.getName() + " contains elements which have not been grouped into a CodePackage!", 
					codePackages.containsKey(umlModel.getName()));
		}

		umlPackages.forEach((umlPackageName, umlPackage) -> {
			assertTrue("UmlPackage" + umlPackageName + " has not been converted!", codePackages.containsKey(umlPackageName));
		});
		
		codePackages.forEach((codePackageName, codePackage) -> {
			if (codePackage.getParent() instanceof CodeRepresentation && !codePackage.getName().equals(codeRepresentation.getName())) {
		  		assertTrue(codePackage.getName() + " must be a subpackage of another CodePackage!",
		  				umlModel.getPackages().contains(umlPackages.get(codePackage.getName())));	
		  	}
			else if (codePackage.getParent() instanceof CodePackage) {
				UmlPackage umlParentPackage = umlPackages.get(codePackage.getParent().getName());	
				UmlPackage umlPackage = umlPackages.get(codePackage.getName());
				assertTrue("CodePackage " + codePackage.getName() + "is wrongly added as subpackage of " + umlParentPackage.getName() + "!",
						umlParentPackage.getPackages().contains(umlPackage)
					);
		  	}
		});
	}	
}
