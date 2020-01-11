package test.testobjects;

import lombok.Data;

/**
 * Represents a template parameter of a {@link ClassUnderTest}
 * 
 * @author dschoenicke
 *
 */
@Data
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
		parent.getTemplateParameters().add(this);
	}
}
