
package coretest.auxiliary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Test;

import uml.UmlClass;
import uml.UmlElement;
import uml.UmlModel;
import uml.UmlPackage;
import uml.UmlVisibility;

/**
 * This class provides maps containing all {@link uml.UmlPackage}s and {@link uml.UmlElement}s referenced with their name for
 * easier testing. The methods creating these maps are tested within this class as well.
 * 
 * @author dschoenicke
 *
 */
public class UmlModelMaps {
	
	/**
	 * Fills a map of {@link uml.UmlPackage}s with their names as keys
	 * 
	 * @param umlModel the {@link uml.UmlModel} containing the {@link uml.UmlPackage}s
	 * @return the map of {@link uml.UmlPackage}s and their names as keys
	 */
	public static HashMap<String, UmlPackage> createUmlPackageMap(UmlModel umlModel) {
		HashMap<String, UmlPackage> umlPackages = new HashMap<>();
		
		umlModel.getPackagesAsList().forEach((umlPackage) -> {
			umlPackages.put(umlPackage.getName(), umlPackage);
		});
		
		return umlPackages;
	}
	
	/**
	 * Fills a map of {@link uml.UmlElement}s with their names as keys
	 * 
	 * @param umlModel the {@link uml.UmlModel} containing the {@link uml.UmlElement}s
	 * @return the map of {@link uml.UmlElement}s and their names as keys
	 */
	public static HashMap<String, UmlElement> createUmlElementMap(UmlModel umlModel) {
		HashMap<String, UmlElement> umlElements = new HashMap<>();
		
		umlModel.getElementsAsList().forEach((umlElement) -> {
			umlElements.put(umlElement.getName(), umlElement);
		});
		
		return umlElements;
	}
	
	/**
	 * Tests {@link coretest.auxiliary.UmlModelMaps#createUmlPackageMap} and {@link coretest.auxiliary.UmlModelMaps#createUmlElementMap}
	 */
	@Test
	public void testUmlMapCreation() {
		UmlModel testModel = new UmlModel("test");
		UmlPackage topLevelPackage = new UmlPackage("topLevel");
		UmlPackage subPackage1 = new UmlPackage("subPackage1");
		UmlPackage subPackage2 = new UmlPackage("subPackage2");
		
		topLevelPackage.addPackage(subPackage1);
		topLevelPackage.addPackage(subPackage2);
		topLevelPackage.addElement(new UmlClass("topLevelPackageElement", UmlVisibility.PUBLIC));
		subPackage1.addElement(new UmlClass("subPackage1Element", UmlVisibility.PUBLIC));
		subPackage2.addElement(new UmlClass("subPackage2Element", UmlVisibility.PUBLIC));
		testModel.addPackage(topLevelPackage);
		testModel.addElement(new UmlClass("topLevelElement", UmlVisibility.PUBLIC));
		
		HashMap<String, UmlPackage> testPackageMap = createUmlPackageMap(testModel);
		HashMap<String, UmlElement> testElementMap = createUmlElementMap(testModel);
		
		assertEquals(testPackageMap.size(), 3);
		assertEquals(testElementMap.size(), 4);
		
		testModel.getPackagesAsList().forEach((umlPackage) -> {
			assertTrue(testPackageMap.containsKey(umlPackage.getName()));
		});
		testModel.getElementsAsList().forEach((umlElement) -> {
			assertTrue(testElementMap.containsKey(umlElement.getName()));
		});
	}
}
