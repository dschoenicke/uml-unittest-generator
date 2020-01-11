package code;

import java.util.ArrayList;

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
	 * Constructor with {@link CodeParent} and modifiers.
	 * The modifiers are converted to an int value usable for the {@link CodeModifier} constructors.<br>
	 * Initializes the lists for {@link CodeParameter}s, {@link CodeTemplateBinding}s and {@link CodeTemplateParameter}s
	 * 
	 * @param parent the {@link CodeParent} element of the constructor
	 * @param visibility the {@link CodeVisibility} value representing the access modifier of the field
	 */
	public CodeConstructor(CodeParent parent, CodeVisibility visibility) {
		this.parent = parent;
		this.modifiers = CodeModifier.convertModifierValue(visibility, false, false, false);
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
