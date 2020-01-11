package test.testobjects;

import lombok.Getter;

/**
 * Represents a field of a {@link ClassUnderTest}
 * 
 * @author dschoenicke
 *
 */
@Getter
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
		parent.getFields().add(this);
	}
}
