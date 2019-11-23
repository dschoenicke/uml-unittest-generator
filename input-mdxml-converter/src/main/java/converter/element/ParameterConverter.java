package converter.element;

import converter.auxiliary.MultiplicityConverter;
import converter.temporary.TemporaryModel;
import mdxml.OwnedOperation;
import mdxml.OwnedParameter;
import uml.UmlOperation;
import uml.UmlParameter;

public class ParameterConverter {

	public static void convertParameters(OwnedOperation ownedOperation, UmlOperation operation, TemporaryModel tmpModel) {
	
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
			tmpModel.addParameter(parameter);
		}
	}
}
