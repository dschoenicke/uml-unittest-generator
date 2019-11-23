package mdxmlconverter.element;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import mdxml.OwnedParameter;
import mdxml.OwnedTemplateSignature;
import mdxmlconverter.temporary.TemporaryModel;
import uml.UmlElement;
import uml.UmlOperation;
import uml.UmlTemplateParameter;

/**
 * Class providing static methods to convert {@link mdxml.OwnedTemplateSignature}s to {@link uml.UmlTemplateParameter}s
 * 
 * @author dschoenicke
 *
 */
public class TemplateParameterConverter {

	/**
	 * Static method converting a given {@link mdxml.OwnedTemplateSignature} with its {@link mdxml.Parameter}s to {@link uml.UmlTemplateParameter}s and adds them to the owning {@link uml.UmlElement}
	 * 
	 * @param signature the {@link mdxml.OwnedTemplateSignature} which {@link mdxml.Parameter}s should be converted
	 * @param element the {@link uml.UmlElement} to which the converted {@link uml.UmlTemplateParameter}s should be added
	 * @param tmpModel the {@link mdxmlconverter.temporary.TemporaryModel} to which the converted {@link uml.UmlTemplateParameter}s should be added
	 */
	public static void convertTemplateParameters(OwnedTemplateSignature signature, UmlElement element, TemporaryModel tmpModel) {
		if (signature == null) {
			return;
		}
		
		for (UmlTemplateParameter templateParameter : convertTemplateParameters(signature, tmpModel)) {
			element.addTemplateParameter(templateParameter);
		}
	}
	
	/**
	 * Static method converting a given {@link mdxml.OwnedTemplateSignature} with its {@link mdxml.Parameter}s to {@link uml.UmlTemplateParameter}s and adds them to the owning {@link uml.UmlOperation}
	 * 
	 * @param signature the {@link mdxml.OwnedTemplateSignature} which {@link mdxml.Parameter}s should be converted
	 * @param operation the {@link uml.UmlOperation} to which the converted {@link uml.UmlTemplateParameter}s should be added
	 * @param tmpModel the {@link mdxmlconverter.temporary.TemporaryModel} to which the converted {@link uml.UmlTemplateParameter}s should be added
	 */
	public static void convertTemplateParameters(OwnedTemplateSignature signature, UmlOperation operation, TemporaryModel tmpModel) {
		if (signature == null) {
			return;
		}
		
		for (UmlTemplateParameter templateParameter : convertTemplateParameters(signature, tmpModel)) {
			operation.addTemplateParameter(templateParameter);
		}
	}
	
	/**
	 * Static method to which the actual conversion of a {@link mdxml.OwnedTemplateSignature} is delegated
	 * 
	 * @param signature the {@link mdxml.OwnedTemplateSignature} which {@link mdxml.Parameter}s should be converted
	 * @param tmpModel the {@link mdxmlconverter.temporary.TemporaryModel} to which the converted {@link uml.UmlTemplateParameter}s should be added
	 * @return a list of converted{@link uml.UmlTemplateParameter}s
	 */
	private static ArrayList<UmlTemplateParameter> convertTemplateParameters(OwnedTemplateSignature signature, TemporaryModel tmpModel) {
		ArrayList<UmlTemplateParameter> parameters = new ArrayList<>();
		
		for (OwnedParameter ownedParameter : signature.getOwnedParameters()) {
			assertNotNull("The id of an ownedParameter must not be null!\nOccurance in ownedTemplateSignature with id " + signature.getId(), ownedParameter.getId());
			assertNotNull("The ownedParameteredElement of an ownedParameter must not be null!\nOccurance in ownedTemplateSignature with id " + signature.getId(), ownedParameter.getOwnedParameteredElement());
			assertNotNull("The name of an ownedParameteredElement must not be null!\nOccurance in ownedParameteredElement with id " + signature.getId(), ownedParameter.getOwnedParameteredElement().getId());
			
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
