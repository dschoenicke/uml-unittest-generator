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
import test.TestRepresentation;

public class TestFileCreator {
	
	public static void createTestFiles(JunitRepresentation junitRepresentation, String outputPath) {
		for (JunitTestClass testClass : junitRepresentation.getTestClassesAsList()) {
			String filepath = outputPath + File.separator + testClass.getPackageDeclaration().replace(".", File.separator) + File.separator + testClass.getName() + ".java";
			
			if (testClass.getClassName().startsWith(junitRepresentation.getName())) {
				createTestFile(junitRepresentation, testClass, filepath);
			}
			else {
				System.out.println("[WARNING] The file " + filepath + " wasn't created!\n" + 
					"          The corresponding class isn't located in a package tree with the application name as root.\n" + 
					"          Therefore it is assumed to be a class of an external package, which cannot be tested.");
			}
		}
	}
	
	static void createTestFile(JunitRepresentation junitRepresentation, JunitTestClass testClass, String testFilePath) {
		Map<String, Object> contents = new HashMap<>();
		contents.put("testClass", testClass);
		/*contents.put("package", createPackageDeclaration(testRepresentation, testFilePath));
		contents.put("className", testClass.getClassUnderTest().getQualifiedName());
		contents.put("isNestedClass", testClass.getClassUnderTest().getNestHost().isPresent());
		contents.put("hasSuperClass", testClass.getClassUnderTest().getSuperClass().isPresent());
		contents.put("constructors", ConstructorConverter.convertConstructors(classUnderTest));
		contents.put("methods", MethodConverter.convertMethods(classUnderTest));
		
		if (testClass.getClassUnderTest().getNestHost().isPresent()) {
			contents.put("nestHost", testClass.getClassUnderTest().getNestHost().get().getQualifiedName());
		}
		
		if (testClass.getClassUnderTest().getSuperClass().isPresent()) {
			contents.put("superClass", testClass.getClassUnderTest().getSuperClass().get());
		}*/
		
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
