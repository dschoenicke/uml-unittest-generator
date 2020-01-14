package outputjunit;

import java.io.File;

import junit.JunitRepresentation;
import outputjunit.converter.PackageConverter;
import outputjunit.converter.TestClassConverter;
import outputjunit.converter.temporary.TemporaryModel;
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
	 * Firstly, converts the {@link test.TestRepresentation} to a {@link junit.JunitTestClass}es and maps them to {@link test.TestClass}es.
	 * Delegates the creation of the directory to the {@link outputjunit.files.FileDirectoryCreator}.<br>
	 * Delegates the creation of the test files to the {@link outputjunit.files.TestFileCreator}.<br>
	 * Prints a success message, if the test files have been created successfully.
	 * 
	 * @param testRepresentation the {@link test.TestRepresentation} describing the structure of the tests to be created.
	 * @param outputDirectory the file path where the directory of the tests files has to be created.
	 */
	@Override
	public void convertTestFiles(TestRepresentation testRepresentation, String outputDirectory) {
		JunitRepresentation junitRepresentation = convertTestToJunitRepresentation(testRepresentation);
		FileDirectoryCreator.createFileDirectories(junitRepresentation, outputDirectory);
		TestFileCreator.createTestFiles(junitRepresentation, outputDirectory);
		System.out.println("\n" +
				"[SUCCESS\u001B[0m] The test files for " + testRepresentation.getName() + " have been successfully created.\n" + 
				"          You can find the files in " + outputDirectory + File.separator + testRepresentation.getName() + "Structure.\n");
	}
	
	/**
	 * Converts a given {@link test.TestRepresentation} to a {@link junit.JunitRepresentation}.
	 * 
	 * @param testRepresentation the {@link test.TestRepresentation} to be converted
	 * @return the converted {@link junit.JunitRepresentation}
	 */
	static JunitRepresentation convertTestToJunitRepresentation(TestRepresentation testRepresentation) {
		JunitRepresentation junitRepresentation = new JunitRepresentation(testRepresentation.getName());
		TemporaryModel tmpModel = new TemporaryModel();
		PackageConverter.convertPackages(testRepresentation, junitRepresentation, tmpModel);
		TestClassConverter.convertTestClasses(junitRepresentation, tmpModel);
		return junitRepresentation;
	}
}
