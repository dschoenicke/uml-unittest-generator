package codetest.converter;

import java.util.Optional;

import code.CodeElement;
import codetest.TemporaryModel;
import lombok.experimental.UtilityClass;
import test.TestClass;
import test.TestPackage;

/**
 * Provides static methods to convert {@link code.CodeElement}s of the {@link code.CodePackage}s in the {@link codetest.TemporaryModel} to {@link test.TestClass}es.
 * 
 * @author dschoenicke
 *
 */
@UtilityClass
public class TestClassConverter {

	/**
	 * Static methods to convert {@link code.CodeElement}s of the {@link code.CodePackage}s in the {@link codetest.TemporaryModel} to {@link test.TestClass}es.
	 * 
	 * @param tmpModel the {@link codetest.TemporaryModel} containing a map of {@link code.CodePackage}s and the corresponding converted {@link test.TestPackage}s as well as {@link test.testobjects.ClassUnderTest}s with their corresponding {@link code.CodeElement}s.
	 */
	public static void convertTestClasses(TemporaryModel tmpModel) {
		tmpModel.getConvertedPackages().forEach((codePackage, testPackage) -> 
			codePackage.getElements().forEach(codeElement -> 
				tmpModel.addConvertedClassUnderTest(codeElement, convertTestClass(codeElement, testPackage).getClassUnderTest())
			)
		);
		
		tmpModel.getConvertedClassesUnderTest().forEach((codeElement, classUnderTest) -> {
			if (codeElement.getNestHost().isPresent()) {
				classUnderTest.setNestHost(Optional.of(tmpModel.getConvertedClassesUnderTest().get(codeElement.getNestHost().get())));
			}
			else {
				classUnderTest.setNestHost(Optional.empty());
			}
		});
	}
	
	/**
	 * Static method converting a given {@link code.CodeElement} to a {@link test.TestClass} with its {@link test.testobjects.ClassUnderTest} and adds it to the given {@link test.TestPackage}.
	 * 
	 * @param codeElement the {@link code.CodeElement} to be converted.
	 * @param parent the {@link test.TestPackage} containing the converted {@link test.TestClass}.
	 * @return the converted {@link test.TestClass}
	 */
	static TestClass convertTestClass(CodeElement codeElement, TestPackage parent) {
		TestClass testClass = new TestClass(codeElement.getName() + "Test", parent, ClassUnderTestConverter.convertClassUnderTest(codeElement));
		parent.addTestClass(testClass);
		return testClass;
	}
}
