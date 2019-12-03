package umlcodeconverter.packages;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import code.CodePackage;
import code.CodeParent;
import code.CodeRepresentation;
import uml.UmlPackage;
import umlcodeconverter.temporary.TemporaryModel;

/**
 * Class providing a static method to convert {@link uml.UmlPackage}s to {@link code.CodePackage}s
 * 
 * @author dschoenicke
 *
 */
public class PackageConverter {
	
	/**
	 * Converts a list of given {@link uml.UmlPackage}s and adds them to a {@link code.CodeParent}.<br>
	 * 
	 * @param umlPackages the {@link uml.UmlPackage}s to be converted
	 * @param parent the {@link code.CodeParent} to add the converted {@link code.CodePackage}s to
	 * @param tmpModel the {@link umlcodeconverter.temporary.TemporaryModel} containing the maps to add {@link uml.UmlPackage}s and converted {@link code.CodePackage}s to
	 */
	public static void convertPackages(ArrayList<UmlPackage> umlPackages, CodeParent parent, TemporaryModel tmpModel) {
		for (UmlPackage umlPackage : umlPackages) {
			convertPackage(umlPackage, parent, tmpModel);
		}
	}
	
	/**
	 * Converts a given {@link uml.UmlPackage} to a {@link code.CodePackage} and adds it to its {@link code.CodeParent}
	 * 
	 * @param umlPackage the {@link uml.UmlPackage} to be converted
	 * @param parent the {@link code.CodeParent} to add the converted {@link code.CodePackage}s to
	 * @param tmpModel the {@link umlcodeconverter.temporary.TemporaryModel} containing the maps to add {@link uml.UmlPackage}s and converted {@link code.CodePackage}s to
	 */
	public static void convertPackage(UmlPackage umlPackage, CodeParent parent, TemporaryModel tmpModel) {
		CodePackage codePackage = null;
		
		if (parent instanceof CodeRepresentation) {
			codePackage = new CodePackage(umlPackage.getName(), parent);
			((CodeRepresentation) parent).addPackage(codePackage);
		}
		else if (parent instanceof CodePackage) {
			codePackage = new CodePackage(umlPackage.getName(), parent);
			((CodePackage) parent).addPackage(codePackage);
		}
		
		assertNotNull("The conversion of UmlPackage " + umlPackage.getName() + " failed!", codePackage);
		tmpModel.addConvertedPackage(umlPackage, codePackage);
		convertPackages(umlPackage.getPackages(), codePackage, tmpModel);
	}
}
