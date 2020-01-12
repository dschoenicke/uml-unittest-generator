package outputjunit;

import java.io.File;

import outputjunit.files.FileDirectoryCreator;
import outputjunit.files.TestFileCreator;
import test.TestRepresentation;
import test.converterinterface.TestConverter;

/**
 * Main class of the converter
 * 
 * @author dschoenicke
 *
 */
public class OutputJUnitConverter implements TestConverter
{
	/**
	 * Default constructor
	 */
	public OutputJUnitConverter() {}
	
	/**
	 * Converts a given {@link test.TestRepresentation} to jUnit test files.<br>
	 * Delegates the creation of the directory to the {@link files.FileDirectoryCreator}.<br>
	 * Delegates the creation of the test files to the {@link files.TestFileCreator}.<br>
	 * Prints a success message, if the test files have been created successfully.
	 * 
	 * @param testRepresentation the {@link test.TestRepresentation} describing the structure of the tests to be created.
	 * @param outputDirectory the file path where the directory of the tests files has to be created.
	 */
	@Override
	public void convertTestFiles(TestRepresentation testRepresentation, String outputDirectory) {
		FileDirectoryCreator.createFileDirectories(testRepresentation, outputDirectory);
		TestFileCreator.createTestFiles(testRepresentation, outputDirectory);
		System.out.println("\n" +
				"[SUCCESS\u001B[0m] The test files for " + testRepresentation.getName() + " have been successfully created.\n" + 
				"          You can find the files in " + outputDirectory + File.separator + testRepresentation.getName() + "Structure.\n");
	}
}
