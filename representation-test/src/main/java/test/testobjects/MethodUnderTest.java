package test.testobjects;

import java.util.ArrayList;

import lombok.Getter;

/**
 * Represents a method of a {@link ClassUnderTest}.
 * 
 * @author dschoenicke
 *
 */
@Getter
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
		parent.getMethods().add(this);
	}
}
