package mdxmlconverter.temporary;

import lombok.Getter;
import lombok.Setter;
import mdxml.OwnedAttribute;
import mdxmlconverter.element.DataTypeConverter;
import mdxmlconverter.element.ModifierConverter;
import mdxmlconverter.multiplicity.MultiplicityConverter;
import uml.UmlAttribute;

/**
 * TemporaryAttribute extends the {@link uml.UmlAttribute} with additional fields for the 'association' and 'aggregation' attributes of the {@link mdxml.OwnedAttribute}
 * 
 * @author dschoenicke
 *
 */
@Getter
public class TemporaryAttribute extends UmlAttribute {
	
	/**
	 * Reference to the association realizing this attribute
	 * @see mdxml.OwnedAttribute#association
	 */
	private String association;
	
	/**
	 * Describes the aggregation type if the attribute is realized by an aggregation
	 * @see mdxml.OwnedAttribute#aggregation
	 */
	@Setter private String aggregation;
	
	/**
	 * Constructor extending the {@link uml.UmlAttribute} constructor with association and aggregation
	 * 
	 * @param ownedAttribute the {@link mdxml.OwnedAttribute} containing to be converted
	 */
	public TemporaryAttribute(OwnedAttribute ownedAttribute) {
		super(ownedAttribute.getName(),
				ModifierConverter.convertAccessModifier(ownedAttribute.getVisibility()), 
				DataTypeConverter.convertDataType(ownedAttribute.getAssociationType(), ownedAttribute.getDataType()), 
				ModifierConverter.convertNonAccessModifier(ownedAttribute.getIsStatic()), 
				ModifierConverter.convertNonAccessModifier(ownedAttribute.getIsFinal()),
				(ownedAttribute.getDefaultValue() != null ? ownedAttribute.getDefaultValue().getValue() : ""), 
				MultiplicityConverter.convertLowerValue(ownedAttribute.getLowerValue()), 
				MultiplicityConverter.convertUpperValue(ownedAttribute.getUpperValue()));
		
		association = ownedAttribute.getAssociation();
		aggregation = ownedAttribute.getAggregation();
	}
}
