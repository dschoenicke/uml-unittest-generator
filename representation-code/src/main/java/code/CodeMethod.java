package code;

import java.util.ArrayList;

/**
 * Represents a method of a {@link CodeElement}
 * 
 * @author dschoenicke
 *
 */
public class CodeMethod implements CodeParent {

	/**
	 * The name of the method
	 */
	private String name;
	
	/**
	 * The {@link CodeParent} of the method
	 */
	private CodeParent parent;
	
	/**
	 * The return type of the method
	 */
	private String returnType;
	
	/**
	 * An integer representing the {@link CodeModifier} determining the method's modifiers
	 */
	private int modifiers;
	
	/**
	 * Determines whether the method has a multiplicity
	 */
	private boolean hasMultiplicity;
	
	/**
	 * The list of {@link CodeParameter}s of the method
	 */
	private ArrayList<CodeParameter> parameters;
	
	/**
	 * The list of {@link CodeTemplateBinding}s of the method
	 */
	private ArrayList<CodeTemplateBinding> templateBindings;
	
	/**
	 * The list of {@link CodeTemplateParameter}s of the method
	 */
	private ArrayList<CodeTemplateParameter> templateParameters;
	
	/**
	 * Constructor with name, {@link CodeParent}, return type, value whether the return value has a multiplicity and modifiers.
	 * The modifiers are converted to an int value usable for the {@link CodeModifier} methods.<br>
	 * Initializes the lists for {@link CodeParameter}s, {@link CodeTemplateBinding}s and {@link CodeTemplateParameter}s
	 * 
	 * @param name the name of the method
	 * @param parent the {@link CodeParent} element of the method
	 * @param returnType the return type of the attribute
	 * @param hasMultiplicity true if the field has a multiplicity
	 * @param visibility the {@link CodeVisibility} value representing the access modifier of the field
	 * @param isAbstract determines whether the field is abstract
	 * @param isStatic determines whether the field is static
	 * @param isFinal determines whether the field is final
	 */
	public CodeMethod(String name,
			CodeParent parent,
			String returnType,
			boolean hasMultiplicity,
			CodeVisibility visibility,
			boolean isAbstract,
			boolean isStatic,
			boolean isFinal
			) {
		
		this.name = name;
		this.parent = parent;
		this.returnType = returnType;
		this.hasMultiplicity = hasMultiplicity;
		this.modifiers = CodeModifier.convertModifierValue(visibility, isStatic, isFinal, isAbstract);
		parameters = new ArrayList<CodeParameter>();
		templateBindings = new ArrayList<CodeTemplateBinding>();
		templateParameters = new ArrayList<CodeTemplateParameter>();
	}
	
	
	/**
	 * Gets the name of the method
	 * 
	 * @return the name of the method
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the method
	 * 
	 * @param name the name of the method
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the {@link CodeParent} of the method
	 * 
	 * @return the {@link CodeParent} of the method
	 */
	public CodeParent getParent() {
		return parent;
	}

	/**
	 * Sets the {@link CodeParent} of the method
	 * 
	 * @param parent the {@link CodeParent} of the method
	 */
	public void setParent(CodeParent parent) {
		this.parent = parent;
	}
	
	/**
	 * Gets the int value representing the {@link CodeModifier}s of the method
	 * 
	 * @return the int value representing the {@link CodeModifier}s of the method
	 */
	public int getModifiers() {
		return modifiers;
	}

	/**
	 * Sets the modifiers value of the method
	 * 
	 * @param modifiers the modifiers method
	 */
	public void setModifiers(int modifiers) {
		this.modifiers = modifiers;
	}
	
	/**
	 * Gets the return type of the method
	 * 
	 * @return the return type of the method
	 */
	public String getReturnType() {
		return returnType;
	}
	
	/**
	 * Sets the return type of the method
	 * 
	 * @param returnType the return type of the method
	 */
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
	
	/**
	 * Returns true, if the field has a multiplicity
	 * 
	 * @return true, if the field has a multiplicity
	 */
	public boolean hasMultiplicity() {
		return hasMultiplicity;
	}

	/**
	 * Sets the value determining whether the method return type can have a multiplicity
	 * 
	 * @param hasMultiplicity the value determining whether the method return type can have a multiplicity
	 */
	public void setHasMultiplicity(boolean hasMultiplicity) {
		this.hasMultiplicity = hasMultiplicity;
	}
	
	/**
	 * Gets the list of {@link CodeParameter}s
	 * 
	 * @return the list of {@link CodeParameter}s
	 */
	public ArrayList<CodeParameter> getParameters() {
		return parameters;
	}

	/**
	 * Adds a {@link CodeParameter} to the list
	 * 
	 * @param parameter the {@link CodeParameter} to add to the list
	 */
	public void addParameter(CodeParameter parameter) {
		parameters.add(parameter);
	}

	/**
	 * Gets the list of {@link CodeTemplateBinding}s
	 * 
	 * @return the list of {@link CodeTemplateBinding}s
	 */
	public ArrayList<CodeTemplateBinding> getTemplateBindings() {
		return templateBindings;
	}

	/**
	 * Adds a {@link CodeTemplateBinding} to the list
	 * 
	 * @param templateBinding the {@link CodeTemplateBinding} to add to the list
	 */
	public void addTemplateBinding(CodeTemplateBinding templateBinding) {
		templateBindings.add(templateBinding);
	}

	/**
	 * Gets the list of {@link CodeTemplateParameter}s
	 * 
	 * @return the list of {@link CodeTemplateParameter}s
	 */
	public ArrayList<CodeTemplateParameter> getTemplateParameters() {
		return templateParameters;
	}

	/**
	 * Adds a {@link CodeTemplateParameter} to the list
	 * 
	 * @param templateParameter the {@link CodeTemplateParameter} to add to the list
	 */
	public void addTemplateParameter(CodeTemplateParameter templateParameter) {
		templateParameters.add(templateParameter);
	}
}
