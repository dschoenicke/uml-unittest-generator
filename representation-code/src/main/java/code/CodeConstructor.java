package code;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

/**
 * Represents a constructor of a {@link CodeElement}
 * 
 * @author dschoenicke
 *
 */
@Getter
public class CodeConstructor {
	
	/**
	 * An integer representing the modifier value
	 */
	private int modifiers;
	
	/**
	 * The list of {@link CodeParameter}s of the constructor
	 */
	private List<CodeParameter> parameters;
	
	/**
	 * The list of {@link CodeTemplateBinding}s of the constructor
	 */
	private List<CodeTemplateBinding> templateBindings;
	
	/**
	 * The list of {@link CodeTemplateParameter}s of the constructor
	 */
	private List<CodeTemplateParameter> templateParameters;
	
	/**
	 * Constructor with modifiers.
	 * Initializes the lists for {@link CodeParameter}s, {@link CodeTemplateBinding}s and {@link CodeTemplateParameter}s
	 * 
	 * @param modifiers the modifier value of the class
	 */
	public CodeConstructor(int modifiers) {
		this.modifiers = modifiers;
		parameters = new ArrayList<>();
		templateBindings = new ArrayList<>();
		templateParameters = new ArrayList<>();
	}
}
