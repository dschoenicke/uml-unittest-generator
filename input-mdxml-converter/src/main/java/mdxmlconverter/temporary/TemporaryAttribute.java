package mdxmlconverter.temporary;

import lombok.Getter;
import lombok.Setter;
import uml.UmlAttribute;
import uml.UmlMultiplicityValue;
import uml.UmlVisibility;

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
	 * @param name the name of the attribute
	 * @param visibility the {@link UmlVisibility} of the attribute
	 * @param type the data type of the attribute
	 * @param isStatic true if the attribute is static
	 * @param isFinal true if the attribute is final
	 * @param defaultValue the default value of the attribute
	 * @param lowerValue the lower multiplicity value
	 * @param upperValue the upper multiplicity value
	 * @param association the reference to the association
	 * @param aggregation the type of the aggregation
	 */
	public TemporaryAttribute(String name, 
			UmlVisibility visibility, 
			String type, 
			boolean isStatic, 
			boolean isFinal, 
			String defaultValue,
			UmlMultiplicityValue lowerValue, 
			UmlMultiplicityValue upperValue,
			String association,
			String aggregation) {
		super(name, visibility, type, isStatic, isFinal, defaultValue, lowerValue, upperValue);
		this.association = association;
		this.aggregation = aggregation;
	}
}
