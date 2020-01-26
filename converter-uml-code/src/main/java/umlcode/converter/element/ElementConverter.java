package umlcode.converter.element;

import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import code.CodeClass;
import code.CodeElement;
import code.CodeEnumeration;
import code.CodeInterface;
import code.CodePackage;
import code.CodeRepresentation;
import lombok.experimental.UtilityClass;
import uml.UmlClass;
import uml.UmlElement;
import uml.UmlEnumeration;
import uml.UmlInterface;
import uml.UmlModel;
import uml.UmlPackage;
import umlcode.TemporaryModel;

/**
 * Class providing static methods to convert {@link uml.UmlElement}s to {@link code.CodeElement}s and adding them to a {@link code.CodeParent}.
 * 
 * @author dschoenicke
 *
 */
@UtilityClass
public class ElementConverter {

	/**
	 * Static method converting the {@link uml.UmlElement}s of a given {@link uml.UmlModel} to {@link code.CodeElement}s for the {@link code.CodeRepresentation}.<br>
	 * If the {@link uml.UmlModel} contains {@link uml.UmlElement}s at the top level, a {@link code.CodePackage} is created, where the converted {@link code.CodeElement}s are added to. 
	 * 
	 * @param umlModel the {@link uml.UmlModel} containing the {@link uml.UmlElement}s and {@link uml.UmlPackage}s to be converted
	 * @param codeRepresentation the {@link code.CodeRepresentation} to which the converted elements should be added
	 * @param tmpModel the {@link umlcode.TemporaryModel} containing the maps to add {@link uml.UmlElement}s and converted {@link code.CodeElement}s to
	 */
	public static void convertElements(UmlModel umlModel, CodeRepresentation codeRepresentation, TemporaryModel tmpModel) {
		if (!umlModel.getElements().isEmpty()) {
			CodePackage topLevelPackage = PackageConverter.createTopLevelPackage(codeRepresentation);
			
			for (UmlElement umlElement : umlModel.getElements()) {
				convertElement(umlElement, null, topLevelPackage, tmpModel);
			}
		}
		
		tmpModel.getConvertedPackages().forEach((umlPackage, codePackage) ->
			umlPackage.getElements().forEach(umlElement ->
				convertElement(umlElement, umlPackage, codePackage, tmpModel)
			)
		);
	}
	
	/**
	 * Static method to convert a given {@link uml.UmlElement} to a {@link code.CodeElement} and adding it to a {@link code.CodePackage}.<br>
	 * Delegates the conversion of {@link code.CodeLiteral}s to the {@link umlcode.converter.element.LiteralConverter}<br>
	 * Delegates the conversion of {@link code.CodeField}s to the {@link umlcode.converter.element.FieldConverter}<br>
	 * Delegates the conversion of {@link code.CodeConstructor}s to the {@link umlcode.converter.element.ConstructorConverter}<br>
	 * Delegates the conversion of {@link code.CodeMethod}s to the {@link umlcode.converter.element.MethodConverter}<br>
	 * Delegates the conversion of {@link code.CodeTemplateParameter}s to the {@link umlcode.converter.element.TemplateParameterConverter}<br>
	 * 
	 * @param element the {@link uml.UmlElement} to be converted
	 * @param umlPackage the {@link uml.UmlPackage} used to get the {@link code.CodePackage} out of the map of the {@link umlcode.TemporaryModel}. Can be {@literal null} in case of the conversion of a nested {@link uml.UmlElement} 
	 * @param codePackage the {@link code.CodePackage} to add the converted {@link code.CodeElement} to.
	 * @param tmpModel the {@link umlcode.TemporaryModel} containing the maps to add temporary {@link code.CodeTemplateBinding}s and converted {@link code.CodeTemplateParameter}s and {@link code.CodeElement}s to
	 * @return the converted {@link code.CodeElement}
	 */
	public static CodeElement convertElement(UmlElement element, UmlPackage umlPackage, CodePackage codePackage, TemporaryModel tmpModel) {
		assertNotNull("There was no CodePackage found to add the CodeElement " + element.getName() + " to!" +
				(umlPackage != null ? ("\nA package with name " + umlPackage.getName() + " is expected!") : ""), codePackage);
				
		CodeElement codeElement = null;
		
		if (element instanceof UmlClass) {
			codeElement = new CodeClass(element.getName(),
					codePackage,
					ModifierConverter.convertModifierValue(element.getVisibility(), 
							((UmlClass) element).isStatic(),
							((UmlClass) element).isFinal(),
							((UmlClass) element).isAbstract())
				);
		}
		else if (element instanceof UmlInterface) {
			codeElement = new CodeInterface(element.getName(),
					codePackage,
					ModifierConverter.convertModifierValue(element.getVisibility(), 
							((UmlInterface) element).isStatic(),
							false,
							((UmlInterface) element).isAbstract())
				);
		}
		else {
			codeElement = new CodeEnumeration(element.getName(),
					codePackage,
					ModifierConverter.convertModifierValue(element.getVisibility(), ((UmlEnumeration) element).isStatic(), false, false)
				);
		
			LiteralConverter.convertLiterals((UmlEnumeration) element, (CodeEnumeration) codeElement);
		}
		
		FieldConverter.convertFields(element, codeElement);
		ConstructorConverter.convertConstructors(element, codeElement, tmpModel);
		MethodConverter.convertMethods(element, codeElement, tmpModel);
		codeElement.getTemplateParameters().addAll(TemplateParameterConverter.convertTemplateParameters(element.getTemplateParameters(), tmpModel));
		codeElement.getTemplateBindings().addAll(TemplateBindingConverter.convertTemplateBindings(element.getTemplateBindings(), tmpModel));
		
		for (UmlElement innerElement : element.getInnerElements()) {
			CodeElement nestedElement = convertElement(innerElement, null, codePackage, tmpModel);
			nestedElement.setNestHost(Optional.of(codeElement));
			codeElement.addNestedElement(nestedElement);
		}
		
		tmpModel.addConvertedElement(element, codeElement);
		codePackage.addElement(codeElement);
		return codeElement;
	}
}
