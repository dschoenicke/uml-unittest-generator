package core.options;

import java.io.File;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.MissingArgumentException;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import codetestconverter.CodeTestConverter;
import core.Core;
import mdxmlconverter.MdxmlUmlConverter;
import outputjunit.OutputJunitConverter;
import test.converterinterface.TestConverter;
import uml.converterinterface.UmlRepresentationConverter;
import umlcodeconverter.UmlCodeConverter;

/**
 * Contains the functions necessary to process CLI commands for the test file creation
 * 
 * @author dschoenicke
 *
 */
public class TestCreator {
	
	/**
	 * Maps input type options to an actual {@link uml.converterinterface.UmlRepresentationConverter} instance
	 */
	private static Map<String, UmlRepresentationConverter> inputtypes = Stream.of(new Object[][] { 
	    {"mdxml", new MdxmlUmlConverter()}
	}).collect(Collectors.toMap(data -> (String) data[0], data -> (UmlRepresentationConverter) data[1]));
	
	/**
	 * Maps output type options to an actual {@link test.converterinterface.TestConverter} instance
	 */
	private static Map<String, TestConverter> outputtypes = Stream.of(new Object[][] { 
	    {"junit", new OutputJunitConverter()}
	}).collect(Collectors.toMap(data -> (String) data[0], data -> (TestConverter) data[1]));
	
	/**
	 * Creates the {@link org.apache.commons.cli.Option}s for the test file creation
	 * 
	 * @param options the {@link org.apache.commons.cli.Options} instance to add the {@link org.apache.commons.cli.Option}s to
	 */
	public static void addTestCreatorOptions(Options options) {
		options.addOption(Option.builder("ct")
				.longOpt("createtests")
				.desc("create test files out of a given input diagram in a given output directory")
				.numberOfArgs(4)
				.argName("input-format input-file output-format output-directory")
				.build());
		
		options.addOption(Option.builder("inputtypes")
				.desc("show supported input diagram types")
				.build());
		
		options.addOption(Option.builder("outputtypes")
				.desc("show supported output diagram types")
				.build());
	}
	
	/**
	 * Evaluates the input arguments whether they match the {@link org.apache.commons.cli.Options}.
	 * 
	 * @param options the {@link org.apache.commons.cli.Options} to be checked
	 * @param args the input arguments to be checked
	 * @return true, if the given arguments belong to the test file creation {@link org.apache.commons.cli.Options}.
	 */
	public static boolean parseOptions(Options options, String[] args) {
		try {
			CommandLine cmd = new DefaultParser().parse(options, args);
			
			if (cmd.hasOption("ct")) {
				if (evaluateArguments(args)) {
					execute(args);
				}
				
				return true;
			}
			else if (cmd.hasOption("inputtypes")) {
				showInputs();
				return true;
			}
			else if (cmd.hasOption("outputtypes")) {
				showOutputs();
				return true;
			}
			
			return false;
		} catch (ParseException e) {
			if (e instanceof MissingArgumentException) {
				if (((MissingArgumentException) e).getOption().getOpt().equals("ct")) {
					System.out.println("\tError: -createtests requires arguments <input-type> <input-file> <output-type> <output-path>");
					return true;
				}
			}
			
			return false;
		}
	}
	
	/**
	 * Checks whether the given arguments are valid for {@link TestCreator#execute}
	 * 
	 * @param args the arguments to be checked
	 * @return true if the given arguments are valid for {@link TestCreator#execute}
	 */
	static boolean evaluateArguments(String[] args) {
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
	
	/**
	 * Starts the conversion of a class diagram to test files for the given arguments
	 * 
	 * @param args the arguments (input-type) (input-path) (output-type) (output-path)
	 */
	static void execute(String[] args) {
		UmlCodeConverter umlToCode = new UmlCodeConverter();
		CodeTestConverter codeToTest = new CodeTestConverter();
		
		outputtypes.get(args[3]).convertTestFiles(codeToTest.convertCodeToTestRepresentation(
				umlToCode.convertUmlToCodeRepresentation(
						inputtypes.get(args[1]).convertToUmlRepresentation(args[2]), Core.dbPath)), 
				args[4]);
	}
	
	/**
	 * Prints all supported input types
	 */
	static void showInputs() {
		System.out.print("Supported input diagram formats:\n");
		inputtypes.forEach((inputtype, converter) -> {
			System.out.print("\t" + inputtype + "\n");
		});
	}
	
	/**
	 * Prints all supported output type
	 */
	static void showOutputs() {
		System.out.print("Supported output test formats:\n");
		outputtypes.forEach((outputtype, converter) -> {
			System.out.print("\t" + outputtype + "\n");
		});
	}
}
