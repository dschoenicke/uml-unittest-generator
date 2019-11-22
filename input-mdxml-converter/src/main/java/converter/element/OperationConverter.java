package converter.element;

import converter.temporary.TemporaryModel;
import model.OwnedOperation;
import model.PackagedElement;
import model.UmlElement;
import model.UmlOperation;

public class OperationConverter {

	public static void convertOperations(PackagedElement packagedElement, UmlElement element, TemporaryModel tmpModel) {
		for (OwnedOperation ownedOperation : packagedElement.getOwnedOperations()) {
			UmlOperation operation = new UmlOperation(ownedOperation.getName(),
					VisibilityConverter.convertVisibility(ownedOperation.getVisibility()),
					ClassifierConverter.convertClassifier(ownedOperation.getIsStatic()),
					ClassifierConverter.convertClassifier(ownedOperation.getIsFinal()),
					ClassifierConverter.convertClassifier(ownedOperation.getIsAbstract())
			);
			
			ParameterConverter.convertParameters(ownedOperation, operation);
			TemplateParameterConverter.convertTemplateParameters(ownedOperation.getOwnedTemplateSignature(), operation, tmpModel);
			TemplateBindingConverter.convertTemplateBindings(ownedOperation.getTemplateBindings(), operation);
			element.addOperation(operation);
		}
	}
}
