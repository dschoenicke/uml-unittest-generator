package test.testobjects;

/**
 * Represents a field of a {@link ClassUnderTest}
 * 
 * @author dschoenicke
 *
 */
public class FieldUnderTest implements TestObject {

	/**
	 * The name of the field under test.
	 */
	private String name;
	
	/**
	 * The fully qualified name of the type of the field under test.
	 */
	private String type;
	
	/**
	 * The modifier value of the field under test.
	 */
	private int modifiers;
	
	/**
	 * The parent {@link ClassUnderTest} of the field under test.
	 */
	private ClassUnderTest parent;
	
	/**
	 * Determines whether the field can be {@literal null} to indicate a check for type Optional.
	 */
	private boolean canBeNull;
	
	/**
	 * Determines whether the field has a multiplicity to indicate a check for Collections or Arrays.
	 */
	private boolean hasMultiplicity;
	
	/**
	 * Constructor with name, type, modifier value and boolean values whether the field under test can be {@literal null} or has a multiplicity.
	 * Adds the field to the list of fields of the parent {@link ClassUnderTest}.
	 * 
	 * @param name the name of the field under test.
	 * @param type the fully qualified name of the type of the field under test.
	 * @param modifier the modifier value of the field under test.
	 * @param parent the parent {@link ClassUnderTest} of the field under test.
	 * @param canBeNull boolean value determining whether the field can be {@literal null}.
	 * @param hasMultiplicity boolean value determining whether the field has a multiplicity.
	 */
	public FieldUnderTest(String name,
			String type,
			int modifiers,
			ClassUnderTest parent,
			boolean canBeNull,
			boolean hasMultiplicity) {
		this.name = name;
		this.type = type;
		this.modifiers = modifiers;
		this.parent = parent;
		this.canBeNull = canBeNull;
		this.hasMultiplicity = hasMultiplicity;
		parent.addField(this);
	}
	
	/**
	 * Gets the name of the field under test.
	 * 
	 * @return the name of the field under test.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the field under test.
	 * 
	 * @param name the name of the field under test.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the fully qualified name of the type of the field under test.
	 * 
	 * @return the fully qualified name of the type of the field under test.
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Sets the fully qualified name of the type of the field under test.
	 * 
	 * @param qualifiedName the fully qualified name of the type of the field under test.
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Gets the modifier value of the field under test.
	 * 
	 * @return the modifier value of the field.
	 */
	public int getModifiers() {
		return modifiers;
	}
	
	/**
	 * Sets the modifier value of the field under test.
	 * 
	 * @param modifiers the modifier value of the field.
	 */
	public void setModifiers(int modifiers) {
		this.modifiers = modifiers;
	}
	
	/**
	 * Gets the parent {@link ClassUnderTest} of the field under test.
	 * 
	 * @return the parent {@link ClassUnderTest} of the field under test.
	 */
	public ClassUnderTest getParent() {
		return parent;
	}
	
	/**
	 * Sets the parent {@link ClassUnderTest} of the field under test.
	 * 
	 * @return parent the parent {@link ClassUnderTest} of the field under test.
	 */
	public void setParent(ClassUnderTest parent) {
		this.parent = parent;
	}
	
	/**
	 * Gets the boolean value determining whether the field can be {@literal null}.
	 * 
	 * @return true, if the field under test can be {@literal null}.
	 */
	public boolean canBeNull() {
		return canBeNull;
	}
	
	/**
	 * Sets the boolean value determining whether the field can be {@literal null}.
	 * 
	 * @param canBeNull true, if the field under test can be {@literal null}.
	 */
	public void canBeNull(boolean canBeNull) {
		this.canBeNull = canBeNull;
	}
	
	/**
	 * Gets the boolean value determining whether the field has a multiplicity.
	 * 
	 * @return true, if the field under test has a multiplicity.
	 */
	public boolean hasMultiplicity() {
		return hasMultiplicity;
	}
	
	/**
	 * Sets the boolean value determining whether the field has a multiplicity.
	 * 
	 * @param hasMultiplicity true, if the field under test has a multiplicity.
	 */
	public void hasMulitplicity(boolean hasMultiplicity) {
		this.hasMultiplicity = hasMultiplicity;
	}
}
