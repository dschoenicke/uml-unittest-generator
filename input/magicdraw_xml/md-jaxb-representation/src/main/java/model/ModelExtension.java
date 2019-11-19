package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

/**
 * Represents an auxiliary node in the XML tree held by an {@link Extension}
 * Holds {@link LowerValue}s and {@link UpperValue}s when used by an {@link OwnedAttribute}
 * or {@link OwnedDiagram}s when used by the {@link Model}
 * 
 * @author dschoenicke
 *
 */
public class ModelExtension {

	/**
	 * The list of {@link OwnedDiagram}s if the {@link Extension}, which holds this model extension, 
	 * is used by the {@link Model}
	 */
	private ArrayList<OwnedDiagram> ownedDiagrams;
	
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
	public ModelExtension() {
		ownedDiagrams = new ArrayList<OwnedDiagram>();
	}
	
	/**
	 * Gets the list of {@link OwnedDiagram}s
	 * 
	 * @return the list of {@link OwnedDiagram}s
	 */
	@XmlElement(name = "ownedDiagram")
	public ArrayList<OwnedDiagram> getOwnedDiagrams() {
		return ownedDiagrams;
	}
	
	/**
	 * Sets the list of {@link OwnedDiagram}s
	 * 
	 * @param ownedDiagrams the list of {@link OwnedDiagram}s
	 */
	public void setOwnedDiagrams(ArrayList<OwnedDiagram> ownedDiagrams) {
		this.ownedDiagrams = ownedDiagrams;
	}
	
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
