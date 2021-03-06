package core.options;

import java.io.File;
import java.util.Map;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.MissingArgumentException;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import codetest.CodeTestConverter;
import core.Core;
import inputmdxml.MdxmlUmlConverter;
import lombok.experimental.UtilityClass;
import outputjunit.OutputJunitConverter;
import test.converterinterface.TestConverter;
import uml.converterinterface.UmlRepresentationConverter;
import umlcode.UmlCodeConverter;

/**
 * Contains the functions necessary to process CLI commands for the test file creation
 * 
 * @author dschoenicke
 *
 */
@UtilityClass
public class TestCreator {
	
	/**
	 * The {@link org.slf4j.Logger} to be used in the methods
	 */
	private static final Logger LOG = LoggerFactory.getLogger("");
	
	/**
	 * Maps input type options to an actual {@link uml.converterinterface.UmlRepresentationConverter} instance
	 */
	private static Map<String, UmlRepresentationConverter> inputtypes = Map.of(
				"mdxml", new MdxmlUmlConverter()
			);
	
	/**
	 * Maps output type options to an actual {@link test.converterinterface.TestConverter} instance
	 */
	private static Map<String, TestConverter> outputtypes = Map.of(
				"junit", new OutputJunitConverter()
			);
	
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
	 * @param cmd the parsed {@link org.apache.commons.cli.CommandLine} containing the arguments
	 * @param args the command line input arguments to be parsed
	 * @return true, if the given arguments belong to the test file creation {@link org.apache.commons.cli.Options}.
	 */
	public static boolean parseOptions(CommandLine cmd, String[] args) {
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
	}
			
	/**
	 * Checks a thrown {@link org.apache.commons.cli.ParseException} whether it is associated with association type commands
	 * 
	 * @param e the {@link org.apache.commons.cli.ParseException} to be parsed.
	 */
	public static void checkParseException(ParseException e) {
		if (e instanceof MissingArgumentException &&
				((MissingArgumentException) e).getOption().getOpt().equals("ct")) {
				
			LOG.error("-createtests requires arguments <input-type> <input-file> <output-type> <output-path>");
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
			LOG.error("Invalid input-type {}!", args[1]);
			return false;
		}
		
		File inputDiagram = new File(args[2]);
		
		if (!inputDiagram.exists() || inputDiagram.isDirectory()) { 
			LOG.error("Invalid input-path {}!", args[2]);
			LOG.error("The given file does not exist!");
			return false;
		}
		
		if (!outputtypes.containsKey(args[3])) {
			LOG.error("Invalid output-type {}!", args[3]);
			return false;
		}
		
		File outputDirectory = new File(args[4]);
		
		if (!outputDirectory.exists() || !outputDirectory.isDirectory()) { 
			LOG.error("Invalid output-path {}!", args[4]);
			LOG.error("The given directory does not exist!");
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
		DB database = DBMaker.fileDB(Core.DB_PATH).make();
		BTreeMap<String, String> qualifiedNames = null;
		BTreeMap<String, String> associationTypes = null;
		
		try {
			qualifiedNames = QualifiedNamesMapper.loadQualifiedNamesDB(database);
			associationTypes = AssociationTypeMapper.loadAssociationTypesDB(database);
			
			outputtypes.get(args[3]).convertTestFiles(codeToTest.convertCodeToTestRepresentation(
					umlToCode.convertUmlToCodeRepresentation(
							inputtypes.get(args[1]).convertToUmlRepresentation(args[2]), qualifiedNames, associationTypes)), 
					args[4]);
		} finally {
			if (qualifiedNames != null) {
				qualifiedNames.close();
			}
			
			if (associationTypes != null) {
				associationTypes.close();
			}
			
			database.close();
		}
	}
	
	/**
	 * Prints all supported input types
	 */
	static void showInputs() {
		LOG.info("Supported input diagram formats:");
		inputtypes.forEach((inputtype, converter) -> 
			LOG.info("\t{}", inputtype)
		);
	}
	
	/**
	 * Prints all supported output type
	 */
	static void showOutputs() {
		LOG.info("Supported output test formats:");
		outputtypes.forEach((outputtype, converter) -> 
			LOG.info("\t{}", outputtype)
		);
	}
}
