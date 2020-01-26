package umlcode.converter.element;

import java.util.ArrayList;
import java.util.List;

import code.CodeTemplateParameter;
import lombok.experimental.UtilityClass;
import uml.UmlTemplateParameter;
import umlcode.TemporaryModel;

/**
 * Provides static methods to convert {@link uml.UmlTemplateParameter}s to {@link code.CodeTemplateParameter}s and adding them to the {@link code.CodeParent}
 * 
 * @author dschoenicke
 *
 */
@UtilityClass
public class TemplateParameterConverter {

	/**
	 * Static method to convert {@link uml.UmlTemplateParameter}s to {@link code.CodeTemplateParameter}s and adding them to the {@link code.CodeParent}
	 * 
	 * @param templateParameters the list of {@link uml.UmlTemplateParameter}s to be converted
	 * @param tmpModel the {@link umlcode.TemporaryModel} containing the map to add the converted {@link code.CodeTemplateParameter}s to
	 * @return the converted {@link code.CodeTemplateParameter}s.
	 */
	public static List<CodeTemplateParameter> convertTemplateParameters(List<UmlTemplateParameter> templateParameters, TemporaryModel tmpModel) {
		List<CodeTemplateParameter> returnTemplateParameters = new ArrayList<>();
		templateParameters.forEach(templateParameter -> 
			returnTemplateParameters.add(convertTemplateParameter(templateParameter, tmpModel))
		);
		
		return returnTemplateParameters;
	}
	
	/**
	 * Static method to convert a given {@link uml.UmlTemplateParameter} to a {@link code.CodeTemplateParameter}
	 * 
	 * @param templateParameter the {@link uml.UmlTemplateParameter} to be converted
	 * @param tmpModel the {@link umlcode.TemporaryModel} containing the maps for converted {@link code.CodeTemplateParameter}s
	 * @return the converted {@link code.CodeTemplateParameter}
	 */
	 static CodeTemplateParameter convertTemplateParameter(UmlTemplateParameter templateParameter, TemporaryModel tmpModel) {
		CodeTemplateParameter codeTemplateParameter = new CodeTemplateParameter(templateParameter.getName(), templateParameter.getType());
		tmpModel.addConvertedTemplateParameter(templateParameter, codeTemplateParameter);
		return codeTemplateParameter;
	}
}
