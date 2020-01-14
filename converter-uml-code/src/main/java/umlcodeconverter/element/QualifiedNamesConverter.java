package umlcodeconverter.element;

import java.util.HashMap;
import java.util.Map;

import org.mapdb.BTreeMap;

import code.CodeElement;
import code.CodePackage;
import code.CodeRepresentation;

/**
 * Provides static methods to create qualified names for {@link code.CodeElement}s and replace the type attributes of {@link code.CodeParameter}s and {@link code.CodeTemplateParameter}s.
 * 
 * @author dschoenicke
 *
 */
public class QualifiedNamesConverter {

	/**
	 * Map containing mappings of {@link code.CodeElement} names to their qualified names.
	 */
	private static Map<String, String> qualifiedNames;
	
	/**
	 * Sets qualified names for all {@link code.CodeElement}s of the given {@link code.CodeRepresentation} and replaces the type attributes of {@link code.CodeParameter}s and {@link code.CodeTemplateParameter}s
	 * with potential qualified names, if their type is one of the {@link code.CodeElement}s.
	 * 
	 * @param codeRepresentation the {@link code.CodeRepresentation} containing the {@link code.CodeElement}s
	 * @param qualifiedNamesDB the map representing the MapDB database containing mappings for qualified names of external classes
	 */
	public static void resolveQualifiedNames(CodeRepresentation codeRepresentation, BTreeMap<String, String> qualifiedNamesDB) {
		
		qualifiedNames = new HashMap<>();
		codeRepresentation.getElementsAsList().forEach(codeElement -> {
			if (qualifiedNamesDB.containsKey(codeElement.getName())) {
				codeElement.setQualifiedName(qualifiedNamesDB.get(codeElement.getName()));
			}
			else {
				codeElement.setQualifiedName(createQualifiedName(codeElement));
			}
			
			qualifiedNames.put(codeElement.getName(), codeElement.getQualifiedName());
		});
		
		codeRepresentation.getElementsAsList().forEach(codeElement -> {
			codeElement.getConstructors().forEach(codeConstructor -> {
				codeConstructor.getParameters().forEach(codeParameter -> {
					if (qualifiedNames.containsKey(codeParameter.getType())) {
						codeParameter.setType(qualifiedNames.get(codeParameter.getType()).replace("$",  "."));
					}
				});
			});
			
			codeElement.getMethods().forEach(codeMethod -> {
				if (qualifiedNames.containsKey(codeMethod.getReturnType().getType())) {
					codeMethod.getReturnType().setType(qualifiedNames.get(codeMethod.getReturnType().getType()));
				}
				
				codeMethod.getParameters().forEach(codeParameter -> {
					if (qualifiedNames.containsKey(codeParameter.getType())) {
						codeParameter.setType(qualifiedNames.get(codeParameter.getType()).replace("$",  "."));
					}
				});
			});
			
			codeElement.getTemplateParameters().forEach(codeTemplateParameter -> {
				if (qualifiedNames.containsKey(codeTemplateParameter.getType())) {
					codeTemplateParameter.setType(qualifiedNames.get(codeTemplateParameter.getType()).replace("$",  "."));
				}
			});
		});
	}
	
	/**
	 * Creates the fully qualified name for a given {@link code.CodeElement}.
	 * 
	 * @param codeElement the {@link code.CodeElement} to create the fully qualified name for.
	 * @return the fully qualified name for the given {@link code.CodeElement}.
	 */
	static String createQualifiedName(CodeElement codeElement) {
		if (codeElement.getParent() instanceof CodePackage) {
			return createQualifiedName((CodePackage) codeElement.getParent()) + "." + codeElement.getName();
		}
		
		return createQualifiedName((CodeElement) codeElement.getParent()) + "$" + codeElement.getName();
	}
	
	/**
	 * Creates the fully qualified name for a given {@link code.CodePackage}.
	 * 
	 * @param codePackage the {@link code.CodePackage} to create the fully qualified name for.
	 * @return the fully qualified name for the given {@link code.CodePackage}.
	 */
	static String createQualifiedName(CodePackage codePackage) {
		if (codePackage.getParent() instanceof CodeRepresentation) {
			return codePackage.getName();
		}
		
		return createQualifiedName((CodePackage) codePackage.getParent()) + "." + codePackage.getName();
	}
}
