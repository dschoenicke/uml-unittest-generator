package coretest.auxiliary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Test;

import code.CodePackage;
import code.CodeRepresentation;
import code.CodeClass;
import code.CodeElement;
import code.CodeVisibility;

/**
 * This class provides methods creating maps, which contain all {@link code.CodePackage}s and {@link code.CodeElement}s referenced with their name for
 * easier testing. The methods creating these maps are tested within this class as well.
 * 
 * @author dschoenicke
 *
 */
public class CodeRepresentationMaps {

	/**
	 * Fills a map of {@link code.CodePackage}s with their names as keys
	 * 
	 * @param codeRepresentation the {@link code.CodeRepresentation} containing the {@link code.CodePackage}s
	 * @return the map of {@link code.CodePackage}s and their names as keys
	 */
	public static HashMap<String, CodePackage> createCodePackageMap(CodeRepresentation codeRepresentation) {
		HashMap<String, CodePackage> codePackages = new HashMap<>();
		
		codeRepresentation.getPackagesAsList().forEach((codePackage) -> {
			codePackages.put(codePackage.getName(), codePackage);
		});
		
		return codePackages;
	}
	
	/**
	 * Fills a map of {@link code.CodeElement}s with their names as keys
	 * 
	 * @param codeRepresentation the {@link code.CodeRepresentation} containing the {@link code.CodeElement}s
	 * @return the map of {@link code.CodeElement}s and their names as keys
	 */
	public static HashMap<String, CodeElement> createCodeElementMap(CodeRepresentation codeRepresentation) {
		HashMap<String, CodeElement> codeElements = new HashMap<>();
		
		codeRepresentation.getElementsAsList().forEach((codeElement) -> {
			codeElements.put(codeElement.getName(), codeElement);
		});
		
		return codeElements;
	}
	
	/**
	 * Tests {@link coretest.auxiliary.CodeRepresentationMaps#createCodePackageMap} and {@link coretest.auxiliary.CodeRepresentationMaps#createCodeElementMap}
	 */
	@Test
	public void testCodeMapCreation() {
		CodeRepresentation testRepresentation = new CodeRepresentation("test");
		CodePackage topLevelPackage = new CodePackage("topLevel", testRepresentation);
		CodePackage subPackage1 = new CodePackage("subPackage1", topLevelPackage);
		CodePackage subPackage2 = new CodePackage("subPackage2", subPackage1);
		
		topLevelPackage.addPackage(subPackage1);
		subPackage1.addPackage(subPackage2);
		topLevelPackage.addElement(new CodeClass("topLevelPackageElement", topLevelPackage, CodeVisibility.PUBLIC, false, false, false));
		subPackage1.addElement(new CodeClass("subPackage1Element", subPackage1, CodeVisibility.PUBLIC, false, false, false));
		subPackage2.addElement(new CodeClass("subPackage2Element", subPackage2, CodeVisibility.PUBLIC, false, false, false));
		testRepresentation.addPackage(topLevelPackage);
		
		HashMap<String, CodePackage> testPackageMap = createCodePackageMap(testRepresentation);
		HashMap<String, CodeElement> testElementMap = createCodeElementMap(testRepresentation);
		
		assertEquals(testPackageMap.size(), 3);
		assertEquals(testElementMap.size(), 3);
		
		testRepresentation.getPackagesAsList().forEach((umlPackage) -> {
			assertTrue(testPackageMap.containsKey(umlPackage.getName()));
		});
		testRepresentation.getElementsAsList().forEach((umlElement) -> {
			assertTrue(testElementMap.containsKey(umlElement.getName()));
		});
	}
}
