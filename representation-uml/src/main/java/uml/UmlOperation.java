package uml;

import java.util.ArrayList;

import core.representation.Node;

public class UmlOperation implements Node {

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
	 * List of {@link UmlTemplateBinding}s of the operation
	 */
	private ArrayList<UmlTemplateBinding> templateBindings;
	
	/**
	 * List of {@link UmlTemplateParameter}s of the operation
	 */
	private ArrayList<UmlTemplateParameter> templateParameters;
	
	/**
	 * Constructor with name and visibility, initializes the list for the {@link UmlParameter}s, {@link UmlTemplateBinding}s and {@link UmlTemplateParameter}s
	 * 
	 * @param name the name of the element
	 * @param visibility the {@link UmlVisibility} of the element
	 */
	public UmlOperation(String name, UmlVisibility visibility) {
		this.name = name;
		this.visibility = visibility;
		parameters = new ArrayList<UmlParameter>();
		templateBindings = new ArrayList<UmlTemplateBinding>();
		templateParameters = new ArrayList<UmlTemplateParameter>();
	}
	
	/**
	 * Constructor with name, visibility and static-, final-, and abstract-operationifiers, initializes the list for {@link UmlParameter}s, {@link UmlTemplateBinding}s and {@link UmlTemplateParameter}s
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
		templateBindings = new ArrayList<UmlTemplateBinding>();
		templateParameters = new ArrayList<UmlTemplateParameter>();
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
	
	/**
	 * Returns the list of {@link UmlTemplateBinding}s
	 * 
	 * @return the list of {@link UmlTemplateBinding}s
	 */
	public ArrayList<UmlTemplateBinding> getUmlTemplateBindings() {
		return templateBindings;
	}
	
	/**
	 * Adds an {@link UmlTemplateBinding} to the list
	 * 
	 * @param templateBinding the {@link UmlTemplateBinding} to add
	 */
	public void addUmlTemplateBinding(UmlTemplateBinding templateBinding) {
		templateBindings.add(templateBinding);
	}
	
	/**
	 * Returns the list of {@link UmlTemplateParameter}s
	 * 
	 * @return the list of {@link UmlTemplateParameter}s
	 */
	public ArrayList<UmlTemplateParameter> getTemplateParameters() {
		return templateParameters;
	}
	
	/**
	 * Adds an {@link UmlTemplateParameter} to the list
	 * 
	 * @param templateParameter the {@link UmlTemplateParameter} to add
	 */
	public void addTemplateParameter(UmlTemplateParameter templateParameter) {
		templateParameters.add(templateParameter);
	}
	
	/**
	 * Returns true, if the operation is a constructor.<br>
	 * A constructor is defined as a method without a {@link UmlParameter} with {@link UmlParameterDirection#RETURN}
	 * 
	 * @return true, if the operation is a constructor, false otherwise
	 */
	public boolean isConstructor() {
		for (UmlParameter parameter : parameters) {
			if (parameter.getDirection() == UmlParameterDirection.RETURN) {
				return false;
			}
		}
		
		return true;
	}
}
