package mdxmlconverter.element;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;

import mdxml.OwnedOperation;
import mdxml.OwnedParameter;
import mdxmlconverter.multiplicity.MultiplicityConverter;
import mdxmlconverter.temporary.TemporaryModel;
import uml.UmlOperation;
import uml.UmlParameter;

/**
 * Class providing a static method to convert {@link mdxml.OwnedParameter}s of an {@link mdxml.OwnedOperation} to {@link uml.UmlParameter}s
 * 
 * @author dschoenicke
 *
 */
public class ParameterConverter {

	/**
	 * Static method converting all {@link mdxml.OwnedParameter}s of a given {@link mdxml.OwnedOperation} and adds them to the owning {@link uml.UmlOperation} and the {@link mdxmlconverter.temporary.TemporaryModel}
	 * 
	 * @param ownedOperation the {@link mdxml.OwnedOperation} which {@link mdxml.OwnedParameter}s should be converted
	 * @param operation the {@link uml.UmlOperation} to which the converted {@link uml.UmlParameter}s should be added
	 * @param tmpModel the {@link mdxmlconverter.temporary.TemporaryModel} to which the converted {@link uml.UmlParameter}s should be added
	 */
	public static void convertParameters(OwnedOperation ownedOperation, UmlOperation operation, TemporaryModel tmpModel) {
	
		for (OwnedParameter ownedParameter : ownedOperation.getOwnedParameters()) {
			assertNotNull("The direction of an ownedParameter must not be null!\nOccurance in " + operation.getName() + "(), parameter with id " + ownedParameter.getId());
			assertFalse("The name of an ownedParameter with direction 'in' must not be null!\nOccurance in " + operation.getName() + "() with id " + ownedOperation.getId(), (ownedParameter.getName() == null && ownedParameter.getDirection().equals("in")));
			
			UmlParameter parameter = new UmlParameter(
					(ownedParameter.getName() == null) ? "" : ownedParameter.getName(),
					DataTypeConverter.convertDataType(ownedParameter.getAssociationType(), ownedParameter.getDataType()),
					ParameterDirectionConverter.convertDirection(ownedParameter.getDirection()),
					ModifierConverter.convertNonAccessModifier(ownedParameter.getIsFinal()),
					MultiplicityConverter.convertLowerValue(ownedParameter.getLowerValue()),
					MultiplicityConverter.convertUpperValue(ownedParameter.getUpperValue())
			);
			
			operation.addParameter(parameter);
			tmpModel.addParameter(parameter);
		}
	}
}
