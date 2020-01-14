package test.testobjects;

import java.util.ArrayList;
import java.util.Optional;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents the class under test of a {@link test.TestClass}.
 * 
 * @author dschoenicke
 *
 */
@Getter
public class ClassUnderTest implements TestObject {

	/**
	 * The fully qualified name of the class.
	 */
	private String qualifiedName;
	
	/**
	 * The qualified name of the super class of the class under test. Can be {@literal null}.
	 */
	private Optional<String> superClass;
	
	/**
	 * The {@link ClassUnderTest} acting as the nest host of the class under test. Can be {@literal null}.
	 */
	@Setter private Optional<ClassUnderTest> nestHost;
	
	/**
	 * A list of qualified names of interfaces of the class under test.
	 */
	private ArrayList<String> interfaces;
	
	/**
	 * The {@link ClassUnderTestType} of the class under test.
	 */
	private ClassUnderTestType type;
	
	/**
	 * The modifier value of the class under test.
	 */
	private int modifiers;
	
	/**
	 * A list of {@link TemplateParameterUnderTest} of the class under test.
	 */
	private ArrayList<TemplateParameterUnderTest> templateParameters;
	
	/**
	 * A list of {@link FieldUnderTest} of the class under test.
	 */
	private ArrayList<FieldUnderTest> fields;

	/**
	 * A list of {@link ConstructorUnderTest}s of the class under test.
	 */
	private ArrayList<ConstructorUnderTest> constructors;
	
	/**
	 * A list of {@link MethodUnderTest} of the class under test.
	 */
	private ArrayList<MethodUnderTest> methods;
	
	/**
	 * A list of {@link EnumConstantUnderTest} of the class under test.
	 */
	private ArrayList<EnumConstantUnderTest> enumConstants;
	
	/**
	 * Constructor with qualified name, {@link ClassUnderTestType}, modifiers and a potential super class of the class under test.<br>
	 * Initializes the lists of {@link TemplateParameterUnderTest}, {@link FieldUnderTest}, {@link ConstructorUnderTest}, {@link MethodUnderTest} and {@link EnumConstantUnderTest}.
	 * 
	 * @param qualifiedName the fully qualified name of the class under test.
	 * @param type the {@link ClassUnderTestType} of the class under test.
	 * @param modifiers the modifier value of the class under test.
	 * @param superClass the potential super class of the class under test. Can be {@literal null}.
	 */
	public ClassUnderTest(String qualifiedName, ClassUnderTestType type, int modifiers, Optional<String> superClass) {
		this.qualifiedName = qualifiedName;
		this.type = type;
		this.superClass = superClass;
		this.modifiers = modifiers;
		templateParameters = new ArrayList<>();
		fields = new ArrayList<>();
		constructors = new ArrayList<>();
		methods = new ArrayList<>();
		enumConstants = new ArrayList<>();
		interfaces = new ArrayList<>();
	}
	
	/**
	 * Returns true, if the type equals {ClassUnderTestType#CLASS}.
	 * 
	 * @return true, if the type equals {ClassUnderTestType#CLASS}.
	 */
	public boolean isClass() {
		return type == ClassUnderTestType.CLASS;
	}
	
	/**
	 * Returns true, if the type equals {ClassUnderTestType#ENUM}.
	 * 
	 * @return true, if the type equals {ClassUnderTestType#ENUM}.
	 */
	public boolean isEnum() {
		return type == ClassUnderTestType.ENUM;
	}
	
	/**
	 * Returns true, if the type equals {ClassUnderTestType#INTERFACE}.
	 * 
	 * @return true, if the type equals {ClassUnderTestType#INTERFACE}.
	 */
	public boolean isInterface() {
		return type == ClassUnderTestType.INTERFACE;
	}
	
	/**
	 * Enumeration describing the class type of the {@link ClassUnderTest}
	 * 
	 * @author dschoenicke
	 *
	 */
	public static enum ClassUnderTestType {
		CLASS, ENUM, INTERFACE;
	}
}
