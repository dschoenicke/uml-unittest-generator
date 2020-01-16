package core;

import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

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
	public static String dbPath = "configuration.db";
	
	/**
	 * Main method.<br>
	 * Delegates the creation of test files to the {@link options.TestCreator}.<br>
	 * Delegates the administration of qualified names to the {@link options.QualifiedNamesMapper}.<br>
	 * Delegates the administration of association types to the {@link options.AssociationTypeMapper}.<br>
	 * Prints the help message if an invalid argument is passed.
	 * 
	 * @param args the command line arguments passed to the application
	 */
	public static void main(String[] args) {
		
		Options options = new Options();
		TestCreator.addTestCreatorOptions(options);
		QualifiedNamesMapper.addQualifiedNamesMapperOptions(options);
		AssociationTypeMapper.addAssociationTypeMapperOptions(options);
		
		if (!(TestCreator.parseOptions(options, args) 
				|| QualifiedNamesMapper.parseOptions(options, args) 
				|| AssociationTypeMapper.parseOptions(options, args))) {
			
			new HelpFormatter().printHelp(100, " ", "Commands to convert diagrams and manage qualified names and association types", options, "Version 0.0.1");
		}
	}
}
