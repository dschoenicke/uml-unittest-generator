package core.options;

import java.io.File;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import codetestconverter.CodeTestConverter;
import mdxmlconverter.MdxmlUmlConverter;
import outputjunit.OutputJUnitConverter;
import test.converterinterface.TestConverter;
import uml.converterinterface.UmlRepresentationConverter;
import umlcodeconverter.UmlCodeConverter;

public class TestCreator {

	private static Map<String, UmlRepresentationConverter> inputtypes = Stream.of(new Object[][] { 
	    {"mdxml", new MdxmlUmlConverter()}
	}).collect(Collectors.toMap(data -> (String) data[0], data -> (UmlRepresentationConverter) data[1]));
	
	private static Map<String, TestConverter> outputtypes = Stream.of(new Object[][] { 
	    {"junit", new OutputJUnitConverter()}
	}).collect(Collectors.toMap(data -> (String) data[0], data -> (TestConverter) data[1]));
	
	public static boolean evaluateArguments(String[] args) {
		if (!inputtypes.containsKey(args[1])) {
			System.out.println("\tError: Invalid input-type " + args[1] + "!");
			return false;
		}
		
		File inputDiagram = new File(args[2]);
		
		if (!inputDiagram.exists() || inputDiagram.isDirectory()) { 
			System.out.println("\tError: Invalid input-path " + args[2] + "!");
			System.out.println("\tThe given file does not exist!");
			return false;
		}
		
		if (!outputtypes.containsKey(args[3])) {
			System.out.println("\tError: Invalid output-type " + args[3] + "!");
			return false;
		}
		
		File outputDirectory = new File(args[4]);
		
		if (!outputDirectory.exists() || !outputDirectory.isDirectory()) { 
			System.out.println("\tError: Invalid output-path " + args[4] + "!");
			System.out.println("\tThe given directory does not exist!");
			return false;
		}
		
		return true;
	}
	
	public static void execute(String[] args) {
		UmlCodeConverter umlToCode = new UmlCodeConverter();
		CodeTestConverter codeToTest = new CodeTestConverter();
		
		outputtypes.get(args[3]).convertTestFiles(codeToTest.convertCodeToTestRepresentation(
				umlToCode.convertUmlToCodeRepresentation(
						inputtypes.get(args[1]).convertToUmlRepresentation(args[2])
					)
				), 
				args[4]);
	}
}
