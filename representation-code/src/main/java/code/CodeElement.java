package code;

import java.util.ArrayList;

/**
 * Abstract class extended by {@link CodeClass}es, {@link CodeInterface}s and {@link CodeEnumeration}s
 * 
 * @author dschoenicke
 *
 */
public abstract class CodeElement implements CodeParent {
	
	/**
	 * The name of the element
	 */
	private String name;
	
	/**
	 * The {@link CodeParent} of the element
	 */
	private CodeParent parent;
	
	/**
	 * The list of {@link CodeField}s of the element
	 */
	private ArrayList<CodeField> fields;
	
	/**
	 * The list of {@link CodeMethod}s of the element
	 */
	private ArrayList<CodeMethod> methods;
	
	/**
	 * The list of {@link CodeTemplateBinding}s of the element
	 */
	private ArrayList<CodeTemplateBinding> templateBindings;
	
	/**
	 * The list of {@link CodeTemplateParameter}s of the element
	 */
	private ArrayList<CodeTemplateParameter> templateParameters;
	
	/**
	 * The list of nested elements of the element
	 */
	private ArrayList<CodeElement> nestedElements;
	
	/**
	 * An integer representing the {@link CodeModifier} determining the elements modifiers
	 */
	private int modifiers;
	
	/**
	 * Constructor with name, {@link CodeParent} and modifiers.<br>
	 * The modifiers are converted to an int value usable for the {@link CodeModifier} methods.<br>
	 * Initializes the lists of {@link CodeField}s, {@link CodeMethod}s, {@link CodeTemplateBinding}s, {@link CodeTemplateParameter}s and nested {@link CodeElement}s.
	 * 
	 * @param name the name of the element
	 * @param parent the {@link CodeParent} of the element
	 * @param visibility the {@link CodeVisibility} value representing the access modifier of the element
	 * @param isAbstract determines whether the element is abstract
	 * @param isStatic determines whether the element is static
	 * @param isFinal determines whether the element is final
	 */
	public CodeElement(String name, 
			CodeParent parent,
			CodeVisibility visibility, 
			boolean isAbstract, 
			boolean isStatic, 
			boolean isFinal) {
		
		this.name = name;
		this.parent = parent;
		modifiers = CodeModifier.convertModifierValue(visibility, isStatic, isFinal, isAbstract);
		fields = new ArrayList<>();
		methods = new ArrayList<>();
		templateBindings = new ArrayList<>();
		templateParameters = new ArrayList<>();
		nestedElements = new ArrayList<>();
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
	 * Gets the {@link CodeParent} of the element
	 * 
	 * @return the {@link CodeParent} of the element
	 */
	public CodeParent getParent() {
		return parent;
	}

	/**
	 * Sets the {@link CodeParent} of the element
	 * 
	 * @param parent the {@link CodeParent} of the element
	 */
	public void setParent(CodeParent parent) {
		this.parent = parent;
	}

	/**
	 * Gets the list of {@link CodeField}s
	 * 
	 * @return the list of {@link CodeField}s
	 */
	public ArrayList<CodeField> getFields() {
		return fields;
	}

	/**
	 * Adds a {@link CodeField} to the list
	 * 
	 * @param field the {@link CodeField} to add to the list
	 */
	public void addField(CodeField field) {
		fields.add(field);
	}

	/**
	 * Gets the list of {@link CodeMethod}s
	 * 
	 * @return the list of {@link CodeMethod}s
	 */
	public ArrayList<CodeMethod> getMethods() {
		return methods;
	}

	/**
	 * Adds a {@link CodeMethod} to the list
	 * 
	 * @param method the {@link CodeMethod} to add to the list
	 */
	public void addMethod(CodeMethod method) {
		methods.add(method);
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

	/**
	 * Gets the list of nested elements
	 * 
	 * @return the list of nested elements
	 */
	public ArrayList<CodeElement> getNestedElements() {
		return nestedElements;
	}

	/**
	 * Adds a nested element to the list
	 * 
	 * @param nestedElement the nested element to add to the list
	 */
	public void addNestedElement(CodeElement nestedElement) {
		nestedElements.add(nestedElement);
	}

	/**
	 * Gets the int value representing the {@link CodeModifier}s of the element
	 * 
	 * @return the int value representing the {@link CodeModifier}s of the element
	 */
	public int getModifiers() {
		return modifiers;
	}

	/**
	 * Sets the modifiers value of the element
	 * 
	 * @param modifiers the modifiers element
	 */
	public void setModifiers(int modifiers) {
		this.modifiers = modifiers;
	}
}
