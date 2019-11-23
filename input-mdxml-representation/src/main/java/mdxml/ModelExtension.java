package mdxml;

import javax.xml.bind.annotation.XmlElement;

import core.representation.Node;

/**
 * Represents an auxiliary node in the XML tree held by an {@link Extension}
 * Holds {@link LowerValue}s and {@link UpperValue}s when used by an {@link OwnedAttribute}
 * 
 * @author dschoenicke
 *
 */
public class ModelExtension implements Node {
	
	/**
	 * The {@link LowerValue} of the {@link OwnedAttribute} which uses the {@link Extension} which holds this model extension
	 */
	private LowerValue lowerValue;
	
	/**
	 * The {@link UpperValue} of the {@link OwnedAttribute} which uses the {@link Extension} which holds this model extension
	 */
	private UpperValue upperValue;
	
	/**
	 * Default constructor
	 */
	public ModelExtension() {}
	
	/**
	 * Gets the {@link LowerValue} object
	 * 
	 * @return the {@link LowerValue} object
	 */
	@XmlElement(name = "lowerValue")
	public LowerValue getLowerValue() {
		return lowerValue;
	}
	
	/**
	 * Sets the {@link LowerValue} object
	 * 
	 * @param lowerValue the {@link LowerValue} object
	 */
	public void setLowerValue(LowerValue lowerValue) {
		this.lowerValue = lowerValue;
	}
	
	/**
	 * Gets the {@link UpperValue} object
	 * 
	 * @return the {@link UpperValue} object
	 */
	@XmlElement(name = "upperValue")
	public UpperValue getUpperValue() {
		return upperValue;
	}
	
	/**
	 * Sets the {@link UpperValue} object
	 * 
	 * @param upperValue the {@link UpperValue} object
	 */
	public void setUpperValue(UpperValue upperValue) {
		this.upperValue = upperValue;
	}
}
