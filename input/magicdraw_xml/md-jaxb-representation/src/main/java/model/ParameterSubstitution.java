package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Represents a substitution of a template {@link Parameter}
 * 
 * @author dschoenicke
 *
 */
public class ParameterSubstitution {
	
	private String id;
	
	/**
	 * References the {@link Parameter} used in this substitution by its id
	 */
	private String formal;
	
	/**
	 * References the {@link PackagedElement} which replaces the {@link Parameter} by its id
	 */
	private String actual;
	
	/**
	 * Reference to the type replacing the {@link Parameter} if it is a primitive type
	 */
	private Actual primitiveActual;
	
	/**
	 * Default constructor
	 */
	public ParameterSubstitution() {}

	/**
	 * Gets the id of the parameter substitution
	 * 
	 * @return the id of the parameter substitution
	 */
	@XmlElement(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	public String getId() {
		return id;
	}

	/**
	 * Sets the id of the parameter substitution
	 * 
	 * @param id the id of the parameter substitution
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the id of the {@link Parameter}
	 * 
	 * @return the id of the {@link Parameter}
	 */
	@XmlAttribute(name = "formal")
	public String getFormal() {
		return formal;
	}

	/**
	 * Sets the id of the {@link Parameter}
	 * 
	 * @param formal the id of the {@link Parameter}
	 */
	public void setFormal(String formal) {
		this.formal = formal;
	}

	/**
	 * Gets the id of the {@link PackagedElement} which replaces the {@link Parameter}
	 * 
	 * @return the id of the {@link PackagedElement} which replaces the {@link Parameter}
	 */
	@XmlAttribute(name = "actual")
	public String getActual() {
		return actual;
	}

	/**
	 * Sets the id of the {@link PackagedElement} which replaces the {@link Parameter}
	 * 
	 * @param actual the id of the {@link PackagedElement} which replaces the {@link Parameter}
	 */
	public void setActual(String actual) {
		this.actual = actual;
	}
	
	/**
	 * Gets the {@link Actual} which describes the primitive type replacing the {@link Parameter}
	 * 
	 * @return the {@link Actual} which describes the primitive type replacing the {@link Parameter}
	 */
	@XmlElement(name = "actual")
	public Actual getPrimitiveActual() {
		return primitiveActual;
	}

	/**
	 * Sets the {@link Actual} which describes the primitive type replacing the {@link Parameter}
	 * 
	 * @param primitiveActual the {@link Actual} which describes the primitive type replacing the {@link Parameter}
	 */
	public void setPrimitiveActual(Actual primitiveActual) {
		this.primitiveActual = primitiveActual;
	}
}
