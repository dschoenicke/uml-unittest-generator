package inputmdxml.converter.element;

import static org.junit.Assert.assertNotNull;

import inputmdxml.temporary.TemporaryModel;
import lombok.experimental.UtilityClass;
import mdxml.OwnedOperation;
import mdxml.PackagedElement;
import uml.UmlElement;
import uml.UmlOperation;

/**
 * Class providing a static method to convert a given {@link mdxml.OwnedOperation} to an {@link uml.UmlOperation} and adds it to its {@link uml.UmlElement}
 * 
 * @author dschoenicke
 *
 */
@UtilityClass
public class OperationConverter {
	
	/**
	 * Static method converting all {@link mdxml.OwnedOperation}s of a given {@link PackagedElement} to {@link uml.UmlOperation}s and adds them to the owning {@link uml.UmlElement}
	 * Delegates the conversion of the {@link mdxml.OwnedParameter}s to the {@link inputmdxml.converter.element.ParameterConverter}
	 * Delegates the conversion of the {@link mdxml.OwnedTemplateSignature}s to the {@link inputmdxml.converter.element.TemplateParameterConverter}
	 * Delegates the conversion of the {@link mdxml.TemplateBinding}s to the {@link inputmdxml.converter.element.TemplateBindingConverter}
	 * 
	 * @param packagedElement the {@link mdxml.PackagedElement} containing the {@link OwnedOperation}s
	 * @param element the {@link uml.UmlElement} to which the {@link uml.UmlOperation}s should be added
	 * @param tmpModel the {@link inputmdxml.temporary.TemporaryModel} passed to the {@link inputmdxml.converter.element.ParameterConverter} and {@link inputmdxml.converter.element.TemplateBindingConverter}
	 */
	public static void convertOperations(PackagedElement packagedElement, UmlElement element, TemporaryModel tmpModel) {
		for (OwnedOperation ownedOperation : packagedElement.getOwnedOperations()) {
			assertNotNull("The name of an ownedOperation must not be null!\nOccurance in PackagedElement " + element.getName(), ownedOperation.getName());
			UmlOperation operation = new UmlOperation(ownedOperation.getName(),
					ModifierConverter.convertAccessModifier(ownedOperation.getVisibility()),
					ModifierConverter.convertNonAccessModifier(ownedOperation.getIsStatic()),
					ModifierConverter.convertNonAccessModifier(ownedOperation.getIsFinal()),
					ModifierConverter.convertNonAccessModifier(ownedOperation.getIsAbstract())
			);
			
			ParameterConverter.convertParameters(ownedOperation, operation, tmpModel);
			TemplateParameterConverter.convertTemplateParameters(ownedOperation.getOwnedTemplateSignature(), operation, tmpModel);
			TemplateBindingConverter.convertTemplateBindings(ownedOperation.getTemplateBindings(), operation);
			element.addOperation(operation);
		}
	}
}
