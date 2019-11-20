package converter.element;

import java.util.ArrayList;

import converter.temporary.TemporaryModel;
import model.OwnedParameter;
import model.OwnedTemplateSignature;
import model.UmlElement;
import model.UmlOperation;
import model.UmlTemplateParameter;

public class TemplateParameterConverter {

	public static void convertTemplateParameters(OwnedTemplateSignature signature, UmlElement element, TemporaryModel tmpModel) {
		for (UmlTemplateParameter templateParameter : convertTemplateParameters(signature, tmpModel)) {
			element.addTemplateParameter(templateParameter);
		}
	}
	
	public static void convertTemplateParameters(OwnedTemplateSignature signature, UmlOperation operation, TemporaryModel tmpModel) {
		for (UmlTemplateParameter templateParameter : convertTemplateParameters(signature, tmpModel)) {
			operation.addTemplateParameter(templateParameter);
		}
	}
	
	private static ArrayList<UmlTemplateParameter> convertTemplateParameters(OwnedTemplateSignature signature, TemporaryModel tmpModel) {
		ArrayList<UmlTemplateParameter> parameters = new ArrayList<>();
		
		for (OwnedParameter ownedParameter : signature.getOwnedParameters()) {
			try {
				UmlTemplateParameter templateParameter = new UmlTemplateParameter(
						ownedParameter.getOwnedParameteredElement().getName(),
						(ownedParameter.getConstrainingClassifier() != null) ? ownedParameter.getConstrainingClassifier().getIdref() : ""
					);
				tmpModel.addTemplateParameter(ownedParameter.getId(), templateParameter);
				parameters.add(templateParameter);
			} catch(NullPointerException np) {}
		}
		
		return parameters;
	}
}
