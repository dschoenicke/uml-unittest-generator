package converter.element;

import converter.temporary.TemporaryModel;
import mdxml.OwnedOperation;
import mdxml.PackagedElement;
import uml.UmlElement;
import uml.UmlOperation;

public class OperationConverter {

	public static void convertOperations(PackagedElement packagedElement, UmlElement element, TemporaryModel tmpModel) {
		for (OwnedOperation ownedOperation : packagedElement.getOwnedOperations()) {
			UmlOperation operation = new UmlOperation(ownedOperation.getName(),
					VisibilityConverter.convertVisibility(ownedOperation.getVisibility()),
					ClassifierConverter.convertClassifier(ownedOperation.getIsStatic()),
					ClassifierConverter.convertClassifier(ownedOperation.getIsFinal()),
					ClassifierConverter.convertClassifier(ownedOperation.getIsAbstract())
			);
			
			ParameterConverter.convertParameters(ownedOperation, operation, tmpModel);
			TemplateParameterConverter.convertTemplateParameters(ownedOperation.getOwnedTemplateSignature(), operation, tmpModel);
			TemplateBindingConverter.convertTemplateBindings(ownedOperation.getTemplateBindings(), operation);
			element.addOperation(operation);
		}
	}
}
