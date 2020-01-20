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

	private QualifiedNamesConverter() {
		throw new IllegalStateException("utility class");
	}
	
	/**
	 * Map containing mappings of {@link code.CodeElement} names to their qualified names.
	 */
	private static Map<String, String> qualifiedNames = new HashMap<>();
	
	/**
	 * Sets qualified names for all {@link code.CodeElement}s of the given {@link code.CodeRepresentation} and replaces the type attributes of {@link code.CodeParameter}s and {@link code.CodeTemplateParameter}s
	 * with potential qualified names, if their type is one of the {@link code.CodeElement}s.
	 * 
	 * @param codeRepresentation the {@link code.CodeRepresentation} containing the {@link code.CodeElement}s
	 * @param qualifiedNamesDB the map representing the MapDB database containing mappings for qualified names of external classes
	 */
	public static void resolveQualifiedNames(CodeRepresentation codeRepresentation, BTreeMap<String, String> qualifiedNamesDB) {
		codeRepresentation.getElementsAsList().forEach(codeElement -> 
			resolveElementQualifiedName(codeElement, qualifiedNamesDB));
	
		codeRepresentation.getElementsAsList().forEach(codeElement -> {
			resolveElementConstructorParameters(codeElement);
			resolveElementMethodParameters(codeElement);
			resolveElementTemplateParameters(codeElement);
		});
	}
	
	/**
	 * Resolves the fully qualified name of a given {@link code.CodeElement}
	 * 
	 * @param codeElement the {@link code.CodeElement} to set the qualified name for
	 * @param qualifiedNamesDB the map representing the MapDB database containing mappings for qualified names of external classes 
	 */
	static void resolveElementQualifiedName(CodeElement codeElement, BTreeMap<String, String> qualifiedNamesDB) {
		String key = codeElement.getName();
		String genericType = "";
		
		//Check for generic type in class name
		if (key.contains("<")) {
			genericType = key.substring(key.indexOf('<'));
			key = key.substring(0, key.indexOf('<') - 1);
		}
		
		codeElement.setQualifiedName(qualifiedNamesDB.containsKey(key) ? qualifiedNamesDB.get(key) + genericType : createQualifiedName(codeElement));
		qualifiedNames.put(codeElement.getName(), codeElement.getQualifiedName());
	}
		
	/**
	 * Resolves the fully qualified name of the {@link code.CodeParameter}s of the {@link code.CodeConstructor}s of a given {@link code.CodeElement}
	 * 
	 * @param codeElement the {@link code.CodeElement} to containing the {@link code.CodeConstructor}s
	 */
	static void resolveElementConstructorParameters(CodeElement codeElement) {
		codeElement.getConstructors().forEach(codeConstructor -> 
			codeConstructor.getParameters().forEach(codeParameter -> {
				if (qualifiedNames.containsKey(codeParameter.getType())) {
					codeParameter.setType(qualifiedNames.get(codeParameter.getType()).replace("$",  "."));
				}
			})
		);
	}
	
	/**
	 * Resolves the fully qualified name of the {@link code.CodeParameter}s of the {@link code.CodeMethod}s of a given {@link code.CodeElement}
	 * 
	 * @param codeElement the {@link code.CodeElement} to containing the {@link code.CodeMethod}s
	 */
	static void resolveElementMethodParameters(CodeElement codeElement) {
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
	}
	
	/**
	 * Resolves the fully qualified name of the types of {@link code.CodeTemplateParameter}s of a given {@link code.CodeElement}
	 * 
	 * @param codeElement the {@link code.CodeElement} to containing the {@link code.CodeTemplateParameter}s
	 */
	static void resolveElementTemplateParameters(CodeElement codeElement) {
		codeElement.getTemplateParameters().forEach(codeTemplateParameter -> {
			if (qualifiedNames.containsKey(codeTemplateParameter.getType())) {
				codeTemplateParameter.setType(qualifiedNames.get(codeTemplateParameter.getType()).replace("$",  "."));
			}
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
