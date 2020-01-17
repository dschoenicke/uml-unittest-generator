package outputjunit.files;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	
	private TestFileCreator() {
		throw new IllegalStateException("utility class");
	}
	
	/**
	 * The {@link org.slf4j.Logger} to be used in the methods
	 */
	private static final Logger LOG = LoggerFactory.getLogger("");
	
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
				LOG.warn("The file {} wasn't created!", filepath);
				LOG.warn("The corresponding class isn't located in a package tree with the application name as root.");
				LOG.warn("Therefore it is assumed to be a class of an external package, which cannot be tested.");
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
			Writer writer = mustache.execute(new PrintWriter(new File(testFilePath)), contents);
			writer.flush();
			writer.close();
			LOG.info("Created {}", testFilePath);
		} catch (IOException e) {
			LOG.error("The file {} could not be created!", testFilePath);
			LOG.error("The directory {} doesn't exists.", testFilePath.substring(0, testFilePath.lastIndexOf(File.separator)));
		}
	}
}
