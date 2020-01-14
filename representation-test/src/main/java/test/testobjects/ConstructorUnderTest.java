package test.testobjects;

import java.util.ArrayList;

import lombok.Getter;

/**
 * Represents a constructor of a {@link ClassUnderTest}.
 * 
 * @author dschoenicke
 *
 */
@Getter
public class ConstructorUnderTest implements TestObject {
	
	/**
	 * The modifier value of the constructor under test.
	 */
	private int modifiers;
	
	/**
	 * The parent {@link ClassUnderTest} of the constructor.
	 */
	private ClassUnderTest parent;
	
	/**
	 * The list of {@link ParameterUnderTest} of the constructor.
	 */
	private ArrayList<ParameterUnderTest> parameters;
	
	/**
	 * Constructor with modifier value.
	 * Initializes the list of {@link ParameterUnderTest}.
	 * Adds the constructor to the parent {@link ClassUnderTest}.
	 * 
	 * @param modifiers the modifier value of the constructor under test.
	 * @param parent the parent {@link ClassUnderTest} of the constructor.
	 */
	public ConstructorUnderTest(int modifiers, ClassUnderTest parent) {
		this.modifiers = modifiers;
		this.parent = parent;
		parameters = new ArrayList<>();
		parent.getConstructors().add(this);
	}
	
	/**
	 * Adds a {@link ParameterUnderTest} to the list.
	 * 
	 * @param parameter the {@link ParameterUnderTest} to be added to the list.
	 */
	public void addParameter(ParameterUnderTest parameter) {
		parameters.add(parameter);
	}
}
