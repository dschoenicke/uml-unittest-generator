package core;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.MissingArgumentException;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import core.options.AssociationTypeMapper;
import core.options.QualifiedNamesMapper;
import core.options.TestCreator;

public class Core {

	public static final String dbPath = "configuration.db";
	
	public static void main(String[] args) {
		
		Options options = new Options();
		TestCreator.addTestCreatorOptions(options);
		QualifiedNamesMapper.addQualifiedNamesMapperOptions(options);
		AssociationTypeMapper.addAssociationTypeMapperOptions(options);
		CommandLineParser cmpParser = new DefaultParser();
		
		try {
			CommandLine cmd = cmpParser.parse(options, args);
			
			if (cmd.hasOption("ct")) {
				if (TestCreator.evaluateArguments(args)) {
					TestCreator.execute(args);
				}
			}
			else if (cmd.hasOption("inputtypes")) {
				TestCreator.showInputs();
			}
			else if (cmd.hasOption("outputtypes")) {
				TestCreator.showOutputs();
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
			else if (cmd.hasOption("aat")) {
				AssociationTypeMapper.addAssociationType(args[1], args[2]);
			}
			else if (cmd.hasOption("rat")) {
				AssociationTypeMapper.replaceAssociationType(args[1], args[2]);
			}
			else if (cmd.hasOption("dat")) {
				AssociationTypeMapper.deleteAssociationType(args[1]);
			}
			else if (cmd.hasOption("cat")) {
				AssociationTypeMapper.clearAssociationTypes();
			}
			else if (cmd.hasOption("sat")) {
				AssociationTypeMapper.showAssociationTypes();
			}
			else {
				new HelpFormatter().printHelp(100, " ", "Commands to convert diagrams and manage qualified names and association types", options, "Version 0.0.1");
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
				else if (((MissingArgumentException) e).getOption().getOpt().equals("dqn")) {
					System.out.println("\tError: -deletequalifiedname requires argument <shortcut>");
				}
				else if (((MissingArgumentException) e).getOption().getOpt().equals("aat")) {
					System.out.println("\tError: -addassociationtype requires arguments <attribute> <collection-type>");
					System.out.println("\tExample: -addassociationtype Person.friends ArrayList");
				}
				else if (((MissingArgumentException) e).getOption().getOpt().equals("rat")) {
					System.out.println("\tError: -replaceassociationtype requires arguments <attribute> <new-collection-type>");
				}
				else if (((MissingArgumentException) e).getOption().getOpt().equals("dat")) {
					System.out.println("\tError: -deleteassociationtype requires argument <attribute>");
				}
			}
			else {
				e.printStackTrace();
			}
		}
	}
}
