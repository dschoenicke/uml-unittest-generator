package code;

import java.util.ArrayList;

/**
 * Represents a constructor of a {@link CodeElement}
 * 
 * @author dschoenicke
 *
 */
public class CodeConstructor implements CodeParent {

	/**
	 * The name of the constructor
	 */
	private String name;
	
	/**
	 * The {@link CodeParent} of the constructor
	 */
	private CodeParent parent;
	
	/**
	 * An integer representing the {@link CodeModifier} determining the constructor's modifiers
	 */
	private int modifiers;
	
	/**
	 * The list of {@link CodeParameter}s of the constructor
	 */
	private ArrayList<CodeParameter> parameters;
	
	/**
	 * The list of {@link CodeTemplateBinding}s of the constructor
	 */
	private ArrayList<CodeTemplateBinding> templateBindings;
	
	/**
	 * The list of {@link CodeTemplateParameter}s of the constructor
	 */
	private ArrayList<CodeTemplateParameter> templateParameters;
	
	/**
	 * Constructor with name, {@link CodeParent} and modifiers.
	 * The modifiers are converted to an int value usable for the {@link CodeModifier} constructors.<br>
	 * Initializes the lists for {@link CodeParameter}s, {@link CodeTemplateBinding}s and {@link CodeTemplateParameter}s
	 * 
	 * @param name the name of the constructor
	 * @param parent the {@link CodeParent} element of the constructor
	 * @param visibility the {@link CodeVisibility} value representing the access modifier of the field
	 */
	public CodeConstructor(String name,
			CodeParent parent,
			CodeVisibility visibility
			) {
		
		this.name = name;
		this.parent = parent;
		this.modifiers = CodeModifier.convertModifierValue(visibility, false, false, false);
		parameters = new ArrayList<CodeParameter>();
		templateBindings = new ArrayList<CodeTemplateBinding>();
		templateParameters = new ArrayList<CodeTemplateParameter>();
	}
	
	
	/**
	 * Gets the name of the constructor
	 * 
	 * @return the name of the constructor
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the constructor
	 * 
	 * @param name the name of the constructor
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the {@link CodeParent} of the constructor
	 * 
	 * @return the {@link CodeParent} of the constructor
	 */
	public CodeParent getParent() {
		return parent;
	}

	/**
	 * Sets the {@link CodeParent} of the constructor
	 * 
	 * @param parent the {@link CodeParent} of the constructor
	 */
	public void setParent(CodeParent parent) {
		this.parent = parent;
	}
	
	/**
	 * Gets the int value representing the {@link CodeModifier}s of the constructor
	 * 
	 * @return the int value representing the {@link CodeModifier}s of the constructor
	 */
	public int getModifiers() {
		return modifiers;
	}

	/**
	 * Sets the modifiers value of the constructor
	 * 
	 * @param modifiers the modifiers constructor
	 */
	public void setModifiers(int modifiers) {
		this.modifiers = modifiers;
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
