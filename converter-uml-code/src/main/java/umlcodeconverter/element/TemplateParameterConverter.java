package umlcodeconverter.element;

import java.util.List;

import code.CodeConstructor;
import code.CodeElement;
import code.CodeMethod;
import code.CodeParent;
import code.CodeTemplateParameter;
import uml.UmlTemplateParameter;
import umlcodeconverter.temporary.TemporaryModel;

/**
 * Provides static methods to convert {@link uml.UmlTemplateParameter}s to {@link code.CodeTemplateParameter}s and adding them to the {@link code.CodeParent}
 * 
 * @author dschoenicke
 *
 */
public class TemplateParameterConverter {

	private TemplateParameterConverter() {}
	
	/**
	 * Static method to convert {@link uml.UmlTemplateParameter}s to {@link code.CodeTemplateParameter}s and adding them to the {@link code.CodeParent}
	 * 
	 * @param templateParameters the list of {@link uml.UmlTemplateParameter}s to be converted
	 * @param codeParent the {@link code.CodeParent} to add the converted {@link code.CodeTemplateParameter}s to
	 * @param tmpModel the {@link umlcodeconverter.temporary.TemporaryModel} containing the map to add the converted {@link code.CodeTemplateParameter}s to
	 */
	public static void convertTemplateParameters(List<UmlTemplateParameter> templateParameters, CodeParent codeParent, TemporaryModel tmpModel) {
		for (UmlTemplateParameter templateParameter : templateParameters) {
			
			if (codeParent instanceof CodeElement) {
				((CodeElement) codeParent).addTemplateParameter(convertTemplateParameter(templateParameter, codeParent, tmpModel));
			}
			else if (codeParent instanceof CodeConstructor) {
				((CodeConstructor) codeParent).getTemplateParameters().add(convertTemplateParameter(templateParameter, codeParent, tmpModel));
			}
			else if (codeParent instanceof CodeMethod) {
				((CodeMethod) codeParent).getTemplateParameters().add(convertTemplateParameter(templateParameter, codeParent, tmpModel));
			}
			else {
				throw new IllegalArgumentException(codeParent.getName() + " is an invalid parent for a template parameter!");
			}
		}
	}
	
	/**
	 * Static method to convert a given {@link uml.UmlTemplateParameter} to a {@link code.CodeTemplateParameter}
	 * 
	 * @param templateParameter the {@link uml.UmlTemplateParameter} to be converted
	 * @param codeParent the {@link code.CodeParent} to add the converted {@link code.CodeTemplateParameter}s to
	 * @param tmpModel the {@link umlcodeconverter.temporary.TemporaryModel} containing the maps for converted {@link code.CodeTemplateParameter}s
	 * @return the converted {@link code.CodeTemplateParameter}
	 */
	 static CodeTemplateParameter convertTemplateParameter(UmlTemplateParameter templateParameter, CodeParent codeParent, TemporaryModel tmpModel) {
		CodeTemplateParameter codeTemplateParameter = new CodeTemplateParameter(templateParameter.getName(), codeParent, templateParameter.getType());
		tmpModel.addConvertedTemplateParameter(templateParameter, codeTemplateParameter);
		return codeTemplateParameter;
	}
}
