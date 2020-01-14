package code;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

/**
 * Abstract class extended by {@link CodeClass}es, {@link CodeInterface}s and {@link CodeEnumeration}s
 * 
 * @author dschoenicke
 *
 */
@Getter
public abstract class CodeElement implements CodeParent {
	
	/**
	 * The name of the element
	 */
	private String name;
	
	/**
	 * The fully qualified name of the element
	 */
	@Setter private String qualifiedName;
	
	/**
	 * The parent {@link CodeParent} of the element
	 */
	private CodeParent parent;
	
	/**
	 * The list of {@link CodeField}s of the element
	 */
	private ArrayList<CodeField> fields;
	
	/**
	 * An integer representing the {@link CodeModifier} determining the elements modifiers
	 */
	private int modifiers;
	
	/**
	 * The list of {@link CodeConstructor}s of the element
	 */
	private ArrayList<CodeConstructor> constructors;
	
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
	 * The list of implemented or extended {@link CodeInterface}s of the element
	 */
	private ArrayList<CodeInterface> interfaces;
	
	/**
	 * The list of nested elements of the element
	 */
	private ArrayList<CodeElement> nestedElements;
	
	/**
	 * Constructor with name, fully qualified name, {@link CodeParent} and modifiers.<br>
	 * The modifiers are converted to an int value usable for the {@link CodeModifier} methods.<br>
	 * Initializes the lists of {@link CodeField}s, {@link CodeConstructor}s, {@link CodeMethod}s, {@link CodeTemplateBinding}s, {@link CodeTemplateParameter}s, {@link CodeInterface}s and nested {@link CodeElement}s.<br>
	 * Sets the qualified name to the name value since it is set afterwards.
	 * 
	 * @param name the name of the element
	 * @param parent the parent {@link CodeParent} of the element
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
		this.qualifiedName = name;
		this.parent = parent;
		modifiers = CodeModifier.convertModifierValue(visibility, isStatic, isFinal, isAbstract);
		fields = new ArrayList<>();
		constructors = new ArrayList<>();
		methods = new ArrayList<>();
		templateBindings = new ArrayList<>();
		templateParameters = new ArrayList<>();
		interfaces = new ArrayList<>();
		nestedElements = new ArrayList<>();
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
	 * Adds a {@link CodeConstructor} to the list
	 * 
	 * @param constructor the {@link CodeConstructor} to add to the list
	 */
	public void addConstructor(CodeConstructor constructor) {
		constructors.add(constructor);
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
	 * Adds a {@link CodeTemplateBinding} to the list
	 * 
	 * @param templateBinding the {@link CodeTemplateBinding} to add to the list
	 */
	public void addTemplateBinding(CodeTemplateBinding templateBinding) {
		templateBindings.add(templateBinding);
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
	 * Adds an implemented or extended {@link CodeInterface} to the list
	 * 
	 * @param codeInterface the implemented or extended {@link CodeInterface} to add to the list
	 */
	public void addInterface(CodeInterface codeInterface) {
		interfaces.add(codeInterface);
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
	 * Returns all nested elements regardless of their hierarchy
	 * 
	 * @return all nested elements regardless of their hierarchy
	 */
	public ArrayList<CodeElement> getNestedElementsAsList() {
		ArrayList<CodeElement> ownedElements = new ArrayList<>();
		nestedElements.forEach(nestedElement -> {
			ownedElements.add(nestedElement);
			ownedElements.addAll(nestedElement.getNestedElementsAsList());
		});
		return ownedElements;
	}
}
