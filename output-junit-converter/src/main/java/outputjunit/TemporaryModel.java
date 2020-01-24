package outputjunit;

import java.util.HashMap;

import junit.JunitPackage;
import lombok.Getter;
import test.TestPackage;

/**
 * Auxiliary class providing a map of {@link test.TestPackage}s and converted {@link junit.JunitPackage}s to be used by {@link outputjunit.converter.TestClassConverter#convertTestClasses}.
 * 
 * @author dschoenicke
 *
 */
@Getter
public class TemporaryModel {

	/**
	 * The map with {@link test.TestPackage} as key and {@link junit.JunitPackage}s as value.
	 */
	private HashMap<TestPackage, JunitPackage> convertedPackages;
	
	/**
	 * Constructor, initializes the map of {@link test.TestPackage}s and {@link junit.JunitPackage}s.
	 */
	public TemporaryModel() {
		convertedPackages = new HashMap<>();
	}
	
	/**
	 * Adds a {@link test.TestPackage} with its corresponding converted {@link junit.JunitPackage} to the map.
	 * 
	 * @param testPackage the {@link test.TestPackage} to be added to the map
	 * @param junitPackage the {@link junit.JunitPackage} to be added to the map
	 */
	public void addConvertedPackage(TestPackage testPackage, JunitPackage junitPackage) {
		convertedPackages.put(testPackage, junitPackage);
	}
}
