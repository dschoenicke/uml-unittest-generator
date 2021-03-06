package inputmdxml.converter.element;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import inputmdxml.temporary.TemporaryModel;
import lombok.experimental.UtilityClass;
import mdxml.ConstrainingClassifier;
import mdxml.OwnedParameter;
import mdxml.OwnedTemplateSignature;
import uml.UmlElement;
import uml.UmlOperation;
import uml.UmlTemplateParameter;

/**
 * Class providing static methods to convert {@link mdxml.OwnedTemplateSignature}s to {@link uml.UmlTemplateParameter}s
 * 
 * @author dschoenicke
 *
 */
@UtilityClass
public class TemplateParameterConverter {
	
	/**
	 * Static method converting a given {@link mdxml.OwnedTemplateSignature} with its {@link mdxml.Parameter}s to {@link uml.UmlTemplateParameter}s and adds them to the owning {@link uml.UmlElement}
	 * 
	 * @param signature the {@link mdxml.OwnedTemplateSignature} which {@link mdxml.Parameter}s should be converted
	 * @param element the {@link uml.UmlElement} to which the converted {@link uml.UmlTemplateParameter}s should be added
	 * @param tmpModel the {@link inputmdxml.temporary.TemporaryModel} to which the converted {@link uml.UmlTemplateParameter}s should be added
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
	 * @param tmpModel the {@link inputmdxml.temporary.TemporaryModel} to which the converted {@link uml.UmlTemplateParameter}s should be added
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
	 * @param tmpModel the {@link inputmdxml.temporary.TemporaryModel} to which the converted {@link uml.UmlTemplateParameter}s should be added
	 * @return a list of converted{@link uml.UmlTemplateParameter}s
	 */
	public static List<UmlTemplateParameter> convertTemplateParameters(OwnedTemplateSignature signature, TemporaryModel tmpModel) {
		List<UmlTemplateParameter> parameters = new ArrayList<>();
		
		for (OwnedParameter ownedParameter : signature.getOwnedParameters()) {
			assertNotNull("The id of an ownedParameter must not be null!\nOccurance in ownedTemplateSignature with id " + signature.getId(), ownedParameter.getId());
			assertNotNull("The ownedParameteredElement of an ownedParameter must not be null!\nOccurance in ownedTemplateSignature with id " + signature.getId(), ownedParameter.getOwnedParameteredElement());
			assertNotNull("The name of an ownedParameteredElement must not be null!\nOccurance in ownedParameteredElement with id " + signature.getId(), ownedParameter.getOwnedParameteredElement().getName());
			
			String constrainingClassifierString = "java.lang.Object";
			ConstrainingClassifier constrainingClassifier = ownedParameter.getConstrainingClassifier();
			
			if (constrainingClassifier != null) {
				if (constrainingClassifier.getIdref() != null) {
					constrainingClassifierString = constrainingClassifier.getIdref(); 
				}
				else {
					assertNotNull("The id and Extension of an ConstrainingClassifier must not both be null!\nOccurance in ownedParameter with id " + ownedParameter.getId(), constrainingClassifier.getExtension());
					assertNotNull("The id and Extension.ReferenceExtension of an ConstrainingClassifier must not both be null!\nOccurance in ownedParameter with id " + ownedParameter.getId(), constrainingClassifier.getExtension().getReferenceExtension());
					constrainingClassifierString = DataTypeConverter.generateDataTypeString(constrainingClassifier.getExtension());
				}
			}
			
			UmlTemplateParameter templateParameter = new UmlTemplateParameter(ownedParameter.getOwnedParameteredElement().getName(), constrainingClassifierString);
			tmpModel.addTemplateParameter(ownedParameter.getId(), templateParameter);
			parameters.add(templateParameter);
		}
		
		return parameters;
	}
}
