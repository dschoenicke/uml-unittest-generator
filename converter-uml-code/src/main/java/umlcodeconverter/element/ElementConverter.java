package umlcodeconverter.element;

import static org.junit.Assert.assertNotNull;

import code.CodeClass;
import code.CodeElement;
import code.CodeEnumeration;
import code.CodeInterface;
import code.CodePackage;
import code.CodeParent;
import code.CodeRepresentation;
import uml.UmlClass;
import uml.UmlElement;
import uml.UmlEnumeration;
import uml.UmlInterface;
import uml.UmlModel;
import uml.UmlPackage;
import umlcodeconverter.temporary.TemporaryModel;

/**
 * Class providing static methods to convert {@link uml.UmlElement}s to {@link code.CodeElement}s and adding them to a {@link code.CodeParent}.
 * 
 * @author dschoenicke
 *
 */
public class ElementConverter {

	private ElementConverter() {}
	
	/**
	 * Static method converting the {@link uml.UmlElement}s of a given {@link uml.UmlModel} to {@link code.CodeElement}s for the {@link code.CodeRepresentation}.<br>
	 * If the {@link uml.UmlModel} contains {@link uml.UmlElement}s at the top level, a {@link code.CodePackage} is created, where the converted {@link code.CodeElement}s are added to. 
	 * 
	 * @param umlModel the {@link uml.UmlModel} containing the {@link uml.UmlElement}s and {@link uml.UmlPackage}s to be converted
	 * @param codeRepresentation the {@link code.CodeRepresentation} to which the converted elements should be added
	 * @param tmpModel the {@link umlcodeconverter.temporary.TemporaryModel} containing the maps to add {@link uml.UmlElement}s and converted {@link code.CodeElement}s to
	 */
	public static void convertElements(UmlModel umlModel, CodeRepresentation codeRepresentation, TemporaryModel tmpModel) {
		if (!umlModel.getElements().isEmpty()) {
			CodePackage topLevelPackage = new CodePackage(umlModel.getName(), codeRepresentation);
			codeRepresentation.addPackage(topLevelPackage);
			
			for (UmlElement umlElement : umlModel.getElements()) {
				convertElement(umlElement, null, topLevelPackage, tmpModel);
			}
		}
		
		for (UmlPackage umlPackage : umlModel.getPackagesAsList()) {
			for (UmlElement umlElement : umlPackage.getElements()) {
				convertElement(umlElement, umlPackage, null, tmpModel);
			}
		}
	}
	
	/**
	 * Static method to convert a given {@link uml.UmlElement} to a {@link code.CodeElement} and adding it to a {@link code.CodePackage}.<br>
	 * Delegates the conversion of {@link code.CodeLiteral}s to the {@link umlcodeconverter.element.LiteralConverter}<br>
	 * Delegates the conversion of {@link code.CodeField}s to the {@link umlcodeconverter.element.FieldConverter}<br>
	 * Delegates the conversion of {@link code.CodeConstructor}s to the {@link umlcodeconverter.element.ConstructorConverter}<br>
	 * Delegates the conversion of {@link code.CodeMethod}s to the {@link umlcodeconverter.element.MethodConverter}<br>
	 * Delegates the conversion of {@link code.CodeTemplateParameter}s to the {@link umlcodeconverter.element.TemplateParameterConverter}<br>
	 * 
	 * @param element the {@link uml.UmlElement} to be converted
	 * @param umlPackage the {@link uml.UmlPackage} used to get the {@link code.CodePackage} out of the map of the {@link umlcodeconverter.temporary.TemporaryModel}. Can be {@literal null} in case of the conversion of a nested {@link uml.UmlElement} 
	 * @param parent the {@link code.CodeParent} to add the converted {@link code.CodeElement} to. Can be {@literal null} in which case it needs to be taken out of the map in the {@link umlcodeconverter.temporary.TemporaryModel} with the {@link uml.UmlPackage} as key.
	 * @param tmpModel the {@link umlcodeconverter.temporary.TemporaryModel} containing the maps to add temporary {@link code.CodeTemplateBinding}s and converted {@link code.CodeTemplateParameter}s and {@link code.CodeElement}s to
	 * @return the converted {@link code.CodeElement}
	 */
	public static CodeElement convertElement(UmlElement element, UmlPackage umlPackage, CodeParent parent, TemporaryModel tmpModel) {
		if (parent == null) {
			parent= tmpModel.getConvertedPackages().get(umlPackage);
		}
		
		assertNotNull("There was no CodePackage found to add the CodeElement " + element.getName() + " to!" +
				(umlPackage != null ? ("\nA package with name " + umlPackage.getName() + " is expected!") : ""), parent);
				
		CodeElement codeElement = null;
		
		if (element instanceof UmlClass) {
			codeElement = new CodeClass(element.getName(),
					parent,
					ModifierConverter.convertModifierValue(element.getVisibility(), 
							((UmlClass) element).isStatic(),
							((UmlClass) element).isFinal(),
							((UmlClass) element).isAbstract())
				);
		}
		else if (element instanceof UmlInterface) {
			codeElement = new CodeInterface(element.getName(),
					parent,
					ModifierConverter.convertModifierValue(element.getVisibility(), 
							((UmlInterface) element).isStatic(),
							false,
							((UmlInterface) element).isAbstract())
				);
		}
		else {
			codeElement = new CodeEnumeration(element.getName(),
					parent,
					ModifierConverter.convertModifierValue(element.getVisibility(), ((UmlEnumeration) element).isStatic(), false, false)
				);
		
			LiteralConverter.convertLiterals((UmlEnumeration) element, (CodeEnumeration) codeElement);
		}
		
		FieldConverter.convertFields(element, codeElement);
		ConstructorConverter.convertConstructors(element, codeElement, tmpModel);
		MethodConverter.convertMethods(element, codeElement, tmpModel);
		TemplateParameterConverter.convertTemplateParameters(element.getTemplateParameters(), codeElement, tmpModel);
		TemplateBindingConverter.convertTemplateBindings(element.getTemplateBindings(), codeElement, tmpModel);
		
		for (UmlElement nestedElement : element.getInnerElements()) {
			codeElement.addNestedElement(convertElement(nestedElement, null, codeElement, tmpModel));
		}
		
		tmpModel.addConvertedElement(element, codeElement);
		
		if (parent instanceof CodePackage) {
			((CodePackage) parent).addElement(codeElement);
		}
		
		return codeElement;
	}
}
