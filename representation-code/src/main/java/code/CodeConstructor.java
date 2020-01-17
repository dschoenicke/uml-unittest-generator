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
public class CodeConstructor implements CodeParent {
	
	/**
	 * The {@link CodeParent} of the constructor
	 */
	private CodeParent parent;
	
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
	 * Constructor with {@link CodeParent} and modifiers.
	 * Initializes the lists for {@link CodeParameter}s, {@link CodeTemplateBinding}s and {@link CodeTemplateParameter}s
	 * 
	 * @param parent the {@link CodeParent} element of the constructor
	 * @param modifiers the modifier value of the class
	 */
	public CodeConstructor(CodeParent parent, int modifiers) {
		this.parent = parent;
		this.modifiers = modifiers;
		parameters = new ArrayList<>();
		templateBindings = new ArrayList<>();
		templateParameters = new ArrayList<>();
	}

	/**
	 * Gets the name of the {@link CodeParent}.
	 * 
	 * @return the name of the {@link CodeParent}.
	 */
	@Override
	public String getName() {
		return parent.getName();
	}
}
