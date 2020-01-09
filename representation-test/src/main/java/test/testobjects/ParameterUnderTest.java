package test.testobjects;

/**
 * Represents a parameter of a {@link ConstructorUnderTest} or a {@link MethodUnderTest}.
 * 
 * @author dschoenicke
 *
 */
public class ParameterUnderTest implements TestObject {

	/**
	 * The name of the parameter under test.
	 */
	private String name;
	
	/**
	 * The fully qualified name of the type of the parameter under test.
	 */
	private String type;
	
	/**
	 * The modifier value of the parameter under test.
	 */
	private int modifiers;
	
	/**
	 * Determines whether the parameter can be {@literal null} to indicate a check for type Optional.
	 */
	private boolean canBeNull;
	
	/**
	 * Determines whether the parameter has a multiplicity to indicate a check for Collections or Arrays.
	 */
	private boolean hasMultiplicity;
	
	/**
	 * Constructor with name, type, modifier value and boolean values whether the parameter under test can be {@literal null} or has a multiplicity.
	 * 
	 * @param namre the name of the parameter under test.
	 * @param the fully qualified name of the type of the parameter under test.
	 * @param the modifier value of the parameter under test.
	 * @param canBeNull boolean value determining whether the parameter can be {@literal null}.
	 * @param hasMultiplicity boolean value determining whether the parameter has a multiplicity.
	 */
	public ParameterUnderTest(String name,
			String type,
			int modifiers,
			boolean canBeNull,
			boolean hasMultiplicity) {
		this.name = name;
		this.type = type;
		this.modifiers = modifiers;
		this.canBeNull = canBeNull;
		this.hasMultiplicity = hasMultiplicity;
	}
	
	/**
	 * Gets the fully qualified name of the parameter under test.
	 * 
	 * @return the fully qualified name of the parameter under test.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the parameter under test.
	 * 
	 * @param name the name of the parameter under test.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the fully qualified name of the type of the parameter under test.
	 * 
	 * @return the fully qualified name of the type of the parameter under test.
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Sets the fully qualified name of the type of the parameter under test.
	 * 
	 * @param qualifiedName the fully qualified name of the type of the parameter under test.
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Gets the modifier value of the parameter under test.
	 * 
	 * @return the modifier value of the parameter.
	 */
	public int getModifiers() {
		return modifiers;
	}
	
	/**
	 * Sets the modifier value of the parameter under test.
	 * 
	 * @param modifiers the modifier value of the parameter.
	 */
	public void setModifiers(int modifiers) {
		this.modifiers = modifiers;
	}
	
	/**
	 * Gets the boolean value determining whether the parameter can be {@literal null}.
	 * 
	 * @return true, if the parameter under test can be {@literal null}.
	 */
	public boolean canBeNull() {
		return canBeNull;
	}
	
	/**
	 * Sets the boolean value determining whether the parameter can be {@literal null}.
	 * 
	 * @param canBeNull true, if the parameter under test can be {@literal null}.
	 */
	public void canBeNull(boolean canBeNull) {
		this.canBeNull = canBeNull;
	}
	
	/**
	 * Gets the boolean value determining whether the parameter has a multiplicity.
	 * 
	 * @return true, if the parameter under test has a multiplicity.
	 */
	public boolean hasMultiplicity() {
		return hasMultiplicity;
	}
	
	/**
	 * Sets the boolean value determining whether the parameter has a multiplicity.
	 * 
	 * @param hasMultiplicity true, if the parameter under test has a multiplicity.
	 */
	public void hasMulitplicity(boolean hasMultiplicity) {
		this.hasMultiplicity = hasMultiplicity;
	}
}
