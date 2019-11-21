package converter.element;

import converter.auxiliary.MultiplicityConverter;
import model.OwnedOperation;
import model.OwnedParameter;
import model.UmlOperation;
import model.UmlParameter;

public class ParameterConverter {

	public static void convertParameters(OwnedOperation ownedOperation, UmlOperation operation) {
	
		for (OwnedParameter ownedParameter : ownedOperation.getOwnedParameters()) {
			
			UmlParameter parameter = new UmlParameter(
					ownedParameter.getName(),
					DataTypeConverter.convertDataType(ownedParameter.getAssociationType(), ownedParameter.getDataType()),
					ParameterDirectionConverter.convertDirection(ownedParameter.getDirection()),
					ClassifierConverter.convertClassifier(ownedParameter.getIsFinal()),
					MultiplicityConverter.convertLowerValue(ownedParameter.getLowerValue()),
					MultiplicityConverter.convertUpperValue(ownedParameter.getUpperValue())
			);
			
			operation.addParameter(parameter);
		}
	}
}
