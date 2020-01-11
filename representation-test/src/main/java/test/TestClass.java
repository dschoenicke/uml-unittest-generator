package test;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import test.testobjects.ClassUnderTest;

/**
 * Represents a test class, which contains reflection bases {@link TestMethod}s for its properties, fields, constructors and methods
 * 
 * @author dschoenicke
 *
 */
@Getter
@RequiredArgsConstructor
public class TestClass {

	/**
	 * The name of the test class
	 */
	@NonNull private String name;
	
	/**
	 * The {@link TestPackage} containing this test class
	 */
	@NonNull private TestPackage parent;
	
	/**
	 * The {@link test.testobjects.ClassUnderTest} which this test class contains the tests for.
	 */
	@NonNull private ClassUnderTest classUnderTest;
	
	/**
	 * Gets the qualified name of the test class
	 * 
	 * @return the qualified name of the test class
	 */
	public String getQualifiedName() {
		return this.parent.getQualifiedName() + "." + this.name;
	}
}
