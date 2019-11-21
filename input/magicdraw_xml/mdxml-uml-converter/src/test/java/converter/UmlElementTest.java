package converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import model.PackagedElement;
import model.UmlPackage;

public class UmlElementTest extends MdxmlUmlConverterTest {

	@Test
	public void testUmlElements() {
		for (PackagedElement packagedElement : getMdxmlRepresentation().getXmi().getModel().getPackagedElements()) {
			performPackagedElementTest(packagedElement);
		}
	}
	
	private void performPackagedElementTest(PackagedElement packagedElement) {
		switch (packagedElement.getType()) {
			case "uml:Class": {
				testUmlPackage(packagedElement);
				break;
			}
		}
	}
	
	private void testUmlPackage(PackagedElement packagedElement) {
		UmlPackage umlPackage = ClassFinder.findUmlPackageByName(packagedElement.getName(), getUmlModel());
		assertNotNull(umlPackage);
		assertEquals(umlPackage.getName(), packagedElement.getName());
		assertEquals(umlPackage.getElements().size() + umlPackage.getRelationships().size(), packagedElement.getPackagedElements().size());

	}
}
