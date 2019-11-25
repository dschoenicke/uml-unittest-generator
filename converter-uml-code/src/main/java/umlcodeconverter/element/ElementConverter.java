package umlcodeconverter.element;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

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
import umlcodeconverter.temporary.TemporaryModel;

/**
 * Class providing static methods to convert {@link uml.UmlElement}s to {@link code.CodeElement}s and adding them to a {@link code.CodeParent}.
 * 
 * @author dschoenicke
 *
 */
public class ElementConverter {

	/**
	 * Static method to convert a list of given {@link uml.UmlElement}s to {@link code.CodeElement}s and adding them to a {@link code.CodeParent}.<br>
	 * If the given {@link code.CodeParent} is an instance of {@link code.CodeRepresentation}, a {@link code.CodePackage} with the name of the {@link CodeRepresentation}
	 * is created to act as the {@link code.CodeParent} for the {@link code.CodeElement}s.
	 * 
	 * @param umlElements the list of {@link uml.UmlElement}s to be converted
	 * @param parent the {@link code.CodeParent} to add the converted {@link code.CodeElement}s to
	 * @param tmpModel the {@link umlcodeconverter.temporary.TemporaryModel} containing the maps to add temporary {@link code.CodeTemplateBinding}s and converted {@link code.CodeTemplateParameter}s to
	 */
	public static void convertElements(ArrayList<UmlElement> umlElements, CodeParent parent, TemporaryModel tmpModel) {
		CodePackage parentPackage = null;
		
		if (parent instanceof CodeRepresentation) {
			parentPackage = new CodePackage(parent.getName(), parent);
		}
		else if (parent instanceof CodePackage) {
			parentPackage = (CodePackage) parent;
		}
		
		assertNotNull("The CodeParent " + parent.getName() + " is not of type CodePackage or CodeRepresentation and does not qualify as a parent for its CodeElements!", parentPackage);
		
		for (UmlElement element : umlElements) {
			parentPackage.addElement(convertElement(element, parentPackage, tmpModel));
		}
	}
	
	/**
	 * Static method to convert a given {@link uml.UmlElement}s to {@link code.CodeElement}s and adding it to a {@link code.CodePackage}.<br>
	 * Delegates the conversion of {@link code.CodeLiteral}s to the {@link umlcodeconverter.element.LiteralConverter}<br>
	 * Delegates the conversion of {@link code.CodeField}s to the {@link umlcodeconverter.element.FieldConverter}<br>
	 * Delegates the conversion of {@link code.CodeConstructor}s to the {@link umlcodeconverter.element.ConstructorConverter}<br>
	 * Delegates the conversion of {@link code.CodeMethod}s to the {@link umlcodeconverter.element.MethodConverter}<br>
	 * Delegates the conversion of {@link code.CodeTemplateParameter}s to the {@link umlcodeconverter.element.TemplateParameterConverter}<br>
	 * 
	 * @param element the {@link uml.UmlElement} to be converted
	 * @param parent the {@link code.CodeParent} to add the converted {@link code.CodeElement}s to
	 * @param tmpModel the {@link umlcodeconverter.temporary.TemporaryModel} containing the maps to add temporary {@link code.CodeTemplateBinding}s and converted {@link code.CodeTemplateParameter}s and {@link code.CodeElement}s to
	 * @return the converted {@link code.CodeElement}
	 */
	public static CodeElement convertElement(UmlElement element, CodeParent parent, TemporaryModel tmpModel) {
		CodeElement codeElement = null;
		
		if (element instanceof UmlClass) {
			codeElement = new CodeClass(element.getName(),
					parent,
					ModifierConverter.convertAccessModifier(element.getVisibility()),
					((UmlClass) element).isAbstract(),
					((UmlClass) element).isStatic(),
					((UmlClass) element).isFinal()
				);
		}
		else if (element instanceof UmlInterface) {
			codeElement = new CodeInterface(element.getName(),
					parent,
					ModifierConverter.convertAccessModifier(element.getVisibility()),
					((UmlInterface) element).isAbstract(),
					((UmlInterface) element).isStatic(),
					false
				);
		}
		else if (element instanceof UmlEnumeration) {
			codeElement = new CodeEnumeration(element.getName(),
					parent,
					ModifierConverter.convertAccessModifier(element.getVisibility()),
					false,
					((UmlEnumeration) element).isStatic(),
					false
				);
			
			LiteralConverter.convertLiterals((UmlEnumeration) element, (CodeEnumeration) codeElement);
		}
		
		assertNotNull("The UmlElement " + element.getName() + " could not be converted!", codeElement);
		FieldConverter.convertFields(element, codeElement);
		ConstructorConverter.convertConstructors(element, codeElement, tmpModel);
		MethodConverter.convertMethods(element, codeElement, tmpModel);
		TemplateParameterConverter.convertTemplateParameters(element.getTemplateParameters(), codeElement, tmpModel);
		TemplateBindingConverter.convertTemplateBindings(element.getUmlTemplateBindings(), codeElement, tmpModel);
		
		for (UmlElement nestedElement : element.getInnerElements()) {
			codeElement.addNestedElement(convertElement(nestedElement, codeElement, tmpModel));
		}
		
		tmpModel.addConvertedElement(element, codeElement);
		
		return codeElement;
	}
}
