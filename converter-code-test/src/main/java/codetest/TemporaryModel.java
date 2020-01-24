package codetest;

import java.util.HashMap;

import code.CodePackage;
import lombok.Getter;
import test.TestPackage;

/**
 * Auxiliary class providing a map of {@link code.CodePackage}s and converted {@link test.TestPackage}s to be used by {@link codetest.converter.TestClassConverter#convertTestClasses}.
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
	 * Constructor, initializes the map of {@link code.CodePackage}s and {@link test.TestPackage}s.
	 */
	public TemporaryModel() {
		convertedPackages = new HashMap<>();
	}
	
	/**
	 * Adds a {@link code.CodePackage} with its corresponding converted {@link test.TestPackage} to the map of {@link code.CodePackage}s and {@link test.TestPackage}s.
	 * 
	 * @param codePackage the {@link code.CodePackage} to add to the map
	 * @param testPackage the {@link test.TestPackage} to add to the map
	 */
	public void addConvertedPackage(CodePackage codePackage, TestPackage testPackage) {
		convertedPackages.put(codePackage, testPackage);
	}
}
