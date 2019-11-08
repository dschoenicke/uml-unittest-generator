package model;

import java.util.ArrayList;

public class UmlOperation {

	/**
	 * The name of the operation
	 */
	private String name;
	
	/**
	 * The visibility of the operation
	 */
	private UmlVisibility visibility;
	
	/**
	 * Determines whether the operation is static
	 */
	private boolean  isStatic;
	
	/**
	 * Determines whether the operation is final
	 */
	private boolean  isFinal;
	
	/**
	 * Determines whether the operation is abstract
	 */
	private boolean  isAbstract;
	
	/**
	 * List of {@link UmlParameter}s of the operation
	 */
	private ArrayList<UmlParameter> parameters;
	
	/**
	 * Constructor with name and visibility, initializes the list for the {@link UmlParameter}s
	 * 
	 * @param name the name of the element
	 * @param visibility the {@link UmlVisibility} of the element
	 */
	public UmlOperation(String name, UmlVisibility visibility) {
		this.name = name;
		this.visibility = visibility;
		parameters = new ArrayList<UmlParameter>();
	}
	
	/**
	 * Constructor with name, visibility and static-, final-, and abstract-operationifiers, initializes the list for {@link UmlParameter}s
	 * 
	 * @param name the name of the operation
	 * @param visibility the {@link UmlVisibility} of the operation
	 * @param isStatic true if the operation is static
	 * @param isFinal true if the operation is final
	 * @param isAbstract true if the operation is abstract
	 */
	public UmlOperation(String name, UmlVisibility visibility, boolean isStatic, boolean isFinal, boolean isAbstract) {
		this.name = name;
		this.visibility = visibility;
		this.isStatic = isStatic;
		this.isFinal = isFinal;
		this.isAbstract = isAbstract;
		parameters = new ArrayList<UmlParameter>();
	}
	
	/**
	 * Gets the name of the element
	 * 
	 * @return the name of the element
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the element
	 * 
	 * @param name the name of the element
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the {@link UmlVisibility} of the element
	 * 
	 * @return the {@link UmlVisibility} of the element
	 */
	public UmlVisibility getVisibility() {
		return visibility;
	}
	
	/**
	 * Sets the {@link UmlVisibility} of the element
	 * 
	 * @param visibility the {@link UmlVisibility} of the element
	 */
	public void setVisibility(UmlVisibility visibility) {
		this.visibility = visibility;
	}
	
	/**
	 * Returns true if the operation is static
	 * 
	 * @return true if the operation is static
	 */
	public boolean isStatic() {
		return isStatic;
	}

	/**
	 * Sets the static value
	 * 
	 * @param isStatic the static value
	 */
	public void setStatic(boolean isStatic) {
		this.isStatic = isStatic;
	}

	/**
	 * Returns true if the operation is final
	 * 
	 * @return true if the operation is final
	 */
	public boolean isFinal() {
		return isFinal;
	}

	/**
	 * Sets the final value
	 * 
	 * @param isFinal the final value
	 */
	public void setFinal(boolean isFinal) {
		this.isFinal = isFinal;
	}

	/**
	 * Returns true if the operation is abstract
	 * 
	 * @return true if the operation is abstract
	 */
	public boolean isAbstract() {
		return isAbstract;
	}

	/**
	 * Sets the abstract value
	 * 
	 * @param isAbstract the abstract value
	 */
	public void setAbstract(boolean isAbstract) {
		this.isAbstract = isAbstract;
	}
	
	/**
	 * Gets the list of {@link UmlParameter}s
	 * 
	 * @return the list of {@link UmlParameter}s
	 */
	public ArrayList<UmlParameter> getParameters() {
		return parameters;
	}
	
	/**
	 * Adds an {@link UmlParameter} to the list
	 * 
	 * @param parameter the {@link UmlParameter} to add to the list 
	 */
	public void addParameter(UmlParameter parameter) {
		parameters.add(parameter);
	}
}
