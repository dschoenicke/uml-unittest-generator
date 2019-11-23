package mdxmlconverter.element;

import java.util.ArrayList;

import mdxml.OwnedParameter;
import mdxml.OwnedTemplateSignature;
import mdxmlconverter.temporary.TemporaryModel;
import uml.UmlElement;
import uml.UmlOperation;
import uml.UmlTemplateParameter;

public class TemplateParameterConverter {

	public static void convertTemplateParameters(OwnedTemplateSignature signature, UmlElement element, TemporaryModel tmpModel) {
		if (signature == null) {
			return;
		}
		
		for (UmlTemplateParameter templateParameter : convertTemplateParameters(signature, tmpModel)) {
			element.addTemplateParameter(templateParameter);
		}
	}
	
	public static void convertTemplateParameters(OwnedTemplateSignature signature, UmlOperation operation, TemporaryModel tmpModel) {
		if (signature == null) {
			return;
		}
		
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
