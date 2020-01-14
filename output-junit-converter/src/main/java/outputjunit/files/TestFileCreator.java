package outputjunit.files;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import junit.JunitRepresentation;
import junit.JunitTestClass;

/**
 * Provides static methods the generate test class file out of the mustache template
 * 
 * @author dschoenicke
 *
 */
public class TestFileCreator {
	
	/**
	 * Create test class files for the given {@link junit.JunitRepresentation} in the given output directory.
	 * 
	 * @param junitRepresentation the {@link junit.JunitRepresentation} for which the test files should be created
	 * @param outputPath the path to the directory, where the test files should be created
	 */
	public static void createTestFiles(JunitRepresentation junitRepresentation, String outputPath) {
		for (JunitTestClass testClass : junitRepresentation.getTestClassesAsList()) {
			String filepath = outputPath + File.separator + testClass.getPackageDeclaration().replace(".", File.separator) + File.separator + testClass.getName() + ".java";
			
			if (testClass.getClassName().startsWith(junitRepresentation.getName())) {
				createTestFile(testClass, filepath);
			}
			else {
				System.out.println("[WARNING] The file " + filepath + " wasn't created!\n" + 
					"          The corresponding class isn't located in a package tree with the application name as root.\n" + 
					"          Therefore it is assumed to be a class of an external package, which cannot be tested.");
			}
		}
	}
	
	/**
	 * Creates a test file with the mustache template for a given {@link junit.JunitTestClass}
	 * 
	 * @param testClass the {@link junit.JunitTestClass} for which the test file should be created
	 * @param testFilePath the path of the test file to be created
	 */
	static void createTestFile(JunitTestClass testClass, String testFilePath) {
		Map<String, Object> contents = new HashMap<>();
		contents.put("testClass", testClass);
		MustacheFactory mf = new DefaultMustacheFactory();
		Mustache mustache = mf.compile("junittemplate.mustache");
		
		try {
			mustache.execute(new PrintWriter(new File(testFilePath)), contents).flush();
			System.out.println("[INFO] Created " + testFilePath);
		} catch (IOException e) {
			System.err.println("[ERROR] Error while creating the file " + testFilePath + "!\n" + 
					"        The directory " + testFilePath.substring(0, testFilePath.lastIndexOf(File.separator)) + " doesn't exist.");
		}
	}
}
