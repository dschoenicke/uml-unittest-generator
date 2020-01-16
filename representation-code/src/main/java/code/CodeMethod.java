package code;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents a method of a {@link CodeElement}
 * 
 * @author dschoenicke
 *
 */
@Getter
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
	@Setter private CodeParameter returnType;
	
	/**
	 * An integer representing the modifier value
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
	 * Initializes the lists for {@link CodeParameter}s, {@link CodeTemplateBinding}s and {@link CodeTemplateParameter}s
	 * 
	 * @param name the name of the method
	 * @param parent the {@link CodeParent} element of the method
	 * @param returnType the {@link CodeParameter} representing the return type of the method
	 * @param hasMultiplicity true if the field has a multiplicity
	 * @param modifiers the modifier value of the class
	 */
	public CodeMethod(String name,
			CodeParent parent,
			CodeParameter returnType,
			boolean hasMultiplicity,
			int modifiers) {
		
		this.name = name;
		this.parent = parent;
		this.returnType = returnType;
		this.hasMultiplicity = hasMultiplicity;
		this.modifiers = modifiers;
		parameters = new ArrayList<CodeParameter>();
		templateBindings = new ArrayList<CodeTemplateBinding>();
		templateParameters = new ArrayList<CodeTemplateParameter>();
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
}
