package mdxmlconverter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import mdxml.PackagedElement;
import uml.UmlModel;
import uml.UmlPackage;

public class UmlPackageTest {
	
	public static void evaluateUmlPackage(PackagedElement packagedElement, UmlModel umlModel) {
		boolean found = false;
		
		for (UmlPackage umlPackage : umlModel.getPackagesAsList()) {
			if (umlPackage.getName().equals(packagedElement.getName())) {
				assertFalse("There exist multiple occurances of UmlPackage " + umlPackage.getName() + "!", found);
				found = true;
			}
		}
		
		assertTrue("The UmlPackage for " + packagedElement.getName() + " hasn't been converted!", found);
	}
}
