package junit;

import java.util.ArrayList;

/**
 * Interface implemented by the {@link JunitRepresentation} and {@link JunitPackage}, provides a method the get its {@link JunitPackage}s
 * 
 * @author dschoenicke
 *
 */
public interface JunitParent {
	public String getName();
	
	public ArrayList<JunitPackage> getPackages();
}