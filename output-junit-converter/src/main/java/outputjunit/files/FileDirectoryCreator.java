package outputjunit.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;

import test.TestPackage;
import test.TestParent;
import test.TestRepresentation;

/**
 * Provides static methods to create the directory for the test files.
 * 
 * @author dschoenicke
 *
 */
public class FileDirectoryCreator {

	/**
	 * Static method to create the directories for the test files of the given {@link test.TestRepresentation}.<br>
	 * Hereby, a directory for each package is created, which will contain its sub packages and test files.<br>
	 * Creates the tests in a directory called [representation name]Structure, overwrites the directory, if it already exists.<br>
	 * 
	 * @param testRepresentation the {@link test.TestRepresentation} containing the {@link test.TestPackage}s to create the directory for.
	 * @param outputPath the file path where the directories should be created.
	 */
	public static void createFileDirectories(TestRepresentation testRepresentation, String outputPath) {
		String testFilePath = outputPath + File.separator + testRepresentation.getName() + "Structure";
		
		try {
			FileUtils.deleteDirectory(new File(testFilePath));
		} catch (IOException e) {
			System.out.println("\n\u001B[0m91Error while creating a directory!\nThe directory " + testFilePath +
					" already exists and could not be overwritten!\n\u001B[0m");
			return;
		}
		
		createFileDirectory(testRepresentation, testRepresentation, testFilePath);
	}
	
	/**
	 * Static method to create a directory for a given {@link test.TestPackage}.<br>
	 * This method ignores all packages, which qualified name doesn't start with the name of the {@link test.TestRepresentation}
	 * to exclude tests of external classes.
	 * 
	 * @param testRepresentation the {@link test.TestRepresentation} to check whether the given {@link test.TestPackage} is a package of the application under test.
	 * @param testParent the {@link test.TestParent} to create the directory for and which {@link test.TestPackage}s the directories should be created.
	 * @param testFilePath the path of the root directory.
	 */
	static void createFileDirectory(TestRepresentation testRepresentation, TestParent testParent, String testFilePath) {	
		try {
			if (testParent instanceof TestRepresentation) {
				Files.createDirectories(Paths.get(testFilePath));
			} 
			else {
				Files.createDirectories(Paths.get(testFilePath + File.separator + ((TestPackage ) testParent).getQualifiedName().replace(".", File.separator)));
			}
			
			for (TestPackage testPackage : testParent.getPackages()) {
				if (testPackage.getQualifiedName().startsWith(testRepresentation.getName())) {
					createFileDirectory(testRepresentation, testPackage, testFilePath);
				}
			}
		} catch (IOException e) {
			System.out.println("\n\u001B[0m91Error while creating a directory!\nThe directory " + testFilePath +
					" could not be created!\n\u001B[0m");
			return;
		}
	}
}
