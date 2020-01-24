package test;

import java.util.List;

/**
 * Interface implemented by the classes of the model to reference a parent class, provides a method to get its name and its {@link TestPackage}s
 * 
 * @author dschoenicke
 *
 */
public interface TestParent {
	public String getName();
	
	public List<TestPackage> getPackages();
}
