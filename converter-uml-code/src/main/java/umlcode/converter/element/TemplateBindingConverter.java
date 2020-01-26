package umlcode.converter.element;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import code.CodeTemplateBinding;
import lombok.experimental.UtilityClass;
import uml.UmlParameterSubstitution;
import uml.UmlTemplateBinding;
import umlcode.TemporaryModel;

/**
 * Static class providing methods to convert {@link uml.UmlTemplateBinding}s to {@link code.CodeTemplateBinding}s.<br>
 * Since the necessary {@link code.CodeTemplateParameter}s needed for the parameter substitutions of the {@link code.CodeTemplateBinding}
 * might not be available during the conversion, the {@link code.CodeTemplateBinding}s are converted without the parameter substitutions
 * and are stored in a map in a {@link umlcode.TemporaryModel} with the list of {@link uml.UmlParameterSubstitution}s,
 * which hold references to the {@link uml.UmlTemplateParameter}s. Therefore, another map with {@link uml.UmlTemplateParameter}s and
 * {@link code.CodeTemplateParameter}s is stored in {@link umlcode.TemporaryModel} to resolve the references in
 * {@link umlcode.converter.element.TemplateBindingConverter#finishTemplateBindingConversions} after all {@link code.CodeTemplateParameter}s are converted.
 * 
 * @author dschoenicke
 *
 */
@UtilityClass
public class TemplateBindingConverter {

	/**
	 * Static method converting a given list of {@link uml.UmlTemplateBinding}s to {@link code.CodeTemplateBinding}s
	 * 
	 * @param templateBindings the list of {@link uml.UmlTemplateBinding}s to be converted
	 * @param tmpModel the {@link umlcode.TemporaryModel} containing the maps to add temporary {@link code.CodeTemplateBinding}s to
	 * @return the converted {@link code.CodeTemplateBinding}s.
	 */
	public static List<CodeTemplateBinding> convertTemplateBindings(List<UmlTemplateBinding> templateBindings, TemporaryModel tmpModel) {
		List<CodeTemplateBinding> returnTemplateBindings = new ArrayList<>();
		templateBindings.forEach(templateBinding ->
			returnTemplateBindings.add(convertTemporaryTemplateBinding(templateBinding, tmpModel))
		);
		
		return returnTemplateBindings;
	}
	
	/**
	 * Static method converting a given {@link uml.UmlTemplateBinding} to a {@link code.CodeTemplateBinding} and adding it to the {@link umlcode.TemporaryModel}
	 * 
	 * @param templateBinding the {@link uml.UmlTemplateBinding} to be converted
	 * @param tmpModel the {@link umlcode.TemporaryModel} containing the map to add the temporary {@link code.CodeTemplateBinding} to
	 * @return the converted {@link code.CodeTemplateBinding}
	 */
	static CodeTemplateBinding convertTemporaryTemplateBinding(UmlTemplateBinding templateBinding, TemporaryModel tmpModel) {
		CodeTemplateBinding codeTemplateBinding = new CodeTemplateBinding();
		tmpModel.addTemporaryTemplateBinding(codeTemplateBinding, templateBinding.getParameterSubstitutions());
		return codeTemplateBinding;
	}
	
	/**
	 * Static method converting all temporary {@link code.CodeTemplateBinding}s stored in {@link umlcode.TemporaryModel}
	 * using the list of {@link uml.UmlParameterSubstitution}s stored in the map with the {@link code.CodeTemplateBinding}
	 * 
	 * @param tmpModel the {@link umlcode.TemporaryModel} containing the {@link code.CodeTemplateBinding}s and {@link code.CodeTemplateParameter}s necessary for the conversion
	 */
	public static void finishTemplateBindingConversions(TemporaryModel tmpModel) {
		tmpModel.getTemporaryTemplateBindings().forEach((templateBinding, parameterSubstitutions) -> {
			for (UmlParameterSubstitution parameterSubstitution : parameterSubstitutions) {
				assertNotNull("The converted CodeTemplateParameter for the UmlTemplateParameter " + 
					parameterSubstitution.getTemplateParameter().getName() + 
					" wasn't found in the TemporaryModel", 
					tmpModel.getConvertedTemplateParameters().get(parameterSubstitution.getTemplateParameter()));
			
				templateBinding.addParameterSubstitution(
						tmpModel.getConvertedTemplateParameters().get(parameterSubstitution.getTemplateParameter()), 
						parameterSubstitution.getSubstitutionType());
			}
		});
	}
}
