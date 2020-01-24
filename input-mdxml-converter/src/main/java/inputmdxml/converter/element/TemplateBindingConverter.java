package inputmdxml.converter.element;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import inputmdxml.temporary.TemporaryModel;
import inputmdxml.temporary.TemporaryTemplateBinding;
import mdxml.ParameterSubstitution;
import mdxml.TemplateBinding;
import uml.UmlElement;
import uml.UmlOperation;
import uml.UmlParameterSubstitution;
import uml.UmlTemplateBinding;

/**
 * Class providing static methods to convert {@link mdxml.TemplateBinding}s of {@link mdxml.PackagedElement}s and {@link mdxml.OwnedOperation}s to {@link uml.UmlTemplateBinding}s
 * 
 * @author dschoenicke
 *
 */
public class TemplateBindingConverter {

	private TemplateBindingConverter() {}
	
	/**
	 * Static method converting {@link mdxml.TemplateBinding}s of an {@link mdxml.OwnedOperation} to {@link inputmdxml.temporary.TemporaryTemplateBinding}s and adds them to the owning {@link uml.UmlOperation}
	 * 
	 * @param templateBindings a list of {@link mdxml.TemplateBinding}s which should be converted
	 * @param operation the {@link uml.UmlOperation} to which the converted {@link inputmdxml.temporary.TemporaryTemplateBinding}s should be added
	 */
	public static void convertTemplateBindings(List<TemplateBinding> templateBindings, UmlOperation operation) {
		for (TemporaryTemplateBinding tmpBinding : convertTemporaryTemplateBindings(templateBindings)) {
			operation.addTemplateBinding(tmpBinding);
		}
	}
	
	/**
	 * Static method converting {@link mdxml.TemplateBinding}s of an {@link mdxml.PackagedElement} to {@link inputmdxml.temporary.TemporaryTemplateBinding}s and adds them to the owning {@link uml.UmlElement}
	 * 
	 * @param templateBindings a list of {@link mdxml.TemplateBinding}s which should be converted
	 * @param element the {@link uml.UmlElement} to which the converted {@link inputmdxml.temporary.TemporaryTemplateBinding}s should be added
	 */
	public static void convertTemplateBindings(List<TemplateBinding> templateBindings, UmlElement element) {
		for (TemporaryTemplateBinding tmpBinding : convertTemporaryTemplateBindings(templateBindings)) {
			element.addTemplateBinding(tmpBinding);
		}
	}
	
	/**
	 * Static method converting a list of {@link mdxml.TemplateBinding}s to {@link inputmdxml.temporary.TemporaryTemplateBinding}s
	 * Adds information about the {@link mdxml.TemplateBinding}s' {@link mdxml.ParameterSubstitution}s to the converted {@link inputmdxml.temporary.TemporaryTemplateBinding}
	 * 
	 * @param templateBindings the list of {@link mdxml.TemplateBinding}s which should be converted
	 * @return the list of converted {@link inputmdxml.temporary.TemporaryTemplateBinding}s
	 */
	public static List<TemporaryTemplateBinding> convertTemporaryTemplateBindings(List<TemplateBinding> templateBindings) {
		List<TemporaryTemplateBinding> tmpBindings = new ArrayList<>();
		
		for (TemplateBinding templateBinding : templateBindings) {
			TemporaryTemplateBinding tmpBinding = new TemporaryTemplateBinding();
			tmpBindings.add(tmpBinding);
			
			for (ParameterSubstitution parameterSubstitution : templateBinding.getParameterSubstitutions()) {
				assertNotNull("The formal of a parameterSubstitution must not be null!\nOccurance in parameterSubstitution with id " + parameterSubstitution.getId(), parameterSubstitution.getFormal());
				
				tmpBinding.addTemporarySubstitution(
						parameterSubstitution.getFormal(), 
						DataTypeConverter.convertDataType(parameterSubstitution.getActual(), parameterSubstitution.getPrimitiveActual())
				);
			}
		}
		
		return tmpBindings;
	}
	
	/**
	 * Converts a {@link inputmdxml.temporary.TemporaryTemplateBinding} to a {@link uml.UmlTemplateBinding} with its {@link uml.UmlParameterSubstitution}s
	 * 
	 * @param tmpBinding the {@link inputmdxml.temporary.TemporaryTemplateBinding} which should be converted
	 * @param tmpModel the {@link inputmdxml.temporary.TemporaryModel} containing the information about the parameter substitution
	 * @return the converted {@link uml.UmlTemplateBinding}
	 */
	public static UmlTemplateBinding convertParameterSubstitutionID(TemporaryTemplateBinding tmpBinding, TemporaryModel tmpModel) {
		UmlTemplateBinding templateBinding = new UmlTemplateBinding();
		tmpBinding.getParameterSubstitutionMap().forEach((templateParameter, substitutionType) -> {
			if (tmpModel.getTemplateParameterIDs().containsKey(templateParameter)) {
				templateBinding.addParameterSubstitution(new UmlParameterSubstitution(
					tmpModel.getTemplateParameterIDs().get(templateParameter),
					(tmpModel.getElementIDs().containsKey(substitutionType) ? tmpModel.getElementIDs().get(substitutionType).getName() : substitutionType)
				));
			}
		});
		
		return templateBinding;
	}
}
