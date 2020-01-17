package outputjunit;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.JunitRepresentation;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
public class OutputJunitConverter implements TestConverter {

	/**
	 * The {@link org.slf4j.Logger} to be used in the methods
	 */
	private static final Logger LOG = LoggerFactory.getLogger("");
	
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
		LOG.info("");
		LOG.info("The test files for {} have been successfully created.", testRepresentation.getName());
		LOG.info("You can find the test files in {}{}{}Structure", outputDirectory, File.separator, testRepresentation.getName());
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
