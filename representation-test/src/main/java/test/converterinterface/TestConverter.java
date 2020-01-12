package test.converterinterface;

import test.TestRepresentation;

/**
 * This interface has to be implemented by every output converter.
 * 
 * @author dschoenicke
 *
 */
public interface TestConverter {
	
	/**
	 * Interface for the convert method of an output converter.
	 * 
	 * @param testRepresentation the {@link test.TestRepresentation} describing the structure of the tests to be created.
	 * @param outputDirectory the file path where the directory of the tests files has to be created.
	 */
	public void convertTestFiles(TestRepresentation testRepresentation, String outputDirectory);
}
