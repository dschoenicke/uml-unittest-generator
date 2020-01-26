package code;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents a method of a {@link CodeElement}
 * 
 * @author dschoenicke
 *
 */
@Getter
public class CodeMethod {

	/**
	 * The name of the method
	 */
	private String name;
	
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
	private List<CodeParameter> parameters;
	
	/**
	 * The list of {@link CodeTemplateBinding}s of the method
	 */
	private List<CodeTemplateBinding> templateBindings;
	
	/**
	 * The list of {@link CodeTemplateParameter}s of the method
	 */
	private List<CodeTemplateParameter> templateParameters;
	
	/**
	 * Constructor with name, return type, value whether the return value has a multiplicity and modifiers.
	 * Initializes the lists for {@link CodeParameter}s, {@link CodeTemplateBinding}s and {@link CodeTemplateParameter}s
	 * 
	 * @param name the name of the method
	 * @param returnType the {@link CodeParameter} representing the return type of the method
	 * @param hasMultiplicity true if the field has a multiplicity
	 * @param modifiers the modifier value of the class
	 */
	public CodeMethod(String name,
			CodeParameter returnType,
			boolean hasMultiplicity,
			int modifiers) {
		
		this.name = name;
		this.returnType = returnType;
		this.hasMultiplicity = hasMultiplicity;
		this.modifiers = modifiers;
		parameters = new ArrayList<>();
		templateBindings = new ArrayList<>();
		templateParameters = new ArrayList<>();
	}
}
