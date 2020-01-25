package umlcode.converter.element;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import code.CodeConstructor;
import code.CodeElement;
import code.CodeMethod;
import code.CodeParent;
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
	 * @param codeParent the {@link code.CodeParent} to add the converted {@link code.CodeTemplateBinding} to
	 * @param tmpModel the {@link umlcode.TemporaryModel} containing the maps to add temporary {@link code.CodeTemplateBinding}s to
	 */
	public static void convertTemplateBindings(List<UmlTemplateBinding> templateBindings, CodeParent codeParent, TemporaryModel tmpModel) {
		for (UmlTemplateBinding templateBinding : templateBindings) {
			convertTemporaryTemplateBinding(templateBinding, codeParent, tmpModel);
		}
	}
	
	/**
	 * Static method converting a given {@link uml.UmlTemplateBinding} to a {@link code.CodeTemplateBinding} and adding it to the {@link umlcode.TemporaryModel}
	 * 
	 * @param templateBinding the {@link uml.UmlTemplateBinding} to be converted
	 * @param codeParent the {@link code.CodeParent} to add the converted {@link code.CodeTemplateBinding} to
	 * @param tmpModel the {@link umlcode.TemporaryModel} containing the map to add the temporary {@link code.CodeTemplateBinding} to
	 */
	static void convertTemporaryTemplateBinding(UmlTemplateBinding templateBinding, CodeParent codeParent, TemporaryModel tmpModel) {
		CodeTemplateBinding codeTemplateBinding = new CodeTemplateBinding();
		tmpModel.addTemporaryTemplateBinding(codeTemplateBinding, templateBinding.getParameterSubstitutions());
		
		if (codeParent instanceof CodeElement) {
			((CodeElement) codeParent).addTemplateBinding(codeTemplateBinding);
		}
		else if (codeParent instanceof CodeConstructor) {
			((CodeConstructor) codeParent).getTemplateBindings().add(codeTemplateBinding);
		}
		else if (codeParent instanceof CodeMethod) {
			((CodeMethod) codeParent).getTemplateBindings().add(codeTemplateBinding);
		}
		else {
			throw new IllegalArgumentException(codeParent.getName() + " is an invalid parent for a template binding!");
		}
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