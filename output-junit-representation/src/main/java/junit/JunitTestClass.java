package junit;

import java.util.ArrayList;

import lombok.Getter;

/**
 * Represents a test class which will be converted in a mustache template
 * 
 * @author dschoenicke
 *
 */
@Getter
public class JunitTestClass {
	
	/**
	 * The name of the test class
	 */
	private String name;
	
	/**
	 * The fully qualified name of the class under test
	 */
	private String className;
	
	/**
	 * The package declaration of the class under test
	 */
	private String packageDeclaration;
	
	/**
	 * The {@link JunitPackage} containing this test class
	 */
	private JunitPackage junitPackage;
	
	/**
	 * Determines whether the class under test is an enumeration
	 */
	private boolean enumeration;
	
	/**
	 * List of {@link JunitAssertion}s checking the classes' properties
	 */
    private ArrayList<JunitAssertion> propertyAssertions;
    
    /**
	 * List of {@link JunitAssertion}s checking the classes' relationships
	 */
    private ArrayList<JunitAssertion> relationshipAssertions;
    
    /**
     * List of {@link JunitAssertion}s checking the classes' enum constants
     */
    private ArrayList<JunitAssertion> enumConstantAssertions;
    
    /**
     * List of {@link JunitTemplateParameterUnderTest} which should be checked
     */
    private ArrayList<JunitTemplateParameterUnderTest> templateParameters;
    
    /**
     * List of {@link JunitFieldUnderTest} which should be checked
     */
    private ArrayList<JunitFieldUnderTest> fields;
    
    /**
     * List of {@link JunitConstructorUnderTest} which should be checked
     */
    private ArrayList<JunitConstructorUnderTest> constructors;
    
    /**
     * List of {@link JunitMethodUnderTest} which should be checked
     */
    private ArrayList<JunitMethodUnderTest> methods;
    
    /**
     * Constructor with name, qualified name, package declaration and {@link JunitPackage}.<br>
     * Initializes the lists of the different {@link JunitAssertion}s, {@link JunitFieldUnderTest}, {@link JunitConstructorUnderTest} and {@link JunitMethodUnderTest}.
     * 
     * @param name the name of the test class
     * @param className the qualified name of the test class
     * @param packageDeclaration the package declaration of the test class
     * @param junitPackage the {@link JunitPackage} containing this test class
     * @param enumeration determines whether the class is an enumeration
     */
    public JunitTestClass(String name, String className, String packageDeclaration, JunitPackage junitPackage, boolean enumeration) {
    	this.name = name;
    	this.className = className;
    	this.packageDeclaration = packageDeclaration;
    	this.junitPackage = junitPackage;
    	this.enumeration = enumeration;
    	propertyAssertions = new ArrayList<>();
    	relationshipAssertions = new ArrayList<>();
    	enumConstantAssertions = new ArrayList<>();
    	templateParameters = new ArrayList<>();
    	fields = new ArrayList<>();
    	constructors = new ArrayList<>();
    	methods = new ArrayList<>();
    }
    
    /**
	 * Adds a property {@link JunitAssertion} to the list
	 * 
	 * @param assertion the {@link JunitAssertion} to be added to the list
	 */
	public void addPropertyAssertion(JunitAssertion assertion) {
		propertyAssertions.add(assertion);
	}
	
	/**
	 * Adds a relationship {@link JunitAssertion} to the list
	 * 
	 * @param assertion the {@link JunitAssertion} to be added to the list
	 */
	public void addRelationshipAssertion(JunitAssertion assertion) {
		relationshipAssertions.add(assertion);
	}
	
	/**
	 * Adds a enum constant {@link JunitAssertion} to the list
	 * 
	 * @param assertion the {@link JunitAssertion} to be added to the list
	 */
	public void addEnumConstantAssertion(JunitAssertion assertion) {
		enumConstantAssertions.add(assertion);
	}
	
	/**
	 * Adds a {@link JunitTemplateParameterUnderTest} to the list
	 * 
	 * @param templateParameter the {@link JunitTemplateParameterUnderTest} to be added to the list
	 */
	public void addTemplateParameter(JunitTemplateParameterUnderTest templateParameter) {
		templateParameters.add(templateParameter);
	}
	
	/**
	 * Adds a {@link JunitFieldUnderTest} to the list
	 * 
	 * @param field the {@link JunitFieldUnderTest} to be added to the list
	 */
	public void addField(JunitFieldUnderTest field) {
		fields.add(field);
	}
	
	/**
	 * Adds a {@link JunitFieldUnderTest} to the list
	 * 
	 * @param constructor the {@link JunitFieldUnderTest} to be added to the list
	 */
	public void addConstructor(JunitConstructorUnderTest constructor) {
		constructors.add(constructor);
	}
	
	/**
	 * Adds a {@link JunitMethodUnderTest} to the list
	 * 
	 * @param method the {@link JunitMethodUnderTest} to be added to the list
	 */
	public void addMethod(JunitMethodUnderTest method) {
		methods.add(method);
	}
}
