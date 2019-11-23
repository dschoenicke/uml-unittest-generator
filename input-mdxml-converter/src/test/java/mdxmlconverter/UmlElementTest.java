package mdxmlconverter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import mdxml.OwnedAttribute;
import mdxml.OwnedLiteral;
import mdxml.OwnedOperation;
import mdxml.PackagedElement;
import uml.UmlAttribute;
import uml.UmlClass;
import uml.UmlElement;
import uml.UmlEnumeration;
import uml.UmlInterface;
import uml.UmlLiteral;
import uml.UmlModel;
import uml.UmlOperation;

public class UmlElementTest extends MdxmlUmlConverterTest {
	
	public static void evaluateUmlElement(PackagedElement packagedElement, UmlModel umlModel) {
		boolean found = false;
		
		for (UmlElement umlElement : umlModel.getElementsAsList()) {
			if (umlElement.getName().equals(packagedElement.getName())) {
				assertFalse("There exist multiple occurances of UmlElement " + umlElement.getName() + "!", found);
				evaluateModifiers(packagedElement, umlElement);
				evaluateAttributes(packagedElement, umlElement);
				evaluateOperations(packagedElement, umlElement);
				
				if (umlElement instanceof UmlEnumeration) {
					evaluateLiterals(packagedElement, (UmlEnumeration) umlElement);
				}
				
				found = true;
			}
		}
		
		assertTrue("The UmlElement for " + packagedElement.getName() + " hasn't been converted!", found);
	}
	
	private static void evaluateModifiers(PackagedElement packagedElement, UmlElement umlElement) {
		assertEquals("The UmlElement " + umlElement.getName() + " is expected to be " + (packagedElement.getIsStatic() != null ? "" : "not ") + "static",
				Boolean.parseBoolean(packagedElement.getIsStatic()), umlElement.isStatic());
		
		if (umlElement instanceof UmlClass) {
			UmlClass umlClass = (UmlClass) umlElement;
			assertEquals("The UmlClass " + umlElement.getName() + " is expected to be " + (packagedElement.getIsAbstract() != null ? "" : "not ") + "abstract",
					Boolean.parseBoolean(packagedElement.getIsAbstract()), umlClass.isAbstract());
			assertEquals("The UmlClass " + umlElement.getName() + " is expected to be " + (packagedElement.getIsFinal() != null ? "" : "not ") + "final",
					Boolean.parseBoolean(packagedElement.getIsFinal()), umlClass.isFinal());
		}
		else if (umlElement instanceof UmlInterface) {
			UmlInterface umlInterface = (UmlInterface) umlElement;
			assertEquals("The UmlInterface " + umlElement.getName() + " is expected to be " + (packagedElement.getIsAbstract() != null ? "" : "not ") + "abstract",
					Boolean.parseBoolean(packagedElement.getIsAbstract()), umlInterface.isAbstract());
		}
	}
	
	private static void evaluateAttributes(PackagedElement packagedElement, UmlElement umlElement) {
		for (OwnedAttribute attribute : packagedElement.getOwnedAttributes()) {
			boolean found = false;
			
			for (UmlAttribute umlAttribute : umlElement.getAttributes()) {
				if (umlAttribute.getName().equals(attribute.getName())) {
					assertFalse("There exist multiple occurances of UmlAttribute " + umlElement.getName() + "." + umlAttribute.getName() + "!", found);
					
					if (attribute.getDefaultValue() != null) {
						assertEquals(umlAttribute.getDefaultValue(), attribute.getDefaultValue());
					}
					
					assertEquals("The UmlAttribute " + umlAttribute.getName() + " is expected to be " + (attribute.getIsStatic() != null ? "" : "not ") + "static",
							Boolean.parseBoolean(attribute.getIsStatic()), umlAttribute.isStatic());
					assertEquals("The UmlAttribute " + umlAttribute.getName() + " is expected to be " + (attribute.getIsStatic() != null ? "" : "not ") + "final",
							Boolean.parseBoolean(attribute.getIsFinal()), umlAttribute.isFinal());
					
					found = true;
				}
			}
			
			assertTrue("The UmlAttribute for " + packagedElement.getName() + "." + attribute.getName() + " has not been converted!", found);
		}
	}
	
	private static void evaluateOperations(PackagedElement packagedElement, UmlElement umlElement) {
		for (OwnedOperation operation : packagedElement.getOwnedOperations()) {
			boolean found = false;
			
			for (UmlOperation umlOperation : umlElement.getOperations()) {
				if (umlOperation.getName().equals(operation.getName())) {
					assertEquals("The UmlOperation " + umlOperation.getName() + " is expected to be " + (operation.getIsStatic() != null ? "" : "not ") + "static",
							Boolean.parseBoolean(operation.getIsStatic()), umlOperation.isStatic());
					assertEquals("The UmlOperation " + umlOperation.getName() + " is expected to be " + (operation.getIsFinal() != null ? "" : "not ") + "final",
							Boolean.parseBoolean(operation.getIsFinal()), umlOperation.isFinal());
					assertEquals("The UmlOperation " + umlOperation.getName() + " is expected to be " + (operation.getIsAbstract() != null ? "" : "not ") + "abstract",
							Boolean.parseBoolean(operation.getIsAbstract()), umlOperation.isAbstract());
					
					found = true;
				}
			}
			
			assertTrue("The UmlOperation for " + packagedElement.getName() + "." + operation.getName() + " has not been converted!", found);
		}
	}
	
	private static void evaluateLiterals(PackagedElement packagedElement, UmlEnumeration umlEnumeration) {
		for (OwnedLiteral ownedLiteral : packagedElement.getOwnedLiterals()) {
			boolean found = false;
			
			for (UmlLiteral literal : umlEnumeration.getLiterals()) {
				if (literal.getName().equals(ownedLiteral.getName())) {
					assertFalse("There exist multiple occurances of UmlEnumeration " + umlEnumeration.getName() + "." + literal.getName() + "!", found);
					found = true;
				}
			}
			
			assertTrue("The UmlLiteral for " + packagedElement.getName() + "." + ownedLiteral.getName() + " has not been converted!", found);
		}
	}
}
