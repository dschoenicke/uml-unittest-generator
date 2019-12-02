package coretest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

import code.CodeRepresentation;
import codetestconverter.CodeTestConverter;
import mdxml.MdxmlRepresentation;
import mdxmlconverter.MdxmlUmlConverter;
import test.TestAssertion;
import test.TestClass;
import test.TestMethod;
import test.TestPackage;
import test.TestRepresentation;
import uml.UmlModel;
import umlcodeconverter.UmlCodeConverter;

public class EndToEndOverviewTest {

	@Test
	public void createTestFiles() throws Exception {
		MdxmlRepresentation mdxml = new MdxmlRepresentation(getClass().getClassLoader().getResource("md_test.xml").getFile());
		UmlModel uml = new MdxmlUmlConverter().convertToUmlRepresentation(mdxml);
		CodeRepresentation code = new UmlCodeConverter().convertUmlToCodeRepresentation(uml);
		TestRepresentation test = new CodeTestConverter().convertCodeToTestRepresentation(code);
	
		File root = new File("test-files");
		root.mkdir();
		File modelFile = new File(root.getPath() + File.separator + test.getName());
		modelFile.mkdir();
		File index = new File(modelFile + File.separator + "index.html");
		index.createNewFile();
		String indexContent = "<html><head><title>" + test.getName() + "</title></head><body>";
		
		for (TestPackage tPackage : test.getPackages()) {
			indexContent = createTestPackageDirectory(tPackage, indexContent, index);
		}
		
		indexContent += "</body></html>";
		FileWriter fw = new FileWriter(index);
		fw.write(indexContent);
		fw.close();
	}
	
	private String createTestPackageDirectory(TestPackage testPackage, String indexContent, File index) throws IOException {
		File pack = new File("test-files" + File.separator + testPackage.getQualifiedName().replace(".", File.separator));
		pack.mkdir();
		indexContent += ("<h2>" + testPackage.getQualifiedName() + "</h2><ul>");
		
		for (TestClass testClass : testPackage.getTestClasses()) {
			File test = new File("test-files" + File.separator + testClass.getParent().getQualifiedName().replace(".", File.separator) + File.separator + testClass.getName() + ".html");
			test.createNewFile();
			indexContent += ("<li><a href=\"File:///" + test.getCanonicalPath() + "\">" + testClass.getName() + "</a></li>");
			
			String testContent = "<html><head><title>" + testClass.getName() + "</title><style>table, th, td {border: 1px solid black;border-collapse: collapse;}th, td {padding: 5px;text-align: left;}</style></head><body><a href=\"File:///" + index.getCanonicalPath() + "\">Home</a><br/>";
			
			for (TestMethod method : testClass.getMethods()) {
				testContent = getTestMethodText(method, testContent);
			}
			
			testContent += "</body></html>";
			FileWriter fw = new FileWriter(test);
			fw.write(testContent);
			fw.close();
		}
		
		indexContent += "</ul>";
		
		for (TestPackage subPackage : testPackage.getPackages()) {
			indexContent = createTestPackageDirectory(subPackage, indexContent, index);
		}
		
		return indexContent;
	}
	
	private String getTestMethodText(TestMethod method, String testContent) {
		testContent += ("<h2>public void " + method.getName() + "()</h2><table><thead><th>AssertionType</th><th>Message</th></thead><tbody>");
		
		for (TestAssertion assertion : method.getAssertions()) {
			testContent = getTestAssertionText(assertion, testContent);
		}
		
		testContent += "</tbody></table>";
		
		return testContent;
	}
	
	private String getTestAssertionText(TestAssertion assertion, String testContent) {
		testContent += "<tr><td>" + assertion.getAssertionType() + "</td><td>" + assertion.getMessage() + "</td></tr>";
		
		return testContent;
	}
}
