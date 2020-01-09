package test.testobjects;

import java.util.ArrayList;

/**
 * Represents a method of a {@link ClassUnderTest}.
 * 
 * @author dschoenicke
 *
 */
public class MethodUnderTest implements TestObject {

	/**
	 * The name of the method under test.
	 */
	private String name;
	
	/**
	 * The modifier value of the method under test.
	 */
	private int modifiers;
	
	/**
	 * The parent {@link ClassUnderTest} of the method.
	 */
	private ClassUnderTest parent;
	
	/**
	 * The {@link ParameterUnderTest} representing the return type of the method.
	 */
	private ParameterUnderTest returnType;
	
	/**
	 * The list of {@link ParameterUnderTest} of the method.
	 */
	private ArrayList<ParameterUnderTest> parameters;
	
	/**
	 * Constructor with name, modifier value, parent {@link ClassUnderTest} and {@link ParameterUnderTest} as return type.
	 * Initializes the list of {@link ParamterUnderTest}.
	 * Adds the method to the list of methods of the parent {@link ClassUnderTest}.
	 * 
	 * @param name the name of the method under test.
	 * @param the modifier value of the method under test.
	 * @param parent the parent {@link ClassUnderTest} of the method under test.
	 */
	public MethodUnderTest(String name, int modifiers, ClassUnderTest parent, ParameterUnderTest returnType) {
		this.name = name;
		this.modifiers = modifiers;
		this.parent = parent;
		this.returnType = returnType;
		parameters = new ArrayList<>();
		parent.addMethod(this);
	}
	
	/**
	 * Gets the name of the method under test.
	 * 
	 * @return the name of the method under test.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the method under test.
	 * 
	 * @param the name of the method under test.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the modifier value of the method under test.
	 * 
	 * @return the modifier value of the method.
	 */
	public int getModifiers() {
		return modifiers;
	}
	
	/**
	 * Sets the modifier value of the method under test.
	 * 
	 * @param modifiers the modifier value of the method.
	 */
	public void setModifiers(int modifiers) {
		this.modifiers = modifiers;
	}
	
	/**
	 * Gets the parent {@link ClassUnderTest} of the method under test.
	 * 
	 * @return the parent {@link ClassUnderTest} of the method under test.
	 */
	public ClassUnderTest getParent() {
		return parent;
	}
	
	/**
	 * Sets the parent {@link ClassUnderTest} of the method under test.
	 * 
	 * @return parent the parent {@link ClassUnderTest} of the method under test.
	 */
	public void setParent(ClassUnderTest parent) {
		this.parent = parent;
	}
	
	/**
	 * Gets the {@link ParameterUnderTest} representing the return type of the method under test.
	 * 
	 * @return the {@link ParameterUnderTest} representing the return type of the method under test.
	 */
	public ParameterUnderTest getReturnType() {
		return returnType;
	}
	
	/**
	 * Sets the {@link ParameterUnderTest} representing the return type of the method under test.
	 * 
	 * @param returnType the {@link ParameterUnderTest} representing the return type of the method under test.
	 */
	public void setReturnType(ParameterUnderTest returnType) {
		this.returnType = returnType;
	}
	
	/**
	 * Gets the list of {@link ParameterUnderTest} of the method under test.
	 * 
	 * @return the list of {@link ParameterUnderTest} of the method under test.
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
