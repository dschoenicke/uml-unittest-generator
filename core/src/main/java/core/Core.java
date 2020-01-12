package core;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.MissingArgumentException;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import core.options.QualifiedNamesMapper;
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
		
		options.addOption(Option.builder("rqn")
				.longOpt("replacequalifiedname")
				.desc("replace a fully qualified name for a given shortcut used in the class diagram")
				.numberOfArgs(2)
				.build());
		
		options.addOption(Option.builder("dqn")
				.longOpt("deletequalifiedname")
				.desc("delete the mapping with the given shortcut")
				.numberOfArgs(1)
				.build());
		
		options.addOption(Option.builder("cqn")
				.longOpt("clearqualifiednames")
				.desc("delete all mappings of diagram shortcuts to fully qualified names")
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
				QualifiedNamesMapper.addQualifiedName(args[1], args[2]);
			}
			else if (cmd.hasOption("rqn")) {
				QualifiedNamesMapper.replaceQualifiedName(args[1], args[2]);
			}
			else if (cmd.hasOption("dqn")) {
				QualifiedNamesMapper.deleteQualifiedName(args[1]);
			}
			else if (cmd.hasOption("cqn")) {
				QualifiedNamesMapper.clearQualifiedNames();
			}
			else if (cmd.hasOption("sqn")) {
				QualifiedNamesMapper.showQualifiedNames();
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
				else if (((MissingArgumentException) e).getOption().getOpt().equals("rqn")) {
					System.out.println("\tError: -replacequalifiedname requires arguments <shortcut> <new-qualified-name>");
				}
				else if (((MissingArgumentException) e).getOption().getOpt().equals("aqn")) {
					System.out.println("\tError: -deletequalifiedname requires argument <shortcut>");
				}
			}
			else {
				e.printStackTrace();
			}
		}
	}
}
