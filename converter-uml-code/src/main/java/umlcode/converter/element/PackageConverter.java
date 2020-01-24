package umlcode.converter.element;

import java.util.ArrayList;
import java.util.List;

import code.CodePackage;
import code.CodeParent;
import code.CodeRepresentation;
import lombok.experimental.UtilityClass;
import uml.UmlPackage;
import umlcode.TemporaryModel;

/**
 * Class providing a static method to convert {@link uml.UmlPackage}s to {@link code.CodePackage}s
 * 
 * @author dschoenicke
 *
 */
@UtilityClass
public class PackageConverter {
	
	/**
	 * Converts a list of given {@link uml.UmlPackage}s and adds them to a {@link code.CodeParent}.<br>
	 * 
	 * @param umlPackages the {@link uml.UmlPackage}s to be converted
	 * @param parent the {@link code.CodeParent} to add the converted {@link code.CodePackage}s to
	 * @param tmpModel the {@link umlcode.TemporaryModel} containing the maps to add {@link uml.UmlPackage}s and converted {@link code.CodePackage}s to
	 */
	public static void convertPackages(List<UmlPackage> umlPackages, CodeParent parent, TemporaryModel tmpModel) {
		for (UmlPackage umlPackage : umlPackages) {
			convertPackage(umlPackage, parent, tmpModel);
		}
	}
	
	/**
	 * Converts a given {@link uml.UmlPackage} to a {@link code.CodePackage} and adds it to its {@link code.CodeParent}
	 * 
	 * @param umlPackage the {@link uml.UmlPackage} to be converted
	 * @param parent the {@link code.CodeParent} to add the converted {@link code.CodePackage}s to
	 * @param tmpModel the {@link umlcode.TemporaryModel} containing the maps to add {@link uml.UmlPackage}s and converted {@link code.CodePackage}s to
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
		else {
			throw new IllegalArgumentException(parent.getName() + " is an invalid parent element for package " + umlPackage.getName());
		}
		
		tmpModel.addConvertedPackage(umlPackage, codePackage);
		convertPackages(umlPackage.getPackages(), codePackage, tmpModel);
	}
	
	/**
	 * Creates a {@link code.CodePackage} with the name of the given {@link code.CodeRepresentation}.<br>
	 * This function is called, if the {@link uml.UmlModel} to be converted contains {@link uml.UmlElement}s as direct child elements.<br>
	 * In this case, the converted {@link code.CodeElement} are grouped in the returned {@link code.CodePackage}.<br>
	 * All sub {@link code.CodePackage}s of the {@link code.CodeRepresentation} which names start with the name of the representation
	 * are added to the newly created {@link code.CodePackage} because with the representation name as prefix, they are considered subpackages.<br>
	 * {@link code.CodePackage}s without this prefix in their name are considered external packages and are kept as child packages of the {@link code.CodeRepresentation} object.
	 * 
	 * @param codeRepresentation the {@link code.CodeRepresentation} to add the {@link code.CodePackage}s to
	 * @return the created top level {@link code.CodePackage}
	 */
	public static CodePackage createTopLevelPackage(CodeRepresentation codeRepresentation) {
		CodePackage topLevelPackage = new CodePackage(codeRepresentation.getName(), codeRepresentation);
		List<CodePackage> externalPackages = new ArrayList<>();
		
		for (CodePackage codePackage : codeRepresentation.getPackages()) {
			if (codePackage.getName().startsWith(codeRepresentation.getName() + ".")) {
				topLevelPackage.addPackage(codePackage);
			}
			else {
				externalPackages.add(codePackage);
			}
		}
		
		codeRepresentation.getPackages().clear();
		codeRepresentation.getPackages().addAll(externalPackages);
		codeRepresentation.addPackage(topLevelPackage);
		return topLevelPackage;
	}
}
