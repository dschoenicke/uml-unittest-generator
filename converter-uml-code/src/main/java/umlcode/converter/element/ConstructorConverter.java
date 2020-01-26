package umlcode.converter.element;

import code.CodeConstructor;
import code.CodeElement;
import lombok.experimental.UtilityClass;
import uml.UmlElement;
import uml.UmlOperation;
import umlcode.TemporaryModel;

/**
 * Provides a static method to convert {@link uml.UmlOperation}s of an {@link uml.UmlElement} to {@link code.CodeConstructor}s and adding them to the {@link code.CodeElement}
 * 
 * @author dschoenicke
 *
 */
@UtilityClass
public class ConstructorConverter {
	
	/**
	 * Static method to convert {@link uml.UmlOperation}s of an {@link uml.UmlElement} to {@link code.CodeConstructor}s and adding them to the {@link code.CodeElement}.<br>
	 * Delegates the conversion of {@link code.CodeParameter}s to the {@link umlcode.converter.element.ParameterConverter}<br>
	 * Delegates the conversion of {@link code.CodeTemplateParameter}s to the {@link umlcode.converter.element.TemplateParameterConverter}<br>
	 * 
	 * @param element the {@link uml.UmlElement} which {@link uml.UmlOperation}s should be converted
	 * @param codeElement the {@link code.CodeElement} to which the converted {@link code.CodeConstructor}s should be added to
	 * @param tmpModel the {@link umlcode.TemporaryModel} containing the maps to add temporary {@link code.CodeTemplateBinding}s and converted {@link code.CodeTemplateParameter}s to
	 */
	public static void convertConstructors(UmlElement element, CodeElement codeElement, TemporaryModel tmpModel) {
		for (UmlOperation operation : element.getOperations()) {
			if (!operation.isConstructor() || !operation.getName().equals(element.getName())) {
				continue;
			}
			
			CodeConstructor constructor = new CodeConstructor(ModifierConverter.convertModifierValue(operation.getVisibility(), operation.isStatic(), operation.isFinal(), operation.isAbstract()));
			
			ParameterConverter.convertParameters(operation, constructor);
			constructor.getTemplateParameters().addAll(TemplateParameterConverter.convertTemplateParameters(operation.getTemplateParameters(), tmpModel));
			constructor.getTemplateBindings().addAll(TemplateBindingConverter.convertTemplateBindings(operation.getTemplateBindings(), tmpModel));
			codeElement.addConstructor(constructor);
		}
	}
}
