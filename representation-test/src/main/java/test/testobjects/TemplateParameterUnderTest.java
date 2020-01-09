package test.testobjects;

/**
 * Represents a template parameter of a {@link ClassUnderTest}
 * 
 * @author dschoenicke
 *
 */
public class TemplateParameterUnderTest implements TestObject {

	/**
	 * The name of the template parameter.
	 */
	private String parameterName;
	
	/**
	 * The qualified name of the bounded type of the template parameter
	 */
	private String boundedType;

	/**
	 * The parent {@link ClassUnderTest} of the template parameter.
	 */
	private ClassUnderTest parent;
	
	/**
	 * Constructor with parameter name and bounded type.
	 * Adds the template parameter to the parent {@link ClassUnderTest}.
	 * 
	 * @param parameterName the name of the template parameter
	 * @param boundedType the qualified name of the bounded type of the template parameter
	 * @param parent the parent {@link ClassUnderTest} of the template parameter.
	 */
	public TemplateParameterUnderTest(String parameterName, String boundedType, ClassUnderTest parent) {
		this.parameterName = parameterName;
		this.boundedType = boundedType;
		this.parent = parent;
		parent.addTemplateParameter(this);
	}
	
	/**
	 * Gets the parameter name of the template parameter.
	 * 
	 * @return the parameter name of the template parameter.
	 */
	public String getParameterName() {
		return parameterName;
	}
	
	/**
	 * Sets the parameter name of the template parameter.
	 * 
	 * @param parameterName the parameter name of the template parameter.
	 */
	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}
	
	/**
	 * Gets the qualified name of the bounded type of the template parameter.
	 * 
	 * @return the qualified name of the bounded type of the template parameter.
	 */
	public String getBoundedType() {
		return boundedType;
	}
	
	/**
	 * Sets the qualified name of the bounded type of the template parameter.
	 * 
	 * @param boundedType the qualified name of the bounded type of the template parameter.
	 */
	public void setBoundedType(String boundedType) {
		this.boundedType = boundedType;
	}
	
	/**
	 * Gets the parent {@link ClassUnderTest} of the template parameter.
	 * 
	 * @return the parent {@link ClassUnderTest} of the template parameter.
	 */
	public ClassUnderTest getParent() {
		return parent;
	}
	
	/**
	 * Sets the parent {@link ClassUnderTest} of the template parameter.
	 * 
	 * @return parent the parent {@link ClassUnderTest} of the template parameter.
	 */
	public void setParent(ClassUnderTest parent) {
		this.parent = parent;
	}
}
