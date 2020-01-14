package junit;

import org.junit.Before;

/**
 * Provides mock elements and an initialization method.<br>
 * Must be extended by all test classes of this package.
 * 
 * @author dschoenicke
 *
 */
public class TestInitializer {
	
	/**
	 * Mocks a {@link junit.JunitRepresentation}
	 */
	JunitRepresentation mockRepresentation;
	
	/**
	 * Mocks a {@link junit.JunitPackage}
	 */
	JunitPackage mockPackage;
	
	/**
	 * Mocks a sub {@link junit.JunitPackage}
	 */
	JunitPackage subPackage;
	
	/**
	 * Mocks a {@link junit.JunitTestClass}
	 */
	JunitTestClass mockTestClass1;
	
	/**
	 * Mocks another {@link junit.JunitTestClass}
	 */
	JunitTestClass mockTestClass2;
	
	/**
	 * Initializes the mock elements
	 */
	@Before
	public void init() {
		mockRepresentation = new JunitRepresentation("test");
		mockPackage = new JunitPackage("parent", mockRepresentation);
		subPackage = new JunitPackage("sub", mockPackage);
		mockTestClass1 = new JunitTestClass("class1", "", "", mockPackage);
		mockTestClass2 = new JunitTestClass("class2", "", "", subPackage);
		mockPackage.addPackage(subPackage);
		mockPackage.addTestClass(mockTestClass1);
		subPackage.addTestClass(mockTestClass2);
		mockRepresentation.addPackage(mockPackage);
	}
}
