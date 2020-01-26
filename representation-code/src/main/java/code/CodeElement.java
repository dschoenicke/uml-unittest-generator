package code;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.Getter;
import lombok.Setter;

/**
 * Abstract class extended by {@link CodeClass}es, {@link CodeInterface}s and {@link CodeEnumeration}s
 * 
 * @author dschoenicke
 *
 */
@Getter
public abstract class CodeElement {
	
	/**
	 * The name of the element
	 */
	private String name;
	
	/**
	 * The fully qualified name of the element
	 */
	@Setter private String qualifiedName;
	
	/**
	 * The parent {@link CodePackage} of the element
	 */
	private CodePackage parent;
	
	/**
	 * The list of {@link CodeField}s of the element
	 */
	private List<CodeField> fields;
	
	/**
	 * An integer representing the modifier value
	 */
	private int modifiers;
	
	/**
	 * The list of {@link CodeConstructor}s of the element
	 */
	private List<CodeConstructor> constructors;
	
	/**
	 * The list of {@link CodeMethod}s of the element
	 */
	private List<CodeMethod> methods;
	
	/**
	 * The list of {@link CodeTemplateBinding}s of the element
	 */
	private List<CodeTemplateBinding> templateBindings;
	
	/**
	 * The list of {@link CodeTemplateParameter}s of the element
	 */
	private List<CodeTemplateParameter> templateParameters;
	
	/**
	 * The list of implemented or extended {@link CodeInterface}s of the element
	 */
	private List<CodeInterface> interfaces;
	
	/**
	 * The list of nested elements of the element
	 */
	private List<CodeElement> nestedElements;
	
	/**
	 * The nest host element of the element
	 */
	@Setter private Optional<CodeElement> nestHost;
	
	/**
	 * Constructor with name, fully qualified name, {@link CodePackage} and modifiers.<br>
	 * Initializes the lists of {@link CodeField}s, {@link CodeConstructor}s, {@link CodeMethod}s, {@link CodeTemplateBinding}s, {@link CodeTemplateParameter}s, {@link CodeInterface}s and nested {@link CodeElement}s.<br>
	 * Sets the qualified name to the name value since it is set afterwards.<br>
	 * Sets the nest host to empty.
	 * 
	 * @param name the name of the element
	 * @param parent the parent {@link CodePackage} of the element
	 * @param modifiers the modifier value of the class
	 */
	public CodeElement(String name, 
			CodePackage parent,
			int modifiers) {
		
		this.name = name;
		this.qualifiedName = name;
		this.parent = parent;
		this.modifiers = modifiers;
		this.nestHost = Optional.empty();
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
	public List<CodeElement> getNestedElementsAsList() {
		ArrayList<CodeElement> ownedElements = new ArrayList<>();
		nestedElements.forEach(nestedElement -> {
			ownedElements.add(nestedElement);
			ownedElements.addAll(nestedElement.getNestedElementsAsList());
		});
		return ownedElements;
	}
}
