package umlcodeconverter.element;

import static org.junit.Assert.assertNotNull;

import code.CodeElement;
import code.CodeMethod;
import uml.UmlElement;
import uml.UmlMultiplicityValue;
import uml.UmlOperation;
import uml.UmlParameter;
import uml.UmlParameterDirection;
import umlcodeconverter.temporary.TemporaryModel;

/**
 * Provides a static method to convert {@link uml.UmlOperation}s of an {@link uml.UmlElement} to {@link code.CodeMethod}s and adding them to the {@link code.CodeElement}
 * 
 * @author dschoenicke
 *
 */
public class MethodConverter {

	/**
	 * Static method to convert {@link uml.UmlOperation}s of an {@link uml.UmlElement} to {@link code.CodeMethod}s and adding them to the {@link code.CodeElement}.<br>
	 * Delegates the conversion of {@link code.CodeParameter}s to the {@link umlcodeconverter.element.ParameterConverter}<br>
	 * Delegates the conversion of {@link code.CodeTemplateParameter}s to the {@link umlcodeconverter.element.TemplateParameterConverter}<br>
	 * 
	 * @param element the {@link uml.UmlElement} which {@link uml.UmlOperation} should be converted
	 * @param codeElement the {@link code.CodeElement} to which the converted {@link code.CodeMethod}s should be added to
	 * @param tmpModel the {@link umlcodeconverter.temporary.TemporaryModel} containing the maps to add temporary {@link code.CodeTemplateBinding}s and converted {@link code.CodeTemplateParameter}s to
	 */
	public static void convertMethods(UmlElement element, CodeElement codeElement, TemporaryModel tmpModel) {
		for (UmlOperation operation : element.getOperations()) {
			if (operation.isConstructor()) {
				continue;
			}
			
			UmlParameter returnParameter = getOperationReturnParameter(operation);
			assertNotNull("The operation " + element.getName() + "." + operation.getName() + " has no return parameter!", returnParameter);
			CodeMethod method = new CodeMethod(
					operation.getName(),
					codeElement,
					returnParameter.getType(),
					(returnParameter.getUpperValue() == UmlMultiplicityValue.INFINITE),
					ModifierConverter.convertAccessModifier(operation.getVisibility()),
					operation.isAbstract(),
					operation.isStatic(),
					operation.isFinal()
				);
			
			ParameterConverter.convertParameters(operation, method);
			TemplateParameterConverter.convertTemplateParameters(operation.getTemplateParameters(), method, tmpModel);
			TemplateBindingConverter.convertTemplateBindings(operation.getUmlTemplateBindings(), method, tmpModel);
			codeElement.addMethod(method);
		}
	}
	
	/**
	 * Returns the {@link uml.UmlParameter} of the given {@link uml.UmlOperation} with {@link uml.UmlParameterDirection#RETURN}.
	 * 
	 * @param operation the {@link uml.UmlOperation} to get the return {@link uml.UmlParameter} of
	 * @return the {@link uml.UmlParameter} with {@link uml.UmlParameterDirection#RETURN} or {@literal null} if there is none.
	 */
	public static UmlParameter getOperationReturnParameter(UmlOperation operation) {
		UmlParameter returnParameter = null;
		
		for (UmlParameter parameter : operation.getParameters()) {
			if (parameter.getDirection() == UmlParameterDirection.RETURN) {
				returnParameter = parameter;
				break;
			}
		}
		
		return returnParameter;
	}
}
