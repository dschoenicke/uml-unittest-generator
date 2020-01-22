package umlcodeconverter.element;

import code.CodeConstructor;
import code.CodeElement;
import uml.UmlElement;
import uml.UmlOperation;
import umlcodeconverter.temporary.TemporaryModel;

/**
 * Provides a static method to convert {@link uml.UmlOperation}s of an {@link uml.UmlElement} to {@link code.CodeConstructor}s and adding them to the {@link code.CodeElement}
 * 
 * @author dschoenicke
 *
 */
public class ConstructorConverter {

	private ConstructorConverter() {}
	
	/**
	 * Static method to convert {@link uml.UmlOperation}s of an {@link uml.UmlElement} to {@link code.CodeConstructor}s and adding them to the {@link code.CodeElement}.<br>
	 * Delegates the conversion of {@link code.CodeParameter}s to the {@link umlcodeconverter.element.ParameterConverter}<br>
	 * Delegates the conversion of {@link code.CodeTemplateParameter}s to the {@link umlcodeconverter.element.TemplateParameterConverter}<br>
	 * 
	 * @param element the {@link uml.UmlElement} which {@link uml.UmlOperation}s should be converted
	 * @param codeElement the {@link code.CodeElement} to which the converted {@link code.CodeConstructor}s should be added to
	 * @param tmpModel the {@link umlcodeconverter.temporary.TemporaryModel} containing the maps to add temporary {@link code.CodeTemplateBinding}s and converted {@link code.CodeTemplateParameter}s to
	 */
	public static void convertConstructors(UmlElement element, CodeElement codeElement, TemporaryModel tmpModel) {
		for (UmlOperation operation : element.getOperations()) {
			if (!operation.isConstructor() || !operation.getName().equals(element.getName())) {
				continue;
			}
			
			CodeConstructor constructor = new CodeConstructor(codeElement,
					ModifierConverter.convertModifierValue(operation.getVisibility(), operation.isStatic(), operation.isFinal(), operation.isAbstract()));
			
			ParameterConverter.convertParameters(operation, constructor);
			TemplateParameterConverter.convertTemplateParameters(operation.getTemplateParameters(), constructor, tmpModel);
			TemplateBindingConverter.convertTemplateBindings(operation.getTemplateBindings(), constructor, tmpModel);
			codeElement.addConstructor(constructor);
		}
	}
}
