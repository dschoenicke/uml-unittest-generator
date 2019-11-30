package coretest.umlcodeconverter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import code.CodeElement;
import code.CodePackage;
import code.CodeRepresentation;
import uml.UmlElement;
import uml.UmlModel;
import uml.UmlPackage;

public class UmlCodeElementTests {

	public static void testElements(HashMap<String, UmlPackage> umlPackages,
			HashMap<String, UmlElement> umlElements,
			HashMap<String, CodePackage> codePackages,
			HashMap<String, CodeElement> codeElements,
			UmlModel umlModel,
			CodeRepresentation codeRepresentation) {
		
		testElementStructure(umlPackages, umlElements, codePackages, codeElements, umlModel, codeRepresentation);
		//testNestedElements();
		//UmlCodeFieldTests.testElementFields();
		//UmlCodeMethodTests.testElementMethods();
		//UmlCodeTemplateParameterTests.testElementTemplateParameters();
		//UmlCodeRelationshipTests.testElementRelations();
	}
	
	private static void testElementStructure(HashMap<String, UmlPackage> umlPackages,
			HashMap<String, UmlElement> umlElements,
			HashMap<String, CodePackage> codePackages,
			HashMap<String, CodeElement> codeElements,
			UmlModel umlModel,
			CodeRepresentation codeRepresentation) {
		
		umlElements.forEach((umlElementName, umlElement) -> {
			assertTrue(umlElementName + " has not been converted!", codeElements.containsKey(umlElementName));
		});
		
		umlPackages.forEach((umlPackageName, umlPackage) -> {
			umlPackage.getElements().forEach(umlElement -> {
				CodeElement codeElement = codeElements.get(umlElement.getName());
				assertEquals("CodeElement " + codeElement.getName() + " should have been added to package " + 
						umlPackage.getName() + " but was added to " + codeElement.getParent().getName() + "!",
						umlPackage.getName(), codeElement.getParent().getName()				
				);
			});
		});
	}
}
