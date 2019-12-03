package umlcodeconverter.element;

import code.CodeConstructor;
import code.CodeMethod;
import code.CodeParameter;
import code.CodeParent;
import uml.UmlMultiplicityValue;
import uml.UmlOperation;
import uml.UmlParameter;
import uml.UmlParameterDirection;

/**
 * Provides a static method to convert {@link uml.UmlParameter}s of an {@link uml.UmlElement} to {@link code.CodeParameter}s and adding them to the {@link code.CodeConstructor} or {@link code.CodeMethod}
 * 
 * @author dschoenicke
 *
 */
public class ParameterConverter {

	/**
	 * Static method converting the {@link uml.UmlParameter}s of an {@link uml.UmlOperation} with {@link uml.UmlParameterDirection#IN} to {@link code.CodeParameter}s and adding them to a {@link code.CodeMethod}.
	 * 
	 * @param operation the {@link uml.UmlOperation} containing the {@link uml.UmlParameter}s
	 * @param method the {@link code.CodeMethod} to which the converted {@link code.CodeParameter}s should be added to
	 */
	public static void convertParameters(UmlOperation operation, CodeMethod method) {
		for (UmlParameter parameter : operation.getParameters()) {
			if (parameter.getDirection() == UmlParameterDirection.IN) {
				method.addParameter(createParameter(parameter, method));
			}
		}
	}
	
	/**
	 * Static method converting the {@link uml.UmlParameter}s of an {@link uml.UmlOperation} with {@link uml.UmlParameterDirection#IN} to {@link code.CodeParameter}s and adding them to a {@link code.CodeConstructor}.
	 * 
	 * @param operation the {@link uml.UmlOperation} containing the {@link uml.UmlParameter}s
	 * @param constructor the {@link code.CodeConstructor} to which the converted {@link code.CodeParameter}s should be added to
	 */
	public static void convertParameters(UmlOperation operation, CodeConstructor constructor) {
		for (UmlParameter parameter : operation.getParameters()) {
			if (parameter.getDirection() == UmlParameterDirection.IN) {
				constructor.addParameter(createParameter(parameter, constructor));
			}
		}
	}
	
	/**
	 * Static method converting a given {@link uml.UmlParameter} to a {@link code.CodeParameter} and adding it to the {@link code.CodeParent}
	 * 
	 * @param parameter the {@link uml.UmlParameter} to be converted
	 * @param parent the {@link code.CodeParent} to which the converted {@link code.CodeParameter} should be added to
	 * @return the converted {@link code.CodeParameter}
	 */
	static CodeParameter createParameter(UmlParameter parameter, CodeParent parent) {
		return new CodeParameter(
						parameter.getName(),
						parent,
						parameter.getType(),
						(parameter.getUpperValue() == UmlMultiplicityValue.INFINITE),
						parameter.isFinal()
					);
	}
}
