package converter.element;

import converter.auxiliary.MultiplicityConverter;
import converter.temporary.TemporaryAttribute;
import converter.temporary.TemporaryModel;
import model.OwnedAttribute;
import model.PackagedElement;
import model.UmlAttribute;
import model.UmlElement;

public class AttributeConverter {

	public static void convertAttributes(PackagedElement packagedElement, UmlElement element, TemporaryModel tmpModel) {
		for (OwnedAttribute ownedAttribute : packagedElement.getOwnedAttributes()) {
	
			UmlAttribute attribute = new TemporaryAttribute(ownedAttribute.getName(), 
					VisibilityConverter.convertVisibility(ownedAttribute.getVisibility()), 
					DataTypeConverter.convertDataType(ownedAttribute.getAssociationType(), ownedAttribute.getDataType()), 
					ClassifierConverter.convertClassifier(ownedAttribute.getIsStatic()), 
					ClassifierConverter.convertClassifier(ownedAttribute.getIsFinal()),
					(ownedAttribute.getDefaultValue() != null ? ownedAttribute.getDefaultValue().getValue() : ""), 
					MultiplicityConverter.convertLowerValue(ownedAttribute.getLowerValue()), 
					MultiplicityConverter.convertUpperValue(ownedAttribute.getUpperValue()), 
					ownedAttribute.getAssociation(),
					ownedAttribute.getAggregation()
				);
			
			element.addAttribute(attribute);
			tmpModel.addAttribute(ownedAttribute.getId(), attribute);
		}
	}
}
