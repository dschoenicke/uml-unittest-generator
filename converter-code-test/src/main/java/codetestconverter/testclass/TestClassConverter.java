package codetestconverter.testclass;

import java.util.ArrayList;

import code.CodeElement;
import codetestconverter.temporary.TemporaryModel;
import test.TestClass;
import test.TestPackage;

/**
 * Provides static methods to convert {@link code.CodeElement}s to {@link test.TestClass}es.
 * 
 * @author dschoenicke
 *
 */
public class TestClassConverter {

	/**
	 * Static method converting the {@link code.CodeElement}s of the {@link code.CodePackage}s in the map provided by {@link codetestconverter.temporary.TemporaryModel}
	 * to {@link test.TestClass}es and adds them to the corresponding {@link test.TestPackage}.
	 * 
	 * @param testPackages the {@link test.TestPackage}s of the {@link test.TestRepresentation} to which the converted {@link test.TestClass}es should be added.
	 * @param tmpModel the {@link codetestconverter.temporary.TemporaryModel} containing the {@link code.CodePackage}s providing the {@link code.CodeElement}s to be converted.
	 */
	public static void convertTestClasses(ArrayList<TestPackage> testPackages, TemporaryModel tmpModel) {
		tmpModel.getConvertedPackages().forEach((codePackage, testPackage) -> {
			for (CodeElement codeElement : codePackage.getElements()) {
				convertTestClass(codeElement, testPackage);
			}
		});
	}
	
	/**
	 * Converts a given {@link code.CodeElement} to a {@link test.TestClass} and adds it to the corresponding {@link test.TestPackage}.<br>
	 * Calls itself recursively for all nested {@link code.CodeElement}s of the given {@link code.CodeElement}.
	 * 
	 * @param codeElement the {@link code.CodeElement} to be converted.
	 * @param parentPackage the {@link test.TestPackage} to which the converted {@link test.TestClass} should be added.
	 */
	private static void convertTestClass(CodeElement codeElement, TestPackage parentPackage) {
		TestClass testClass = new TestClass(codeElement.getName() + "Test", parentPackage);
		parentPackage.addTestClass(testClass);
		TestMethodConverter.createTestMethods(codeElement, testClass);
		
		for (CodeElement nestedElement : codeElement.getNestedElements()) {
			convertTestClass(nestedElement, parentPackage);
		}
	}
}
