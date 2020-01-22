package core;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import core.options.AssociationTypeMapper;
import core.options.QualifiedNamesMapper;
import core.options.TestCreator;

/**
 * Main class
 * 
 * @author dschoenicke
 *
 */
public class Core {

	/**
	 * The path to the configuration database
	 */
	public static final String DB_PATH = "configuration.db";
	
	/**
	 * Main method.<br>
	 * Delegates the creation of test files to the {@link core.options.TestCreator}.<br>
	 * Delegates the administration of qualified names to the {@link core.options.QualifiedNamesMapper}.<br>
	 * Delegates the administration of association types to the {@link core.options.AssociationTypeMapper}.<br>
	 * Prints the help message if an invalid argument is passed.
	 * 
	 * @param args the command line arguments passed to the application
	 * @throws Exception if the input conversion process fails
	 */
	public static void main(String[] args) throws Exception {
		Options options = new Options();
		TestCreator.addTestCreatorOptions(options);
		QualifiedNamesMapper.addQualifiedNamesMapperOptions(options);
		AssociationTypeMapper.addAssociationTypeMapperOptions(options);
		
		try {
			CommandLine cmd = new DefaultParser().parse(options, args);
		
			if (!(TestCreator.parseOptions(cmd, args) 
					|| QualifiedNamesMapper.parseOptions(cmd, args) 
					|| AssociationTypeMapper.parseOptions(cmd, args))) {
				
				new HelpFormatter().printHelp(100, " ", "Commands to convert diagrams and manage qualified names and association types", options, "Version 0.0.1");
			}
		} catch (ParseException e) {
			TestCreator.checkParseException(e);
			QualifiedNamesMapper.checkQualifiedNamesParseException(e);
			AssociationTypeMapper.checkAssociationTypeParseException(e);
		}
	}
}
