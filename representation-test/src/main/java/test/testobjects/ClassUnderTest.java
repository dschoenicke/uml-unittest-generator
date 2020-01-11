package test.testobjects;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Represents the class under test of a {@link test.TestClass}.
 * 
 * @author dschoenicke
 *
 */
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
	private Optional<ClassUnderTest> nestHost;
	
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
	 * Initializes the lists of {@link TemplateParameterUnderTest}, {@link FieldUnderTest}, {@link ConstructorUnderTes}, {@link MethodUnderTest} and {@link EnumConstantUnderTest}.
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
	 * Gets the qualified name of the class under test.
	 * 
	 * @return the qualified name of the class.
	 */
	public String getQualifiedName() {
		return qualifiedName;
	}
	
	/**
	 * Sets the qualified name of the class under test.
	 * 
	 * @param qualifiedName the qualified name of the class.
	 */
	public void setQualifiedName(String qualifiedName) {
		this.qualifiedName = qualifiedName;
	}
	
	/**
	 * Gets the {@link ClassUnderTestType} of the class under test.
	 * 
	 * @return the {@link ClassUnderTestType} of the class under test.
	 */
	public ClassUnderTestType getType() {
		return type;
	}
	
	/**
	 * Sets the {@link ClassUnderTestType} of the class under test.
	 * 
	 * @param the {@link ClassUnderTestType} of the class under test.
	 */
	public void setType(ClassUnderTestType type) {
		this.type = type;
	}
	
	/**
	 * Gets the qualified name of the potential super class of the class under test.
	 * 
	 * @return the potential super class of the class under test, can be {@literal null}.
	 */
	public Optional<String> getSuperClass() {
		return superClass;
	}
	
	/**
	 * Sets the qualified name of the potential super class of the class under test.
	 * 
	 * @param superClass the potential super class of the class, can be {@literal null}.
	 */
	public void setSuperClass(Optional<String> superClass) {
		this.superClass = superClass;
	}
	
	/**
	 * Gets the potential {@link ClassUnderTest} acting as the nest host of the class.
	 * 
	 * @return the potential {@link ClassUnderTest} acting as the nest host of the class. Can be {@literal null}.
	 */
	public Optional<ClassUnderTest> getNestHost() {
		return nestHost;
	}
	
	/**
	 * Sets the potential {@link ClassUnderTest} acting as the nest host of the class.
	 * 
	 * @param the potential {@link ClassUnderTest} acting as the nest host of the class. Can be {@literal null}.
	 */
	public void setNestHost(Optional<ClassUnderTest> nestHost) {
		this.nestHost = nestHost;
	}
	
	/**
	 * Gets the modifier value of the class under test.
	 * 
	 * @return the modifier value of the class.
	 */
	public int getModifiers() {
		return modifiers;
	}
	
	/**
	 * Sets the modifier value of the class under test.
	 * 
	 * @param modifiers the modifier value of the class.
	 */
	public void setModifiers(int modifiers) {
		this.modifiers = modifiers;
	}
	
	/**
	 * Gets the list of interfaces of the class under test.
	 * 
	 * @return the list of qualified names of the interfaces, implemented by the class under test.
	 */
	public ArrayList<String> getInterfaces() {
		return interfaces;
	}
	
	/**
	 * Adds an interface name to the list.
	 * 
	 * @param interfaceName the qualified name of the interface to be added to the list.
	 */
	public void addInterface(String interfaceName) {
		interfaces.add(interfaceName);
	}
	
	/**
	 * Gets the list of {@link TemplateParameterUnderTest} of the class under test.
	 * 
	 * @return the list of {@link TemplateParameterUnderTest} of the class under test.
	 */
	public ArrayList<TemplateParameterUnderTest> getTemplateParameters() {
		return templateParameters;
	}
	
	/**
	 * Adds a {@link TemplateParameterUnderTest} to the list.
	 * 
	 * @param templateParameter the {@link TemplateParameterUnderTest} to be added to the list.
	 */
	public void addTemplateParameter(TemplateParameterUnderTest templateParameter) {
		templateParameters.add(templateParameter);
	}
	
	/**
	 * Gets the list of {@link FieldUnderTest} of the class under test.
	 * 
	 * @return the list of {@link FieldUnderTest} of the class under test.
	 */
	public ArrayList<FieldUnderTest> getFields() {
		return fields;
	}
	
	/**
	 * Adds a {@link FieldUnderTest} to the list.
	 * 
	 * @param field the {@link FieldUnderTest} to be added to the list.
	 */
	public void addField(FieldUnderTest field) {
		fields.add(field);
	}
	
	/**
	 * Gets the list of {@link ConstructorUnderTest} of the class under test.
	 * 
	 * @return the list of {@link ConstructorUnderTest} of the class under test.
	 */
	public ArrayList<ConstructorUnderTest> getConstructors() {
		return constructors;
	}
	
	/**
	 * Adds a {@link ConstructorUnderTest} to the list.
	 * 
	 * @param constructor the {@link ConstuctorUnderTest} to be added to the list.
	 */
	public void addConstructor(ConstructorUnderTest constructor) {
		constructors.add(constructor);
	}
	
	/**
	 * Gets the list of {@link MethodUnderTest} of the class under test.
	 * 
	 * @return the list of {@link MethodUnderTest} of the class under test.
	 */
	public ArrayList<MethodUnderTest> getMethods() {
		return methods;
	}
	
	/**
	 * Adds a {@link MethodUnderTest} to the list.
	 * 
	 * @param method the {@link MethodUnderTest} to be added to the list.
	 */
	public void addMethod(MethodUnderTest method) {
		methods.add(method);
	}
	
	/**
	 * Gets the list of {@link EnumConstantUnderTest} of the class under test.
	 * 
	 * @return the list of {@link EnumConstantUnderTest} of the class under test.
	 */
	public ArrayList<EnumConstantUnderTest> getEnumConstants() {
		return enumConstants;
	}
	
	/**
	 * Adds a {@link EnumConstantUnderTest} name to the list.
	 * 
	 * @param enumConstant the {@link EnumConstantUnderTest} to be added to the list.
	 */
	public void addEnumConstant(EnumConstantUnderTest enumConstant) {
		enumConstants.add(enumConstant);
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
