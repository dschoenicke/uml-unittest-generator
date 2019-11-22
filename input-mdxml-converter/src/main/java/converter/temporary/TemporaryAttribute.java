package converter.temporary;

import model.UmlAttribute;
import model.UmlMultiplicityValue;
import model.UmlVisibility;

public class TemporaryAttribute extends UmlAttribute {
	
	private String association;
	private String aggregation;
	
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

	public String getAssociation() {
		return association;
	}

	public void setAssociation(String association) {
		this.association = association;
	}

	public String getAggregation() {
		return aggregation;
	}

	public void setAggregation(String aggregation) {
		this.aggregation = aggregation;
	}
}
