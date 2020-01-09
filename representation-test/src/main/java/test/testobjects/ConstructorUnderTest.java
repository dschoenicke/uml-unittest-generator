package test.testobjects;

import java.util.ArrayList;

/**
 * Represents a constructor of a {@link ClassUnderTest}.
 * 
 * @author dschoenicke
 *
 */
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
	 * Initializes the list of {@link ParamterUnderTest}.
	 * Adds the constructor to the parent {@link ClassUnderTest}.
	 * 
	 * @param the modifier value of the constructor under test.
	 * @param parent the parent {@link ClassUnderTest} of the constructor.
	 */
	public ConstructorUnderTest(int modifiers, ClassUnderTest parent) {
		this.modifiers = modifiers;
		this.parent = parent;
		parameters = new ArrayList<>();
		parent.addConstructor(this);
	}
	
	/**
	 * Gets the modifier value of the constructor under test.
	 * 
	 * @return the modifier value of the constructor.
	 */
	public int getModifiers() {
		return modifiers;
	}
	
	/**
	 * Sets the modifier value of the constructor under test.
	 * 
	 * @param modifiers the modifier value of the constructor.
	 */
	public void setModifiers(int modifiers) {
		this.modifiers = modifiers;
	}
	
	/**
	 * Gets the parent {@link ClassUnderTest} of the constructor under test.
	 * 
	 * @return the parent {@link ClassUnderTest} of the constructor under test.
	 */
	public ClassUnderTest getParent() {
		return parent;
	}
	
	/**
	 * Sets the parent {@link ClassUnderTest} of the constructor under test.
	 * 
	 * @return parent the parent {@link ClassUnderTest} of the constructor under test.
	 */
	public void setParent(ClassUnderTest parent) {
		this.parent = parent;
	}
	
	/**
	 * Gets the list of {@link ParameterUnderTest} of the constructor under test.
	 * 
	 * @return the list of {@link ParameterUnderTest} of the constructor under test.
	 */
	public ArrayList<ParameterUnderTest> getParameters() {
		return parameters;
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
