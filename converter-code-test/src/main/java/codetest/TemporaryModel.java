package codetest;

import java.util.HashMap;

import code.CodeElement;
import code.CodePackage;
import lombok.Getter;
import test.TestPackage;
import test.testobjects.ClassUnderTest;

/**
 * Auxiliary class providing a map of {@link code.CodePackage}s and converted {@link test.TestPackage}s as well as a map of
 * {@link code.CodeElement}s and converted {@link test.testobjects.ClassUnderTest}s to be used by {@link codetest.converter.TestClassConverter#convertTestClasses}.
 * 
 * @author dschoenicke
 *
 */
@Getter
public class TemporaryModel {

	/**
	 * The map with {@link code.CodePackage} as key and {@link test.TestPackage}s as value.
	 */
	private HashMap<CodePackage, TestPackage> convertedPackages;
	
	/**
	 * The map with {@link code.CodeElement}s as key and {@link test.testobjects.ClassUnderTest}s as value.
	 */
	private HashMap<CodeElement, ClassUnderTest> convertedClassesUnderTest;
	
	/**
	 * Constructor, initializes the map of {@link code.CodePackage}s and {@link test.TestPackage}s as well as the map of {@link code.CodeElement}s and {@link test.testobjects.ClassUnderTest}s.
	 */
	public TemporaryModel() {
		convertedPackages = new HashMap<>();
		convertedClassesUnderTest = new HashMap<>();
	}
	
	/**
	 * Adds a {@link code.CodePackage} with its corresponding converted {@link test.TestPackage} to the map.
	 * 
	 * @param codePackage the {@link code.CodePackage} to add to the map
	 * @param testPackage the {@link test.TestPackage} to add to the map
	 */
	public void addConvertedPackage(CodePackage codePackage, TestPackage testPackage) {
		convertedPackages.put(codePackage, testPackage);
	}
	
	/**
	 * Adds a {@link code.CodeElement} with its corresponding converted {@link test.testobjects.ClassUnderTest} to the map.
	 * 
	 * @param codeElement the {@link code.CodeElement} to add to the map
	 * @param classUnderTest the {@link test.testobjects.ClassUnderTest} to add to the map
	 */
	public void addConvertedClassUnderTest(CodeElement codeElement, ClassUnderTest classUnderTest) {
		convertedClassesUnderTest.put(codeElement, classUnderTest);
	}
}
