package codetestconverter.testclass;

import code.CodeElement;
import codetestconverter.temporary.TemporaryModel;
import test.TestClass;
import test.TestPackage;

/**
 * Provides static methods to convert {@link code.CodeElement}s of the {@link code.CodePackage}s in the {@link codetestconverter.temporary.TemporaryModel} to {@link test.TestClass}es.
 * 
 * @author dschoenicke
 *
 */
public class TestClassConverter {

	/**
	 * Static methods to convert {@link code.CodeElement}s of the {@link code.CodePackage}s in the {@link codetestconverter.temporary.TemporaryModel} to {@link test.TestClass}es.
	 * 
	 * @param tmpModel the {@link codetestconverter.temporary.TemporaryModel} containing a map of {@link code.CodePackage}s and the corresponding converted {@link test.TestPackage}s.
	 * @author dschoenicke
	 *
	 */
	public static void convertTestClasses(TemporaryModel tmpModel) {
		tmpModel.getConvertedPackages().forEach((codePackage, testPackage) -> {
			codePackage.getElements().forEach(codeElement -> {
				convertTestClass(codeElement, testPackage);
			});
		});
	}
	
	/**
	 * Static method converting a given {@link code.CodeElement} to a {@link test.TestClass} with its {@link test.testobjects.ClassUnderTest} and adds it to the given {@link test.TestParent}.
	 * 
	 * @param codeElement the {@link code.CodeElement} to be converted.
	 * @param parent the {@link test.TestPackage} containing the converted {@link test.TestClass}.
	 */
	static void convertTestClass(CodeElement codeElement, TestPackage parent) {
		TestClass testClass = new TestClass(codeElement.getName() + "Test", parent);
		testClass.setClassUnderTest(ClassUnderTestConverter.convertClassUnderTest(codeElement));
		parent.addTestClass(testClass);
		
		for (CodeElement nestedElement : codeElement.getNestedElements()) {
			convertTestClass(nestedElement, parent);
		}
	}
}
