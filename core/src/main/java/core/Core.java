package core;

import java.io.File;

import javax.xml.bind.JAXBException;

import code.CodeRepresentation;
import codetestconverter.CodeTestConverter;
import mdxml.MdxmlRepresentation;
import mdxmlconverter.MdxmlUmlConverter;
import outputjunit.OutputJUnitConverter;
import test.TestRepresentation;
import uml.UmlModel;
import umlcodeconverter.UmlCodeConverter;

public class Core {

	public static void main(String[] args) {
		
		if (args.length == 2 && args[0] != null && args[1] != null) {
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
		}
	}
}
