package converter.element;

import java.util.ArrayList;

import converter.temporary.TemporaryModel;
import converter.temporary.TemporaryTemplateBinding;
import model.ParameterSubstitution;
import model.TemplateBinding;
import model.UmlElement;
import model.UmlOperation;
import model.UmlParameterSubstitution;
import model.UmlTemplateBinding;

public class TemplateBindingConverter {

	public static void convertTemplateBindings(ArrayList<TemplateBinding> templateBindings, UmlOperation operation) {
		for (TemporaryTemplateBinding tmpBinding : convertTemporaryTemplateBindings(templateBindings)) {
			operation.addUmlTemplateBinding(tmpBinding);
		}
	}
	
	public static void convertTemplateBindings(ArrayList<TemplateBinding> templateBindings, UmlElement element) {
		for (TemporaryTemplateBinding tmpBinding : convertTemporaryTemplateBindings(templateBindings)) {
			element.addUmlTemplateBinding(tmpBinding);
		}
	}
	
	private static ArrayList<TemporaryTemplateBinding> convertTemporaryTemplateBindings(ArrayList<TemplateBinding> templateBindings) {
		ArrayList<TemporaryTemplateBinding> tmpBindings = new ArrayList<>();
		
		for (TemplateBinding templateBinding : templateBindings) {
			TemporaryTemplateBinding tmpBinding = new TemporaryTemplateBinding();
			
			for (ParameterSubstitution parameterSubstitution : templateBinding.getParameterSubstitutions()) {
				tmpBinding.addTemporarySubstitution(
						parameterSubstitution.getFormal(), 
						DataTypeConverter.convertDataType(parameterSubstitution.getActual(), parameterSubstitution.getPrimitiveActual())
				);
			}
		}
		
		return tmpBindings;
	}
	
	public static UmlTemplateBinding convertParameterSubstitutionID(TemporaryTemplateBinding tmpBinding, TemporaryModel tmpModel) {
		UmlTemplateBinding templateBinding = new UmlTemplateBinding();
		tmpBinding.getParameterSubstitutionMap().forEach((templateParameter, substitutionType) -> {
			if (tmpModel.getSubstitutionIDs().containsKey(templateParameter)) {
				templateBinding.addParameterSubstitution(new UmlParameterSubstitution(
					tmpModel.getSubstitutionIDs().get(templateParameter),
					(tmpModel.getElementIDs().containsKey(substitutionType) ? tmpModel.getElementIDs().get(substitutionType).getName() : substitutionType)
				));
			}
		});
		
		return templateBinding;
	}
}
