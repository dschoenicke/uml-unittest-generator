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
					ownedAttribute.getDefaultValue().getValue(), 
					MultiplicityConverter.convertLowerValue(ownedAttribute.getLowerValue()), 
					MultiplicityConverter.convertUpperValue(ownedAttribute.getUpperValue()), 
					ownedAttribute.getAssociation(),
					ownedAttribute.getAggregation()
				);
			
			element.addAttribute(attribute);
			tmpModel.addAttribute(ownedAttribute.getId(), attribute);
		}
	}
	
	public static UmlAttribute convertTemporaryAttribute(TemporaryAttribute tmpAttribute, TemporaryModel tmpModel) {
		return new UmlAttribute(
				tmpAttribute.getName(),
				tmpAttribute.getVisibility(),
				(tmpAttribute.getAssociation() != null) ? DataTypeConverter.convertElementID(tmpAttribute.getType(), tmpModel) : tmpAttribute.getType(),
				tmpAttribute.isStatic(),
				tmpAttribute.isFinal(),
				tmpAttribute.getDefaultValue(),
				tmpAttribute.getLowerValue(),
				tmpAttribute.getUpperValue()
			);
	}
}
