package outputjunit.files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import outputjunit.testmethod.TestMethodConverter;
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
				System.out.println("[\u001B[093mWARNING\u001B[0m] \u001B[093mThe file " + filepath + " wasn't created!\n" + 
					"\tThe corresponding class isn't located in a package tree with the application name as root.\n" + 
					"\tTherefore it is assumed to be a class of an external package, which cannot be tested.\u001B[0m");
			}
		}
	}
	
	static void createTestFile(TestRepresentation testRepresentation, TestClass testClass, String testFilePath) {
		ClassUnderTest classUnderTest = testClass.getClassUnderTest();
		
		if (classUnderTest == null) {
			System.out.println("[\u001B[93mWARNING\u001B[0m] \u001B[93mThe file " + testFilePath + " was skipped since it doesn't contain any ClassUnderTest object.");
			return;
		}
		
		try {
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
			fw.close();
			System.out.println("[\u001B[94mINFO\u001B[0m] Created " + testFilePath);
			
		} catch (IOException e) {
			System.out.println("[\u001B[91mERROR\u001B[0m] \u001B[91mError while creating the file " + testFilePath + "!\n" + 
					"\tThe directory " + testFilePath.substring(0, testFilePath.lastIndexOf(File.separator)) + " doesn't exist.\u001B[0m");
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
