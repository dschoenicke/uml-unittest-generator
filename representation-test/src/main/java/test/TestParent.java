package test;

import java.util.List;

/**
 * Interface implemented by the classes of the model to reference a parent class, provides a method the get its name
 * 
 * @author dschoenicke
 *
 */
public interface TestParent {
	public String getName();
	
	public List<TestPackage> getPackages();
}
