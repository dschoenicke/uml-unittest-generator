package outputjunit.files;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import test.TestClass;
import test.TestRepresentation;
import test.testobjects.ClassUnderTest;

public class TestFileCreator {
	
	public static void createTestFiles(TestRepresentation testRepresentation, String outputPath) {
		for (TestClass testClass : testRepresentation.getTestClassesAsList()) {
			String filepath = outputPath + File.separator + testRepresentation.getName() + "Structure" + File.separator + testClass.getQualifiedName().replace(".", File.separator) + ".java";
			
			if (testClass.getQualifiedName().startsWith(testRepresentation.getName())) {
				createTestFile(testRepresentation, testClass, filepath);
			}
			else {
				System.out.println("[WARNING] The file " + filepath + " wasn't created!\n" + 
					"          The corresponding class isn't located in a package tree with the application name as root.\n" + 
					"          Therefore it is assumed to be a class of an external package, which cannot be tested.");
			}
		}
	}
	
	static void createTestFile(TestRepresentation testRepresentation, TestClass testClass, String testFilePath) {
		ClassUnderTest classUnderTest = testClass.getClassUnderTest();
		
		if (classUnderTest == null) {
			System.out.println("[WARNING] The file " + testFilePath + " was skipped since it doesn't contain any ClassUnderTest object.");
			return;
		}
		
		Map<String, Object> contents = new HashMap<>();
		contents.put("testClass", testClass);
		contents.put("package", createPackageDeclaration(testRepresentation, testFilePath));
		contents.put("className", testClass.getClassUnderTest().getQualifiedName());
		MustacheFactory mf = new DefaultMustacheFactory();
		Mustache mustache = mf.compile("junittemplate.mustache");
		
		try {
			mustache.execute(new PrintWriter(new File(testFilePath)), contents).flush();
			/*} catch (IOException e) {
				e.printStackTrace();
			}
			
			Files.createFile(Paths.get(testFilePath));
			
			String fileContent = "package " + createPackageDeclaration(testRepresentation, testFilePath) + 
					"\n\nimport org.junit.jupiter.api.*;" +
					"\nimport static org.junit.jupiter.api.Assertions.*;" +
					"\nimport " + createPackageImport(testRepresentation, testFilePath) + 
					"\nimport java.lang.reflect.*;" + 
					"\nimport java.util.Arrays;\n\n" +
					"public class " + testClass.getName() + " {\n\n" + 
					ClassUnderTestCreator.createClassUnderTest(classUnderTest) +
					TestMethodConverter.createTestMethods(classUnderTest) +
					"}\n";
			
			FileWriter fw = new FileWriter(testFilePath);
			fw.write(fileContent);
			fw.close();*/
			System.out.println("[INFO] Created " + testFilePath);
		} catch (IOException e) {
			System.err.println("[ERROR] Error while creating the file " + testFilePath + "!\n" + 
					"        The directory " + testFilePath.substring(0, testFilePath.lastIndexOf(File.separator)) + " doesn't exist.");
		}
	}
	
	static String createPackageDeclaration(TestRepresentation testRepresentation, String testFilePath) {
		return testFilePath.substring(
					testFilePath.lastIndexOf(testRepresentation.getName() + "Structure"), 
					testFilePath.lastIndexOf(File.separator)).
				replace(File.separator, ".") + ";";
	}
	
	static String createPackageImport(TestRepresentation testRepresentation, String testFilePath) {
		return testFilePath.substring(
					testFilePath.lastIndexOf(testRepresentation.getName() + "Structure") + testRepresentation.getName().length() + 10, 
					testFilePath.lastIndexOf(File.separator)).
				replace(File.separator, ".") + ".*;";
	}
}
