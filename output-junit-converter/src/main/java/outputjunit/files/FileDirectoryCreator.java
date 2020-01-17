package outputjunit.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.JunitPackage;
import junit.JunitParent;
import junit.JunitRepresentation;

/**
 * Provides static methods to create the directory for the test files.
 * 
 * @author dschoenicke
 *
 */
public class FileDirectoryCreator {

	private FileDirectoryCreator() {
		throw new IllegalStateException("utility class");
	}
	
	/**
	 * The {@link org.slf4j.Logger} to be used in the methods
	 */
	private static final Logger LOG = LoggerFactory.getLogger("");
	
	/**
	 * Static method to create the directories for the test files of the given {@link junit.JunitRepresentation}.<br>
	 * Hereby, a directory for each package is created, which will contain its sub packages and test files.<br>
	 * Creates the tests in a directory called [representation name]Structure, overwrites the directory, if it already exists.<br>
	 * 
	 * @param junitRepresentation the {@link junit.JunitRepresentation} containing the {@link junit.JunitPackage}s to create the directory for.
	 * @param outputPath the file path where the directories should be created.
	 */
	public static void createFileDirectories(JunitRepresentation junitRepresentation, String outputPath) {
		String testFilePath = outputPath + File.separator + junitRepresentation.getName() + "Structure";
		
		try {
			FileUtils.deleteDirectory(new File(testFilePath));
		} catch (IOException e) {
			LOG.error("The directory {} already exists and could not be overwritten!", testFilePath);
			return;
		}
		
		createFileDirectory(junitRepresentation, junitRepresentation, testFilePath);
	}
	
	/**
	 * Static method to create a directory for a given {@link junit.JunitPackage}.<br>
	 * This method ignores all packages, which qualified name doesn't start with the name of the {@link junit.JunitRepresentation}
	 * to exclude tests of external classes.
	 * 
	 * @param junitRepresentation the {@link junit.JunitRepresentation} to check whether the given {@link junit.JunitPackage} is a package of the application under test.
	 * @param junitParent the {@link junit.JunitParent} to create the directory for and which {@link junit.JunitPackage}s the directories should be created.
	 * @param testFilePath the path of the root directory.
	 */
	static void createFileDirectory(JunitRepresentation junitRepresentation, JunitParent junitParent, String testFilePath) {	
		try {
			if (junitParent instanceof JunitRepresentation) {
				Files.createDirectories(Paths.get(testFilePath));
			} 
			else {
				Files.createDirectories(Paths.get(testFilePath + File.separator + ((JunitPackage ) junitParent).getQualifiedName().replace(".", File.separator)));
			}
			
			for (JunitPackage junitPackage : junitParent.getPackages()) {
				if (junitPackage.getQualifiedName().startsWith(junitRepresentation.getName())) {
					createFileDirectory(junitRepresentation, junitPackage, testFilePath);
				}
			}
		} catch (IOException e) {
			LOG.error("The directory {} could not be created!", testFilePath);
		}
	}
}
