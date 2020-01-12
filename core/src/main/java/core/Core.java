package core;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.MissingArgumentException;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import core.options.TestCreator;

public class Core {

	public static void main(String[] args) {
		
		Options options = new Options();
		options.addOption(Option.builder("ct")
				.longOpt("createtests")
				.desc("create test files out of a given input diagram in a given output directory")
				.numberOfArgs(4)
				.build());
		
		options.addOption(Option.builder("aqn")
				.longOpt("addqualifiedname")
				.desc("add a fully qualified name for a given shortcut used in the class diagram")
				.numberOfArgs(2)
				.build());
		
		options.addOption(Option.builder("sqn")
				.longOpt("showqualifiednames")
				.desc("show all mappings of diagram shortcuts to fully qualified names")
				.build());
		
		CommandLineParser cmpParser = new DefaultParser();
		
		try {
			CommandLine cmd = cmpParser.parse(options, args);
			
			if (cmd.hasOption("ct")) {
				if (TestCreator.evaluateArguments(args)) {
					TestCreator.execute(args);
				}
			}
			else if (cmd.hasOption("aqn")) {
				System.out.println("Add QualifiedName");
			}
			else if (cmd.hasOption("sqn")) {
				System.out.println("Show qualified names");
			}
			else {
				if (args.length == 0) {
					System.out.println("\tNo options found!\n\tUse -help to show available options.");
				}
				else {
					System.out.println("\tThe option " + args[0] + " is not valid!\n\tUse -help to show available options.");
				}
			}
		} catch (ParseException e) {
			if (e instanceof MissingArgumentException) {
				if (((MissingArgumentException) e).getOption().getOpt().equals("ct")) {
					System.out.println("\tError: -createtests requires arguments <input-type> <input-file> <output-type> <output-path>");
				}
				else if (((MissingArgumentException) e).getOption().getOpt().equals("aqn")) {
					System.out.println("\tError: -addqualifiedname requires arguments <shortcut> <qualified-name>");
					System.out.println("\tExample: -addqualifiedname java.Money org.javamoney.moneta.Money");
				}
			}
		}
		
		/*if (args.length == 2 && args[0] != null && args[1] != null) {
			File input = new File(args[0]);
			File output = new File(args[1]);
			
			if (input.exists()) {
				if (output.exists()) {
					try {
						MdxmlRepresentation mdxml = new MdxmlRepresentation(args[0]);
						UmlModel uml = new MdxmlUmlConverter().convertToUmlRepresentation(mdxml);
						CodeRepresentation code = new UmlCodeConverter().convertUmlToCodeRepresentation(uml);
						TestRepresentation test = new CodeTestConverter().convertCodeToTestRepresentation(code);
						new OutputJUnitConverter().convertToJUnitTestFiles(test, args[1]);
					} catch (JAXBException e) {
						System.out.println("\n\u001B[91mThe file " + args[0] + " isn't a valid Magic Draw XML project file!\n\u001b[0m");
					}
				} 
				else {
					System.out.println("\n\u001B[91mThe directory " + args[1] + " doesn't exist!\n\u001B[0m");
				}
			}
			else {
				System.out.println("\n\u001B[91mThe file " + args[0] + " doesn't exist!\n\u001B[0m");
			}
		}
		else {
			System.out.println("\n" + (char)27 + "[31m" + "You have to give file paths for the input diagram and an output directory!\n" + 
					"Mandatory parameters: [input-file] [output-directory]\n\u001B[0m");
		}*/
	}
}
